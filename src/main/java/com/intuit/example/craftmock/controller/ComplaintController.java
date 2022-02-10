package com.intuit.example.craftmock.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
import com.intuit.example.craftmock.entity.ComplaintEntity;
import com.intuit.example.craftmock.entity.PurchaseEntity;
import com.intuit.example.craftmock.model.response.Complaint;
import com.intuit.example.craftmock.model.response.Messages;
import com.intuit.example.craftmock.service.IComplaintService;
import com.intuit.example.craftmock.service.IPurchaseService;
import com.intuit.example.craftmock.service.IUserService;
import com.intuit.example.craftmock.shared.dto.UserDto;

@RestController // Able to receive httpRequest - match the url Path
@RequestMapping("complaint") // for create user, update, delete //http://localhost:8080/users
public class ComplaintController {

	@Autowired
	private final IComplaintService iComplaintService;

	@Autowired
	private final IUserService iUserService;

	@Autowired
	private final IPurchaseService iPurchaseService;

	@Autowired
	public ComplaintController(IUserService iUserService, IPurchaseService iPurchaseService,
			IComplaintService iComplaintService) { 
		this.iComplaintService = iComplaintService;
		this.iUserService = iUserService;
		this.iPurchaseService = iPurchaseService;
	}

	
	@GetMapping(path = "/{userId}")
	public ResponseEntity<UserDto> getComplaint(@PathVariable UUID userId) 
	{
		return ResponseEntity.ok(iComplaintService.retriveAll(userId));
	}
	
	
	@GetMapping(path = "/userId/{userId}")
	public ResponseEntity<List<ComplaintEntity>> getComplaintUser(@PathVariable UUID userId) 
	{
		iComplaintService.retriveAll(userId);
		return ResponseEntity.ok(iComplaintService.retriveComplaint(userId));
	}
	
	
	@GetMapping(path = "/purchaseId/{id}")
	public ResponseEntity<Optional<PurchaseEntity>> getPurchaseUser(@PathVariable UUID id) 
	{
		return ResponseEntity.ok(iPurchaseService.retrivePurchase(id));
	}
	
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<String> createComplaintUser(@Valid @RequestBody Complaint complaint)
	{
		iComplaintService.saveComplaint(complaint);

		iUserService.saveUser(UUID.fromString(complaint.getUserId()));

		iPurchaseService.savePurchase(complaint);

		return ResponseEntity.ok(Messages.MESSAGE_SUCCESS.getMessage());

	}

	/*
	 * @PostMapping(value = "/retriev") public ResponseEntity<UserDto>
	 * createCaseRetrieval(@Valid @RequestBody Complaint complaint) throws Exception
	 * { iUserService.findById(UUID.fromString(complaint.getUserId()));
	 * 
	 * return ResponseEntity.ok(iUserService.savePurchase(complaint));
	 * 
	 * }
	 */

	@PutMapping
	public String updateComplaintUser() {

		return "update user was called";
	}

	@DeleteMapping
	public String deleteComplaintUser() {

		return "delete user was called";
	}

}
