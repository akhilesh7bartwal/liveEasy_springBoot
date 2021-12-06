package com.springrest.liveEasy_springBoot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.liveEasy_springBoot.exception.ResourceNotFoundException;
import com.springrest.liveEasy_springBoot.model.PayLoad;
import com.springrest.liveEasy_springBoot.repository.PayLoadRepository;

@RestController
@RequestMapping("/api/")
public class PayLoadController {
	
	@Autowired
	private PayLoadRepository payloadRepository;
	
	//get payloads
	
	@GetMapping("payloads")
	public List<PayLoad> getAllPayLoad(){
		return this.payloadRepository.findAll();
	}
	
	//get payload by id
	
	@GetMapping("/payload/{id}")
	public ResponseEntity<PayLoad> getPayloadId(@PathVariable(value = "id") Long payloadId)
			throws ResourceNotFoundException {
		PayLoad payload = payloadRepository.findById(payloadId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + payloadId));
		return ResponseEntity.ok().body(payload);
	}

	
	//save payload
	@PostMapping("payload")
	public PayLoad createPayload(@RequestBody PayLoad payload) {
		return this.payloadRepository.save(payload);
	}
	
	//update payload
	@PutMapping("/payload/{id}")
	public ResponseEntity<PayLoad> updatePayload(@PathVariable(value = "id") Long payloadId,
			@Valid @RequestBody PayLoad payloadDetails) throws ResourceNotFoundException {
		
		PayLoad payload = payloadRepository.findById(payloadId)
				.orElseThrow(() -> new ResourceNotFoundException("Payload not found for this id :: " + payloadId));
		
		payload.setComment(payloadDetails.getComment());
		payload.setNoOfTrucks(payloadDetails.getNoOfTrucks());
		payload.setWeight(payloadDetails.getWeight());
		payload.setDate(payloadDetails.getDate());
		payload.setLoadingPoint(payloadDetails.getLoadingPoint());
		payload.setUnloadingPoint(payloadDetails.getUnloadingPoint());
		payload.setTruckType(payloadDetails.getTruckType());
		payload.setProductType(payloadDetails.getProductType());
		
		final PayLoad updatedPayload= payloadRepository.save(payload);
		
		return ResponseEntity.ok(updatedPayload);
				
	}
	
	//delete payload	
	@DeleteMapping("payload/{id}")
	public Map<String, Boolean> deletePayload(@PathVariable(value="id") Long payloadId ) throws ResourceNotFoundException{
		
		PayLoad payload = payloadRepository.findById(payloadId)
				.orElseThrow(() -> new ResourceNotFoundException("Payload not found for this id :: " + payloadId));
		
		this.payloadRepository.delete(payload);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		
		return response;
	}
}
