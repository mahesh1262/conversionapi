package com.playsafeholding.assessment.controller;

import java.math.BigDecimal;


import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.playsafeholding.assessment.dto.Distance;
import com.playsafeholding.assessment.dto.Temperature;


/**
 * @author mahesh
 *
 */

@RestController
public class ConversionController {
	
		/** convert kelvin to celcius
		 * 
		 * @param kelvin
		 * @return celcius
		 */

		@GetMapping("conversions/ktoc")
		public Temperature kelvinToCelsius(@RequestParam(value = "kelvin", defaultValue = "0") String kelvin) {
			Temperature temp = new Temperature();
		
			if (NumberUtils.isCreatable(kelvin)) {
				temp.setKelvin(new BigDecimal(kelvin));
				return temp;
			}
			temp.setKelvin(new BigDecimal("0"));
			return temp;
		}

		/** convert celcius to kelvin
		 * 
		 * @param celcius
		 * @return kelvin and celcius
		 */
		
		@GetMapping("conversions/ctok")
		public Temperature celsiusToKelvin(@RequestParam(value = "celsius", defaultValue = "0") String celsius) {
			Temperature temp = new Temperature();
			if (NumberUtils.isCreatable(celsius)) {
				temp.setCelsius(new BigDecimal(celsius));
				return temp;
			}
			temp.setCelsius(new BigDecimal("0"));
			return temp;
		}
		
		/** convert miles to kilometers 
		 * 
		 * @param miles
		 * @return kilometers
		 */

		@GetMapping("conversions/mtok")
		public Distance milesToKilometers(@RequestParam(value = "miles", defaultValue = "0") String miles) {
			Distance dist = new Distance();
			if (NumberUtils.isCreatable(miles)) {
				dist.setMiles(new BigDecimal(miles));
				return dist;
			}
			dist.setMiles(new BigDecimal("0"));
			return dist;
		}
		
		/** convert kilometers to miles 
		 * 
		 * @param kilometers
		 * @return miles
		 */

		@GetMapping("conversions/ktom")
		public Distance kilometersToMiles(@RequestParam(value = "kilometers", defaultValue = "0") String kilometers) {
			Distance dist = new Distance();
			if (NumberUtils.isCreatable(kilometers)) {
				dist.setKilometers(new BigDecimal(kilometers));
				return dist;
			}
			dist.setKilometers(new BigDecimal("0"));
			return dist;
		}
}
