package Ploting;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlotingMain extends CheckArray {
	
	
	
	public PlotingMain(ArrayList<String> ploting_allocation) {
		super(ploting_allocation);
		// TODO Auto-generated constructor stub
	}

	public static void main(String []args) throws Exception
	{
		
		
		String first_line,command_line="",car_entrydetails="",
				second_line,thrid_line,fourth_line,fiveth_line,six_line,seventh_line,eight_line,nineth_line;
		
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Welcome to Parking lot");
		
		
		
		first_line = sc.nextLine();
		System.out.println(first_line);
		 
		
		
		ArrayList<String> orginalcarenter = new ArrayList<String>();
		ArrayList<String> carenter = new ArrayList<String>();
		
		ArrayList<String> filedata = new ArrayList<String>();
		
		orginalcarenter.clear();
		carenter.clear();
        orginalcarenter.add("0");
        carenter.add("0");
		
        
        File file = new File(first_line);
		
		
		if(file.exists())
		{
			System.out.println("hiiiiiii");
			
			Scanner sc1 = new Scanner(file); 
			

			  
		    while (sc1.hasNextLine()) 
		    {
		    	filedata.add(sc1.nextLine());
			     // System.out.println(sc1.nextLine()); 
		    }
		    	
		    System.out.println(filedata.size());
		    
		    command_line=filedata.get(0).replaceFirst(".*?(\\d+).*", "$1");
		    
		    
		    for(int i=1;i<=Integer.parseInt(command_line);i++)
		    {
		    	String file_cardata =filedata.get(i);
		    	
		    	System.out.println(file_cardata);
		    	
		    	carenter.add(file_cardata);
		    	orginalcarenter.add(file_cardata);
		    }
		    
		    
		    
		    
		    
		     
		      
		      
		     
		}
		else
		{
			command_line = first_line.replaceFirst(".*?(\\d+).*", "$1");
			
			
			  
			for(int i=1;i<=Integer.parseInt(command_line);i++)
			{
				
				System.out.println("enter car details");
				
				
				
				second_line=sc.nextLine();
				
				
				
					System.out.println(second_line);
					orginalcarenter.add(second_line);
				    carenter.add(second_line);
				    System.out.println("Allocated slot number:"+i);
				
				
				
			}
			
			
			
			
			
			
					System.out.println("leave");
					
					thrid_line=sc.nextLine();
				
					System.out.println("pass status");
					
					fourth_line=sc.nextLine();
				
					System.out.println("allocating check");
					
					fiveth_line=sc.nextLine();
			
					System.out.println("registration_numbers_for_cars_with_colour");
					
					six_line=sc.nextLine();
					
					System.out.println("slot_numbers_for_cars_with_colour");
					
					seventh_line=sc.nextLine();
					
					System.out.println("slot_number_for_registration_number");
					eight_line=sc.nextLine();
					
					System.out.println("park available slot");
					nineth_line =sc.nextLine();
			
					
			
			
					CheckArray a =new CheckArray(orginalcarenter);
					a.orginalarray(carenter);
					a.leave(thrid_line);
					a.status(fourth_line);
					a.checknumber(fiveth_line);
					a.color(six_line);
					a.getslots(seventh_line);
					a.checkcarnum(eight_line);
					a.avaliable(nineth_line);
			
			
			
		}
		
		
		 
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
