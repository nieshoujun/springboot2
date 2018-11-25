package com.example.common.util;

import java.util.List;

@SuppressWarnings("rawtypes")
public class Page<T> {

	public int pageNo;
	public int pageSize;
	public int startRow;
	public int endRow;
	public long total;
	public int pages;
	public List<T> result;
	private Object object;

	public Page() {

	}

	public Page(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.startRow = pageNo > 0 ? (pageNo - 1) * pageSize : 0;
		this.endRow = pageNo * pageSize;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Page{" + "pageNo=" + pageNo + ", pageSize=" + pageSize + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", total=" + total + ", pages=" + pages + '}';
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
