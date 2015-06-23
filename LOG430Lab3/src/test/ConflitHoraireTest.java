package test;

import static org.junit.Assert.*;
import log430lab3.Delivery;
import log430lab3.DeliveryReader;
import log430lab3.Driver;
import log430lab3.DriverReader;
import org.junit.Test;

public class ConflitHoraireTest {

	@Test
	public void test41a() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV200");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D150");
		myDriver.assignDelivery(myDelivery);
		myDelivery.assignDriver(myDriver);
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D158");
		assertTrue(myDelivery.isConflictWith(my2ndDelivery));
	}
	
	@Test
	public void test41b() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV210");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D154");
		myDriver.assignDelivery(myDelivery);
		myDelivery.assignDriver(myDriver);
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D155");
		assertTrue(myDelivery.isConflictWith(my2ndDelivery));
	}
	@Test
	public void test41c() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV200");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D150");
		myDriver.assignDelivery(myDelivery);
		myDelivery.assignDriver(myDriver);
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D181");
		assertTrue(myDelivery.isConflictWith(my2ndDelivery));
	}
	@Test
	public void test41d() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV320");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D157");
		myDriver.assignDelivery(myDelivery);
		myDelivery.assignDriver(myDriver);
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D154");
		assertFalse(myDelivery.isConflictWith(my2ndDelivery));
	}
	@Test
	public void test41e() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV320");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D154");
		myDriver.assignDelivery(myDelivery);
		myDelivery.assignDriver(myDriver);
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D157");
		assertFalse(myDelivery.isConflictWith(my2ndDelivery));
	}

}
