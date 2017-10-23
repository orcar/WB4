package hello.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import hello.IndexForm;


@Repository
public class HelloRepositoryImpl implements HelloRepository {
	
	Map<Integer, IndexForm> map = new HashMap<Integer, IndexForm>();
	
	@Override
	public Map<Integer, IndexForm> Storage(IndexForm indexForm) {

		map.put(indexForm.getId(), indexForm);	

		
	    for (Entry<Integer, IndexForm> entry : map.entrySet()) {
	        System.out.println("Key" + entry.getKey() + ":" + entry.getValue()); 
	    }
	    System.out.println("HelloRepositoryImpl map");
		System.out.println(map);
		
		return map;
	}

	@Override
	public Map<Integer, IndexForm> ReturnMapData() {
		return map;
	}
	
}
