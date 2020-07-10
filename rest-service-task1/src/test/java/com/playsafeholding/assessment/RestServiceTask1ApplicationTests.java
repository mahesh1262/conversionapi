package com.playsafeholding.assessment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.playsafeholding.assessment.controller.ConversionController;
import com.playsafeholding.assessment.dto.Distance;
import com.playsafeholding.assessment.dto.Temperature;

@WebMvcTest(ConversionController.class)
class RestServiceTask1ApplicationTests {


	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private Temperature temp;

	@MockBean
	private Distance dist;

	@Test
	public void temperatureShouldReturnCelsiusFromKelvin() throws Exception {
		mockMvc.perform(get("/conversions/ktoc?kelvin=400")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":126.85000000000002,\"kelvin\":400}"));
	}

	@Test
	public void temperatureShouldReturnCelsiusFromInvalidKelvin() throws Exception {
		mockMvc.perform(get("/conversions/ktoc?kelvin=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":-273.15,\"kelvin\":0}"));
	}

	@Test
	public void temperatureShouldReturnCelsiusFromUnsuppliedKelvin() throws Exception {
		mockMvc.perform(get("/conversions/ktoc")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":-273.15,\"kelvin\":0}"));
	}

	@Test
	public void temperatureShouldReturnKelvinFromCelsius() throws Exception {
		mockMvc.perform(get("/conversions/ctok?celsius=43")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":43,\"kelvin\":316.15}"));
	}

	@Test
	public void temperatureShouldReturnKelvinFromInvalidCelsius() throws Exception {
		mockMvc.perform(get("/conversions/ctok?celsius=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":0,\"kelvin\":273.15}"));
	}

	@Test
	public void temperatureShouldReturnKelvinFromUnsuppliedCelsius() throws Exception {
		mockMvc.perform(get("/conversions/ctok")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":0,\"kelvin\":273.15}"));
	}
	
	@Test
	public void distanceShouldReturnKilometersFromMiles() throws Exception {
		mockMvc.perform(get("/conversions/mtok?miles=150")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":150,\"kilometers\":241.40160000000003}"));
	}

	@Test
	public void distanceShouldReturnKilometersFromInvalidMiles() throws Exception {
		mockMvc.perform(get("/conversions/mtok?miles=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":0,\"kilometers\":0}"));
	}

	@Test
	public void distanceShouldReturnKilometersFromUnsuppliedMiles() throws Exception {
		mockMvc.perform(get("/conversions/mtok")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":0,\"kilometers\":0}"));
	}
	
	@Test
	public void distanceShouldReturnMilesFromKilometers() throws Exception {
		mockMvc.perform(get("/conversions/ktom?kilometers=150")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":93.2056788356001,\"kilometers\":150}"));
	}

	@Test
	public void distanceShouldReturnMilesFromInvalidKilometers() throws Exception {
		mockMvc.perform(get("/conversions/ktom?kilometers=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":0,\"kilometers\":0}"));
	}

	@Test
	public void distanceShouldReturnMilesFromUnsuppliedKilometers() throws Exception {
		mockMvc.perform(get("/conversions/ktom?kilometers=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":0,\"kilometers\":0}"));
	}
	
	@Test
	   public void main() {
		RestServiceTask1Application.main(new String[] {});
	   }

}
