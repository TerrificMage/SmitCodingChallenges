package oosequence;

import java.util.Date;

public class Flight {

	private Date departure;
	private Date arrival;

	public Flight(Date givenDeparture, Date givenArrival) {
		if (givenDeparture == null || givenArrival == null) {
			departure = givenDeparture;
			arrival = givenArrival;   
		}

		else if (givenDeparture.before(givenArrival)) {

			departure = givenDeparture;
			arrival = givenArrival;

		}
	}
	public Flight(Flight c) {
		departure = c.departure;
		arrival = c.arrival;
	}
	public long length() {
		if(departure==null) return 0;
		if(departure!=null & arrival!=null ) {
			long departTime = departure.getTime();
			long arriveTime = arrival.getTime();
			long diff = (arriveTime-departTime)/60000;
			return diff;
		}		
		return 0;
	}
	public Date getDeparture() {
		return departure;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setDeparture(Date date) {	
		if(date == null || arrival == null)departure = date;

		else if (date.before(arrival))departure = date;
	}
	public void setArrival(Date date) { 
		if(date == null || departure ==null)arrival = date;
		
		else if (departure.before(date))arrival = date;
	}

}