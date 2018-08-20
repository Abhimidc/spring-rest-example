package com.idc.homedoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idc.homedoctor.model.Accounth;
import com.idc.homedoctor.respository.AccountRespository;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	AccountRespository accountRespository;
	

@Autowired	
public void setAccountRespository(AccountRespository accountRespository) {
		this.accountRespository = accountRespository;
	}


	@Transactional
	public Accounth save(Accounth accounth) 
	{
		return accountRespository.save(accounth);
		
	}
	public List<Accounth> findall()
	{
		return (List<Accounth>) accountRespository.findAll();
	}
	@Transactional
	public void delete(int id)
	{
		Accounth account=accountRespository.findOne(id);
		accountRespository.delete(account);
	}
	@Transactional
	public void update(Accounth account)
	{
		
		accountRespository.save(account);
	}
	public Accounth findOne(int id)
	{
		Accounth account=accountRespository.findOne(id);
		return account;
	}
	

}
