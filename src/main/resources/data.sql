DELETE FROM studentmodule;
DELETE FROM module;
DELETE FROM staff;
DELETE FROM student;

INSERT INTO staff (stf_id, stf_username,stf_password,stf_name,stf_surname,stf_sex)
VALUES
    (1, 'test', 'pass', 'Test', 'User', 0),
    (2, 'SEstrada','IAN56NYE7OT','Sonya','Estrada',1),
    (3, 'CMcclure','WJX98AME2NB','Colin','Mcclure',0),
    (4, 'DNieves','KAW45WDS1NN','Dillon','Nieves',0),
    (5, 'ISosa','TRL69RRV4GV','India','Sosa',1),
    (6, 'CEllis','XKE30ULX5YT','Connor','Ellis',0),
    (7, 'PWatson','DYK21GYN8LN','Pascale','Watson',0),
    (8, 'MPruitt','SMT89XOH5TN','MacKensie','Pruitt',1),
    (9, 'ERogers','QVL96YJC4VW','Erin','Rogers',1),
    (10, 'XPalmer','DJB13JBQ5EA','Xyla','Palmer',1),
    (11, 'RHobbs','XOQ14HEO3CK','Reed','Hobbs',0);


insert into module (mdl_id, mdl_maxstd, mdl_name, mdl_topic, stf_id) values
    (1, 10, 'Major Pharmaceuticals', 'Health Care', 11),
    (2, 12, 'Farming/Seeds/Milling', 'Consumer Non-Durables', 9),
    (3, 16, 'Military/Government/Technical', 'Consumer Services', 6),
    (4, 18, 'Apparel', 'Consumer Non-Durables', 3),
    (5, 11, 'Real Estate Investment Trusts', 'Consumer Services', 11),
    (6, 8, 'Medical Specialities', 'Health Care', 5),
    (7, 13, 'Other Consumer Services', 'Consumer Services', 3),
    (8, 9, 'Property-Casualty Insurers', 'Finance', 10),
    (9, 6, 'EDP Services', 'Technology', 2),
    (10, 25, 'Ordnance And Accessories', 'Capital Goods', 10),
    (11, 10, 'Publishing', 'Consumer Durables', 5),
    (12, 11, 'Services-Misc. Amusement & Recreation', 'Consumer Services', 5),
    (13, 16, 'Automotive Aftermarket', 'Consumer Durables', 8),
    (14, 18, 'Fluid Controls', 'Capital Goods', 11),
    (15, 7, 'Natural Gas Distribution', 'Energy', 5),
    (16, 17, 'Homebuilding', 'Capital Goods', 3),
    (17, 9, 'Meat/Poultry/Fish', 'Consumer Non-Durables', 10),
    (18, 13, 'Computer Software: Prepackaged Software', 'Technology', 7),
    (19, 8, 'Agricultural Chemicals', 'Basic Industries', 9),
    (20, 17, 'Oil & Gas Production', 'Energy', 10),
    (21, 19, 'Telecommunications Equipment', 'Consumer Non-Durables', 11);


insert into student (std_id, std_name, std_surname, std_email, std_sex, std_address, std_username, std_password, std_nationality) values
(1, 'Haydon', 'Pollins', 'hpollins0@state.tx.us', 0, '7444 Little Fleur Lane', 'hpollins0', 'zO1qEuZkLVXo', 'China'),
(2, 'Tamma', 'Courtenay', 'tcourtenay1@google.co.jp', 1, '878 Lyons Junction', 'tcourtenay1', '3ZqOWk', 'Argentina'),
(3, 'Israel', 'Laughtisse', 'ilaughtisse2@yolasite.com', 0, '7383 5th Junction', 'ilaughtisse2', 'zdeh5fYgUZu', 'United Kingdom'),
(4, 'Erastus', 'MacNair', 'emacnair3@economist.com', 1, '4 Pepper Wood Pass', 'emacnair3', 'PNCVaG', 'Colombia'),
(5, 'Prince', 'Iwanicki', 'piwanicki4@cam.ac.uk', 1, '6 Hoffman Street', 'piwanicki4', '1uJEqMgjHT', 'Thailand'),
(6, 'Howie', 'Shakelady', 'hshakelady5@is.gd', 1, '8 Susan Lane', 'hshakelady5', 'liyOFglDGdX', 'China'),
(7, 'Kiah', 'Aspall', 'kaspall6@timesonline.co.uk', 0, '53189 Dorton Plaza', 'kaspall6', 'JyQo4lDxRu', 'Congo'),
(8, 'Seana', 'Pakes', 'spakes7@wikipedia.org', 1, '5 Havey Parkway', 'spakes7', '2uhyF9a', 'Chile'),
(9, 'Mile', 'Borley', 'mborley8@discovery.com', 0, '2 Summer Ridge Plaza', 'mborley8', 'YnI1C4xvo', 'Burundi'),
(10, 'Dulcie', 'Scruton', 'dscruton9@miitbeian.gov.cn', 0, '9627 Carey Drive', 'dscruton9', 'AZ5rixs6rHEv', 'Portugal'),
(11, 'Harmon', 'Pecha', 'hpechaa@hostgator.com', 0, '64 Huxley Parkway', 'hpechaa', 'lY4OaZHdDoR', 'Portugal'),
(12, 'Karen', 'Choldcroft', 'kcholdcroftb@spiegel.de', 0, '6238 Clarendon Crossing', 'kcholdcroftb', 'Vz5pad', 'Poland'),
(13, 'Glennie', 'Avison', 'gavisonc@ucoz.com', 0, '7 Briar Crest Alley', 'gavisonc', 'zhElJVIp', 'United States'),
(14, 'Cariotta', 'Minchella', 'cminchellad@barnesandnoble.com', 1, '005 Westport Street', 'cminchellad', 'gDQWGRU', 'Portugal'),
(15, 'Mona', 'Simmank', 'msimmanke@va.gov', 0, '550 Manley Hill', 'msimmanke', 'LE77KHLnunq', 'Indonesia'),
(16, 'Cobby', 'Laver', 'claverf@last.fm', 1, '9574 Shopko Circle', 'claverf', '5cOZgFFlIBS', 'Tunisia'),
(17, 'Yoko', 'Duthie', 'yduthieg@arstechnica.com', 1, '9 Barby Street', 'yduthieg', '2MJScNI', 'China'),
(18, 'Porter', 'Lyes', 'plyesh@jalbum.net', 1, '771 Hollow Ridge Hill', 'plyesh', '0NZDEC', 'Indonesia'),
(19, 'Anderson', 'Roget', 'arogeti@theglobeandmail.com', 1, '96698 Birchwood Trail', 'arogeti', '8HXDswI2TIG', 'Philippines'),
(20, 'Kimberley', 'Angier', 'kangierj@blogger.com', 1, '8546 Kensington Court', 'kangierj', 'bezlp4', 'China'),
(21, 'Aldon', 'Allright', 'aallrightk@amazon.com', 1, '4554 Merchant Point', 'aallrightk', 'pI2IXzXn', 'Vietnam'),
(22, 'Duff', 'Ridger', 'dridgerl@issuu.com', 0, '8095 Sunnyside Parkway', 'dridgerl', 'dAOlgVO', 'Palestine'),
(23, 'Gabriell', 'Kellough', 'gkelloughm@hostgator.com', 0, '15321 Forest Park', 'gkelloughm', 'hmcdkGF', 'Indonesia'),
(24, 'Madella', 'Weben', 'mwebenn@webs.com', 1, '84 Heath Point', 'mwebenn', 'Fs5SzWRnRh', 'Philippines'),
(25, 'Carlin', 'Dodsley', 'cdodsleyo@t.co', 1, '56226 Judy Crossing', 'cdodsleyo', 'AzgS2DMm', 'United States'),
(26, 'Rubin', 'Mault', 'rmaultp@elegantthemes.com', 1, '476 Milwaukee Place', 'rmaultp', 'SmAFKU4CBG', 'Sweden'),
(27, 'Arnold', 'Maddick', 'amaddickq@surveymonkey.com', 0, '229 Anzinger Hill', 'amaddickq', 'dVPnS0w', 'Netherlands'),
(28, 'Worthington', 'Pickerill', 'wpickerillr@miibeian.gov.cn', 1, '62129 Waubesa Lane', 'wpickerillr', 'ESqXqMYwf', 'Indonesia'),
(29, 'Idalina', 'Hammer', 'ihammers@auda.org.au', 1, '8350 Dennis Avenue', 'ihammers', 'mpvvzFMhC', 'Croatia'),
(30, 'Doreen', 'Bercevelo', 'dbercevelot@cloudflare.com', 0, '55 Mifflin Point', 'dbercevelot', '50EnsQo', 'China'),
(31, 'Jimmie', 'Zipsell', 'jzipsellu@163.com', 1, '85690 Birchwood Park', 'jzipsellu', '3q0COo', 'Sudan'),
(32, 'Trescha', 'Castillo', 'tcastillov@jiathis.com', 1, '21 Doe Crossing Trail', 'tcastillov', 'KbWlOjdw', 'Yemen'),
(33, 'Angelina', 'Dunseath', 'adunseathw@digg.com', 1, '2275 Steensland Parkway', 'adunseathw', 'WCuSDo', 'Indonesia'),
(34, 'Tiphanie', 'Blabie', 'tblabiex@newsvine.com', 1, '3 Kensington Alley', 'tblabiex', '8WfnAg01p', 'Peru'),
(35, 'Desiri', 'Ayars', 'dayarsy@reference.com', 1, '70 Welch Court', 'dayarsy', 'FSoGxndDI7Z', 'Poland'),
(36, 'Blondell', 'Warner', 'bwarnerz@hostgator.com', 0, '9 Maywood Point', 'bwarnerz', 'Dwq9PG8', 'France'),
(37, 'Boycie', 'Haibel', 'bhaibel10@cam.ac.uk', 0, '83 Gulseth Pass', 'bhaibel10', 'CUAnWt', 'Afghanistan'),
(38, 'Obie', 'Yendall', 'oyendall11@t-online.de', 0, '76 Crowley Hill', 'oyendall11', 'qHS0cUvO', 'Nigeria'),
(39, 'Marta', 'Budd', 'mbudd12@yolasite.com', 0, '3 Calypso Hill', 'mbudd12', '8aAt5bPxbC', 'Philippines'),
(40, 'Sarge', 'Lummus', 'slummus13@cmu.edu', 1, '292 Lyons Junction', 'slummus13', 'GAJOanHjbW', 'Poland'),
(41, 'Rosalyn', 'Montford', 'rmontford14@google.ca', 1, '5 Parkside Crossing', 'rmontford14', 'zvRMFfO1', 'Cuba'),
(42, 'Ellary', 'Bercher', 'ebercher15@acquirethisname.com', 1, '9173 Lerdahl Pass', 'ebercher15', '3a10hkBuyjcS', 'China'),
(43, 'Gusti', 'Batcock', 'gbatcock16@mashable.com', 0, '744 Sundown Court', 'gbatcock16', 'ObQDXlNE', 'Nigeria'),
(44, 'Jean', 'McAdam', 'jmcadam17@hostgator.com', 1, '3984 Oxford Point', 'jmcadam17', 'bJCUI55', 'China'),
(45, 'Dru', 'Malan', 'dmalan18@wp.com', 1, '36 Hoepker Street', 'dmalan18', 'unN2fY6N', 'Canada'),
(46, 'Charlena', 'Oliphard', 'coliphard19@msn.com', 1, '7331 Welch Trail', 'coliphard19', '4p26SYepN6n', 'Brazil'),
(47, 'Janeva', 'Verbeek', 'jverbeek1a@nyu.edu', 0, '53754 Granby Place', 'jverbeek1a', 'BpTCW024kP', 'Malaysia'),
(48, 'Kelcie', 'Foden', 'kfoden1b@jimdo.com', 1, '5974 Westend Drive', 'kfoden1b', 'dZwGkQSaZFn', 'China'),
(49, 'Ami', 'Beretta', 'aberetta1c@shareasale.com', 0, '798 Lillian Street', 'aberetta1c', 'SiTKnP4', 'China'),
(50, 'Darlleen', 'Ind', 'dind1d@squidoo.com', 1, '64242 Goodland Plaza', 'dind1d', '1pNhEjDubk', 'Indonesia'),
(51, 'Lonny', 'Howlings', 'lhowlings1e@usa.gov', 1, '0 South Way', 'lhowlings1e', 'Sdvc0mChEKZ', 'China'),
(52, 'Brien', 'Bellwood', 'bbellwood1f@answers.com', 1, '4 Susan Parkway', 'bbellwood1f', 'JGAHmMI3O8', 'Philippines'),
(53, 'Edlin', 'Letixier', 'eletixier1g@google.ca', 1, '2167 Vahlen Terrace', 'eletixier1g', 'qv7JCVmtZE2B', 'Sri Lanka'),
(54, 'Zebulon', 'Lefwich', 'zlefwich1h@last.fm', 1, '88 South Plaza', 'zlefwich1h', 'jmygCLr', 'China'),
(55, 'Roby', 'Dale', 'rdale1i@china.com.cn', 1, '78093 Southridge Park', 'rdale1i', 'dFQmeK5w33', 'Azerbaijan'),
(56, 'Cthrine', 'Bottini', 'cbottini1j@aboutads.info', 0, '5786 Fremont Road', 'cbottini1j', 'BKAg8MS', 'Uganda'),
(57, 'Janka', 'Lutz', 'jlutz1k@hhs.gov', 1, '950 Florence Circle', 'jlutz1k', 'ZXTac6Df', 'Russia'),
(58, 'Bradney', 'Clynter', 'bclynter1l@ibm.com', 0, '4521 Petterle Plaza', 'bclynter1l', 'EiGKFAKIpCU', 'Portugal'),
(59, 'Thaine', 'Scamerdine', 'tscamerdine1m@oracle.com', 1, '3 Arapahoe Alley', 'tscamerdine1m', '63281CkTReA', 'China'),
(60, 'Stanley', 'Dedden', 'sdedden1n@seesaa.net', 1, '7 Stone Corner Parkway', 'sdedden1n', 'RCD3CXFps3pr', 'Afghanistan'),
(61, 'Ilene', 'Pass', 'ipass1o@ucoz.ru', 0, '32580 Bellgrove Pass', 'ipass1o', 'dcXO4oDDq', 'Philippines'),
(62, 'Frasco', 'McLernon', 'fmclernon1p@tripadvisor.com', 0, '02789 Hanover Terrace', 'fmclernon1p', 'LqKjFTI', 'China'),
(63, 'Rodger', 'Razzell', 'rrazzell1q@aboutads.info', 0, '5 Westend Circle', 'rrazzell1q', 'aWB7tE0TJ', 'China'),
(64, 'Antone', 'Nolli', 'anolli1r@redcross.org', 1, '665 Jenna Drive', 'anolli1r', '0N8v895k', 'Nigeria'),
(65, 'Bo', 'Fattori', 'bfattori1s@over-blog.com', 0, '08155 Heath Alley', 'bfattori1s', 'wttRZI0uVRB', 'Vietnam'),
(66, 'Chloe', 'Wickett', 'cwickett1t@acquirethisname.com', 1, '715 John Wall Alley', 'cwickett1t', 'vPCJ9PI', 'Czech Republic'),
(67, 'Nicoline', 'Blankenship', 'nblankenship1u@unc.edu', 1, '857 Luster Center', 'nblankenship1u', 'JzfkuYVoO1N', 'Nicaragua'),
(68, 'Jesse', 'Friese', 'jfriese1v@ftc.gov', 0, '00 Sommers Drive', 'jfriese1v', 'zvenRFW60sSa', 'Cameroon'),
(69, 'Aubry', 'Bullerwell', 'abullerwell1w@shareasale.com', 1, '232 Susan Terrace', 'abullerwell1w', 'KL6uzhGrQcJu', 'South Korea'),
(70, 'Glenn', 'Denyukhin', 'gdenyukhin1x@sohu.com', 1, '6310 Garrison Trail', 'gdenyukhin1x', 'lqMnzHf', 'Indonesia'),
(71, 'Kassia', 'Hawkes', 'khawkes1y@tamu.edu', 0, '9 Tomscot Pass', 'khawkes1y', '61t8nfNaOk', 'Thailand'),
(72, 'Francene', 'Wittleton', 'fwittleton1z@google.ru', 1, '33 Erie Hill', 'fwittleton1z', 'irBWspPKbQn', 'Russia'),
(73, 'Murielle', 'O''Geneay', 'mogeneay20@webs.com', 0, '680 Hayes Way', 'mogeneay20', 'smZicANkr', 'Portugal'),
(74, 'Stacy', 'Pitkeathley', 'spitkeathley21@networksolutions.com', 1, '590 Pearson Plaza', 'spitkeathley21', 'qkVd2O7R8', 'China'),
(75, 'Clayton', 'Flecknoe', 'cflecknoe22@amazon.com', 0, '03 Stephen Pass', 'cflecknoe22', 'oiCwmXWPUBtS', 'Malaysia'),
(76, 'Jeniffer', 'Wheadon', 'jwheadon23@earthlink.net', 0, '180 Scoville Parkway', 'jwheadon23', 'P06sj7', 'Sweden'),
(77, 'Teresita', 'Gates', 'tgates24@shop-pro.jp', 1, '342 Blue Bill Park Drive', 'tgates24', 'Lumr61qy', 'Ukraine'),
(78, 'Zia', 'Meeke', 'zmeeke25@skype.com', 1, '95 Arizona Parkway', 'zmeeke25', 'YnwqnYL', 'Cuba'),
(79, 'Lizbeth', 'Brokenshaw', 'lbrokenshaw26@wiley.com', 1, '0786 Superior Lane', 'lbrokenshaw26', 'O57W8Y5tuBOs', 'Indonesia'),
(80, 'Vilma', 'Scatchar', 'vscatchar27@squarespace.com', 1, '00933 Arapahoe Drive', 'vscatchar27', 'iHu83ZrX2C', 'Russia'),
(81, 'Malynda', 'Sicha', 'msicha28@photobucket.com', 0, '0 Hansons Center', 'msicha28', 'giGhY8r', 'Palestine'),
(82, 'Gabey', 'Beharrell', 'gbeharrell29@wordpress.com', 0, '6 Anzinger Center', 'gbeharrell29', 'G9aNT5Tsj', 'Sweden'),
(83, 'Felice', 'Mathieson', 'fmathieson2a@myspace.com', 0, '76489 Calypso Court', 'fmathieson2a', 'SUat8wpt', 'Burkina Faso'),
(84, 'Salomone', 'Romayne', 'sromayne2b@patch.com', 1, '90 Shasta Avenue', 'sromayne2b', 'I6QUd3Lfi', 'Philippines'),
(85, 'Mace', 'Depper', 'mdepper2c@newsvine.com', 1, '803 Golf Course Point', 'mdepper2c', 'K7XRoOeY', 'China'),
(86, 'Teodorico', 'Dahmel', 'tdahmel2d@cnn.com', 1, '37235 Kensington Terrace', 'tdahmel2d', 'LU01WGLQvamK', 'Panama'),
(87, 'Vivianne', 'Stutard', 'vstutard2e@usnews.com', 0, '20 Merrick Drive', 'vstutard2e', 'OQZej4nW1ABs', 'Brazil'),
(88, 'Syman', 'Soloway', 'ssoloway2f@flavors.me', 0, '2004 Milwaukee Crossing', 'ssoloway2f', '4SxRq7iOZsk', 'Poland'),
(89, 'Gustavus', 'Lidgate', 'glidgate2g@alexa.com', 0, '2534 Talmadge Circle', 'glidgate2g', 'xeZb7FwFEN', 'Chile'),
(90, 'Reggy', 'Sketcher', 'rsketcher2h@oakley.com', 1, '6790 Village Alley', 'rsketcher2h', 'wdL0VQkbxb', 'Mexico'),
(91, 'Monique', 'Mulqueeny', 'mmulqueeny2i@github.io', 0, '52581 Jay Terrace', 'mmulqueeny2i', 'yYmfXSLWNUG', 'Philippines'),
(92, 'Obadias', 'Maine', 'omaine2j@w3.org', 0, '44188 Gateway Alley', 'omaine2j', 'eQIj3fo', 'Indonesia'),
(93, 'Godart', 'Queyos', 'gqueyos2k@hexun.com', 0, '31 Sullivan Hill', 'gqueyos2k', 'GgRem9PM91', 'China'),
(94, 'Nisse', 'Poynor', 'npoynor2l@facebook.com', 0, '2 Annamark Way', 'npoynor2l', 'E7rzAzQ', 'Philippines'),
(95, 'Danni', 'Tabourier', 'dtabourier2m@yelp.com', 0, '37424 Ridge Oak Drive', 'dtabourier2m', 'uM6AOQ', 'Indonesia'),
(96, 'Crin', 'Sprowles', 'csprowles2n@list-manage.com', 0, '24099 Village Point', 'csprowles2n', '9vlLVO6kqT', 'Montenegro'),
(97, 'Floris', 'Illyes', 'fillyes2o@cisco.com', 0, '6682 Pierstorff Avenue', 'fillyes2o', 'fnmBjFO', 'Japan'),
(98, 'Shirl', 'Casotti', 'scasotti2p@over-blog.com', 0, '5 Buell Court', 'scasotti2p', 'ub8FY4apa', 'Indonesia'),
(99, 'Claresta', 'Beney', 'cbeney2q@vinaora.com', 0, '7 Cody Way', 'cbeney2q', 'UcYmCllJ', 'Portugal'),
(100, 'Marsh', 'Raffles', 'mraffles2r@disqus.com', 0, '5711 Linden Court', 'mraffles2r', 'VUEc9q9Z', 'France');



insert into studentmodule (stmd_student_id, stmd_module_id, stmd_year, grade, stmd_semester) values
(18, 4, 2020, 0, 1),
(27, 1, 2020, 0, 2),
(54, 15, 2020, 0, 1),
(98, 5, 2020, 0, 2),
(42, 21, 2020, 0, 1),
(50, 14, 2020, 0, 1),
(40, 9, 2020, 0, 2),
(80, 16, 2020, 0, 1),
(22, 2, 2020, 0, 1),
(63, 9, 2020, 0, 1),
(42, 3, 2020, 0, 1),
(51, 20, 2020, 0, 2),
(4, 2, 2020, 0, 2),
(61, 8, 2020, 0, 1),
(48, 2, 2020, 0, 1),
(57, 8, 2020, 0, 1),
(57, 15, 2020, 0, 2),
(55, 19, 2020, 0, 1),
(24, 10, 2020, 0, 2),
(58, 1, 2020, 0, 2),
(72, 14, 2020, 0, 1),
(24, 2, 2020, 0, 1),
(6, 8, 2020, 0, 1),
(9, 20, 2020, 0, 2),
(23, 13, 2020, 0, 1),
(81, 3, 2020, 0, 2),
(34, 7, 2020, 0, 1),
(53, 13, 2020, 0, 2),
(8, 5, 2020, 0, 2),
(91, 17, 2020, 0, 2),
(68, 17, 2020, 0, 1),
(31, 11, 2020, 0, 2),
(26, 19, 2020, 0, 2),
(66, 18, 2020, 0, 1),
(30, 10, 2020, 0, 2),
(35, 5, 2020, 0, 1),
(44, 9, 2020, 0, 1),
(42, 9, 2020, 0, 2),
(18, 7, 2020, 0, 1),
(74, 13, 2020, 0, 2),
(71, 18, 2020, 0, 1),
(53, 14, 2020, 0, 2),
(97, 6, 2020, 0, 1),
(11, 8, 2020, 0, 1),
(46, 18, 2020, 0, 2),
(56, 15, 2020, 0, 1),
(82, 10, 2020, 0, 1),
(58, 16, 2020, 0, 1),
(43, 6, 2020, 0, 2),
(42, 7, 2020, 0, 2),
(51, 18, 2020, 0, 2),
(87, 13, 2020, 0, 2),
(65, 14, 2020, 0, 2),
(66, 15, 2020, 0, 1),
(85, 13, 2020, 0, 2),
(1, 2, 2020, 0, 1),
(2, 1, 2020, 0, 2),
(72, 12, 2020, 0, 2),
(4, 9, 2020, 0, 2),
(83, 21, 2020, 0, 1),
(87, 9, 2020, 0, 1),
(1, 14, 2020, 0, 2),
(55, 13, 2020, 0, 1),
(8, 4, 2020, 0, 2),
(84, 20, 2020, 0, 2),
(64, 6, 2020, 0, 1),
(60, 6, 2020, 0, 1),
(49, 16, 2020, 0, 1),
(5, 7, 2020, 0, 2),
(89, 10, 2020, 0, 1),
(5, 14, 2020, 0, 2),
(47, 17, 2020, 0, 2),
(97, 13, 2020, 0, 1),
(79, 15, 2020, 0, 2),
(75, 3, 2020, 0, 2),
(38, 10, 2020, 0, 2),
(28, 3, 2020, 0, 1),
(30, 16, 2020, 0, 1),
(67, 14, 2020, 0, 2),
(82, 2, 2020, 0, 2),
(66, 6, 2020, 0, 1),
(22, 17, 2020, 0, 2),
(41, 3, 2020, 0, 2),
(59, 3, 2020, 0, 2),
(33, 12, 2020, 0, 2),
(47, 15, 2020, 0, 1),
(35, 14, 2020, 0, 2),
(63, 7, 2020, 0, 2),
(78, 18, 2020, 0, 2),
(4, 5, 2020, 0, 2),
(59, 1, 2020, 0, 1),
(49, 6, 2020, 0, 1),
(100, 3, 2020, 0, 1),
(42, 11, 2020, 0, 1),
(63, 13, 2020, 0, 2),
(69, 16, 2020, 0, 2),
(78, 7, 2020, 0, 1),
(49, 2, 2020, 0, 1),
(55, 15, 2020, 0, 2),
(6, 21, 2017, 94.58, 2),
(95, 12, 2011, 36.44, 2),
(26, 4, 2018, 88.62, 2),
(76, 19, 2013, 26.17, 2),
(31, 21, 2015, 54.0, 2),
(66, 14, 2016, 95.98, 1),
(43, 20, 2010, 86.33, 2),
(67, 17, 2013, 70.08, 1),
(64, 18, 2013, 4.11, 1),
(87, 7, 2019, 37.85, 2),
(52, 17, 2011, 21.48, 1),
(24, 5, 2018, 65.21, 2),
(53, 17, 2019, 31.74, 2),
(24, 17, 2015, 26.12, 2),
(5, 2, 2013, 44.76, 2),
(69, 4, 2016, 54.44, 1),
(13, 10, 2011, 95.13, 1),
(63, 17, 2014, 78.57, 1),
(77, 18, 2012, 40.67, 1),
(31, 5, 2016, 16.37, 1),
(53, 12, 2011, 64.49, 2),
(12, 8, 2014, 3.76, 2),
(12, 3, 2018, 55.82, 1),
(17, 17, 2010, 90.71, 2),
(46, 19, 2016, 32.2, 2),
(38, 2, 2018, 39.7, 1),
(71, 10, 2016, 48.85, 2),
(15, 9, 2017, 67.11, 1),
(100, 21, 2017, 47.09, 1),
(92, 13, 2013, 87.25, 2),
(71, 6, 2012, 88.18, 1),
(57, 10, 2017, 44.68, 2),
(86, 20, 2012, 69.34, 1),
(42, 13, 2018, 2.05, 2),
(95, 2, 2016, 22.15, 2),
(35, 12, 2016, 70.47, 1),
(76, 11, 2016, 13.6, 1),
(74, 15, 2012, 84.82, 2),
(54, 3, 2018, 98.37, 2),
(40, 12, 2018, 81.59, 2),
(33, 17, 2018, 39.96, 2),
(85, 21, 2011, 42.03, 1),
(70, 21, 2011, 20.14, 1),
(100, 6, 2016, 82.53, 1),
(39, 17, 2013, 99.79, 2),
(38, 15, 2012, 17.24, 1),
(16, 4, 2014, 59.52, 1),
(3, 1, 2018, 2.73, 1),
(16, 20, 2012, 0.14, 1),
(39, 6, 2012, 46.73, 2),
(16, 3, 2011, 49.7, 2),
(76, 2, 2017, 21.71, 1),
(28, 21, 2016, 41.95, 1),
(24, 9, 2011, 89.04, 1),
(21, 5, 2018, 59.44, 2),
(89, 2, 2018, 29.01, 1),
(20, 4, 2017, 87.43, 1),
(33, 6, 2012, 43.73, 2),
(81, 17, 2012, 7.93, 1),
(29, 12, 2011, 89.86, 1),
(17, 11, 2019, 56.68, 2),
(63, 15, 2017, 45.01, 1),
(24, 8, 2018, 90.75, 2),
(45, 7, 2012, 88.56, 1),
(94, 20, 2013, 79.38, 1),
(19, 6, 2017, 3.46, 1),
(10, 5, 2019, 5.21, 1),
(32, 2, 2011, 75.2, 2),
(18, 8, 2013, 99.84, 2),
(65, 17, 2015, 38.6, 1),
(23, 2, 2010, 32.6, 2),
(94, 3, 2015, 74.98, 2),
(96, 1, 2019, 97.31, 2),
(98, 1, 2017, 2.78, 1),
(95, 20, 2019, 18.23, 1),
(81, 18, 2010, 79.79, 1),
(28, 13, 2010, 5.83, 1),
(5, 6, 2018, 32.01, 1),
(76, 3, 2019, 72.43, 1),
(11, 3, 2019, 55.79, 2),
(3, 15, 2014, 79.05, 2),
(77, 21, 2017, 24.09, 1),
(27, 14, 2011, 83.24, 1),
(63, 16, 2010, 76.77, 1),
(80, 20, 2012, 48.34, 2),
(67, 20, 2011, 91.22, 2),
(21, 14, 2016, 31.37, 2),
(28, 9, 2013, 53.01, 2),
(95, 18, 2018, 60.26, 1),
(83, 5, 2016, 5.19, 2),
(17, 20, 2014, 75.09, 2),
(97, 2, 2013, 63.31, 2),
(8, 13, 2017, 53.74, 1),
(17, 10, 2012, 21.05, 1),
(31, 7, 2015, 86.92, 2),
(46, 16, 2017, 76.82, 2),
(74, 4, 2017, 73.67, 2),
(68, 10, 2011, 43.16, 1),
(96, 4, 2016, 19.25, 1),
(76, 21, 2018, 38.6, 1),
(44, 20, 2010, 30.51, 2),
(12, 5, 2013, 45.18, 2),
(26, 3, 2016, 45.41, 1),
(37, 5, 2013, 4.67, 2),
(99, 16, 2010, 39.74, 2),
(98, 19, 2018, 66.91, 2),
(82, 14, 2015, 98.36, 1),
(56, 20, 2014, 12.99, 1),
(58, 8, 2010, 79.1, 2),
(90, 5, 2019, 9.02, 2),
(72, 3, 2019, 51.16, 1),
(85, 19, 2017, 20.49, 2),
(63, 1, 2018, 23.04, 2),
(33, 4, 2018, 85.99, 1),
(18, 16, 2012, 36.4, 2),
(15, 15, 2019, 58.8, 2),
(77, 5, 2010, 48.12, 1),
(35, 11, 2018, 0.98, 1),
(85, 9, 2013, 79.13, 2),
(33, 20, 2011, 1.21, 2),
(61, 9, 2013, 12.58, 1),
(15, 12, 2012, 11.86, 2),
(53, 16, 2010, 91.72, 1),
(40, 17, 2012, 13.64, 2),
(40, 19, 2011, 32.24, 2),
(47, 7, 2011, 91.66, 2),
(62, 6, 2013, 18.58, 1),
(13, 8, 2013, 75.63, 1),
(78, 16, 2016, 97.58, 1),
(4, 3, 2016, 86.01, 1),
(6, 19, 2017, 90.21, 1),
(40, 8, 2015, 9.99, 1),
(39, 18, 2016, 24.03, 2),
(71, 15, 2018, 64.25, 2),
(71, 11, 2019, 38.81, 2),
(68, 14, 2015, 26.41, 1),
(44, 21, 2019, 4.28, 2),
(45, 21, 2017, 66.17, 2),
(2, 3, 2019, 92.57, 2),
(62, 17, 2017, 56.43, 1),
(93, 14, 2014, 22.11, 1),
(34, 15, 2014, 88.7, 1),
(40, 7, 2019, 2.55, 1),
(73, 3, 2016, 78.99, 2),
(66, 13, 2015, 6.27, 2),
(34, 11, 2010, 10.99, 1),
(55, 4, 2013, 18.78, 2),
(37, 4, 2018, 12.88, 1),
(3, 18, 2014, 87.78, 1),
(86, 11, 2014, 23.55, 2),
(5, 10, 2010, 23.32, 2),
(14, 21, 2017, 34.11, 2),
(74, 18, 2011, 30.19, 2),
(53, 4, 2014, 54.82, 1),
(81, 7, 2015, 27.78, 1),
(51, 13, 2018, 43.89, 2),
(35, 4, 2018, 37.88, 1),
(6, 17, 2019, 39.54, 2),
(83, 4, 2010, 13.73, 2),
(63, 11, 2013, 82.47, 1),
(8, 9, 2014, 5.48, 2),
(41, 20, 2019, 48.27, 1),
(14, 3, 2013, 26.8, 2),
(92, 8, 2012, 25.43, 2),
(79, 16, 2014, 24.84, 1),
(38, 19, 2013, 77.98, 2),
(71, 21, 2016, 94.71, 1),
(20, 9, 2011, 37.71, 2),
(15, 19, 2011, 21.13, 2),
(27, 12, 2017, 80.11, 2),
(75, 13, 2014, 27.8, 1),
(20, 20, 2015, 86.91, 2),
(78, 19, 2010, 38.49, 2),
(54, 2, 2010, 74.64, 1),
(39, 10, 2014, 99.73, 1),
(76, 14, 2010, 34.38, 1),
(70, 2, 2010, 3.29, 1),
(12, 16, 2019, 51.45, 2),
(50, 11, 2012, 7.48, 2),
(20, 2, 2012, 15.25, 1),
(91, 9, 2010, 49.11, 2),
(69, 13, 2011, 34.04, 2),
(43, 3, 2015, 81.62, 1),
(19, 8, 2016, 81.63, 2),
(90, 3, 2016, 68.21, 1),
(90, 4, 2012, 52.04, 2),
(100, 13, 2017, 20.0, 2),
(58, 7, 2016, 54.49, 2),
(55, 21, 2010, 82.79, 1),
(73, 10, 2019, 57.58, 2),
(26, 20, 2012, 88.63, 1),
(73, 14, 2011, 14.77, 2),
(53, 5, 2019, 44.9, 2),
(53, 2, 2016, 74.41, 1),
(14, 5, 2014, 18.45, 1),
(32, 8, 2016, 52.63, 2),
(41, 21, 2015, 50.14, 1),
(81, 8, 2019, 50.05, 1),
(4, 13, 2012, 69.32, 1),
(57, 3, 2012, 80.86, 1),
(100, 10, 2011, 29.49, 2),
(3, 20, 2010, 97.83, 1),
(49, 10, 2016, 7.82, 2),
(24, 11, 2011, 87.82, 1),
(61, 12, 2014, 41.04, 2),
(29, 17, 2010, 96.9, 2),
(6, 5, 2014, 72.22, 2),
(2, 2, 2019, 65.37, 1),
(36, 9, 2012, 39.33, 2),
(77, 8, 2013, 49.64, 1),
(89, 21, 2013, 88.7, 2),
(67, 18, 2010, 22.37, 1),
(78, 1, 2016, 4.96, 2),
(5, 21, 2018, 34.5, 2),
(82, 18, 2015, 4.75, 1),
(94, 21, 2012, 27.84, 2),
(22, 4, 2016, 20.71, 1),
(81, 13, 2019, 3.68, 1),
(53, 21, 2019, 82.23, 1),
(96, 10, 2013, 9.28, 1),
(78, 5, 2019, 33.31, 2),
(47, 3, 2014, 52.13, 2),
(23, 20, 2013, 69.09, 1),
(98, 7, 2015, 86.9, 2),
(92, 9, 2018, 13.93, 1),
(25, 2, 2011, 40.57, 1),
(83, 8, 2015, 35.13, 2),
(43, 8, 2011, 60.12, 1),
(67, 11, 2019, 49.65, 1),
(39, 2, 2016, 15.1, 2),
(51, 12, 2013, 97.76, 1),
(99, 4, 2012, 31.42, 1),
(11, 7, 2017, 1.07, 2),
(54, 18, 2013, 86.86, 1),
(19, 3, 2018, 65.67, 2),
(46, 21, 2012, 39.75, 1),
(64, 10, 2010, 61.21, 2),
(84, 7, 2010, 57.74, 2),
(32, 13, 2010, 28.54, 2),
(18, 10, 2017, 35.88, 2),
(4, 20, 2010, 93.44, 1),
(37, 13, 2015, 21.87, 2),
(30, 7, 2015, 72.04, 1),
(52, 20, 2018, 93.75, 2),
(77, 20, 2017, 13.61, 1),
(75, 16, 2016, 52.51, 2),
(38, 17, 2018, 37.76, 1),
(17, 18, 2014, 82.02, 2),
(57, 6, 2015, 89.85, 1),
(2, 13, 2016, 11.27, 2),
(20, 13, 2016, 79.01, 2),
(83, 10, 2012, 36.71, 2),
(73, 6, 2016, 47.65, 2),
(32, 9, 2011, 16.2, 1),
(43, 17, 2019, 61.61, 1),
(37, 18, 2013, 71.95, 1),
(28, 8, 2017, 85.01, 1),
(54, 10, 2014, 51.45, 1),
(21, 4, 2015, 98.03, 2),
(49, 8, 2011, 67.16, 2),
(71, 3, 2014, 84.59, 2),
(31, 20, 2013, 22.02, 1),
(98, 3, 2013, 84.74, 2),
(19, 9, 2012, 3.6, 2),
(66, 10, 2011, 83.91, 1),
(62, 14, 2012, 29.86, 1),
(63, 6, 2011, 35.13, 2),
(27, 17, 2011, 63.46, 1),
(84, 18, 2018, 68.05, 2),
(87, 20, 2013, 99.66, 2),
(91, 5, 2015, 21.27, 1),
(23, 21, 2013, 67.84, 2),
(42, 4, 2012, 29.7, 2),
(34, 10, 2016, 58.28, 2),
(8, 8, 2018, 32.32, 2),
(95, 19, 2018, 94.56, 2),
(96, 13, 2010, 35.52, 2),
(2, 11, 2014, 6.95, 2),
(96, 16, 2010, 95.44, 1),
(77, 19, 2014, 32.11, 1),
(56, 17, 2013, 81.42, 1),
(65, 20, 2018, 70.64, 2),
(1, 6, 2010, 91.25, 1),
(47, 5, 2017, 54.19, 1),
(18, 18, 2015, 80.58, 1),
(50, 8, 2016, 92.73, 2),
(29, 1, 2018, 51.32, 1),
(6, 12, 2010, 56.79, 1),
(68, 20, 2016, 28.81, 1),
(20, 16, 2014, 82.32, 2),
(30, 4, 2013, 37.27, 2),
(61, 7, 2019, 6.63, 1),
(53, 10, 2014, 8.31, 2),
(57, 1, 2018, 66.23, 2),
(17, 8, 2010, 1.65, 2),
(22, 12, 2018, 87.67, 1),
(45, 3, 2019, 86.61, 2),
(41, 18, 2010, 84.85, 1),
(16, 16, 2010, 28.43, 2),
(42, 20, 2013, 13.97, 2),
(5, 20, 2016, 92.54, 2),
(37, 12, 2012, 0.7, 2),
(70, 3, 2016, 15.4, 2),
(51, 19, 2010, 60.36, 2),
(54, 1, 2012, 46.78, 2),
(60, 1, 2016, 96.79, 2),
(29, 6, 2011, 60.03, 2),
(77, 4, 2014, 28.66, 2),
(19, 10, 2014, 82.2, 2),
(92, 15, 2013, 80.92, 2),
(13, 1, 2018, 27.12, 2),
(14, 13, 2011, 7.93, 1),
(93, 11, 2014, 20.69, 2),
(61, 10, 2014, 13.82, 1),
(82, 7, 2019, 85.18, 2),
(91, 8, 2016, 2.78, 2),
(46, 5, 2012, 92.67, 2),
(90, 16, 2017, 7.64, 2),
(52, 2, 2017, 55.16, 2),
(24, 20, 2011, 18.97, 2),
(80, 21, 2012, 17.86, 1),
(88, 13, 2012, 43.78, 1),
(76, 1, 2017, 50.36, 1),
(43, 14, 2019, 58.83, 1),
(83, 14, 2016, 30.82, 1),
(8, 16, 2012, 21.45, 1),
(31, 8, 2016, 29.82, 2),
(96, 3, 2016, 88.27, 1),
(22, 16, 2013, 34.9, 1),
(63, 14, 2019, 21.14, 2),
(33, 10, 2010, 68.97, 2),
(81, 15, 2017, 82.66, 2),
(27, 9, 2010, 65.75, 2),
(83, 9, 2012, 27.99, 2),
(94, 6, 2018, 24.6, 2),
(3, 2, 2013, 11.21, 1),
(15, 4, 2013, 23.45, 1),
(28, 7, 2011, 17.92, 2),
(26, 2, 2013, 65.68, 1),
(74, 2, 2019, 93.73, 1),
(96, 5, 2011, 2.26, 2),
(83, 7, 2016, 48.7, 1),
(72, 13, 2010, 74.13, 1),
(92, 16, 2016, 44.49, 1),
(59, 12, 2019, 68.2, 2),
(25, 12, 2019, 66.95, 2),
(80, 3, 2013, 69.49, 2),
(11, 11, 2011, 8.85, 2),
(99, 8, 2010, 30.15, 1),
(85, 3, 2014, 95.76, 1),
(47, 10, 2015, 22.63, 2),
(17, 9, 2013, 88.9, 1),
(55, 1, 2016, 83.17, 2),
(86, 15, 2012, 28.75, 2),
(82, 8, 2017, 4.29, 1),
(57, 11, 2017, 52.68, 1),
(33, 21, 2014, 43.37, 2),
(9, 15, 2016, 51.54, 2),
(26, 6, 2018, 44.59, 2),
(41, 13, 2015, 18.51, 2),
(13, 21, 2014, 34.99, 1),
(98, 8, 2018, 88.97, 1),
(55, 14, 2017, 69.42, 2),
(72, 2, 2011, 67.74, 1),
(28, 18, 2013, 74.94, 1),
(49, 15, 2011, 37.36, 1),
(100, 18, 2018, 75.55, 1),
(72, 10, 2013, 62.32, 2),
(95, 4, 2019, 17.37, 1),
(84, 21, 2016, 30.85, 1),
(95, 16, 2017, 48.33, 2);