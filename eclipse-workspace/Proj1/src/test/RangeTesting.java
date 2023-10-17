package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class RangeTesting {

    private Range<Integer> range;

    @Before
    public void setUp() {
        range = Range.of(1, 5);
    }

    @Test
    public void testContains() {
        assertTrue(range.contains(4));
        assertFalse(range.contains(6));
    }

    @Test
    public void testContainsRange() {
        Range<Integer> range2 = Range.of(3, 4);
        Range<Integer> range3 = Range.of(6, 8);

        assertTrue(range.containsRange(range2));
        assertFalse(range.containsRange(range3));
    }

    @Test
    public void testMerge() {
        Range<Integer> range2 = Range.of(3, 7);

        try {
            Range<Integer> mergedRange = range.merge(range2);
            assertEquals("[1, 7]", mergedRange.toString());
        } catch (CustomException e) {
            fail("Merge failed: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testIntersection() {
        Range<Integer> range2 = Range.of(3, 7);

        try {
            Range<Integer> intersectionRange = range.intersection(range2);
            assertEquals("[3, 5]", intersectionRange.toString());
        } catch (CustomException e) {
            fail("Intersection failed: " + e.getMessage());
        }
    }

    @Test
    public void testFit() {
        assertEquals(Integer.valueOf(1), range.fit(0));
        assertEquals(Integer.valueOf(4), range.fit(4));
        assertEquals(Integer.valueOf(5), range.fit(7));
    }
    
    @Test(expected = CustomException.class)
    public void testInvalidMerge() throws CustomException {
        Range<Integer> range2 = Range.of(7, 10);
        range.merge(range2); // This should throw a CustomException
    }
    
    @Test(expected = CustomException.class)
    public void testInvalidIntersection() throws CustomException {
        Range<Integer> range2 = Range.of(7, 10);
        range.intersection(range2); // This should throw a CustomException
    }
    
    @Test
    public void testEquality() {
        Range<Integer> range2 = Range.of(1, 5);
        Range<Integer> range3 = Range.of(3, 7);

        assertTrue(range.equals(range2));
        assertFalse(range.equals(range3));
    }
}
