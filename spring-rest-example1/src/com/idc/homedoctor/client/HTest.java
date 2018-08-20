package com.idc.homedoctor.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idc.himedoctor.config.InfrastructoreConfig;
import com.idc.homedoctor.model.Accounth;
import com.idc.homedoctor.service.AccountService;
import com.idc.homedoctor.service.AccountServiceImpl;


public class HTest {

	public static void main(String[] args) 
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(InfrastructoreConfig.class);
		AccountServiceImpl acc=(AccountServiceImpl) context.getBean(AccountServiceImpl.class);
		/*
		Accounth accou=new Accounth();
		accou.setId(800);
		accou.setName("abhi");
		accou.setBalance(9000);
		acc.save(accou);
		System.out.println("done");
		*/
	List<Accounth> axx=	acc.findall();
	System.out.println(axx);

	}

}
