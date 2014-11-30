package com.myHelp.dao;

import java.util.List;

import com.myHelp.domain.History;



public interface HistoryDao {
	
	public List<History> getHistorys(int userID);
	
	public void addHistory(History history);
	
	public List<History> getHistory();
	
	public void updateHistory(History history);
}
