package com.hy.easyveggy.review.model.vo;

import java.sql.Date;

public class Review {
	private int revId;
	private String revTitle;
	private int userId;
	private Date revDate;
	private String revContent;
	private int revStar;
	private String menuId;
	private String nickName;

	public Review() {
		super();
	}

	public Review(int revId, String revTitle, int userId, Date revDate, String revContent, int revStar, String menuId,
			String nickName) {
		super();
		this.revId = revId;
		this.revTitle = revTitle;
		this.userId = userId;
		this.revDate = revDate;
		this.revContent = revContent;
		this.revStar = revStar;
		this.menuId = menuId;
		this.nickName = nickName;
	}

	public int getRevId() {
		return revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public String getRevTitle() {
		return revTitle;
	}

	public void setRevTitle(String revTitle) {
		this.revTitle = revTitle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getRevDate() {
		return revDate;
	}

	public void setRevDate(Date revDate) {
		this.revDate = revDate;
	}

	public String getRevContent() {
		return revContent;
	}

	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}

	public int getRevStar() {
		return revStar;
	}

	public void setRevStar(int revStar) {
		this.revStar = revStar;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Review [revId=" + revId + ", revTitle=" + revTitle + ", userId=" + userId + ", revDate=" + revDate
				+ ", revContent=" + revContent + ", revStar=" + revStar + ", menuId=" + menuId + ", nickName="
				+ nickName + "]";
	}
}
