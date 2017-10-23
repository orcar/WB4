package hello.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.IndexForm;
import hello.repository.HelloRepository;

@Service
public class HelloServiceImpl implements HelloService {

	@Autowired
	private HttpSession session;
	@Autowired
	public HelloRepository helloRepository;

	@Override
	public IndexForm setNumTime(IndexForm indexForm) {

		// get session id
		if (session.getAttribute("sessionId") != null) {
			indexForm.setId((int) session.getAttribute("sessionId"));
		}
		
		int keyValue = indexForm.getId();
		keyValue++;
		
		session.setAttribute("sessionId", keyValue);
		
		indexForm.setId(keyValue);
		indexForm.setReceivedtime(new Date());

//		System.out.println(indexForm);

		helloRepository.Storage(indexForm);

		return indexForm;

	}

	public IndexForm returnData(Integer key) {
		
		Map<Integer, IndexForm> map = helloRepository.ReturnMapData();
		IndexForm indexForm = map.get(key);
		System.out.println(indexForm);
		return indexForm;
	}
	
	
}
