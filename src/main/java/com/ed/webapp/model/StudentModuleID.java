package com.ed.webapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentModuleID implements Serializable {
    @Column
    Long stmd_student_id;
    @Column
    Long stmd_module_id;

    public StudentModuleID() {
    }

    public StudentModuleID(Long stmd_student_id, Long stmd_module_id) {
        this.stmd_student_id = stmd_student_id;
        this.stmd_module_id = stmd_module_id;
    }

    public Long getStmd_student_id() {
        return stmd_student_id;
    }

    public void setStmd_student_id(Long stmd_student_id) {
        this.stmd_student_id = stmd_student_id;
    }

    public Long getStmd_module_id() {
        return stmd_module_id;
    }

    public void setStmd_module_id(Long stmd_module_id) {
        this.stmd_module_id = stmd_module_id;
    }

    @Override
    public String toString() {
        return "StudentModuleID{" + "studentID=" + stmd_student_id + ", moduleID=" + stmd_module_id + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentModuleID that = (StudentModuleID) o;
        return stmd_student_id.equals(that.stmd_student_id) && stmd_module_id.equals(that.stmd_module_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stmd_student_id, stmd_module_id);
    }
}
