package TestingParkingPlot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parkingLot.ParkingAction;

class CreateSlots {

	@Test
	void test() {
		
		ParkingAction parking = new ParkingAction();
		
		String [] args= new String [1];
		
		args[0] ="/home/hduser/parkingplot.txt";
		
	  
	    	//file input 
			parking.takeinputs(args);
			
			
			//creating slots
			parking.createSlots();
			
			//leave slots
			parking.leaveslot();
			
			//status
			parking.status();
		
			//slots full are not checking
			parking.slotfullornot();
			
		   //parking allocated or slots are full check
		   parking.checkallocatedslot();
		   
		   //common color cars get car numbers
		   parking.commoncolorcarsnumbers();

		   //slots of a particular car color
		   parking.colorslotsnumbers();
		   
		   //slot_number_for_registration_number
		   //slot_number_for_registration_number
		   parking.carnumberpresentslotornot();
	    
	    
		
	   
	   
	   
	}

}
