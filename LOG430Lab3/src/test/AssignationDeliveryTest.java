package test;

import static org.junit.Assert.*;
import log430lab3.Delivery;
import log430lab3.DeliveryReader;
import log430lab3.Driver;
import log430lab3.DriverReader;

import org.junit.Before;
import org.junit.Test;

public class AssignationDeliveryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test3a() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV200");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D150");
        myDriver.assignDelivery(myDelivery);
        myDelivery.assignDriver(myDriver);
        Driver my2ndDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV320");
        Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D164");
        my2ndDriver.assignDelivery(my2ndDelivery);
        my2ndDelivery.assignDriver(my2ndDriver);
        assertTrue(my2ndDriver.getDeliveriesAssigned().findDelivery(my2ndDelivery.getDeliveryID())!=null);
        
	}
	
	@Test
	public void test3b() {
		DeliveryReader myDeliveriesList = new DeliveryReader("src/files/deliveries.txt");
        DriverReader myDriverList = new DriverReader("src/files/drivers.txt");
        Driver myDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV200");
        Delivery myDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D150");
        myDriver.assignDelivery(myDelivery);
        myDelivery.assignDriver(myDriver);
        Driver my2ndDriver = myDriverList.getListOfDrivers().findTeacherByID("DRV320");
        Delivery my2ndDelivery = myDeliveriesList.getListOfDeliveries().findDelivery("D150");
        my2ndDriver.assignDelivery(my2ndDelivery);
        my2ndDelivery.assignDriver(my2ndDriver);
        assertTrue(my2ndDriver.getDeliveriesAssigned().findDelivery(my2ndDelivery.getDeliveryID())==null);
        
	}

}
