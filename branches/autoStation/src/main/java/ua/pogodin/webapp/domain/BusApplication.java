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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author elias
 */

@Entity
@Table(name = "bus_application")
public class BusApplication {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "minspeed")
	private int minSpeed;
	@Column(name = "minbusload")
	private int minBusLoad;
	private boolean isdone;
	@OneToMany(mappedBy = "busapp")
	private List<Trip> trips = new ArrayList<Trip>();

	public BusApplication(int minSpeed, int minBusLoad, boolean isdone, Long userId) {
		this.minSpeed = minSpeed;
		this.minBusLoad = minBusLoad;
		this.isdone = isdone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMinSpeed() {
		return minSpeed;
	}

	public void setMinSpeed(int minSpeed) {
		this.minSpeed = minSpeed;
	}

	public int getMinBusLoad() {
		return minBusLoad;
	}

	public void setMinBusLoad(int minBusLoad) {
		this.minBusLoad = minBusLoad;
	}

	public boolean isIsdone() {
		return isdone;
	}

	public void setIsdone(boolean isdone) {
		this.isdone = isdone;
	}

	@Override
	public String toString() {
		return "BusApplication{" + "id=" + id + ", minSpeed=" + minSpeed + ", minBusLoad=" + minBusLoad + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BusApplication that = (BusApplication) o;

		if (isdone != that.isdone)
			return false;
		if (minBusLoad != that.minBusLoad)
			return false;
		if (minSpeed != that.minSpeed)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = minSpeed;
		result = 31 * result + minBusLoad;
		result = 31 * result + (isdone ? 1 : 0);
		return result;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public List<Trip> getTrips() {
		return trips;
	}
}
