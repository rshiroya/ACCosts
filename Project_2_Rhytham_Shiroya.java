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
*/


import java.util.Scanner;        // To use the Scanner for input.
public class Project_2_Rhytham_Shiroya
{
   public static void main(String[] args)
   {
     double length;              // Variable for the length of the room.
     double width;               // Variable for the width of the room.
     int shade;                  // Variable for the shade the room gets.
     double area;                // Variable for the area of the room.
     double btu;                 // Variable for the amount of BTUs the room will need.
     double factor = 0;          // Variable for the amount of increase/decrease in BTUs.
     String roomName;            // String to store the value
     String anotherRoom;         // String to store the value
     String shadeName="";
     int result_count=0;         // variable for the total amount of rooms user adds
     String text="";
     
     Scanner len = new Scanner(System.in);            // Create a Scanner object named len for the input.      
     do           // to compulsarily run the code in do loop even if the condition of while doesn't match.
     {
      result_count++;
      
      System.out.print("Please enter the name of the room: ");    // print the following statement.
      roomName = len.nextLine();                                  // to store the value of room name the user entes.
     
      System.out.print("\nPlease enter the length of the room (in feet):");          // Asks user for the length of the room.
      length = len.nextDouble();                       // It helps to read the usre's input.
     
     while ( length < 5)      // while loop to make sure that the value of length is less than 5 feet.
      {
         System.out.print("Invalid input.The length of the room cannot be less than 5 feet ");  // display the "" statement.
         System.out.print("\nPlease enter the length of the room (in feet):");                  // display the "" statement.
         length = len.nextDouble();          // It helps to read the user's input
      }
     
     System.out.print("\nPlease enter the width of the room (in feet):");           // Asks user for the width of the room.
     width = len.nextDouble();                        // It helps to read the user's input.
     while ( width < 5)     // while loop to make sure that the value of width is less than 5 feet.

     {  
         System.out.print("Invalid input.The width of the room cannot be less than 5 feet ");      // display the "" statement.
         System.out.print("\nPlease enter the width of the room (in feet):");                      // display the "" statement.
         width = len.nextDouble();                 // It helps to read the user's input
      }  
     
     area = calculateArea(length , width);                           // It calculate the area of the room based on the length and width given by the user.
     // 
//      // basic if else statement that creates conditions favored by the user's input.
//      if (area < 250)               // It determines how much BTUs would be needed based on the area of the room
//      {
//         btu = 5500;                // If the area of the room is less than 250, then the btu needed would be 5500 units.
//      }
//      else if(area >= 250 && area <500)
//      {
//        btu = 10000;                // If the area of the room is between 250 and 500, then the btu needed would be 5500 units.
//      }
//      else if(area >= 500 && area < 1000)
//      {
//         btu = 17500;               // If the area of the room is between 500 and 1000, then the btu needed would be 5500 units.
//      }
//      else 
//      {
//         btu = 24000;               // If the area of the room is greater than 24000, then the btu needed would be 5500 units.
//      }
//  
     System.out.println("\nWhat is the amount of shade that this room receives? ");   // Print the statement between ""      
     System.out.println("\n     1. Little Shade");                                    // Print the statement between ""
     System.out.println("     2. Moderate Shade");                                    // Print the statement between ""
     System.out.println("     3. Abundant Shade");                                    // Print the statement between ""
     
        
     System.out.print("\nPlease select from the options above:");                      // Asks the user to choose the amount of shade their room recieves.
     shade = len.nextInt();        // It helps to read the user's input.
     while (shade < 1 || shade > 3)         // while loop to make sure the selction from user is between 1 and 3
      {
         System.out.print("Invalid Selection. The user's menu selection for the amount of shade should be 1, 2, or 3. ");  // print the "" statement
         System.out.print("\nPlease select from the options above:");         // print the "" statement
         shade = len.nextInt();        // to read the user's input
      }  
     //Call the translateShadeChoiceToString method to convert shade choice to the name of shade
     shadeName = translateShadeChoiceToString(shade);   
		  
     //Call the calculateBTUsPerHour method to calculate total BTUs per hour 
     BTU = calculateBTUsPerHour(area, shade);

	  //Call the displayTitle method to display the title
	  displayTitle(text);
        
     //Call the displayRoomInformation method to display the name, area, amount of shade and btus of the room
     displayRoomInformation(roomName, area, shadeName, BTU);          
         
     String Shade = "";            // To create the string.
     // Constants to hold the options.
     static final String LIT = "Little";
     static final String MOD = "Moderate";
     static final String ABU = "Abundant";
     // constants to represent meny options.
     static final int LITTLE = 1;
     static final int MODERATE = 2;
     static final int ABUNDANT = 3;
     static final double LITTLE_SHADE_INCREASE = 0.15;
     static final double ABUNDANT_SHADE_DECREASE = 0.10;
     // basic if else statement that creates conditions favored by the user's input.
//      if (shade == LITTLE)               // If the user selects 1, the value of string Shade changes to Little Shade and BTUs increase by 15%.
//      {
//         Shade = LIT;
//         factor = btu * 0.15;
//         btu = btu + factor;
//         
//      }
//      else if(shade == MODERATE)           // If the user selects 2, the value of string Shade changes to Moderate Shade.
//      {
//         Shade = MOD;
//      }
//      else if (shade == ABUNDANT)          // If the user selects 3, the value of string Shade changes to Abundant Shade and BTUs decrease by 10%.
//      {
//         Shade = ABU;
//         factor = btu * 0.10;
//         btu = btu - factor;
//      }

 //     String str = "Air Conditioning Window Unit Cooling Capacity";      // String to hold the text given in "".
    //  System.out.println("\n" + str);                                    // Print the text being hold in string
//      System.out.print("Room name: " + roomName);               // print the "" statement and the name of the room entered by the user
//      System.out.println("\nRoom Area (in square feet): " + String.format("%.1f", area) ); // Print the statement in "" and display the area calculated from the user's input.
//      System.out.println("Amount of Shade: " + Shade);                   // Print the statement in "" and display the shade selected by the user.
//      int btuf = (int) btu;         // to remove the decimals from the double btu
//      System.out.println("BTU’s Per Hour needed: " +btuf);                // Print the statement in "" and display the amount of BTUs calculated from the user's input.
//  
     System.out.print("\nWould you like to enter information for another room (Y/N)? "); // print the "" statement
     len.nextLine();       
     anotherRoom = len.nextLine();      // to read the user's input
      
     System.out.println();
      
 
     while ( anotherRoom.equalsIgnoreCase( "Y" ));      
      
     System.out.println("The total number of rooms processed was: "+ result_count);

 
   }        //end main
}           //end class


   public static void displayTitle(String text)
   {
      text = "\nAir Conditioning Window Unit Cooling Capacity";
      System.out.println(text);
   }
   
   public static double calculateArea(double length, double width)
   {
      double area = length * width;
      
      return area;//return the area of the room
   }
   public static String translateShadeChoiceToString(int Shade)
   {
      String Shade="";
      
      //Use switch statement to appropriately handle the user's selection
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
      
      return Shade;//return the name of shade     
   } 
   public static double calculateBTUsPerHour(double area, int Shade )
   {
      double BTU;
      
      //Use if/else if statement to appropriately handle the user's selection
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
      
      switch(Shade)
      {
         case LITTLE:
         BTU = BTU + (BTU * LITTLE_SHADE_INCREASE);
		   break;
         
         case MODERATE:
         BTU = BTU;
         break;
         
         case ABUNDANT:
         BTU = BTU - (BTU * ABUNDANT_SHADE_DECREASE);
		   break;
      }
               
      return BTU;//return BTUs per hour
   }
   public static void displayRoomInformation(String roomName, double area, String shadeName, double BTU)
   {
      //Display the name of room
      System.out.print("Room name: " + roomName);
      
      //Display the area of room
      System.out.println("\nRoom Area (in square feet): " + area);
      
      //Display the name of the amount of shade a room gets
      System.out.println("Amount of Shade: "+shadeName);
      
      //Display the BTUs per hour needed 
      System.out.printf("BTU's Per Hour needed: %,.0f" , BTU );
   }   
      
}          
   
//---------- THE END ----------
//----------THANK YOU----------



