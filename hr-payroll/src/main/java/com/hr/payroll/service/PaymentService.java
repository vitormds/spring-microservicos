package com.hr.payroll.service;

import org.springframework.stereotype.Service;

import com.hr.payroll.entities.Payment;

@Service
public class PaymentService {
	public Payment getPagament(long workerId, int days) {
		return new Payment("Bob",200.0,days);
	}
}
