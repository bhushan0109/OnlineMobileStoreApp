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

	private int cameraPixcel;
	private int mobileRAM;

	private int battery;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId")
	private Category category;

	@NotBlank(message = "imagePath url is needed")
	private String imagePath;

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
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

	public int getCameraPixcel() {
		return cameraPixcel;
	}

	public void setCameraPixcel(int cameraPixcel) {
		this.cameraPixcel = cameraPixcel;
	}

	public int getMobileRAM() {
		return mobileRAM;
	}

	public void setMobileRAM(int mobileRAM) {
		this.mobileRAM = mobileRAM;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Mobiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobiles(int mobileId, @NotBlank(message = "mobileName name is needed") String mobileName,
			@Min(value = 0, message = "mobileCost must be greater than 0") Float mobileCost, LocalDate mfDate,
			@NotBlank(message = "modelNumber name is needed") String modelNumber,
			@NotBlank(message = "companyName name is needed") String companyName, int cameraPixcel, int mobileRAM,
			int battery, Category category, @NotBlank(message = "imagePath url is needed") String imagePath) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobileCost = mobileCost;
		this.mfDate = mfDate;
		this.modelNumber = modelNumber;
		this.companyName = companyName;
		this.cameraPixcel = cameraPixcel;
		this.mobileRAM = mobileRAM;
		this.battery = battery;
		this.category = category;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Mobiles [mobileId=" + mobileId + ", mobileName=" + mobileName + ", mobileCost=" + mobileCost
				+ ", mfDate=" + mfDate + ", modelNumber=" + modelNumber + ", companyName=" + companyName
				+ ", cameraPixcel=" + cameraPixcel + ", mobileRAM=" + mobileRAM + ", battery=" + battery + ", category="
				+ category + ", imagePath=" + imagePath + "]";
	}

}
