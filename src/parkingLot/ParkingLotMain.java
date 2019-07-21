package parkingLot;



class ParkingMain extends ParkingAction
{
	
	
}

public class ParkingLotMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ParkingLot");
		ParkingMain main=new ParkingMain();
		if(args!=null && args.length!=0)
		{
			main.takeinputs(args);
			main.createSlots();
			main.leaveslot();
			main.status();
			main.slotfullornot();
			main.checkallocatedslot();
			main.commoncolorcarsnumbers();
			main.colorslotsnumbers();
			main.carnumberpresentslotornot();
		}
		else
		{
			main.createSlots();
			main.leaveslot();
			main.status();
			main.slotfullornot();
			main.checkallocatedslot();
			main.new_carchecking();
			main.commoncolorcarsnumbers();
			main.colorslotsnumbers();
			main.carnumberpresentslotornot();
			main.carthereornot();
		}
		
		
		
		
	}
}
