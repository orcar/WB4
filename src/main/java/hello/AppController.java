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
public class AppController {

	@Autowired
	private HttpSession session;

	@GetMapping("/input")
	public String inputForm(Model model) {

		InputNumber inputNumber = new InputNumber();

		if (session.getAttribute("number") != null) {

			inputNumber.setNumber((long) session.getAttribute("number"));
		}

		model.addAttribute("inputNumber", inputNumber);

		return "/input";
	}

	@PostMapping("/input")
	public String formSubmit(@ModelAttribute InputNumber inputNumber) {
		long sessionNumber = inputNumber.getNumber();
		long sessionNumber2 = sessionNumber * 2;
		inputNumber.setNumber(sessionNumber2);

		session.setAttribute("number", sessionNumber2);

		return "/result";
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