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
	private Integer minspeed;
	@Column(name = "minbusload")
	private Integer minbusload;
	@OneToMany(mappedBy = "busapp")
	private List<Trip> trips = new ArrayList<Trip>();

	public BusApplication(){
		
	}
	
	public BusApplication(int minSpeed, int minBusLoad) {
		this.minspeed = minSpeed;
		this.minbusload = minBusLoad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMinspeed() {
		return minspeed;
	}

	public void setMinspeed(int minSpeed) {
		this.minspeed = minSpeed;
	}

	public int getMinbusload() {
		return minbusload;
	}

	public void setMinbusload(int minBusLoad) {
		this.minbusload = minBusLoad;
	}

	@Override
	public String toString() {
		return "BusApplication{" + "id=" + id + ", minSpeed=" + minspeed + ", minBusLoad=" + minbusload + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BusApplication that = (BusApplication) o;

		if (minbusload != that.minbusload)
			return false;
		if (minspeed != that.minspeed)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = minspeed;
		result = 31 * result + minbusload;
		return result;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public List<Trip> getTrips() {
		return trips;
	}
}
