package hello;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GreetingController {

	@Autowired
	private HttpSession session;

	@GetMapping("/greeting")
	public String greetingForm(Model model) {

		Greeting greeting = new Greeting();

		if (session.getAttribute("number") != null) {

			greeting.setId((long) session.getAttribute("number"));
		}

		model.addAttribute("greeting", greeting);

		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting) {
		long id = greeting.getId();
		long id2 = id * 2;
		greeting.setId(id2);

		session.setAttribute("number", id2);

		return "greeting";
	}
	
	@RequestMapping(value = "Hoge", method = RequestMethod.GET)
	@ResponseBody
	  public String getJson() throws JsonProcessingException {
        Hoge hoge = new Hoge();
        hoge.id = 10;
        hoge.name = "hoge";

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hoge);

        return json;
	}

}