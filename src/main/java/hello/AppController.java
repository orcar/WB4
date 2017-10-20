package hello;

import hello.service.HelloService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AppController {

	@Autowired
	private HttpSession session;
	@Autowired
	private HelloService helloService;

	@GetMapping("/input")
	public String inputForm(Model model) {

		IndexForm indexForm = new IndexForm();
		
		model.addAttribute("indexForm", indexForm);

		return "/input";
	}
	
	@GetMapping("/Muneharu")
	public String saerchByKeyNum(Model model, @RequestParam("Key") int Key) {
		
		System.out.println(Key);
		System.out.println(model);
		IndexForm indexForm = new IndexForm();
		
		model.addAttribute("indexForm", indexForm);
		/*SearchKeyNum searchKeyNum = new searc();
		
		model.addAttribute("indexForm", indexForm);*/

		return "/result";
	}
	

	@PostMapping("/input")
	public String formSubmit(@ModelAttribute IndexForm indexForm) {

		// number*2 Sessison setting
		int sessionNumber = indexForm.getNumber();
		int sessionNumber2 = sessionNumber * 2;
		indexForm.setNumber(sessionNumber2);
		session.setAttribute("sessionNumber", sessionNumber2);
		
		//set id & time in indexForm
		helloService.setNumTime(indexForm);

		return "/result";
	}

	// ajax for output json
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