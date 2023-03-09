package oosequence;

import java.util.Date;

public class Flight {
    Date departure;
    Date arrival;

    // Constructor with two arguments
    public Flight(Date departure, Date arrival) {
        if (departure == null || arrival == null) {
            this.departure = departure;
            this.arrival = arrival;
        } else if (departure.before(arrival)) {
            this.departure = departure;
            this.arrival = arrival;
        } // else, leave the default value of null for both departure and arrival
    }

    // Copy constructor
    public Flight(Flight flight) {
        this.departure = flight.departure;
        this.arrival = flight.arrival;
    }

    // Getter for departure
    public Date getDeparture() {
        return departure;
    }

    // Setter for departure
    public void setDeparture(Date departure) {
        if (departure == null || this.arrival == null || departure.before(this.arrival)) {
            this.departure = departure;
        }
    }

    // Getter for arrival
    public Date getArrival() {
        return arrival;
    }

    // Setter for arrival
    public void setArrival(Date arrival) {
        if (arrival == null || this.departure == null || this.departure.before(arrival)) {
            this.arrival = arrival;
        }
    }

    // Method to calculate flight duration in minutes
    public long length() {
        if (departure != null && arrival != null) {
            return (arrival.getTime() - departure.getTime()) / (1000 * 60);
        }
        return 0;
    }
    
    
}
