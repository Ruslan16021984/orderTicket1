package com.carbit3333333.orderticket.model;

import java.io.Serializable;

public class Order implements Serializable {
    String name;
    String secondNAme;
    String lastNAme;
    String date;
    String fromTo;
    String status;

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }


    public Order(String name, String secondNAme, String lastNAme, String date) {
        this.name = name;
        this.secondNAme = secondNAme;
        this.lastNAme = lastNAme;
        this.date = date;
    }

    public Order(String name, String secondNAme, String lastNAme, String date, String fromTo) {
        this(name, secondNAme, lastNAme, date);
        this.fromTo = fromTo;
    }

    public Order(String name, String secondNAme, String lastNAme, String date, String fromTo, String status) {
      this(name, secondNAme, lastNAme ,date , fromTo);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondNAme(String secondNAme) {
        this.secondNAme = secondNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }

    public String getName() {
        return name;
    }

    public String getSecondNAme() {
        return secondNAme;
    }

    public String getLastNAme() {
        return lastNAme;
    }
}
