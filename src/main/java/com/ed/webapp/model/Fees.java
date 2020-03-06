package com.ed.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@IdClass(FeesID.class)
@Table(name ="fees")
public class Fees implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "fee_student_std_id")
    private Student fee_student;

    @Id
    @GeneratedValue
    private int fee_year;

    @NotNull
    private double fee_amount;

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @NotNull
    private boolean paid;

    public Fees() {
        super();
    }

    public Fees(Student student, int year, double amount) {
        fee_student = student;
        fee_year = year;
        fee_amount = amount;
    }

    public Student getFee_student() {
        return fee_student;
    }

    public void setFee_student(Student fee_student) {
        this.fee_student = fee_student;
    }

    public int getFee_year() {
        return fee_year;
    }

    public void setFee_year(int fee_year) {
        this.fee_year = fee_year;
    }

    public double getFee_amount() {
        return fee_amount;
    }

    public void setFee_amount(double fee_amount) {
        this.fee_amount = fee_amount;
    }
}