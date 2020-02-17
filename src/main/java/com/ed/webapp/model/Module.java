package com.ed.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name ="module")
public class Module {
    @Id
    @GeneratedValue
    private long mdl_ID;
    @NotBlank
    private String mdl_name;
    @NotBlank
    private String mdl_topic;
    @NotBlank
    @ManyToOne
    private Staff mdl_coordinator;
    @NotBlank
    private int mdl_MAXSTD;

    public Module(){
        super();
    }

    public Module(long ID, String name, String topic, Staff coordinator, int MAXSTD){
        mdl_ID = ID;
        mdl_name = name;
        mdl_topic = topic;
        mdl_coordinator = coordinator;
        mdl_MAXSTD = MAXSTD;
    }

    public long getMdl_ID() {
        return mdl_ID;
    }

    public void setMdl_ID(long mdl_ID) {
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
}