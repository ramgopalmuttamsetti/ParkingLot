package parkingLot;





public class ParkingLotMain extends ParkingAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ParkingLot");
		ParkingLotMain main=new ParkingLotMain();
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
			//method for check
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
