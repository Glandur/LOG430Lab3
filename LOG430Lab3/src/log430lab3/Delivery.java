package log430lab3;

/** This class defines the Delivery object for the system.
* 
* @author A.J. Lattanze, CMU
* @version 1.6, 2012-Jun-19
*/

/*
* Modification Log **********************************************************
*
* v1.6, R. Champagne, 2012-Jun-19 - Various refactorings for new lab.
* 
* v1.5, R. Champagne, 2012-May-31 - Various refactorings for new lab.
* 
* v1.4, R. Champagne, 2012-Feb-02 - Various refactorings for new lab.
* 
* v1.3, R. Champagne, 2011-Feb-02 - Various refactorings, conversion of
* comments to javadoc format.
* 
* v1.2, R. Champagne, 2002-May-21 - Adapted for use at ETS.
* 
* v1.1, G.A.Lewis, 01/25/2001 - Bug in second constructor. Removed null
* assignment to deliveryID after being assigned a value.
* 
* v1.0, A.J. Lattanze, 12/29/99 - Original version.
* ***************************************************************************
*/

public class Delivery {

	/**
	 * Delivery ID
	 */
	private String deliveryID;

	/**
	 * Delivery address
	 */
	private String address;

	/**
	 * Time at which the delivery should be planned
	 */
	private String desiredDeliveryTime;

	/**
	 * Estimated duration of delivery
	 */
	private String estimatedDeliveryDuration;

	/**
	 * List of drivers assigned to the delivery
	 */
	private DriverList driversAssigned = new DriverList();

	public Delivery() {
		this(null);
	}

	public Delivery(String deliveryID) {
		this(deliveryID, null);
	}

	public Delivery(String deliveryID, String estimatedDuration) {
		this.setDeliveryID(deliveryID);
		this.setDesiredDeliveryTime(null);
		this.setEstimatedDeliveryDuration(estimatedDuration);
	}

	/**
	 * Assign a driver to a delivery.
	 * 
	 * @param driver
	 */
	public void assignDriver(Driver driver) {
		driversAssigned.addDriver(driver);
	}

	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}

	public String getDeliveryID() {
		return deliveryID;
	}

	public void setDesiredDeliveryTime(String time) {
		this.desiredDeliveryTime = time;
	}

	public String getDesiredDeliveryTime() {
		return desiredDeliveryTime;
	}

	public void setEstimatedDeliveryDuration(String duration) {
		this.estimatedDeliveryDuration = duration;
	}

	public String getEstimatedDeliveryDuration() {
		return estimatedDeliveryDuration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DriverList getDriversAssigned() {
		return driversAssigned;
	}

	public void setDriversAssigned(DriverList driversAssigned) {
		this.driversAssigned = driversAssigned;
	}
        
        private int getStartTimeInMinutes()
        {
            int estimatedDeliveryHours = Integer.parseInt(this.desiredDeliveryTime.substring(0, 2));
            int estimatedDeliveryMinutes = Integer.parseInt(this.desiredDeliveryTime.substring(2,4));
            int estimatedDelivery = (estimatedDeliveryHours * 60) + estimatedDeliveryMinutes;
            int estimatedDeliveryDurationHours = Integer.parseInt(this.estimatedDeliveryDuration.substring(0, 2));
            int estimatedDeliveryDurationMinutes = Integer.parseInt(this.estimatedDeliveryDuration.substring(2, 4));
            int estimatedDeliveryDuration = (estimatedDeliveryDurationHours * 60) + estimatedDeliveryDurationMinutes;
            return estimatedDelivery - (estimatedDeliveryDuration/2);
        }
        
        private int getEndTimeInMinutes()
        {
            int estimatedDeliveryHours = Integer.parseInt(this.desiredDeliveryTime.substring(0,2));
            int estimatedDeliveryMinutes = Integer.parseInt(this.desiredDeliveryTime.substring(2,4));
            int estimatedDelivery = (estimatedDeliveryHours * 60) + estimatedDeliveryMinutes;
            int estimatedDeliveryDurationHours = Integer.parseInt(this.estimatedDeliveryDuration.substring(0, 2));
            int estimatedDeliveryDurationMinutes = Integer.parseInt(this.estimatedDeliveryDuration.substring(2, 4));
            int estimatedDeliveryDuration = (estimatedDeliveryDurationHours * 60) + estimatedDeliveryDurationMinutes;
            return estimatedDelivery + (estimatedDeliveryDuration/2);
        }
        
        public int getEstimatedDeliveryTimeInMinutes()
        {
            int estimatedDeliveryDurationHours = Integer.parseInt(this.estimatedDeliveryDuration.substring(0, 2));
            int estimatedDeliveryDurationMinutes = Integer.parseInt(this.estimatedDeliveryDuration.substring(2,4));
            
            return (estimatedDeliveryDurationHours * 60) + estimatedDeliveryDurationMinutes;
        }
        
        public boolean isConflictWith(Delivery otherDelivery)
        {
            boolean cond1 = (getStartTimeInMinutes() <= otherDelivery.getStartTimeInMinutes())&&(otherDelivery.getStartTimeInMinutes() < getEndTimeInMinutes());
            boolean cond2 = (getStartTimeInMinutes() < otherDelivery.getEndTimeInMinutes()) && (otherDelivery.getEndTimeInMinutes() <= getEndTimeInMinutes());
            boolean cond3 = (otherDelivery.getStartTimeInMinutes() <= getStartTimeInMinutes()) && (getEndTimeInMinutes() <= otherDelivery.getEndTimeInMinutes());
            if (cond1 || cond2 || cond3) 
            {
                return true;
            }
            return false;
        }

} // Delivery class