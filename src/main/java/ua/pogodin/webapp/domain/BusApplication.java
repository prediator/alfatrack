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
import javax.persistence.Table;

/**
 * 
 * @author elias
 */

@Entity
@Table(name = "bus_application")
public class BusApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "minspeed")
	private Integer minSpeed;
	@Column(name = "minbusload")
	private Integer minBusLoad;
	@OneToMany(mappedBy = "busapp")
	private List<Trip> trips = new ArrayList<Trip>();

	public BusApplication(){
		
	}
	
	public BusApplication(int minSpeed, int minBusLoad) {
		this.minSpeed = minSpeed;
		this.minBusLoad = minBusLoad;
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
		return result;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public List<Trip> getTrips() {
		return trips;
	}
}
