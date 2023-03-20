package com.cg.oms.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CategoryException;
import com.cg.oms.exception.MobileNotFoundException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.service.IMobileService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("mobile")
public class MobileController {

	@Autowired
	private IMobileService iMobileService;

	@PostMapping("/add")
	public Mobiles addMobile(@Valid @RequestBody Mobiles mobiles) throws ParseException, CategoryException {

		return iMobileService.addMobile(mobiles);
	}

	@DeleteMapping("/delete/{mobileId}")
	public Mobiles deleteMobilebyId(@PathVariable("mobileId") Integer mobileId) throws MobileNotFoundException {
		return iMobileService.deleteMobile(mobileId);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('Admin')")
	public Mobiles updateMobile(@Valid @RequestBody Mobiles mobiles)
			throws MobilesException, ParseException, CategoryException {
		return iMobileService.updateMobile(mobiles);
	}

	@GetMapping("/getAll")
	public List<Mobiles> getMobiles() {
		return iMobileService.showAllMobile();

	}

	@GetMapping("/get/{mobileId}")
	public Mobiles showMobileById(@PathVariable("mobileId") Integer mobileId) throws MobileNotFoundException {
		return iMobileService.showMobileById(mobileId);
	}

	//// FindMobileByRAM
	@GetMapping("/get//filter/search/{searchString}/{type}")
	public List<Mobiles> findMobileByString(@PathVariable("searchString") String searchString,
			@PathVariable("type") String type) throws MobileNotFoundException {
		return iMobileService.findMobileByString(searchString, type);
	}

	@GetMapping("/get/ram/filter/{searchRam}/{type}")
	public List<Mobiles> findMobileByRam(@PathVariable("searchRam") String searchRam,
			@PathVariable("type") String type) throws MobileNotFoundException {
		return iMobileService.findMobileByRam(searchRam, type);
	}

	@GetMapping("/get/price/filter/upper/{upperPrice}")
	public List<Mobiles> findByMobileCostGreaterThan(@PathVariable("upperPrice") String upperPrice) throws MobileNotFoundException {
		return iMobileService.findByMobileCostGreaterThan(upperPrice);
	}

	@GetMapping("/get/price/filter/lower/{lowerprice}")
	public List<Mobiles> findByMobileCostLessThan(@PathVariable("lowerprice") String lowerprice) throws MobileNotFoundException {
		return iMobileService.findByMobileCostLessThan(lowerprice);
	}

}
