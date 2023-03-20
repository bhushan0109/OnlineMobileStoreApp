package com.cg.oms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mobiles")
public class Mobiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mobileId;
	@NotBlank(message = "mobileName name is needed")
	private String mobileName;

	@Min(value = 0, message = "mobileCost must be greater than 0")
	private Float mobileCost;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate mfDate;

	@NotBlank(message = "modelNumber name is needed")
	private String modelNumber;
	@NotBlank(message = "companyName name is needed")
	private String companyName;

	private int comeraPixcel;

	private int mobileRAM;

	private int battety;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId")
	private Category category;

	public int getMobileId() {
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

	public int getComeraPixcel() {
		return comeraPixcel;
	}

	public void setComeraPixcel(int comeraPixcel) {
		this.comeraPixcel = comeraPixcel;
	}

	public int getMobileRAM() {
		return mobileRAM;
	}

	public void setMobileRAM(int mobileRAM) {
		this.mobileRAM = mobileRAM;
	}

	public int getBattety() {
		return battety;
	}

	public void setBattety(int battety) {
		this.battety = battety;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Mobiles [mobileId=" + mobileId + ", mobileName=" + mobileName + ", mobileCost=" + mobileCost
				+ ", mfDate=" + mfDate + ", modelNumber=" + modelNumber + ", companyName=" + companyName
				+ ", comeraPixcel=" + comeraPixcel + ", mobileRAM=" + mobileRAM + ", battety=" + battety + ", category="
				+ category + "]";
	}

	public Mobiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobiles(int mobileId, @NotBlank(message = "mobileName name is needed") String mobileName,
			@Min(value = 0, message = "mobileCost must be greater than 0") Float mobileCost, LocalDate mfDate,
			@NotBlank(message = "modelNumber name is needed") String modelNumber,
			@NotBlank(message = "companyName name is needed") String companyName, int comeraPixcel, int mobileRAM,
			int battety, Category category) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobileCost = mobileCost;
		this.mfDate = mfDate;
		this.modelNumber = modelNumber;
		this.companyName = companyName;
		this.comeraPixcel = comeraPixcel;
		this.mobileRAM = mobileRAM;
		this.battety = battety;
		this.category = category;
	}


}
