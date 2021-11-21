package cn.edu.uibe.domain;

import java.util.Date;

public class checkout extends checkoutKey {
    private Date checkouttime;

    public Date getCheckouttime() {
        return checkouttime;
    }

    public void setCheckouttime(Date checkouttime) {
        this.checkouttime = checkouttime;
    }
}