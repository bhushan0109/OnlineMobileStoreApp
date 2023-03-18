package com.moboleStore.app.repositiory;



import java.util.List;

import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.MobileNotFoundException;

public interface IMobileRepository {

	public Mobiles addMobile(Mobiles mobile);
	public Mobiles updateMedicine(Mobiles mobile) throws MobileNotFoundException;
	public Mobiles deleteMedicine(int id) throws MobileNotFoundException;
	public List<Mobiles> showAllMobile();
	public Mobiles showMobileById(int mobileId);
}
