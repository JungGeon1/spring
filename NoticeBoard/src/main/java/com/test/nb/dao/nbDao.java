package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.SearchParamDto;
import com.test.nb.domain.ViewPageDataDto;

public interface nbDao {
	

	public int insertNb(NbInfoDto nbInfo);
	
	public int insertNbNoImg(NbInfoDto nbInfo);
	
	public int selectList(Map<String, Object> map);
	
	public List<NbInfoDto> List(Map<String, Object> map);
	
	public NbInfoDto selectViewPage(ViewPageDataDto pageData);
	
	public int viewUp(int idx);
	
	public int deleteNb(Map<String, String> deleteMap);
	
	public int updateNb(NbInfoDto nbInfo);
	
	public int updateNbNoImg(NbInfoDto nbInfo);
}