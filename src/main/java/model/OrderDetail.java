/**
 * クラス名：	OrderDetail
 * 概要　　：	注文明細情報
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package model;

public class OrderDetail {
	private long no;
	private Customer customer;
	private Item item;
	private String orderDate;
	private int quantity;
	private Tax tax;
	private int status;

	public OrderDetail(long no, Customer customer, Item item, String orderDate,
			int quantity, Tax tax, int status) {
		this.no = no;
		this.customer = customer;
		this.item = item;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.tax = tax;
		this.status = status;
	
	}

	public Item getItem() {
		return this.item;
	}

	public Tax getTax() {
		return this.tax;
	}

	public long getNo() {
		return this.no;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public Customer getCustomer () {
		return this.customer;
	}
	
	public String getOrderDate () {
		return this.orderDate;
	}
	
	public int getStatus () {
		return this.status;
	}

}
