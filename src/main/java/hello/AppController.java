package hello;

import java.util.HashMap;
import java.util.Map;

import hello.service.HelloService;
import hello.repository.*;

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
	@Autowired
	private HelloRepository helloRepository;

	@GetMapping("/input")
	public String inputForm(Model model) {

		IndexForm indexForm = new IndexForm();
		
		model.addAttribute("indexForm", indexForm);

		return "/input";
	}
	
	@GetMapping("/Muneharu")
	public String saerchByKeyNum(Model model, @RequestParam("Key") Integer Key) {
		
		System.out.println("Key :" + Key);
		System.out.println("model :" + model);
		IndexForm indexForm = new IndexForm();
		Map<Integer, IndexForm> map = new HashMap<>();
		
		if (Key != null) {
			indexForm = helloService.returnData(Key);
			model.addAttribute("indexForm", indexForm);
			return "/result";
		} else { 
			map = helloRepository.ReturnMapData();
			model.addAttribute("map", map);
			return "/result2";
		}	
	}
	

	@PostMapping("/input")
	public String formSubmit(@ModelAttribute IndexForm indexForm) {

		// number*2 Session setting
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