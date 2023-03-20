package com.cg.oms.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.Category;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.entity.Users;
import com.cg.oms.exception.MobileNotFoundException;

@Repository
public interface IMobileRepository extends JpaRepository<Mobiles, Integer> {

	@Query(value = "SELECT * FROM mobiles WHERE category_id=:categoryId", nativeQuery = true)
	public List<Mobiles> findbyCategory(int categoryId);

	@Query(value = "SELECT * FROM mobiles WHERE company_name LIKE %:searchString% or mobile_name like %:searchString% or model_number  like %:searchString% ", nativeQuery = true)
	public List<Mobiles> findMobileBycompany_nameAndmobile_nameAndmodel_number(
			@Param("searchString") String searchString);

	@Query(value = "SELECT * FROM mobiles WHERE cast(mobileram as varchar) LIKE  %:searchString% or cast(battety as varchar) LIKE  %:ram%  or cast(comera_pixcel as varchar) LIKE  %:searchString% ", nativeQuery = true)
	public List<Mobiles> findMobileByRAM_camera_battery(String searchString);

	List<Mobiles> findByMobileCostGreaterThan(Float price);

	List<Mobiles> findByMobileCostLessThan(Float price);

}
