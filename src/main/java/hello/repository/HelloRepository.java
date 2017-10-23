package hello.repository;

import java.util.Map;

import hello.IndexForm;


public interface HelloRepository {
	Map<Integer, IndexForm> Storage(IndexForm indexForm);
	Map<Integer, IndexForm> ReturnMapData();
	
}