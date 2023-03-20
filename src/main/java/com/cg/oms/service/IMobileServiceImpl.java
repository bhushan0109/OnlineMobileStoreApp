package com.cg.oms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.entity.Category;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CategoryException;
import com.cg.oms.exception.MobileNotFoundException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.repositiory.CategoryRepository;
import com.cg.oms.repositiory.IMobileRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

@Service
public class IMobileServiceImpl implements IMobileService {

	@Autowired
	private IMobileRepository iMobileRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Mobiles addMobile(Mobiles mobile) throws ParseException, CategoryException {

		Category findByCategoryName = categoryRepository.findByCategoryName(mobile.getCategory().getCategoryName());

		if (findByCategoryName == null) {
			// defauls catecory set
			Category category = new Category();
			category.setCategoryName("smartphone");
			Category saveCategory = categoryRepository.save(category);
			mobile.setCategory(saveCategory);
//			throw new CategoryException("CategoryName " + mobile.getCategory().getCategoryName() + " not exists !");
		} else {

		}

		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(mobile.getMfDate().toString());
		LocalDate mfdDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		mobile.setMfDate(mfdDate);
		Mobiles saveMobiles = iMobileRepository.save(mobile);
		return saveMobiles;
	}

	@Override
	public Mobiles updateMobile(Mobiles mobile) throws MobilesException, ParseException, CategoryException {

		Category findByCategoryName = categoryRepository.findByCategoryName(mobile.getCategory().getCategoryName());

		if (findByCategoryName == null) {
			throw new CategoryException("CategoryName " + mobile.getCategory().getCategoryName() + " not exists !");

		}

		Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobile.getMobileId());
		if (optMobiles.isEmpty())
			throw new MobilesException("Mobile id " + mobile.getMobileId() + " does not exists to delete !");

		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(mobile.getMfDate().toString());
		LocalDate mfdDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		mobile.setMfDate(mfdDate);
		return iMobileRepository.save(mobile);

	}

	@Override
	public Mobiles deleteMobile(int mobileId) throws MobileNotFoundException {
		Optional<Mobiles> optBooks = this.iMobileRepository.findById(mobileId);
		if (optBooks.isEmpty())
			throw new MobileNotFoundException("Mobiles id " + mobileId + " does not exists to delete !");
		Mobiles obj = optBooks.get();
		this.iMobileRepository.delete(obj);
		return obj;
	}

	@Override
	public List<Mobiles> showAllMobile() {
		return iMobileRepository.findAll();
	}

	@Override
	public Mobiles showMobileById(int mobileId) throws MobileNotFoundException {
		Optional<Mobiles> optMobiles = iMobileRepository.findById(mobileId);
		if (optMobiles.isEmpty()) {
			throw new MobileNotFoundException("Mobile id not found: " + mobileId);
		}
		return optMobiles.get();
	}

	@Override
	public List<Mobiles> findMobileByString(String searchString, String type) throws MobileNotFoundException {
		boolean flag= false;
		List<Mobiles> modifylist = new ArrayList<Mobiles>();
		if (type.equalsIgnoreCase("mobileName") || type.equalsIgnoreCase("modelNumber")
				|| type.equalsIgnoreCase("companyName")) {
			flag=true; //type is valid
			modifylist = iMobileRepository.findMobileBycompany_nameAndmobile_nameAndmodel_number(searchString);
			return modifylist;
		}

		if (type.equalsIgnoreCase("mobileRAM") || type.equalsIgnoreCase("battety")
				|| type.equalsIgnoreCase("comeraPixcel")) {
			flag=true; //type is valid
			modifylist = iMobileRepository.findMobileByRAM_camera_battery(searchString);
			return modifylist;
		}

		if (type.equalsIgnoreCase("mobileCost")) {
			flag=true; //type is valid
			float f = Float.parseFloat(searchString);
			modifylist = iMobileRepository.findByMobileCostGreaterThan(f);
			return modifylist;
		}
		if(flag == false) {
			throw new MobileNotFoundException("Mobile type should be, mobileName, modelNumber, companyName, mobileRAM , battety, comeraPixcel, mobileCost " );
		}

		return modifylist;
	}

	@Override
	public List<Mobiles> findMobileByRam(String searchString, String type) {
		List<Mobiles> modifylist = new ArrayList<Mobiles>();
		modifylist = iMobileRepository.findMobileByRAM_camera_battery(searchString);
		return modifylist;
	}

	@Override
	public List<Mobiles> findByMobileCostGreaterThan(String searchString) {
		List<Mobiles> modifylist = new ArrayList<Mobiles>();
		float f = Float.parseFloat(searchString);
		modifylist = iMobileRepository.findByMobileCostGreaterThan(f);
		return modifylist;
	}

	@Override
	public List<Mobiles> findByMobileCostLessThan(String searchString) {
		List<Mobiles> modifylist = new ArrayList<Mobiles>();
		float f = Float.parseFloat(searchString);
		modifylist = iMobileRepository.findByMobileCostLessThan(f);
		return modifylist;
	}

}
