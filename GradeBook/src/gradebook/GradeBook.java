// this is the main class
package gradebook;

public class GradeBook {

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Alice", new int[]{85, 90, 78, 92});
        students[1] = new Student("Eleanorea", new int[]{70, 65, 88, 75});
        students[2] = new Student("Archibald", new int[]{95, 100, 98, 93});

        System.out.println("Studen report Marks");
        System.out.println("---------");
        for (Student s : students) {
            s.printReport();
        }
    }
}
