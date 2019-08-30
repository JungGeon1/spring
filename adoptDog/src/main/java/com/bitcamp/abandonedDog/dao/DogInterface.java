package com.bitcamp.abandonedDog.dao;

import java.util.List;


import com.bitcamp.abandonedDog.domain.Doginfo;
import com.bitcamp.abandonedDog.domain.SearchParam;

public interface DogInterface {
	
	
	public int insertDog(Doginfo doginfo);

	public List<Doginfo> showList();
	
	public int deleteDog(int id, String m_id);
	
	public Doginfo selectId(int id);
	
	public int updateDog(Doginfo info);
	
	public Doginfo selectDno(String dNo);
	
	public List<Doginfo> selectSearchList(SearchParam params);
	
}
