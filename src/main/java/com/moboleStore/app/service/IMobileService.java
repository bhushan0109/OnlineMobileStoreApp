package com.moboleStore.app.service;



import java.util.List;

import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.MobileNotFoundException;

public interface IMobileService {

	public Mobiles addMobile(Mobiles mobile);
	public Mobiles updateMedicine(Mobiles mobile) throws MobileNotFoundException;
	public Mobiles deleteMedicine(int id) throws MobileNotFoundException;
	public List<Mobiles> showAllMobile(int id);
	public Mobiles showMobileById(int mobileId);
}
