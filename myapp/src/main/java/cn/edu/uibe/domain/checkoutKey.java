package cn.edu.uibe.domain;

import java.util.Date;

public class checkoutKey {
    private Long id;

    private Date checkoutdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(Date checkoutdate) {
        this.checkoutdate = checkoutdate;
    }
}