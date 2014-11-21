package com.myHelp.dao;

import java.util.List;

import com.myHelp.domain.History;



public interface HistoryDao {
	
	public List<History> getHistorys(int userID);
	

}
