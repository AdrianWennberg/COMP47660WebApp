const countries = [
    {
        "Continent": "Asia",
        "Country": "Afghanistan"
    },
    {
        "Continent": "Europe",
        "Country": "Azerbaijan"
    },
    {
        "Continent": "South America",
        "Country": "Argentina"
    },
    {
        "Continent": "South America",
        "Country": "Brazil"
    },
    {
        "Continent": "Africa",
        "Country": "Burundi"
    },
    {
        "Continent": "Africa",
        "Country": "Cameroon"
    },
    {
        "Continent": "North America",
        "Country": "Canada"
    },
    {
        "Continent": "Asia",
        "Country": "Sri Lanka"
    },
    {
        "Continent": "South America",
        "Country": "Chile"
    },
    {
        "Continent": "Asia",
        "Country": "China"
    },
    {
        "Continent": "South America",
        "Country": "Colombia"
    },
    {
        "Continent": "Africa",
        "Country": "Congo"
    },
    {
        "Continent": "Europe",
        "Country": "Croatia"
    },
    {
        "Continent": "North America",
        "Country": "Cuba"
    },
    {
        "Continent": "Europe",
        "Country": "Czech Republic"
    },
    {
        "Continent": "Europe",
        "Country": "France"
    },
    {
        "Continent": "Asia",
        "Country": "Indonesia"
    },
    {
        "Continent": "Asia",
        "Country": "Japan"
    },
    {
        "Continent": "Asia",
        "Country": "South Korea"
    },
    {
        "Continent": "Asia",
        "Country": "Malaysia"
    },
    {
        "Continent": "North America",
        "Country": "Mexico"
    },
    {
        "Continent": "Europe",
        "Country": "Montenegro"
    },
    {
        "Continent": "Europe",
        "Country": "Netherlands"
    },
    {
        "Continent": "North America",
        "Country": "Nicaragua"
    },
    {
        "Continent": "Africa",
        "Country": "Nigeria"
    },
    {
        "Continent": "Asia",
        "Country": "Palestine"
    },
    {
        "Continent": "North America",
        "Country": "Panama"
    },
    {
        "Continent": "South America",
        "Country": "Peru"
    },
    {
        "Continent": "Asia",
        "Country": "Philippines"
    },
    {
        "Continent": "Europe",
        "Country": "Poland"
    },
    {
        "Continent": "Europe",
        "Country": "Portugal"
    },
    {
        "Continent": "Europe",
        "Country": "Russia"
    },
    {
        "Continent": "Asia",
        "Country": "Vietnam"
    },
    {
        "Continent": "Africa",
        "Country": "Sudan"
    },

    {
        "Continent": "Europe",
        "Country": "Sweden"
    },
    {
        "Continent": "Asia",
        "Country": "Thailand"
    },
    {
        "Continent": "Africa",
        "Country": "Tunisia"
    },
    {
        "Continent": "Africa",
        "Country": "Uganda"
    },
    {
        "Continent": "Europe",
        "Country": "Ukraine"
    },
    {
        "Continent": "Europe",
        "Country": "United Kingdom"
    },
    {
        "Continent": "North America",
        "Country": "United States"
    },
    {
        "Continent": "Africa",
        "Country": "Burkina Faso"
    },
    {
        "Continent": "Asia",
        "Country": "Yemen"
    }
];

const width = 500;
const height = 500;
const radius = 400 / 2;
const color = d3.scale.category20c();


// Make a request for a user with a given ID
axios.get('/student/data')
    .then(function (response) {
        // handle success
        student_sunburst(response.data)
    });

function student_sunburst(data) {

    let country_count = countries.map(x => ({
        "name": x.Country,
        "size": data["nationalities"][x.Country]
    }));


    let continents = [...new Set(countries.map(x => x.Continent))];
    let continents_per_country = Object.assign({}, ...countries.map(x => ({[x.Country]: x.Continent})));

    let nationality_data = {
        "name": "Studnet Nationality", "children": continents.map(x => (
            {
                "name": x, "children": country_count.filter(c => continents_per_country[c.name] === x)
            }
        ))
    };

    let gender_data = {
        "name": "Student Gender", "children": [
            {"name": "Male", "size": data["genders"]["MALE"]},
            {"name": "Female", "size": data["genders"]["FEMALE"]}
        ]
    };


    draw_sunburst("#student-nationality", nationality_data);
    draw_sunburst("#student-gender", gender_data);

}

function draw_sunburst(element, data) {
    let svg = d3.select(element).append("svg")
        .attr("width", width)
        .attr("height", height)
        .append("g")
        .attr("transform", "translate(" + width / 2 + "," + height * .52 + ")");

    let partition = d3.layout.partition()
        .sort(null)
        .size([2 * Math.PI, radius * radius])
        .value(function (d) {
            return d.size;
        });

    var arc = d3.svg.arc()
        .startAngle(function (d) {
            return d.x;
        })
        .endAngle(function (d) {
            return d.x + d.dx;
        })
        .innerRadius(function (d) {
            return Math.sqrt(d.y);
        })
        .outerRadius(function (d) {
            return Math.sqrt(d.y + d.dy);
        });

    let path = svg.datum(data).selectAll("path")
        .data(partition.nodes)
        .enter().append("g");

    path.append("path")
        .attr("display", function (d) {
            return d.depth ? null : "none";
        })
        .attr("d", arc)
        .style("stroke", "#fff")
        .style("fill", function (d) {
            return color((d.children || d.parent === data ? d : d.parent).name);
        })
        .style("fill-rule", "evenodd")
        .each(stash);

    path.append("text")
        .text(function (d) {
            return d.name
        })
        .classed("label", true)
        .attr("x", function (d) {
            return d.x;
        })
        .attr("text-anchor", "middle")
        // translate to the desired point and set the rotation
        .attr("transform", function (d) {
            if (d.depth > 0) {
                return "translate(" + arc.centroid(d) + ")" +
                    "rotate(" + getAngle(d) + ")";
            } else {
                return null;
            }
        })
        .attr("dx", "6") // margin
        .attr("dy", ".35em") // vertical-align
        .attr("pointer-events", "none");


    function getAngle(d) {
        let thetaDeg = (180 / Math.PI * (arc.startAngle()(d) + arc.endAngle()(d)) / 2 - 90);
        return (thetaDeg > 90) ? thetaDeg - 180 : thetaDeg;
    }

    function stash(d) {
        d.x0 = d.x;
        d.dx0 = d.dx;
    }


}
