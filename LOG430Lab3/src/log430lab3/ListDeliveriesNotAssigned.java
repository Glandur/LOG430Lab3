package log430lab3;

import java.util.Observable;

public class ListDeliveriesNotAssigned extends Communication {

	public ListDeliveriesNotAssigned(Integer registrationNumber, String componentName) {
		super(registrationNumber, componentName);
	}

	/**
	 * The update() method is an abstract method that is called whenever the
	 * notifyObservers() method is called by the Observable class First we check
	 * to see if the NotificationNumber is equal to this thread's
	 * RegistrationNumber. If they are, then we execute.
	 * 
	 * @see ca.etsmtl.log430.lab3.Communication#update(java.util.Observable,
	 *      java.lang.Object)
	 */
	public void update(Observable thing, Object notificationNumber) {

		if (registrationNumber.compareTo((Integer) notificationNumber) == 0) {
			Displays display = new Displays();
			display.displayDeliveryNotAssigned(CommonData.theListOfDeliveries
					.getListOfDeliveries());
		}
	}
}