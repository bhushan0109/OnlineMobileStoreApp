package com.cg.oms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.entity.Category;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CategoryException;
import com.cg.oms.exception.MobileNotFoundException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.repositiory.CategoryRepository;
import com.cg.oms.repositiory.IMobileRepository;

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
		}else {
	           
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

}
