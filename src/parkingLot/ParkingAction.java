package parkingLot;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParkingAction implements ParkingLotMethods{
	
	Scanner sc = new Scanner(System.in) ;
	String input,slot_number,file_slot_number,car_fields,convert_word,convert_word_status,add_cardata,leave_slot;
	
	
	
	
	List<String> file_data =new ArrayList<String>();
	
	
	List<String> new_cardata =new ArrayList<String>();
	List<String> original_new_cardata =new ArrayList<String>();
	List<String> empty_slots =new ArrayList<String>();
   
	
	//taking input from the main class through args
	@Override
	public void takeinputs(String[] args) {
		// TODO Auto-generated method stub

		input = args[0];
		File file = new File(input);
		if(file.exists())
		{
			try {
				sc =new Scanner(file);
				while (sc.hasNextLine())
				{
					file_data.add(sc.nextLine());
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			slot_number =input.replaceFirst(".*?(\\d+).*", "$1");
			
			System.out.println("interactive slotnumber  "+slot_number);
		}
	}
   //create slots from the inputs 
	@Override
	public void createSlots(){
		// TODO Auto-generated method stub
		
		
		if(file_data.size()!=0)
		{
			file_slot_number = file_data.get(0).replaceFirst(".*?(\\d+).*", "$1");
			System.out.println("Created a parking lot with "+file_slot_number+" slots");
			new_cardata.clear();
			new_cardata.add("0");
			for(int i=1;i<=Integer.parseInt(file_slot_number);i++)
			{
				
				car_fields = file_data.get(i);
				new_cardata.add(car_fields);
				original_new_cardata.add(car_fields);
				if(i!=0)
				{
					System.out.println("Allocated slot number: "+i);
					System.out.print("\n");
				}
			}
		}
		else
		{
		     input=sc.nextLine();
		     
		     if(input!=null && !input.isEmpty())
		     {
		    	 slot_number =input.replaceFirst(".*?(\\d+).*", "$1");	
				 System.out.println("Created a parking lot with "+slot_number+" slots");
				 System.out.println("Enter car details");
				 
				 new_cardata.clear();
				 original_new_cardata.clear();
				 original_new_cardata.add("0");
				 new_cardata.add("0");
				
				 for(int i=1;i<=Integer.parseInt(slot_number);i++)
				{
					
					
					 car_fields = sc.nextLine();
					 if(car_fields!=null && !car_fields.isEmpty())
					 {
						 new_cardata.add(car_fields);
					     original_new_cardata.add(car_fields);
					     System.out.println("Allocated slot number: "+i);
					     System.out.print("\n");
					 }
					 else
					 {
						 System.out.println("enter input");
					 }
				     
				}
		     }
		     else
		     {
		    	 System.out.println("Pass Input");
		     }
		     
		}
	}
	
	//leave slots from the input
	@Override
	public void leaveslot() {
		// TODO Auto-generated method stub
		
		
			if(file_data.size()!=0)
			{
				for(int i=Integer.parseInt(file_slot_number);i<file_data.size();i++)
			    {
				
					
			    	if(file_data.get(i).contains("leave"))
			    	{
			    		 leave_slot = file_data.get(i).replaceFirst(".*?(\\d+).*", "$1");
			    		 
			    		 new_cardata.remove(Integer.parseInt(leave_slot));
			    		
			    		System.out.println("Slot number " +leave_slot +" is free\n");
			    	}
			    }
				
		}
		
		else
		{
			System.out.println("Leave slot");
			leave_slot =sc.nextLine().replaceFirst(".*?(\\d+).*", "$1");
			
			if(leave_slot!=null && !leave_slot.isEmpty())
			{
				for (int i = 1; i<new_cardata.size(); i++) 
				{
					if (i == Integer.parseInt(leave_slot))
					{
						new_cardata.remove(i);
						System.out.println("Slot number " +leave_slot +" is free\n");
					}
				}
			}
			else
			{
				System.out.println("Pass Input");
			}
			
		}
	}
//geting the status
	@Override
	public void status() {
		// TODO Auto-generated method stub

		if(file_data.size()!=0)
		{
			System.out.println("Slot No "+"Registration No "+"Colour");
			for(int i=0;i<file_data.size();i++)
		    {
				convert_word_status=file_data.get(i);

				if(file_data.get(i).contains("status"))
		    	{
		    		for(int j=1;j<file_data.size();j++)
		    		{
		    			if(new_cardata.contains(file_data.get(j)))
		    			{
		    				System.out.println(file_data.indexOf(file_data.get(j))+" "+file_data.get(j));
		    			}
		    			
		    		}
		    		
		    	}
		    }
		}
		else
		{
			
			System.out.println("status");
			convert_word_status = sc.nextLine();
			if(convert_word_status!=null && !convert_word_status.isEmpty())
    		{
				System.out.println("s.no Registration No Colour");
				 for(String s : new_cardata) 
				 {
					  if(new_cardata.indexOf(s)!=0) 
					  {
					  System.out.println(original_new_cardata.indexOf(s)+" "+s);
					  
					  }
				}
			}
			else
			{
				System.out.println("Pass Input");
			}
		}
	}

	

	@Override
	public void checkallocatedslot() {
		// TODO Auto-generated method stub
		
		if(file_data.size()!=0)
		{
			Collections.sort(empty_slots);
			for(int i=Integer.parseInt(file_slot_number);i<file_data.size();i++)
			{
				if(!new_cardata.contains(file_data.get(i)))
				{
					if(file_data.get(i).contains("park"))
					{
						slotfullornot();
						
						for(int j=0;j<empty_slots.size();j++)
						{
							new_cardata.add(Integer.parseInt(empty_slots.get(j)), file_data.get(i));
							System.out.println("Allocated slot number "+empty_slots.get(j));
							empty_slots.remove(j);
						}
					}
				}
			}
		}
		else
		{
			
			String check_car_number = sc.nextLine();
			Collections.sort(empty_slots);

			if(check_car_number!=null && !check_car_number.isEmpty())
			{
				for(int i=Integer.parseInt(slot_number);i<original_new_cardata.size();i++)
				{
					
				   
				   slotfullornot();
				   for(int j=0;j<empty_slots.size();j++)
					{
					   new_cardata.add(Integer.parseInt(empty_slots.get(j)), check_car_number);
					    System.out.println("Allocated slot number "+empty_slots.get(j));
						empty_slots.remove(j);
					 }
				}
			}
			else
			{
				System.out.println("Pass Input");
			}
		}
	}

	@Override
	public void slotfullornot() {
		// TODO Auto-generated method stub
		
		
		if(file_data.size()!=0)
		{
			if(new_cardata.size()-1==Integer.parseInt(file_slot_number))
			{
				
				System.out.println("Sorry, parking lot is full");
			}
			else
			{
				empty_slots.clear();
				for(int j=1;j<=Integer.parseInt(file_slot_number);j++)
				{
					if(!new_cardata.contains(file_data.get(j)))
					{
						
						empty_slots.add(String.valueOf(file_data.indexOf(file_data.get(j))));
						
					}
				}
			}
		}
		
		else
		{
			
		
				if(new_cardata.size()-1==Integer.parseInt(slot_number))
				{
					
					System.out.println("Sorry, parking lot is full");
				}
				else
				{
					empty_slots.clear();
					for(int j=1;j<=Integer.parseInt(slot_number);j++)
					{
						if(!new_cardata.contains(original_new_cardata.get(j)))
						{
							empty_slots.add(String.valueOf(original_new_cardata.indexOf(original_new_cardata.get(j))));
							
							
						}
					}
				}
			
			
			
		}
	}

	@Override
	public void commoncolorcarsnumbers() {
		// TODO Auto-generated method stub
		
		if(file_data.size()!=0)
		{
			for(int i=1;i<file_data.size();i++)
			{
				if(file_data.get(i).contains("registration_numbers_for_cars_with_colour"))
				{
					System.out.println(file_data.get(i));
					String color [] =file_data.get(i).split(" ");
					StringBuilder sb =new StringBuilder();
					
					for(int j=1;j<new_cardata.size();j++)
					{
						if(new_cardata.get(j).contains(color[1]))
						{
							String [] car_colors =new_cardata.get(j).split(" ");
							sb.append(car_colors[1]).append(",");
							
						}
					}
				System.out.println("\n");
				System.out.println(sb.toString().substring(0, sb.toString().length()-1));
				sb = null;
				}
			}
		}
		
		else
		{
			
			String color_name =sc.nextLine();
			StringBuilder sb =new StringBuilder();
            if(color_name!=null && !color_name.isEmpty())
            {
            	for(int i=1;i<new_cardata.size();i++)
    			{
    				if(new_cardata.get(i).contains(color_name))
    				{
    					
    					String [] car_colors =new_cardata.get(i).split(" ");
    					sb.append(car_colors[1]).append(",");
    					
    				}
    			}
            	System.out.println("\n");
    			System.out.println(sb.toString().substring(0, sb.toString().length()-1));
    			sb = null;
	
            }
            else
            {
            	System.out.println("Pass Input");
            }
		}
	}

	@Override
	public void colorslotsnumbers() {
		// TODO Auto-generated method stub
		
		
		if(file_data.size()!=0)
		{
			for(int i=1;i<file_data.size();i++)
			{
				if(file_data.get(i).contains("slot_numbers_for_cars_with_colour"))
				{
					
					
					String color [] =file_data.get(i).split(" ");
					
					
					StringBuilder sb =new StringBuilder();
					
					for(int j=1;j<new_cardata.size();j++)
					{
						if(new_cardata.get(j).contains(color[1]))
						{
							int slot_numbers=new_cardata.indexOf(new_cardata.get(j));
							sb.append(slot_numbers).append(",");
							
						}
					}
				System.out.println("\n");
				System.out.println(sb.toString().substring(0, sb.toString().length()-1));
				sb = null;
				}
			}
		}
		else
		{
			System.out.println("slot color getting");
			String color_slot_number = sc.nextLine();
			if(color_slot_number!=null && !color_slot_number.isEmpty())
			{
				StringBuilder sb =new StringBuilder();
				for(int j=1;j<new_cardata.size();j++)
				{
					if(new_cardata.get(j).contains(color_slot_number))
					{
						int slot_numbers=new_cardata.indexOf(new_cardata.get(j));
						sb.append(slot_numbers).append(",");
					}
				}
			System.out.println("\n");
			System.out.println(sb.toString().substring(0, sb.toString().length()-1));
			sb = null;
		
			}
			else
			{
				System.out.println("Pass Input Color");
			}
		}
			
	}
		
	@Override
	public void carnumberpresentslotornot() {
		// TODO Auto-generated method stub

		
		if(file_data.size()!=0)
		{
			
			for(int i=1;i<file_data.size();i++)
			{
				if(file_data.get(i).contains("slot_number_for_registration_number"))
				{
					String car_number [] =file_data.get(i).split(" ");
					
					for(int j=1;j<new_cardata.size();j++)
					{
						if(new_cardata.get(j).contains(car_number[1]))
						{
							int slot_numbers=new_cardata.indexOf(new_cardata.get(j));
							System.out.println("\n");
							System.out.println(slot_numbers);
							
						}
						
						else
						{
							System.out.println("Not Found");
							
							break;
						
						}
					}
				}
			}
		}
		else
		{
			
			
			String car_number =sc.nextLine();
			
			if(car_number!=null && !car_number.isEmpty())
			{
				for(int j=1;j<new_cardata.size();j++)
				{
					if(new_cardata.get(j).contains(car_number))
					{
						int slot_numbers=new_cardata.indexOf(new_cardata.get(j));
						System.out.println("\n");
						System.out.println(slot_numbers);
						
					}
					else
					{
						System.out.println("Not Found");
						break;
					}
				}
			}
			else
			{
				System.out.println("Pass Input");
			}
			
			
		}
	}

	@Override
	public void new_carchecking() {
		// TODO Auto-generated method stub
		System.out.println("ramgopal");
		
		String new_car_check = sc.nextLine();
		
		System.out.println(new_car_check+"ramgopal");
		slotfullornot();
		
	}

	@Override
	public void carthereornot() {
		// TODO Auto-generated method stub
		System.out.println("carthereornot");
		String car_number =sc.nextLine();
		if(car_number!=null && !car_number.isEmpty())
		{
			for(int j=1;j<new_cardata.size();j++)
			{
				if(new_cardata.get(j).contains(car_number))
				{
					int slot_numbers=new_cardata.indexOf(new_cardata.get(j));
					System.out.println("\n");
					System.out.println(slot_numbers);
				}
				else
				{
					
					System.out.println("Not Found");	
					break;    
					
				}
			}
		}
		
	}

	

	
}
