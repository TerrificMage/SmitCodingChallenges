package oosequence;

import java.util.Date;

public class Flight {
    Date departure;
    Date arrival;

    public Flight(Date departure, Date arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public Flight(Flight f) {
        this.departure = f.departure;
        this.arrival = f.arrival;
    }

    public long length() {
        return 0;
    }

    public Date getDeparture() {
        return departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }
}
