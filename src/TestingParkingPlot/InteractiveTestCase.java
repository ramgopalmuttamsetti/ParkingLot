package TestingParkingPlot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parkingLot.ParkingAction;

class InteractiveTestCase {

	@Test
	void test() {
		
		//Interactive Test Case 
		ParkingAction parking = new ParkingAction();
		//create slots ftom input
		parking.createSlots();
		//leave slots from input
    	parking.leaveslot();
    	//get status of slots from input
    	parking.status();
    	//slots full or not checking
    	parking.slotfullornot();
    	//check and allocate slot
    	parking.checkallocatedslot();
    	//new car checking
    	parking.new_carchecking();
    	//carnumbers from colors
    	parking.commoncolorcarsnumbers();
    	//slots from color
		parking.colorslotsnumbers();
		//carnumber get slot
		parking.carnumberpresentslotornot();
		//car present or not
		parking.carthereornot();
	}

}
