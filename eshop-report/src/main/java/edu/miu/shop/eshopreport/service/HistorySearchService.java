package edu.miu.shop.eshopreport.service;

import java.util.List;

import edu.miu.shop.eshopreport.domain.SearchHistory;

public interface HistorySearchService {

	List<SearchHistory> listHisReport();
	public String exportReport(String format);
}
