// This is the main class
package streamservassignment;

import java.util.Scanner;

public class StreamServAssignment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Newesst series in 2025");
            System.out.print("Press 1 to go to Main Menu:");
            String choice = scanner.nextLine();

            if (!choice.equals("1")) {
                Series.ExitSeriesApplication();
            }
//menu
            System.out.println("1 Capture series");
            System.out.println("2 Search series");
            System.out.println("3 Update age restriction.");
            System.out.println("4 Delete a series");
            System.out.println("5 Print series report");
            System.out.println("6 Exit");

            System.out.print("Enter option: ");
            String menuChoice = scanner.nextLine();

            switch (menuChoice) {
                case "1":
                    Series.CaptureSeries();
                    break;
                case "2":
                    Series.SearchSeries();
                    break;
                case "3":
                    Series.UpdateSeries();
                    break;
                case "4":
                    Series.DeleteSeries();
                    break;
                case "5":
                    Series.SeriesReport();
                    break;
                case "6":
                    Series.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("");
                    System.out.println("Not an option... shh...");
                    
            }
        }
    }
}
