package cn.edu.uibe.domain;

import java.util.Date;

public class checkin extends checkinKey {
    private Date checkintime;
    

    public Date getCheckintime() {
        return checkintime;
    }

    public checkin() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public void setCheckintime(Date checkintime) {
        this.checkintime = checkintime;

    }
}