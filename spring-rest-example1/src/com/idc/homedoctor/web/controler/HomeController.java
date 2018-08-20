package com.idc.homedoctor.web.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idc.homedoctor.model.Accounth;
import com.idc.homedoctor.service.AccountServiceImpl;

@RestController
public class HomeController {
	@Autowired
	AccountServiceImpl accountServiceImpl;

	@GetMapping("/all")
	public List<Accounth> findAll() {
		return accountServiceImpl.findall();

	}

	@DeleteMapping("/delete-{id}")
	public void delete(@PathVariable int id) {
		accountServiceImpl.delete(id);
	}

	@PostMapping("/open")
	public String save(@RequestBody Accounth accounth, ModelMap model) {

		accounth = accountServiceImpl.save(accounth);
		model.put("account", accounth);
		return "account";
	}

	@PutMapping("/update-{id}")
	public void update(@RequestBody Accounth acounth) {
		accountServiceImpl.update(acounth);
	}

	@GetMapping("findOne-{id}")
	public Accounth findOne(@PathVariable int id) {
		return accountServiceImpl.findOne(id);
	}
}
