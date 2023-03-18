package com.moboleStore.app.service;



import java.text.ParseException;
import java.util.List;

import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CategoryException;
import com.moboleStore.app.exception.MobileNotFoundException;
import com.moboleStore.app.exception.MobilesException;

public interface IMobileService {

	public Mobiles addMobile(Mobiles mobile) throws ParseException;
	public Mobiles updateMobile(Mobiles mobile) throws  MobilesException, ParseException;
	public Mobiles deleteMobile(int id) throws MobileNotFoundException;
	public Mobiles showMobileById(int mobileId) throws MobileNotFoundException;
	public List<Mobiles> showAllMobile();
	public Mobiles addMobilesToCategoryByCategoryId(Integer categoryId, Integer mobileId) throws CategoryException, MobileNotFoundException;
}
