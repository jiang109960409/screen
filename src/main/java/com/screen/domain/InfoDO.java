package com.screen.domain;

/**
 * 创业园信息
 * 
 * @author outsider
 *
 */
public class InfoDO {
	private int id;
	private String name;
	private String address;
	private String fax;
	private String telephoneNumber;
	private long phoneNumber;
	private long qq;
	private String email;

	public InfoDO() {
	}

	public InfoDO(int id, String name, String address, String fax, String telephoneNumber, long phoneNumber, long qq,
			String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.fax = fax;
		this.telephoneNumber = telephoneNumber;
		this.phoneNumber = phoneNumber;
		this.qq = qq;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getQq() {
		return qq;
	}

	public void setQq(long qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
