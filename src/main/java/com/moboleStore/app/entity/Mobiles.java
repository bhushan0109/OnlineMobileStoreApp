package com.moboleStore.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "mobiles")
public class Mobiles {

	@Id
	@GeneratedValue
	private Integer mobileId;
	@NotBlank(message = "mobileName name is needed")
	private String mobileName;

	@Min(value = 0, message = "mobileCost must be greater than 0")
	private Float mobileCost;

	private LocalDate mfDate;

	@NotBlank(message = "modelNumber name is needed")
	private String modelNumber;
	@NotBlank(message = "companyName name is needed")
	private String companyName;
	
	@Pattern(regexp = "[0-9]{3,30}", message = "username should only contain number and should be atleast a length of 3")
	private int comeraPixcel;

	@Pattern(regexp = "[0-9]{3,30}", message = "username should only contain number and should be atleast a length of 3")
	private int mobileRAM;

	@Pattern(regexp = "[0-9]{3,30}", message = "username should only contain number and should be atleast a length of 3")
	private int battety;

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public Float getMobileCost() {
		return mobileCost;
	}

	public void setMobileCost(Float mobileCost) {
		this.mobileCost = mobileCost;
	}

	public LocalDate getMfDate() {
		return mfDate;
	}

	public void setMfDate(LocalDate mfDate) {
		this.mfDate = mfDate;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Mobiles(Integer mobileId, @NotBlank(message = "mobileName name is needed") String mobileName,
			@Min(value = 0, message = "mobileCost must be greater than 0") Float mobileCost, LocalDate mfDate,
			@NotBlank(message = "modelNumber name is needed") String modelNumber,
			@NotBlank(message = "companyName name is needed") String companyName) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobileCost = mobileCost;
		this.mfDate = mfDate;
		this.modelNumber = modelNumber;
		this.companyName = companyName;
	}

	public Mobiles() {
		super();
		// TODO Auto-generated constructor stub
	}

}
