package com.moboleStore.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue
	private Integer categoryId;
	@NotNull(message = "Name of cateogry required")
	@Pattern(regexp = "[a-zA-z]", message = "Give a valid category name, must contain only alphabets")
	private String categoryName;
	
	@OneToMany
	private List<Mobiles> newMobiles = new ArrayList<>();

	public Category() {
		super();
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Mobiles> getNewMobiles() {
		return newMobiles;
	}

	public void setNewMobiles(List<Mobiles> newMobiles) {
		this.newMobiles = newMobiles;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", newMobiles=" + newMobiles
				+ "]";
	}

	
}
