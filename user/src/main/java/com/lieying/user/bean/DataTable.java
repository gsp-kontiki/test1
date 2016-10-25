package com.lieying.user.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DataTable<T> {
	
	private int total;
	
	private List<T> rows;
	
	@JsonIgnore
	private int page;
	
	@JsonIgnore
	private int pageSize;
	
	public DataTable() {
		
	}
	
	public DataTable(int page, int pageSize, int total) {
		this.page = page;
		this.pageSize = pageSize;
		this.total = total;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@JsonIgnore
	public int getFirst() {
		return (page -1) * pageSize;
	}
	
	@JsonIgnore
	public int getMax() {
		return  page * pageSize > total ? total - (page -1) * pageSize : pageSize;
	}

}
