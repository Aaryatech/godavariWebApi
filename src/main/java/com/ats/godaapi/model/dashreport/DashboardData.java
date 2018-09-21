package com.ats.godaapi.model.dashreport;

import java.util.List;

public class DashboardData {
	
	OrderTotAndCount todaysOrdTotAndCount;
	
	SpOrderTotAndCount todaysSpOrdTotAndCount;
	
	OrderCountPending todaysOrderPending;
	
	List<NoOrderDist> noOrderDistList;

	public OrderTotAndCount getTodaysOrdTotAndCount() {
		return todaysOrdTotAndCount;
	}

	public void setTodaysOrdTotAndCount(OrderTotAndCount todaysOrdTotAndCount) {
		this.todaysOrdTotAndCount = todaysOrdTotAndCount;
	}

	public SpOrderTotAndCount getTodaysSpOrdTotAndCount() {
		return todaysSpOrdTotAndCount;
	}

	public void setTodaysSpOrdTotAndCount(SpOrderTotAndCount todaysSpOrdTotAndCount) {
		this.todaysSpOrdTotAndCount = todaysSpOrdTotAndCount;
	}

	public OrderCountPending getTodaysOrderPending() {
		return todaysOrderPending;
	}

	public void setTodaysOrderPending(OrderCountPending todaysOrderPending) {
		this.todaysOrderPending = todaysOrderPending;
	}

	public List<NoOrderDist> getNoOrderDistList() {
		return noOrderDistList;
	}

	public void setNoOrderDistList(List<NoOrderDist> noOrderDistList) {
		this.noOrderDistList = noOrderDistList;
	}

	@Override
	public String toString() {
		return "HubDashboardData [todaysOrdTotAndCount=" + todaysOrdTotAndCount + ", todaysSpOrdTotAndCount="
				+ todaysSpOrdTotAndCount + ", todaysOrderPending=" + todaysOrderPending + ", noOrderDistList="
				+ noOrderDistList + "]";
	}
	
	

}
