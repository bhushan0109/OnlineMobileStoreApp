package com.cg.oms.service;



import java.text.ParseException;
import java.util.List;

import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CategoryException;
import com.cg.oms.exception.MobileNotFoundException;
import com.cg.oms.exception.MobilesException;

public interface IMobileService {

	public Mobiles addMobile(Mobiles mobile) throws ParseException, CategoryException;
	public Mobiles updateMobile(Mobiles mobile) throws  MobilesException, ParseException, CategoryException;
	public Mobiles deleteMobile(int mobileId) throws MobileNotFoundException;
	public Mobiles showMobileById(int mobileId) throws MobileNotFoundException;
	public List<Mobiles> showAllMobile();
}
