package ua.pogodin.webapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.Trip;

import static junit.framework.Assert.*;

public class TestDbUtil {

	DbConnection db = new DbUtil();

	@Before
	public void setUp() throws Exception {
	}
	@Ignore
	@Test
	public void createAndDeleteTrip() {
		Bus bus = new Bus(100, 100, true);
		BusApplication app = new BusApplication(10, 10);

		Trip trip = new Trip(bus, app, false);

		db.createBus(bus);
		db.createBusApp(app);
		db.createTrip(trip);
		Trip expected = db.getTripById(trip.getId());
		assertEquals(expected, trip);
		db.deleteTrip(trip);
		db.deleteEntity(bus);
		db.deleteEntity(app);
		
		
	}
	@Ignore
	@Test
	public void mustToUpdateBusWorkingOrder(){
		Bus bus = new Bus(999, 999, false);
		Driver dr = new Driver("testedBus", "tested", "tested",bus);
		db.createBus(bus);
		db.createUser(dr);
		db.updateBusWorkingOrder(dr.getBus(), true);
		
		assertEquals(true, bus.isWorkingorder());
		List<Object>objs = new ArrayList<Object>();
		objs.add(dr);
		objs.add(bus);
		db.deleteListEnteties(objs);
		
	}
	@Test
	public void testCreatingBus(){
		Driver dr = new Driver("testCreate", "tested", "tested", new Bus(11,12,false));
		db.createUser(dr);
		assertEquals(dr,db.getUserByLogin("testCreate"));
		db.deleteEntity(dr);
	}
	@Ignore
	@Test
	public void createAndDeleteBus() {
		Bus bus = new Bus(100, 100, false);
		db.createBus(bus);
		Bus busExpected = db.getBusById(bus.getId());
		assertEquals(busExpected, bus);
		db.deleteEntity(bus);
		assertNull(db.getBusById(busExpected.getId()));
	}
	@Test
	public void testGetBusByDriverId(){
		Bus bus = new Bus(120, 10, false);
		List<Object> os = new ArrayList<Object>();
		os.add(bus);
		db.createBus(bus);
		
		Driver dr = new Driver("tested", "tested", "tested", bus);
		os.add(dr);
		db.createUser(dr);
		
		assertEquals(bus, db.getBusByDriverId(dr.getId()));
		db.deleteListEnteties(os);
	}
	@Test
	public void getUserBelongToApp(){
		Bus bus1 = new Bus(100,100, true);
		Bus bus2 = new Bus(101,101, true);
		BusApplication app = new BusApplication(10, 10);
		Trip trip1 = new Trip(bus1, app, false);
		Trip trip2 = new Trip(bus2, app, false);
		
		db.createBus(bus1);
		db.createBus(bus2);
		Driver driver1 = new Driver("tested1", "tested1", "tested1", bus1);
		Driver driver2 = new Driver("tested2", "tested2", "tested2", bus2);
		db.createUser(driver1);
		db.createUser(driver2);
		db.createBusApp(app);
		db.createTrip(trip1);
		db.createTrip(trip2);
		
		List<Driver> drivers = db.getDriversByAppId(app.getId());
		
			if(drivers.size() == 2 && drivers.get(0).equals(driver1)){
				assertEquals(driver2, drivers.get(1));
			}else{
				assertEquals(driver2, drivers.get(0));
				assertEquals(driver1, drivers.get(1));
			}
			
		List<Object> objs = new ArrayList<Object>();
		objs.add(trip1);
		objs.add(trip2);
		objs.add(driver1);
		objs.add(driver2);
		objs.add(bus2);
		objs.add(bus1);
		objs.add(app);
		db.deleteListEnteties(objs);
		
	}
	@Test
	public void deleteListEntetiesTest(){
		Bus bus1 = new Bus(100,100, true);
		Bus bus2 = new Bus(101,101, true);
		BusApplication app = new BusApplication(10, 10);
		Driver driver1 = new Driver("tested1", "tested1", "tested1", bus1);
		Driver driver2 = new Driver("tested2", "tested2", "tested2", bus2);
		Trip trip1 = new Trip(bus1, app, false);
		Trip trip2 = new Trip(bus2, app, false);
		
		db.createBus(bus1);
		db.createBus(bus2);
		db.createUser(driver1);
		db.createUser(driver2);
		db.createBusApp(app);
		db.createTrip(trip1);
		db.createTrip(trip2);
		
		List<Object> objs = new ArrayList<Object>();
		objs.add(bus1);
		objs.add(bus2);
		objs.add(trip1);
		objs.add(app);
		objs.add(driver2);
		objs.add(trip2);
		objs.add(driver1);
		db.deleteListEnteties(objs);
		
		assertNull(db.getDriverById(driver1.getId()));
		assertNull(db.getDriverById(driver2.getId()));
		assertNull(db.getBusById(bus1.getId()));
		assertNull(db.getBusById(bus2.getId()));
		assertNull(db.getBusAppById(app.getId()));
		assertNull(db.getTripById(trip1.getId()));
		assertNull(db.getTripById(trip2.getId()));
	}

}

