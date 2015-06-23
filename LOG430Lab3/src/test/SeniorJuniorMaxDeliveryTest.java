package test;

import static org.junit.Assert.*;
import log430lab3.Delivery;
import log430lab3.DeliveryReader;
import log430lab3.Driver;
import log430lab3.DriverReader;

import org.junit.Test;

public class SeniorJuniorMaxDeliveryTest {

	@Test
	public void test42a() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV200");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D185");
        assertFalse(myDriver.canAddDelivery(myDelivery));
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D183");
		assertTrue(myDriver.canAddDelivery(my2ndDelivery));
	}
	
	@Test
	public void test42b() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV330");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D179");
        assertFalse(myDriver.canAddDelivery(myDelivery));
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D180");
		assertTrue(myDriver.canAddDelivery(my2ndDelivery));
	}
	
	@Test
	public void test42c() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV200");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D183");
        assertTrue(myDriver.canAddDelivery(myDelivery));
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D185");
		assertFalse(myDriver.canAddDelivery(my2ndDelivery));
	}
	
	@Test
	public void test42d() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV330");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D180");
        assertTrue(myDriver.canAddDelivery(myDelivery));
		Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D179");
		assertFalse(myDriver.canAddDelivery(my2ndDelivery));
	}

}
