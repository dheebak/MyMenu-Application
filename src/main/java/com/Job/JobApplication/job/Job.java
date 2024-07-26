package com.Job.JobApplication.job;

import java.util.Date;

public class Job {
    private Long id;
    private String name;
    private String housename;
    private long phoneno;
    private int addressid;
    private Date lastOrderDate;

    public Job(Long id, String name, String housename, long phoneno, int addressid, Date lastOrderDate) {
        this.id = id;
        this.name = name;
        this.housename = housename;
        this.phoneno = phoneno;
        this.addressid = addressid;
        this.lastOrderDate = lastOrderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }
}
