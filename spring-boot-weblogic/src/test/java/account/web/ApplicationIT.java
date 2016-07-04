package account.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import account.Application;

/**
 * Basic integration tests for demo application.
 *
 * @author DISID
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest({"PATH_REPO=/tmp/"})
public class ApplicationIT {

	  //Regla JUnit para inicializar Mocks y validar el uso de Mockito
	  @Rule
	  public MockitoRule mockito = MockitoJUnit.rule();

	  static final String NUMBER_ID = "1111";

	  @Autowired
	  private WebApplicationContext context;

	  // Objetos Mock
	  private MockMvc mockMvc;

	  @Before
	  public void setUp() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
	        .addFilter(new HiddenHttpMethodFilter(), "/*")
	        .build();
	  }

	  @After
	  public void tearDown() {
	    this.mockMvc = null;
	  }

	  @Test
	  public void httpShowAccount() throws Exception {

	    // Setup
	    MockHttpServletRequestBuilder request = get("/accounts/{number}", NUMBER_ID)
	        .accept(MediaType.TEXT_HTML);

	    // Exercise
	    ResultActions result = this.mockMvc.perform(request);

	    // Verify
	    result.andExpect(status().isOk());

	    assertThat(result.andReturn().getResponse().getContentAsString())
	        .contains("<div>1111</div>");
	  }

	  @Test
	  public void httpGetAccount() throws Exception {

	    // Setup
	    MockHttpServletRequestBuilder request = get("/accounts/{number}", NUMBER_ID)
	        .accept(MediaType.APPLICATION_JSON);

	    // Exercise
	    ResultActions result = this.mockMvc.perform(request);

	    // Verify
	    result.andExpect(status().isOk());

	    assertThat(result.andReturn().getResponse().getContentAsString())
	        .contains("\"number\":\"1111\"");
	  }

}
