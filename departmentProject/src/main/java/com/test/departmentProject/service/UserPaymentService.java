package com.test.departmentProject.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class UserPaymentService {
/*
	@Autowired
	@Qualifier("${beanName}")*/

//	@Resource(name="${beanName}")

	@Qualifier("paytm")
	@Autowired
	private Payment payment;

	public String processPayment() {
		return payment.doTransaction();
	}

}
