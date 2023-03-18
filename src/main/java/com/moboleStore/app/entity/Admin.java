package com.moboleStore.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name= "Admin")
public class Admin {
	
	@Id
	@Column(unique = true)
	private Integer Id;
	private String Adminame;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getAdminame() {
		return Adminame;
	}
	public void setAdminame(String adminame) {
		Adminame = adminame;
	}
	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", Adminame=" + Adminame + "]";
	}


}
