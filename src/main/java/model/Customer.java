/**
 * クラス名：	Customer
 * 概要　　：	顧客情報
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package model;

public class Customer {

	private int custId;
	private String custName;
	private String kana;
	private String tel;
	private String address;

	public Customer () {}

	public Customer(int custId, String custName, String kana, String tel, String address) {
		this.custId = custId;
		this.custName = custName;
		this.kana = kana;
		this.tel = tel;
		this.address = address;
	}

	
	//	getters
	public int getCustId() {
		return this.custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public String getKana() {
		return this.kana;
	}

	public String getAddress() {
		return this.address;
	}
	
	public String getTel() {
		return this.tel;
	}

	// setters
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public void setKana (String kana) {
		this.kana = kana;
	}
	
	public void setTel (String tel) {
		this.tel = tel;
	}
	
	public void setAddress (String address) {
		this.address = address;
	}
}
