package com.example.FlamesApp.model;

import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;
@Entity


public class FlameEntity {
    private String a;
    private String b;

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }
}
