
package streamservassignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {

    private static ArrayList<Series> seriesList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;

    public Series(String seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
//getter
    public String getSeriesId() {
        return seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }

    public int getSeriesNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }

    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes) {
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
//information gatherer
    public static void CaptureSeries() {
        System.out.println("Capture Series");

        System.out.print("Enter series id: ");
        String id = scanner.nextLine();

        System.out.print("Enter name of series: ");
        String name = scanner.nextLine();

        int age = readInt("Enter the age restriction of series (2-18): ");
        while (age < 2 || age > 18) {
            System.out.println("Incorrect age restriction");
            age = readInt("Enter the series age restriction : ");
        }

        int episodes = readInt("How many episodes are there in " + name + ": ");

        Series s = new Series(id, name, age, episodes);
        seriesList.add(s);

        System.out.println("Series Captured");
    }

    public static void SearchSeries() {
        System.out.print("Search series ID: ");
        String id = scanner.nextLine();

        Series s = findSeriesById(id);
        if (s != null) {
            printSeries(s);
        } else {
            System.out.println("Series ID (" + id + ") was not found");
        }
    }

    public static void UpdateSeries() {
        System.out.print("Enter updated ID: ");
        String id = scanner.nextLine();

        Series s = findSeriesById(id);
        if (s != null) {
            System.out.print("Enter new series name: ");
            s.setSeriesName(scanner.nextLine());

            int age = readInt("Enter new age restriction: ");
            while (age < 2 || age > 18) {
                System.out.println("This is an invalid age restriction ");
                age = readInt("Enter the new age restriction (2-18): ");
            }
            s.setSeriesAge(age);

            int episodes = readInt("Enter the new amount of episodes: ");
            s.setSeriesNumberOfEpisodes(episodes);

            System.out.println("Series updated successfully");
        } else {
            System.out.println("Series ID (" + id + ") was not found!");
        }
    }

    public static void DeleteSeries() {
        System.out.print("Enter series ID: ");
        String id = scanner.nextLine();

        Series s = findSeriesById(id);
        if (s != null) {
            System.out.print("Are you sure you want to delete " + id + "?");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(s);
                System.out.println(id + " Was deleted");
            }
        } else {
            System.out.println("Series ID: " + id + " was not found");
        }
    }

    public static void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No available series");
        } else {
            int count = 1;
            for (Series s : seriesList) {
                System.out.println("Series " + count + " :");
                printSeries(s);
                count++;
            }
        }
    }

    public static void ExitSeriesApplication() {
        System.out.println("Exiting application");
        System.exit(0);
    }

    private static Series findSeriesById(String id) {
        for (Series s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    private static void printSeries(Series s) {
        System.out.println("----------");
        System.out.println("Series ID: " + s.getSeriesId());
        System.out.println("Series Name: " + s.getSeriesName());
        System.out.println("Age Restriction: " + s.getSeriesAge());
        System.out.println("Length: " + s.getSeriesNumberOfEpisodes());
        System.out.println("----------");
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
// Programmatic methods for unit testing
public static Series addSeries(String id, String name, int age, int episodes) {
    Series s = new Series(id, name, age, episodes);
    seriesList.add(s);
    return s;
}

public static Series searchById(String id) {
    return findSeriesById(id);
}

public static boolean updateSeriesData(String id, String name, int age, int episodes) {
    Series s = findSeriesById(id);
    if (s != null) {
        s.setSeriesName(name);
        s.setSeriesAge(age);
        s.setSeriesNumberOfEpisodes(episodes);
        return true;
    }
    return false;
}

public static boolean deleteSeriesData(String id) {
    Series s = findSeriesById(id);
    if (s != null) {
        seriesList.remove(s);
        return true;
    }
    return false;
}

}
