import java.util.Scanner;
public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt){
        String retString = "";
        do{
            System.out.println("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt){
        do{
            System.out.println(prompt + ": ");
            while (!pipe.hasNextInt()) {
                System.out.println("Invalid input. " + prompt + ": ");
                pipe.nextLine(); // clear the input buffer
            }
        }while(!pipe.hasNextInt());

        return pipe.nextInt();
    }

    public static double getDouble(Scanner pipe, String prompt){
        do{
            System.out.println(prompt + ": ");
            while (!pipe.hasNextDouble()) {
                System.out.println("Invalid input. " + prompt + ": ");
                pipe.nextLine(); // clear the input buffer
            }
        }while(!pipe.hasNextDouble());

        return pipe.nextDouble();
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        boolean bounds = false;
        int userVal;
        do{
            System.out.println(prompt + " from "+ low + " to " + high + ": ");
            while (!pipe.hasNextInt()) {
                System.out.println("Invalid input. " + prompt + " from "+ low + " to " + high + ": ");
                pipe.nextLine(); // clear the input buffer
            }
            userVal = pipe.nextInt();
            if (userVal < low || userVal > high) {
                System.out.println("Input out of range. ");
            }
        }while(userVal < low || userVal > high);
        return userVal;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        boolean bounds = false;
        double userVal;
        do{
            System.out.println(prompt + " from "+ low + " to " + high + ": ");
            while (!pipe.hasNextDouble()) {
                System.out.println("Invalid input. " + prompt + " from "+ low + " to " + high + ": ");
                pipe.nextLine(); // clear the input buffer
            }
            userVal = pipe.nextDouble();
            if (userVal < low || userVal > high) {
                System.out.println("Input out of range. ");
            }
        }while(userVal < low || userVal > high);
        return userVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean confirmed = false;
        boolean valid;
        do{
            valid = true;
            System.out.print(prompt + " [Y/N]: ");
            //pipe.nextLine();
            String input = pipe.nextLine();
            if (input.equalsIgnoreCase("y")) {
                confirmed = true;
            }else if (input.equalsIgnoreCase("n")) {
                confirmed = false;
            }else{
                System.out.println("Invalid input. Please enter Y or N.");
                valid = false;
            }
        }while (!valid);
        return confirmed;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern) {
        String str;
        boolean valid = true;
        do {
            System.out.print(prompt + ": ");
            str = pipe.nextLine();
            valid = str.matches(regExPattern);
            if (!valid) {
                System.out.println("Invalid input: " + str);
            }
        } while (!valid);
        return str;
    }

    public static void PrettyHeader(String msg){
        if(msg.length() <= 54) {
            int mid = (54 - msg.length());
            int spacerL = 0;
            int spacerR = 0;
            // Top Line of the header
            for (int i = 0; i < 60; i++) {
                System.out.print('*');
            }
            System.out.println();

            // Middle w/ title
            System.out.print("***");
            // Ensures that the message is center even with an odd length.
            if (mid % 2 == 0) {
                spacerL = mid / 2;
                spacerR = spacerL;
            } else {
                spacerL = (mid - 1) / 2;
                spacerR = spacerL + 1;
            }
            for(int i = 0; i < spacerL; i++){
                System.out.print(' ');
            }
            System.out.print(msg);
            for(int i = 0; i < spacerR; i++){
                System.out.print(' ');
            }
            System.out.println("***");

            // Bottom line
            for (int i = 0; i < 60; i++) {
                System.out.print('*');
            }
        }else{
            System.out.println("Message is too long for the header.");
        }
    }
}