/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author elias
 */
@Entity
@Table(name = "busses")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer busload;
	private Integer maxspeed;
	private boolean workingorder;
	@OneToMany(mappedBy = "bus")
	private List<Trip> trips = new ArrayList<Trip>();
	@OneToOne(mappedBy = "bus")
	private Driver driver;

	public Bus() {
	}

	// only for dispatcher's bus
	public Bus(int busload, int maxSpeed, boolean workingOrder) {
		this.busload = busload;
		this.maxspeed = maxSpeed;
		this.workingorder = workingOrder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBusload() {
		return busload;
	}

	public void setBusload(int busload) {
		this.busload = busload;
	}

	public int getMaxSpeed() {
		return maxspeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxspeed = maxSpeed;
	}

	public boolean isWorkingOrder() {
		return workingorder;
	}

	public void setWorkingOrder(boolean workingOrder) {
		this.workingorder = workingOrder;
	}
	
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	
	public List<Trip> getTrips() {
		return trips;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Bus other = (Bus) obj;
		if (this.busload != other.busload) {
			return false;
		}
		if (this.maxspeed != other.maxspeed) {
			return false;
		}
		if (this.workingorder != other.workingorder) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 47 * hash + this.busload;
		hash = 47 * hash + this.maxspeed;
		hash = 47 * hash + (this.workingorder ? 1 : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "Bus{" + "busload=" + busload + ", maxSpeed=" + maxspeed + ", workingOrder=" + workingorder + '}';
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Driver getDriver() {
		return driver;
	}

}
