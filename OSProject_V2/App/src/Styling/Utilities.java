package Styling;

public class Utilities {

    /**
     * A method that prints the output to the conlose with a specific color and with classical printer type. 
     * @param str is the string given by the user
     * @param color used to change the string color
     */
    public static void displayWithDelay(String str, String color) {
        // Define ANSI escape sequences for the specified color
        String colorCode = "";
        switch (color) {
            case "red":
                colorCode = "\033[31m";
                break;
            case "green":
                colorCode = "\033[32m";
                break;
            case "yellow":
                colorCode = "\033[33m";
                break;
            case "blue":
                colorCode = "\033[34m";
                break;
            case "magenta":
                colorCode = "\033[35m";
                break;
            case "cyan":
                colorCode = "\033[36m";
                break;
            case "white":
                colorCode = "\033[37m";
                break;
            default:
                colorCode = "\033[0m"; // default color is reset
                break;
        }

        // Print each character of the string with the specified delay and color
        for (int i = 0; i < str.length(); i++) {
            System.out.print(colorCode + str.charAt(i));
            // System.out.flush(); // flush the output buffer to immediately display the
            // character
            try {
                Thread.sleep(18); // pausefor the specified delay
            } catch (InterruptedException e) {
                // handle the exception if necessary
            }
        }

        // Reset the color to default
        System.out.println("\033[0m");
    }

    /**
     * A method that prints the output to the conlose with a specific color and with classical printer
     * type without a line after finishing.
     * @param str is the string given by the user
     * @param color used to change the string color
     */
    public static void displayWithDelayNoLine(String str, String color) {
        // Define ANSI escape sequences for the specified color
        String colorCode = "";
        switch (color) {
            case "red":
                colorCode = "\033[31m";
                break;
            case "green":
                colorCode = "\033[32m";
                break;
            case "yellow":
                colorCode = "\033[33m";
                break;
            case "blue":
                colorCode = "\033[34m";
                break;
            case "magenta":
                colorCode = "\033[35m";
                break;
            case "cyan":
                colorCode = "\033[36m";
                break;
            case "white":
                colorCode = "\033[37m";
                break;
            default:
                colorCode = "\033[0m"; // default color is reset
                break;
        }

        // Print each character of the string with the specified delay and color
        for (int i = 0; i < str.length(); i++) {
            System.out.print(colorCode + str.charAt(i));
            // System.out.flush(); // flush the output buffer to immediately display the
            // character
            try {
                Thread.sleep(18); // pausefor the specified delay
            } catch (InterruptedException e) {
                // handle the exception if necessary
            }
        }

        // Reset the color to default
        System.out.print("\033[0m");
    }
}