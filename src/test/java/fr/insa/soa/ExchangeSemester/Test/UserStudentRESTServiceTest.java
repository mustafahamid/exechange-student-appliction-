package fr.insa.soa.ExchangeSemester.Test;

import java.util.Collections;

import javax.print.attribute.standard.Media;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.insa.soa.ExchangeSemester.config.MvcConfigView;
import fr.insa.soa.ExchangeSemester.config.WebSecurityConfig;
import fr.insa.soa.ExchangeSemester.dao.UserRepository;
import fr.insa.soa.ExchangeSemester.restServices.UserRESTService;
import fr.insa.soa.ExchangeSemester.restServices.UserStudentRESTService;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {MvcConfigView.class})
public class UserStudentRESTServiceTest {
	

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserRepository userRepostory;
	
	@Test
	@WithMockUser(authorities="STUDENT")
	public void FirstTest() throws Exception {
		
		Mockito.when(userRepostory.findAll()).thenReturn(
				Collections.emptyList()
		);
		
		MvcResult mvcResult =  mockMvc.perform(
				MockMvcRequestBuilders.get("/service/userStudent")
					.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		
		System.out.println(mvcResult.getResponse());
		
		Mockito.verify(userRepostory).findAll();
	}
}