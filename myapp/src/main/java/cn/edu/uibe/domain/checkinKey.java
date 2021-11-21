package cn.edu.uibe.domain;

import java.util.Date;

public class checkinKey {
    private Long id;

    private Date checkindate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(Date checkindate) {
        this.checkindate = checkindate;
    }
}