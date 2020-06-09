package com.hy.easyveggy.menu.model.vo;

public class Menu {
	private String menuId;
	private String restId;
	private String vlId;
	private String menu;
	private int menuPrice;

	public Menu() {
		super();
	}

	public Menu(String menuId, String restId, String vlId, String menu, int menuPrice) {
		super();
		this.menuId = menuId;
		this.restId = restId;
		this.vlId = vlId;
		this.menu = menu;
		this.menuPrice = menuPrice;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getVlId() {
		return vlId;
	}

	public void setVlId(String vlId) {
		this.vlId = vlId;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restId=" + restId + ", vlId=" + vlId + ", menu=" + menu + ", menuPrice="
				+ menuPrice + "]";
	}
}
