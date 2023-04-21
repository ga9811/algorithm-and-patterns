package com.yc.jdbc.Utils;

/**
The role of tools:
Handle user input in various situations, and get the user's console input according to the programmer's needs.
*/

import java.util.*;

public class Utility {
// Static properties. . .
     private static Scanner scanner = new Scanner(System.in);

    
     /**
      * Function: Read a menu option entered by the keyboard, value: range from 1 to 5
      * @return 1 - 5
      */
     
public static char readMenuSelection() {
         char c;
         for (; ; ) {
             String str = readKeyBoard(1, false);//A string containing one character
             c = str.charAt(0);//Convert the string to char type
             if (c != '1' && c != '2' &&
                 c != '3' && c != '4' && c != '5') {
                 System.out.print("Selection error, please re-enter:");
             } else break;
         }
         return c;
     }

/**
* Function: read a character entered by the keyboard
* @return a character
*/
     public static char readChar() {
         String str = readKeyBoard(1, false);//is a character
         return str. charAt(0);
     }
     /**
      * Function: Read a character entered by the keyboard, if you press Enter directly, it will return the specified default value; otherwise, it will return the input character
      * @param defaultValue specifies the default value
      * @return default value or input character
      */
    
     public static char readChar(char defaultValue) {
         String str = readKeyBoard(1, true);//Either an empty string or a character
         return (str. length() == 0) ? defaultValue : str. charAt(0);
     }

     /**
      * Function: read the integer input by the keyboard, the length is less than 2 digits
      * @return integer
      */
     public static int readInt() {
         int n;
         for (; ; ) {
             String str = readKeyBoard(10, false);//an integer, length<=10 bits
             try {
                 n = Integer.parseInt(str);//convert string to integer
                 break;
             } catch (NumberFormatException e) {
                 System.out.print("Number input error, please re-enter:");
             }
         }
         return n;
     }
     /**
      * 功能：读取键盘输入的double
      * @return 整数
      */
     public static double readDouble() {
         double n;
         for (; ; ) {
             String str = readKeyBoard(10, false);//一个整数，长度<=10位
             try {
                 n = Double.parseDouble(str);
                 break;
             } catch (NumberFormatException e) {
                 System.out.print("Number input error, please re-enter:");
             }
         }
         return n;
     }
     /**
      * Function: read the integer or default value entered by the keyboard, if you press Enter directly, return the default value, otherwise return the entered integer
      * @param defaultValue specifies the default value
      * @return integer or default value
      */
     public static int readInt(int defaultValue) {
         int n;
         for (; ; ) {
             String str = readKeyBoard(10, true);
             if (str. equals("")) {
                 return defaultValue;
             }

// exception handling...
             try {
                 n = Integer. parseInt(str);
                 break;
             } catch (NumberFormatException e) {
                 System.out.print("Number input error, please re-enter:");
             }
         }
         return n;
     }

     /**
      * Function: Read a string of specified length entered by the keyboard
      * @param limit limit length
      * @return a string of specified length
      */

     public static String readString(int limit) {
         return readKeyBoard(limit, false);
     }

     /**
      * Function: Read the string or default value of the specified length entered by the keyboard, if you press Enter directly, return the default value, otherwise return the string
      * @param limit limit length
      * @param defaultValue specifies the default value
      * @return a string of specified length
      */

     public static String readString(int limit, String defaultValue) {
         String str = readKeyBoard(limit, true);
         return str.equals("")? defaultValue : str;
     }


/**
* Function: read the confirmation option of keyboard input, Y or N
* Encapsulate small functions into a method.
* @return Y or N
*/
     public static char readConfirmSelection() {
         System.out.println("Please enter your choice (Y/N): Please choose carefully");
         char c;
         for (; ; ) {// infinite loop
         //Here, the characters will be accepted and converted to uppercase letters
         //y => Y n => N
             String str = readKeyBoard(1, false).toUpperCase();
             c = str. charAt(0);
             if (c == 'Y' || c == 'N') {
                 break;
             } else {
                 System.out.print("Selection error, please re-enter:");
             }
         }
         return c;
     }
     
     /**
     * Function: read the confirmation option of keyboard input, F or M
     * Encapsulate small functions into a method.
     * @return F or M
     */   
     public static char readGenderSelection() {
         System.out.println("Please enter your choice (F/M): ");
         char c;
         for (; ; ) {
             String str = readKeyBoard(1, false).toUpperCase();
             c = str. charAt(0);
             if (c == 'F' || c == 'M') {
                 break;
             } else {
                 System.out.print("Selection error, please re-enter:");
             }
         }
         return c;
     }
     
     /*
      * 
      */
     public static String readDegreeSelection() {
         System.out.println("Please enter your choice (P/M/B): ");
         String c;
         for (; ; ) {
             String str = readKeyBoard(1, false).toUpperCase();
             c = str. substring(0);
             if (c.equals("P") || c.equals("M")|| c.equals("B")) {
                 break;
             } else {
                 System.out.print("Selection error, please re-enter:");
             }
         } if(c.equals("P") ) {return "PHD";}
         else if (c.equals("M") ) {return "MASTER";}
         else
         return "BACHELOR";
     }

     /**
      * Function: read a string
      * @param limit read length
      * @param blankReturn If it is true, it means that the empty string can be read.
      * If false, empty strings cannot be read.
      *
* If the input is empty, or the length of the input is greater than the limit, it will prompt to re-enter.
      * @return
      */
     private static String readKeyBoard(int limit, boolean blankReturn) {
        
//Define the string
String line = "";

//scanner.hasNextLine() to determine whether there is a next line
         while (scanner. hasNextLine()) {
             line = scanner.nextLine();//read this line
           
//If line.length=0, that is, the user has not entered any content, press Enter directly
if (line. length() == 0) {
                 if (blankReturn) return line;//If blankReturn=true, you can return an empty string
                 else continue; //If blankReturn=false, the empty string is not accepted, and the content must be entered
             }

//If the content entered by the user is greater than the limit, prompt to rewrite the input
//If the content of the user such as >0 <= limit, I will accept it
             if (line. length() < 1 || line. length() > limit) {
                 System.out.print("Input length (cannot be greater than " + limit + ") error, please re-enter:");
                 continue;
             }
             break;
         }

         return line;
     }


}

