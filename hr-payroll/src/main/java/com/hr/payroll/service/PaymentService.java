package com.hr.payroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hr.payroll.entities.Payment;
import com.hr.payroll.entities.Worker;
import com.hr.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	@Autowired
	private WorkerFeignClient client;
	
	public Payment getPagament(long workerId, int days) {
		Worker worker = client.findAById(workerId).getBody();
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
	}
}
