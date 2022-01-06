/*
Project 1

CSC 120-93
09-16-2019
                                                      ---------------------------------
                                                      ------      WELCOME!!!    -------                            
                                                      ---------------------------------
The following code will help the users calculate the correct size of air conditioner for a specific room size.
(1) The User would be first asked for their length and width of the room.
(2) Then they would be given the three options to choose from about amount of shade they get in their room.
(3) Based on the information given, the code would first calculate the area of the room, and then from the area, it would select the option for the amount of BTUs the room needs.
(4) If your room recieves little shade, the it would increase the btu capacity by 15%, and if abundant shade, then it would decrease the btu needs by 10%.
(5) Every information calculated would be given in the output of the program.
Hope you like my program. Thank You.
*/


import java.util.Scanner;        // To use the Scanner for input.
public class Project_1
{
   public static void main(String[] args)
   {
     double length;              // Variable for the length of the room.
     double width;               // Variable for the width of the room.
     int shade;                  // Variable for the shade the room gets.
     double area;                // Variable for the area of the room.
     double btu;                 // Variable for the amount of BTUs the room will need.
     double factor = 0;          // Variable for the amount of increase/decrease in BTUs.
     
     Scanner len = new Scanner(System.in);            // Create a Scanner object named len for the input.
     System.out.print("\nPlease enter the length of the room (in feet):");          // Asks user for the length of the room.
     length = len.nextDouble();                       // It helps to read the usre's input.
     
     System.out.print("\nPlease enter the width of the room (in feet):");           // Asks user for the width of the room.
     width = len.nextDouble();                        // It helps to read the user's input.
     
     area = length * width;                           // It calculate the area of the room based on the length and width given by the user.
     
     // basic if else statement that creates conditions favored by the user's input.
     if (area < 250)               // It determines how much BTUs would be needed based on the area of the room
     {
        btu = 5500;                // If the area of the room is less than 250, then the btu needed would be 5500 units.
     }
     else if(area >= 250 && area <500)
     {
       btu = 10000;                // If the area of the room is between 250 and 500, then the btu needed would be 5500 units.
     }
     else if(area >= 500 && area < 1000)
     {
        btu = 17500;               // If the area of the room is between 500 and 1000, then the btu needed would be 5500 units.
     }
     else 
     {
        btu = 24000;               // If the area of the room is greater than 24000, then the btu needed would be 5500 units.
     }
 
     System.out.println("\nWhat is the amount of shade that this room receives? ");   // Print the statement between ""      
     System.out.println("\n     1. Little Shade");                                    // Print the statement between ""
     System.out.println("     2. Moderate Shade");                                    // Print the statement between ""
     System.out.println("     3. Abundant Shade");                                    // Print the statement between ""
          
     System.out.print("\nPlease select from the options above:");                      // Asks the user to choose the amount of shade their room recieves.
     shade = len.nextInt();        // It helps to read the user's input.

     String Shade = "";            // To create the string.
     // Constants to hold the options.
     final String lit = "Little";
     final String mod = "Moderate";
     final String abu = "Abundant";
     // constants to represent meny options.
     final int Little = 1;
     final int Moderate = 2;
     final int Abundant = 3;
     // basic if else statement that creates conditions favored by the user's input.
     if (shade == Little)               // If the user selects 1, the value of string Shade changes to Little Shade and BTUs increase by 15%.
     {
        Shade = lit;
        factor = btu * 0.15;
        btu = btu + factor;
        
     }
     else if(shade == Moderate)           // If the user selects 2, the value of string Shade changes to Moderate Shade.
     {
        Shade = mod;
     }
     else if (shade == Abundant)          // If the user selects 3, the value of string Shade changes to Abundant Shade and BTUs decrease by 10%.
     {
        Shade = abu;
        factor = btu * 0.10;
        btu = btu - factor;
     }

     String str = "Air Conditioning Window Unit Cooling Capacity";      // String to hold the text given in "".
     System.out.println("\n" + str);                                    // Print the text being hold in string
     
     System.out.println("\nRoom Area (in square feet): " + String.format("%.1f", area) ); // Print the statement in "" and display the area calculated from the user's input.
     System.out.println("Amount of Shade: " + Shade);                   // Print the statement in "" and display the shade selected by the user.
     int btuf = (int) btu;         // to remove the decimals from the double btu
     System.out.println("BTU’s Per Hour needed: " +btuf);                // Print the statement in "" and display the amount of BTUs calculated from the user's input.
 
   }        //end main
}           //end class
//---------- THE END ----------
//----------THANK YOU----------



