package ua.pogodin.tryier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.dao.impl.BaseHiberDao;
import ua.pogodin.webapp.dao.impl.HiberJPADao;
import ua.pogodin.webapp.dao.impl.HibernateUtil;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.Trip;
import ua.pogodin.webapp.domain.User;

public class HibernateTryier {

	public static void main (String [] args){
		/*
		System.out.println("start");
		User user ;//= new User("try", "try", "name");
		DbConnection db = new HiberJPADao();
		
		Bus bus1 = new Bus(11, 13, true);
		Bus bus2 = new Bus(21, 13, true);
		Bus bus3 = new Bus(31, 13, true);
		
		
		
		BusApplication app1 = new BusApplication(10, 10);
		BusApplication app2 = new BusApplication(10, 10);
		BusApplication app3 = new BusApplication(10, 10);
		
		Trip trip1 = new Trip(bus1, app1, false);
		Trip trip2 = new Trip(bus1, app2, false);
		Trip trip3 = new Trip(bus1, app3, false);
		//Trip trip4 = new Trip(bus1, app3, false);
	
		
		db.createBus(bus1);
		Driver dr = new Driver("11", "pass" , "name", bus1);
		db.createUser(dr);
		dr = (Driver) db.getUserByLogin("11");
		//db.createBus(bus2);
		//db.createBus(bus3);
		
		db.createBusApp(app1);
		db.createBusApp(app2);
		db.createBusApp(app3);
		
		db.createTrip(trip1);
		db.createTrip(trip2);
		db.createTrip(trip3);
		//db.createTrip(trip4);
		
		List<Trip> trips = db.findTripsByDriverId(dr.getId());
		System.out.println("creating trips");
		db.deleteTrips(trips);*/
		
		List<Integer> ii = new ArrayList<Integer>();
		ii.add(1);
		ii.add(2);
		ii.add(4);
		ii.add(5);
		ii.add(3);
		ii.add(3);
		ii.add(6);
		ii.add(3);
		ii.add(9);
		for (int j=0, i = 0; j<ii.size(); j++) {
			if(ii.get(j).equals(3)){
				Collections.swap(ii, i, j);
				i++;
			}
		}
		System.out.println(ii);
		
	}
}
