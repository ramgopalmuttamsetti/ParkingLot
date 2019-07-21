package Ploting;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckArray  {

	int ploting_allocation;
	String remove_value;

	ArrayList<String> cardetails = new ArrayList<String>();
	ArrayList<String> orginal_cardetails = new ArrayList<String>();
	

	public CheckArray(ArrayList<String> cardetails) {
		// TODO Auto-generated constructor stub

		this.cardetails = cardetails;
	}
	
	
	//original array
	public void orginalarray(ArrayList<String> orginal)
	{
		orginal_cardetails=orginal;
	}
	
	
	
    //remove
	public void leave(String value) {

		remove_value = value.replaceFirst(".*?(\\d+).*", "$1");

		for (int i = 1; i <= cardetails.size(); i++) {

			if (i == Integer.parseInt(remove_value))
				cardetails.remove(i);

		}

		System.out.println("Slot number " + remove_value + "is free");

	}

	//get all list in array
	  public void status(String status) { 
		  
		System.out.println(status);
	    System.out.println("s.no Registration No Colour");
	
	  for(String s : cardetails) {
	  
	  if(cardetails.indexOf(s)!=0)
	  {
		  System.out.println(orginal_cardetails.indexOf(s)+" "+s);

	  }
	  }
	
	 }
	
	  
	  //checking slot numbers
	 public void checknumber(String slotnumber)
	 
	  {
	  
	 
	  for(int i=1;i<cardetails.size();i++) {
	
	  if(cardetails.get(i).equals(slotnumber)) {
	 
	  System.out.println("Allocated slot number:"+cardetails.indexOf(cardetails.get
	  (i))); 
	  
	  }
	  else
	  {
		  System.out.println("not found");
	  }
	
	 
	  }
	  
	  }
	 
	 //passing input to the color
	 public void color(String colorvalue)
	 {
	
		 for(String color :cardetails)
		 {
			 if(color.contains(colorvalue))
			 {
				 String [] value=color.split(" ");
				 
				
					  System.out.println("car number "+value[1]);
				 
			}
			
		 }
		 
	 }
 
	 //get slots based on color
	 
	 public void getslots(String getcolor)
	
	 {
		 for(String color :cardetails)
		 {
			 if(color.contains(getcolor))
			 {
				 
				
					  System.out.println("slots "+orginal_cardetails.indexOf(color));
				 
				
		 }
		 }
		 
		
	 }
	 
	 //car number present or not in slot
	 public void checkcarnum(String carnumber)
	 {
		 
		 
		
		 for(String color :cardetails)
		 {
			 if(!color.contains(carnumber))
			 {
				 
				
					  System.out.println("Not found" +carnumber);
				 
			}
			 else
			 {
				 System.out.println("found "+carnumber);
			 }
		 } 
	 }
	 
	 
	 //check avaiable of slots
	 
	 
	 public void avaliable(String entercarnumber)
	 {
		 if(orginal_cardetails.size()!=7)
		 {
			 System.out.println("Sorry slots full");
		 }
		 else
		 {
			
			 System.out.println("Slot Available");

			 cardetails.add(entercarnumber);
					 
		 }
	 }
	 
	 
	
			 
		 
		 
	 
	 
}
