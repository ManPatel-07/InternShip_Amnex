package org.mm.job_service.controller;

import org.mm.job_service.client.CompanyFeignClient;
import org.mm.job_service.entity.Job;
import org.mm.job_service.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/job")
public class JobController 
{
	private final JobService jobService;
	
	private final CompanyFeignClient companyClient;
	
	@GetMapping(path = "/testFeign/{id}")
	public ResponseEntity<?> getCompanyFeign(@PathVariable("id") Long id)
	{
		return new ResponseEntity<>(companyClient.getCompanyDataById(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/testFeign")
	public ResponseEntity<?> testFeign()
	{
		return new ResponseEntity<>(companyClient.testComapny(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/getJobById/{id}")
	public ResponseEntity<?> getJobById(@PathVariable("id") Long jobId)
	{
		return new ResponseEntity<>(jobService.getJobById(jobId), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<?> saveJobDetail(@RequestBody Job job)
	{
		return new ResponseEntity<>(jobService.saveJobDetails(job), HttpStatus.OK);
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<?> getAllJob()
	{
		return new ResponseEntity<>(jobService.getAllJobData(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/getByCompanyID")
	public ResponseEntity<?> getAllJob(@RequestParam("companyId") Long id)
	{
		return new ResponseEntity<>(jobService.getByCompanyId(id), HttpStatus.OK);
	}
}
