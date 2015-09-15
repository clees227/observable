package headfirst.seniorstudent2;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeatherDataTest {
	WeatherData data;

	@Before
	public void setUp() throws Exception {
		data = new WeatherData();
		data.setMeasurements(0, 0, 0);
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}

	@Test
	public void testSetMeasurements() {
		data.setMeasurements(30, 40, 20);
		assertEquals(data.getTemperature(), 30, 0);
	}

	@Test
	public void testAddObserver() {
		data.addObserver(new EmptyObserver());
		assertEquals(data.countObservers(), 1);
	}

	@Test
	public void testDeleteObserver() {
		EmptyObserver em = new EmptyObserver();
		data.addObserver(em);
		data.deleteObserver(em);
		assertEquals(data.countObservers(), 0);
	}

	public class EmptyObserver implements Observer{
		public EmptyObserver(){
			
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
	}
}
