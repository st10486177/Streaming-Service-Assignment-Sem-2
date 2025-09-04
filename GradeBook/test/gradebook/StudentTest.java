package gradebook;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testAverage() {
        Student s = new Student("Test", new int[]{80, 90, 100});
        assertEquals(90.0, s.getAverage(), 0.001);//Chatgpt, 2025
    }

    @Test
    public void testHighest() {
        Student s = new Student("Test", new int[]{70, 85, 60});
        assertEquals(85, s.getHighest());
    }

    @Test
    public void testLowest() {
        Student s = new Student("Test", new int[]{70, 85, 60});
        assertEquals(60, s.getLowest());
    }
}
