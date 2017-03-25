package jh.studio.entity;

public class Pagination {

	public static Pagination NULL=null;
	private int page;
	private int total;
	private int rows=10;
	private int pageCount;
	
	public int getPageCount(){
		this.pageCount=(total-1)/rows+1;
		return pageCount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total= total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
		
}
