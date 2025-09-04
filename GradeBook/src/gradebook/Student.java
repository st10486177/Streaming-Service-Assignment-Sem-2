
package gradebook;

import java.util.Arrays;

public class Student extends Person {

    private int[] grades;

    public Student(String name, int[] grades) {
        super(name);
        setGrades(grades);
    }

 public final void setGrades(int[] grades) {
    if (grades == null || grades.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty");
    }
    this.grades = new int[grades.length];
        System.arraycopy(grades, 0, this.grades, 0, grades.length);
}

public int[] getGrades() {
    int[] copy = new int[grades.length];
        System.arraycopy(grades, 0, copy, 0, grades.length);
    return copy;
}

    public double getAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return sum / (double) grades.length;
    }

    public int getHighest() {
        int max = grades[0];
        for (int g : grades) {
            if (g > max) {
                max = g;
            }
        }
        return max;
    }

    public int getLowest() {
        int min = grades[0];
        for (int g : grades) {
            if (g < min) {
                min = g;
            }
        }
        return min;
    }

    public void printReport() {
        System.out.println("Student: " + getName());
        System.out.println("Grades: " + Arrays.toString(grades));
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("----------");
    
    }
}
