/*
Project 2
Rhytham Shiroya 
CSC 120-93
10-21-2019
                                                      ---------------------------------
                                                      ------      WELCOME!!!    -------                            
                                                      ---------------------------------
The following code will help the users calculate the correct size of air conditioner for a specific room size.
(1) The User would be first asked for their length and width of the room.
(2) Then they would be given the three options to choose from about amount of shade they get in their room.
(3) Based on the information given, the code would first calculate the area of the room, and then from the area, it would select the option for the amount of BTUs the room needs.
(4) If your room recieves little shade, the it would increase the btu capacity by 15%, and if abundant shade, then it would decrease the btu needs by 10%.
(5) Every information calculated would be given in the output of the program.
                                       *PROJECT 2*
(6) In addition, this program will now be able to enable users to add even more rooms to their calculation needs.
(7) Firstly, the program will ask the user to enter the name of the room.Then the required information would be taken from the user as per neeeded.
(8) Now the program will also check for the amount of length and width the user enters. So, the new minimum length and width the user can enter should be more than 5 feet. If entered less than and error will occur and the user would have to enter the value again.
(9) Next thing, moving on to the shades, the program will check the number you selected and it should be between 1 and 3, if entered inappropriate same thing would happen as of length and width
(10) After the calculation is completed, the proggram will ask the user if they want to add another room to the calculator, if user says yes then the whole process would repeat, but if no then the program would exit titself.
(11) At the end, the program will display the total number of rooms you added to the calculator.
Hope you like my program. Thank You.
                                         *PROJECT 3*
 (12) No changes in calculator but added some methods to calculate.
*/

import java.util.Scanner;
public class Project_3_Rhytham_Shiroya
{
   //Constants  	   
   static final String LIT = "Little";
   static final String MOD = "Moderate";
   static final String ABU = "Abundant";
   static final int LITTLE = 1;
   static final int MODERATE = 2;
   static final int ABUNDANT = 3; 
   static final double LITTLE_INCREASE = 0.15;
   static final double ABUNDANT_DECREASE = 0.10;
   public static void main (String[] args)
   {     
      Scanner len = new Scanner(System.in); // Create a Scanner object named len for the input.    
      //Variables
      double length=0;
      double width=0;
      int shade = 0;
      String roomName;
      String anotherRoom;
      String shadeName="";
      String text="";
      double area=0;
      double BTU =0;
      int resultCount=0;
      do                 // to compulsarily run the code in do loop even if the condition of while doesn't match.
      {
		  resultCount++;
		  System.out.print("Please enter the name of the room: ");
		  roomName = len.nextLine();
		  System.out.print("Please enter the length of the room (in feet): "); 
		  length = len.nextDouble();	  
         // while loop to make sure that the value of length is less than 5 feet.
		  while ( length < 5 )
		  {
			 System.out.print("Input invalid. The length of the room should be atleast 5 feet.\nPlease enter the length of the room (in feet): "); 
			 length = len.nextDouble();
		  }  			   
		  System.out.print("Please enter the width of the room (in feet): ");
		  width = len.nextDouble();	  
        // while loop to make sure that the value of width is less than 5 feet.
		  while ( width < 5 )
		  {
			 System.out.print("Input invalid. The width of the room should be atleast 5 feet.\nPlease enter the width of the room (in feet): "); 
			 width = len.nextDouble();
		  }           
		  System.out.println("What is the amount of shade that this room receives?");
		  System.out.println("\n\t1. Little Shade");
		  System.out.println("\t2. Moderate Shade");
		  System.out.println("\t3. Abundant Shade");	  
		  //Ask the user to select a option from the menu
		  System.out.print("\nPlease select from the options above: ");
		  shade = len.nextInt();	  
        //Validate the user's menu choice by using a while loop
		  while (shade < 1 || shade > 3)
		  {
			 System.out.print("Invalid Selection. The amount of shade should be 1, 2, or 3.\nPlease select an appropriate option from the menu: ");
			 shade = len.nextInt();
		  }
		  //Calling methods
		  area = calculateArea(length , width);        
        shadeName = translateShadeChoiceToString(shade);    
        BTU = calculateBTUsPerHour(area, shade);
		  displayTitle(text);
        displayRoomInformation(roomName, area, shadeName, BTU);  
		  System.out.println();
		  System.out.print("\nWould you like to enter information for another room (Y/N)? ");
		  len.nextLine();
		  anotherRoom = len.nextLine();
		  System.out.println();
      }   
      //The loop will repeat again no matter uppercase or lowercaser
      while ( anotherRoom.equalsIgnoreCase( "Y" ));
	   System.out.println("The total number of rooms processed was: " + resultCount);
   } 
   /**
      @param text: The title for output
   */
   public static void displayTitle(String text)
   {
      text = "\nAir Conditioning Window Unit Cooling Capacity";
      System.out.println(text);
   }  
   /**   
      @param length: The length of room
      @param width: The width of room
   */
   public static double calculateArea(double length, double width)
   {
      double area = length * width;    
      return area;
   }  
   /**
      @param shade: The amount of shade a room gets
   */
   public static String translateShadeChoiceToString(int shade)
   {
      String shadeName="";     
      switch(shade)
      {
         case LITTLE:
         shadeName = LIT;
         break;       
         case MODERATE:
         shadeName = MOD;
         break;       
         case ABUNDANT:
         shadeName = ABU;
       }   
      return shadeName;     
   }    
   /**
      @param area: The area of room
      @param shade: The amount of shade a room gets
   */
   public static double calculateBTUsPerHour(double area, int shade )
   {
      double BTU;     
      if ( area < 250 )
		{
	      BTU = 5500;
      }	  
		else if ( area <= 500 )
		{
		   BTU = 10000; 
		}		  
		else if ( area < 1000 )
		{
		   BTU = 17500;
		}		  
		else
	   {
			BTU = 24000;
		} 
      switch(shade)
      {
         case LITTLE:
         BTU = BTU + (BTU * LITTLE_INCREASE);
		   break;       
         case MODERATE:
         BTU = BTU;
         break;      
         case ABUNDANT:
         BTU = BTU - (BTU * ABUNDANT_DECREASE);
		   break;
      }        
      return BTU;
   }  
   /**
      @param roomName: The name of room
      @param area: The area of room
      @param shadeName: The name of shade a room gets
      @param BTU: BTUs per hour
   */
   public static void displayRoomInformation(String roomName, double area, String shadeName, double BTU)
   {
      System.out.print("Room name: " + roomName);
      System.out.println("\nRoom Area (in square feet): " + area);
      System.out.println("Amount of Shade: "+shadeName); 
      System.out.printf("BTU's Per Hour needed: %,.0f" , BTU );
   }       
}
   
//---------- THE END ----------
//----------THANK YOU----------