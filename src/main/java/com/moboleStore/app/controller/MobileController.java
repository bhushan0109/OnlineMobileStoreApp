package com.moboleStore.app.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CategoryException;
import com.moboleStore.app.exception.MobileNotFoundException;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.service.IMobileService;

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
	public Mobiles deleteMobilebyId(@PathVariable("mobileId") Integer mobileId) throws  MobileNotFoundException{
		return iMobileService.deleteMobile(mobileId);
	}
	
	@PutMapping("/update")
	public Mobiles updateMobile(@Valid @RequestBody Mobiles mobiles) throws MobilesException, ParseException, CategoryException{
		return iMobileService.updateMobile(mobiles);
	}
	
	@GetMapping("/getAll")
	public List<Mobiles> getMobiles() {
		return iMobileService.showAllMobile();
		
	}
	
	@GetMapping("/get/{mobileId}")
	public Mobiles showMobileById(@PathVariable("mobileId") Integer mobileId) throws MobileNotFoundException{
		return iMobileService.showMobileById(mobileId);
	}
	
			
}
