package com.lanou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin" , catalog="entity")
public class Admin {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int aId;
	@Column(name="name")
	private String aName;
	@Column(name="pwd")
	private String aPwd;

	public Admin() {
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaPwd() {
		return aPwd;
	}

	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}

}
