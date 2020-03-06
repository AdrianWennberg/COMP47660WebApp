package com.ed.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name ="module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mdl_ID;
    @NotBlank
    private String mdl_name;
    @NotBlank
    private String mdl_topic;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "stf_id")
    private Staff mdl_coordinator;
    @NotNull
    private int mdl_MAXSTD;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "stmd_module")
    private List<StudentModule> students;

    public Module() {
        super();
    }

    public Module(String name, String topic, Staff coordinator, int MAXSTD) {
        mdl_name = name;
        mdl_topic = topic;
        mdl_coordinator = coordinator;
        mdl_MAXSTD = MAXSTD;
    }

    public Long getMdl_ID() {
        return mdl_ID;
    }

    public void setMdl_ID(Long mdl_ID) {
        this.mdl_ID = mdl_ID;
    }

    public String getMdl_name() {
        return mdl_name;
    }

    public void setMdl_name(String mdl_name) {
        this.mdl_name = mdl_name;
    }

    public String getMdl_topic() {
        return mdl_topic;
    }

    public void setMdl_topic(String mdl_topic) {
        this.mdl_topic = mdl_topic;
    }

    public Staff getMdl_coordinator() {
        return mdl_coordinator;
    }

    public void setMdl_coordinator(Staff mdl_coordinator) {
        this.mdl_coordinator = mdl_coordinator;
    }

    public int getMdl_MAXSTD() {
        return mdl_MAXSTD;
    }

    public void setMdl_MAXSTD(int mdl_MAXSTD) {
        this.mdl_MAXSTD = mdl_MAXSTD;
    }

    public List<StudentModule> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModule> students) {
        this.students = students;
    }

    public Set<Integer> getAllYears() {
        Set<Integer> years = new HashSet<>();
        for (StudentModule student : students) {
            years.add(student.getStmd_year());
        }
        return years;
    }

    @Override
    public String toString() {
        return "Module{" + "mdl_ID=" + mdl_ID + ", mdl_name='" + mdl_name + '\'' + ", mdl_topic='" +
                mdl_topic +
                '\'' +
                ", mdl_coordinator=" +
                mdl_coordinator +
                ", mdl_MAXSTD=" +
                mdl_MAXSTD +
                '}';
    }
}