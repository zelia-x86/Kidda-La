/**
 * クラス名：	Item
 * 概要　　：	商品情報
 * 作成者名：	
 * 作成日　：	
 * 修正者名：
 * 修正日　：
 */

package model;

public class Item {
	
	private String itemId;
	private String itemName;
	private String size;
	private int price;

	public Item(String itemId, String itemName, String size, int price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.size = size;
		this.price = price;
	}

	public String getItemId() {
		return this.itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public String getSize() {
		return this.size;
	}

	public int getPrice() {
		return this.price;
	}
	
	public void setItemId (String itemId) {
		this.itemId = itemId;
	}
	
	public void setItemName (String itemName) {
		this.itemName = itemName;
	}
	
	public void setSize (String size) {
		this.size = size;
	}
	
	public void setPrice (int price) {
		this.price = price;
	}

}
