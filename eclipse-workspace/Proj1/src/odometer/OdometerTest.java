package odometer;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import odometer.Odometer;
//import odometer.exceptions.ReadingException;

class OdometerTest {

	private Odometer o;
	
	@BeforeEach
	void setUp() {
		o = new Odometer(5);
		assertEquals(12345, o.getReading());
	}
	
	@Test
	void testIncrementNonRollOver() {
		o.incrementReading();
		assertEquals(12346, o.getReading());
	}
	
	@Test
	void testIncrementRollOver() throws ReadingException {
		o.setReading(56789);
		o.incrementReading();
		assertEquals(12345, o.getReading());
	}
	
	@Test
	void testsize() {
		assertEquals(5, o.getSize());
	}
	
	@Test
	void testnextReading() throws ReadingException{
		o.setReading(12345);
		o.nextReading();
		assertEquals(12345,o.getReading());
	}
	
	@Test
	void testreset() throws ReadingException{
		o.setReading(56789);
		o.reset();
		assertEquals(12345,o.getReading());
	}
	
	@Test
	void testdecrementReading() throws ReadingException {
		o.setReading(23457);
		o.decrementReading();
		assertEquals(23456, o.getReading());
		
	}
	
	@Test
	void testdecrementReadinglast() throws ReadingException {
		o.setReading(12345);
		o.decrementReading();
		assertEquals(56789, o.getReading());
		
	}
	
	@Test
	void testAscending() throws ReadingException{
		o.isAscending(23456);
		assertDoesNotThrow(() -> o.setReading(23456));
	}

	@Test
    public void testEquals() {
   	 Odometer o1 = new Odometer(5);
   	 Odometer o2 = new Odometer(4);
   	 assertEquals(true,o1.equals(o));
   	 
   	 assertEquals(false,o1.equals(o2));
    }
	
	
	  @Test
	    public void testToString() {
	        Odometer odo = new Odometer(3);
	        assertEquals("(123)", odo.toString());

	        // Test after incrementing the reading
	        odo.incrementReading();
	        assertEquals("(124)", odo.toString());

	        // Test after resetting the reading
	        odo.reset();
	        assertEquals("(123)", odo.toString());
	    }
	  
	  @Test
	    public void testNotAscendingReadingException() throws ReadingException {
	        Odometer odo = new Odometer(3);
	        assertThrows(ReadingException.class, () -> {        	
	        	odo.setReading(432); 
	        });
	    }

	    @Test
	    public void testSizeMismatchException() throws ReadingException {
	        Odometer odo = new Odometer(3);
	        odo.incrementReading();
	        assertThrows(ReadingException.class, () -> {        	
	        	odo.setReading(1234); // Reading size mismatch should throw an exception
	        });
	    }

}