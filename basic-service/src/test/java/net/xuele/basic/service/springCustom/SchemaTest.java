package net.xuele.basic.service.springCustom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springCustom.bean.Car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:app.xml" })
public class SchemaTest {

	@Autowired
	private Car car;

	@Test
	public void propertyTest() {
		assertNotNull(car);

		String brand = car.getBrand();
		float engine = car.getEngine();
		int horsePower = car.getHorsePower();


		System.out.println("------------->"+brand);
	}
}
