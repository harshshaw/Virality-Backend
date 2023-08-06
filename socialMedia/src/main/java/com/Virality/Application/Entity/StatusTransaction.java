package com.Virality.Application.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.transaction.TransactionStatus;

public enum StatusTransaction {
    PENDING("Pending"),
    Success("Success"),
    Fail("Fail");

    private String status;

    private  StatusTransaction(String status) {

        this.status= status;
    }

    public String status() {

        return this.status;
    }


    @JsonCreator
    public static StatusTransaction getDepartmentFromCode(String value) {

        for (StatusTransaction ts : StatusTransaction.values()) {

            if (ts.status().equals(value)) {

                return ts;
            }
        }

        return null;
    }
}
