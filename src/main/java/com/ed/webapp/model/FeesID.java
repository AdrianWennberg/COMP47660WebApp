package com.ed.webapp.model;

import java.io.Serializable;
import java.util.Objects;

public class FeesID implements Serializable {
    Long fee_student;
    int fee_year;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FeesID feesID = (FeesID) o;
        return fee_year == feesID.fee_year && fee_student.equals(feesID.fee_student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fee_student, fee_year);
    }
}
