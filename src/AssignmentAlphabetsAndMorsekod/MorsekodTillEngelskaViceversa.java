package AssignmentAlphabetsAndMorsekod;
//----------------------- Main class

import java.util.Scanner;

public class MorsekodTillEngelskaViceversa {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConverterMorsekodAlphabets converterMorsekodAlphabets = new ConverterMorsekodAlphabets();
        boolean keepGoing = true;
        String selection = "";
        System.out.println("*************** Welcome to The Text <--> Morse-code Converter!! ***************");
        while (keepGoing) {
            String morsecode = "";
            String english = "";
            System.out.println("Write 1, 2 or 3 to select the following options: ");
            System.out.println("1. Enter alphabets (A-Z), " +
                    "numbers (0-9) or symbols (. , ?)  to convert into morse-code \n " +
                    "and separate each word by a space ");
            System.out.println("2. Enter morse-code comprising of '*' and '-' signs" +
                    " and separate each code by space to convert to alphabets (A-Z), " +
                    "digits (0-9) or symbols (. , ? )");
            System.out.println("3. Stop to terminate the program!!");
            selection = scan.nextLine();
            if (selection.equals("1")) {
                System.out.println("Enter alphabets, digits/symbols without space or more than one word with space ");
                // getting input from user: giving string and getting string of morse-code
                String engText = scan.nextLine();
                // Calling method from class ConverterMorsekodAlphabets
                morsecode = converterMorsekodAlphabets.getCode(engText);
                if (morsecode.equals("Invalid Input")) {
                    System.out.println("No morse-code generated!!");
                } else {
                    System.out.println("This gives Morse-code: " + morsecode);
                }
            }
            //____________________________Morse code to Text_________________________
            else if (selection.equals("2")) {
                // getting input from user: giving Morse code and getting string of text
                System.out.println("Enter your morse-code separated by space: ");
                String morseText = scan.nextLine();
                // Calling method from class ConverterMorsekodAlphabets
                english = converterMorsekodAlphabets.getText(morseText);
                if (english.equals("Invalid Input")) { // if (english =="")
                    System.out.println("Unable to covert code to text, digits or signs !!!");
                } else {
                    System.out.println("This gives text-code: " + english);
                }
            } else if (selection.equals("3")) {
                System.out.println("Thankyou for using The Text-Morse-Code Converter!!\n" +
                        "Terminating the program...");
                keepGoing = false;
            } else {
                System.out.println("Please select the correct option!");
            }
        } // while loop
    }
}
