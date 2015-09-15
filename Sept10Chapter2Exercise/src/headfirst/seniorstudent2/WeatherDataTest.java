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
		EmptyObserver em = new EmptyObserver(data);
		data.setMeasurements(30, 40, 20);
		assertEquals(data.getTemperature(), 30, 0);
		assertEquals(data.getHumidity(), 40, 0);
		assertEquals(data.getPressure(), 20,0);
		assertEquals(em.getTemp(), 30, 0);
		assertEquals(em.getHum(), 40, 0);
		assertEquals(em.getPres(), 20,0);
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
		private WeatherData weatherData;
		private float temp;
		private float hum;
		private float pres;
		public EmptyObserver(){
			
		}
		public EmptyObserver(Observable ob){
			temp = 0;
			hum = 0;
			pres = 0;
			weatherData = (WeatherData)ob;
			weatherData.addObserver(this);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			WeatherData wData = (WeatherData)arg0;
			temp = wData.getTemperature();
			hum = wData.getHumidity();
			pres = wData.getPressure();
		}
		public float getTemp(){
			return temp;
		}
		public float getHum(){
			return hum;
		}
		public float getPres(){
			return pres;
		}
	}
}
