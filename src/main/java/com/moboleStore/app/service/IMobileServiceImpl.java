package com.moboleStore.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moboleStore.app.entity.Category;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CategoryException;
import com.moboleStore.app.exception.MobileNotFoundException;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.repositiory.CategoryRepository;
import com.moboleStore.app.repositiory.IMobileRepository;

@Service
public class IMobileServiceImpl implements IMobileService {

	@Autowired
	private IMobileRepository iMobileRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Mobiles addMobile(Mobiles mobile) throws ParseException, CategoryException {
		
		Category findByCategoryName = categoryRepository.findByCategoryName(mobile.getCategory().getCategoryName());
		
		if(findByCategoryName == null){
			throw new CategoryException("CategoryName " + mobile.getCategory().getCategoryName() + " not exists !");
			
		}
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(mobile.getMfDate().toString());
		LocalDate mfdDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		mobile.setMfDate(mfdDate);
		Mobiles saveMobiles = iMobileRepository.save(mobile);
		return saveMobiles;
	}

	@Override
	public Mobiles updateMobile(Mobiles mobile) throws MobilesException, ParseException {
		Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobile.getMobileId());
		if (optMobiles.isEmpty())
			throw new MobilesException("Book id " + mobile.getMobileId() + " does not exists to delete !");

		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(mobile.getMfDate().toString());
		LocalDate mfdDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		mobile.setMfDate(mfdDate);
		return iMobileRepository.save(mobile);

	}

	@Override
	public Mobiles deleteMobile(int mobileId) throws MobileNotFoundException {
		Optional<Mobiles> optBooks = this.iMobileRepository.findById(mobileId);
		if (optBooks.isEmpty())
			throw new MobileNotFoundException("Mobiles id " +mobileId+ " does not exists to delete !");
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
	public Mobiles addMobilesToCategoryByCategoryId(Integer categoryId, Integer mobileId) throws CategoryException, MobileNotFoundException {
		return null;
//		Optional<Category> optCategory = this.categoryRepository.findById(categoryId);
//		if (optCategory.isEmpty()) {
//			throw new CategoryException("Cateogory doesn't exist for Id: " + categoryId);
//		}
//		
//		Optional<Mobiles> optMobiles = iMobileRepository.findById(mobileId);
//		if (optMobiles.isEmpty()) {
//			throw new MobileNotFoundException("Mobile id not found: " + mobileId);
//		}
//
//		Mobiles mobiles = optMobiles.get();
//		Category foundCategory = optCategory.get();
//		
//		foundCategory.setNewMobiles(null);
//		foundCategory.getNewMobiles().add(mobiles);
//		this.categoryRepository.save(foundCategory);
//		return mobiles;
	}
}
