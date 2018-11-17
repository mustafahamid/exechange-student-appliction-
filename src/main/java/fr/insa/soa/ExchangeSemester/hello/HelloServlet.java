package fr.insa.soa.ExchangeSemester.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloServlet {

	@Autowired
	// This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@GetMapping("/hello")
	public String sayHello(Model model) {
		System.out.println("servlet reached");
		Iterable<User> itUser = userRepository.findAll();
		for (User user : itUser) {
			System.out.println(user.getFirstName() + " " + user.getLastName());
		}
		System.out.println("Now, there are : " + userRepository.count() + " users saved");
		model.addAttribute("users", itUser);
		return "greeting";
	}
}