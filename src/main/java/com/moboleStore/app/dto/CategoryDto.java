package com.moboleStore.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CategoryDto {

	private Integer categoryId;
	@NotNull(message = "Name of cateogry required")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Give a valid category name, must contain only alphabets")
	private String categoryName;
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
	public CategoryDto(Integer categoryId,
			@NotNull(message = "Name of cateogry required") @Pattern(regexp = "[a-zA-z]", message = "Give a valid category name, must contain only alphabets") String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
