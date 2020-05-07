package com.EcommerceApp.Models;

public class Product {
	private int pid;
	private String prdName;
	private float price;

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", prdName=" + prdName + ", price=" + price + "]";
	}
}
