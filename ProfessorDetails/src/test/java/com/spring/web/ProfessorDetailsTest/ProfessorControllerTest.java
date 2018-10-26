package com.spring.web.ProfessorDetailsTest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class ProfessorControllerTest extends ProfessorDetailsApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testServiceURL() throws Exception {
		mockMvc.perform(get("/professorDetails")).andExpect(status().isOk());
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("").accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
		int serviceStatusCode = mvcResult.getResponse().getStatus();
		assertEquals(200, serviceStatusCode);
	}

	@Test
	public void testServiceResponse() throws Exception {
		mockMvc.perform(get("/professorDetails")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.", Matchers.hasSize(7)));
	}

	@Test
	public void testStudentById() throws Exception {
		mockMvc.perform(get("/professorDetails/{id}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.id", Matchers.is(7))).andExpect(jsonPath("$.firstname", Matchers.is("Noor")))
				.andExpect(jsonPath("$.lastname", Matchers.is("Noor")))
				.andExpect(jsonPath("$.address", Matchers.is("Noor")));
	}

}
