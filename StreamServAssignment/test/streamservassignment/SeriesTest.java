package streamservassignment;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import streamservassignment.Series;

public class SeriesTest {

    @Before
    public void setup() {
        Series.deleteSeriesData("101");
        Series.deleteSeriesData("102");
        Series.deleteSeriesData("103");
    }

    @Test
    public void TestSearchSeries() {
        Series.addSeries("101", "Extreme Sports", 12, 10);
        Series result = Series.searchById("101");
        assertNotNull(result);
        assertEquals("Extreme Sports", result.getSeriesName());
    }

    @Test
    public void TestSearchSeriesFail() {
        Series result = Series.searchById("999");
        assertNull(result);
    }

    @Test
    public void TestUpdateSeries() {
        Series.addSeries("101", "Extreme Sports", 12, 10);
        boolean updated = Series.updateSeriesData("101", "Extreme Sports 2025", 15, 12);
        assertTrue(updated);
        Series result = Series.searchById("101");
        assertEquals("Extreme Sports 2025", result.getSeriesName());
        assertEquals(15, result.getSeriesAge());
        assertEquals(12, result.getSeriesNumberOfEpisodes());
    }

    @Test
    public void TestDeleteSeries() {
        Series.addSeries("101", "Extreme Sports", 12, 10);
        boolean deleted = Series.deleteSeriesData("101");
        assertTrue(deleted);
        assertNull(Series.searchById("101"));
    }

    @Test
    public void TestDeleteSeriesfail() {
        boolean deleted = Series.deleteSeriesData("999");
        assertFalse(deleted);
    }

    @Test
    public void TestSeriesAgeRestrictionPass() {
        Series s = Series.addSeries("101", "Test Show", 15, 5);
        assertTrue(s.getSeriesAge() >= 2 && s.getSeriesAge() <= 18);//(Chatgpt, 2025)
    }

    @Test
    public void TestSeriesAgeRestrictionFail() {
        Series s = new Series("102", "Invalid Show", 25, 5);
        assertFalse(s.getSeriesAge() >= 2 && s.getSeriesAge() <= 18);
    }
}