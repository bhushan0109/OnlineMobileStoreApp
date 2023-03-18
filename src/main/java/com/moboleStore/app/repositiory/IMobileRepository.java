package com.moboleStore.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moboleStore.app.entity.Category;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.MobileNotFoundException;

@Repository
public interface IMobileRepository extends JpaRepository<Mobiles, Integer> {

	@Query(value = "SELECT * FROM mobiles WHERE category_id=:categoryId", nativeQuery = true)
	public List<Mobiles> findbyCategory(int categoryId);

//	public Mobiles addMobile(Mobiles mobile);
//	public Mobiles updateMedicine(Mobiles mobile) throws MobileNotFoundException;
//	public Mobiles deleteMedicine(int id) throws MobileNotFoundException;
//	public List<Mobiles> showAllMobile();
//	public Mobiles showMobileById(int mobileId);
}
