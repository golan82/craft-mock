package com.intuit.example.craftmock.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intuit.example.craftmock.entity.ComplaintEntity;
import com.intuit.example.craftmock.entity.PurchaseEntity;
import com.intuit.example.craftmock.entity.UserEntity;
import com.intuit.example.craftmock.model.response.Complaint;
import com.intuit.example.craftmock.repositories.ComplaintRepository;
import com.intuit.example.craftmock.repositories.PurchaseRepository;
import com.intuit.example.craftmock.repositories.UserRepository;
import com.intuit.example.craftmock.service.IComplaintService;
import com.intuit.example.craftmock.shared.dto.UserDto;

@Service
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	ComplaintRepository complaintRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;

	@Override
	public Complaint saveComplaint(Complaint complaint) {
		ComplaintEntity ce = new ComplaintEntity();
		
		BeanUtils.copyProperties(complaint, ce);
		ce.setCreatedDate(new Date());
		ce.setUserId(UUID.fromString(complaint.getUserId()));
		ce = complaintRepository.save(ce);

		return complaint;
	}

	@Override
	public List<ComplaintEntity> retriveComplaint(UUID id) {
		List<ComplaintEntity> complaintEntity = new ArrayList<ComplaintEntity>();

		complaintEntity = complaintRepository.findByUserId(id);
		complaintRepository.count();
		return complaintEntity;
	}


	@Override
	public UserDto retriveAll(UUID id) {
		ModelMapper modelMapper = new ModelMapper();
		UserDto ud = new UserDto();
		List<ComplaintEntity> ce = new ArrayList<ComplaintEntity>();
		PurchaseEntity pe = new PurchaseEntity();
		Optional<UserEntity> ue = Optional.empty();

		ue = userRepository.findById(id);
		ce = complaintRepository.findByUserId(id);
		pe = purchaseRepository.findByUserId(id);
		modelMapper.map(ue, ud);

		ud.setComplaints(ce);
		ud.setPurchases(pe);

		return ud;
	}
	
	
}
