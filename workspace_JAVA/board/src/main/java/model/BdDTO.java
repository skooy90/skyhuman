package model;

import java.util.Date;

public class BdDTO {
	
	private int bid;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bcreatedAt;
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBcreatedAt() {
		return bcreatedAt;
	}
	public void setBcreatedAt(Date bcreatedAt) {
		this.bcreatedAt = bcreatedAt;
	}
	
	@Override
	public String toString() {
		return ", bid=" + bid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter="
				+ bwriter + ", bcreatedAt=" + bcreatedAt + "]";
	}
	
	
	
}
