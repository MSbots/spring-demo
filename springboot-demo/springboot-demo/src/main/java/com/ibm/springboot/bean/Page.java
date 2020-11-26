package com.ibm.springboot.bean;

public class Page {
    private Integer pageSize;
    private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
    
}
