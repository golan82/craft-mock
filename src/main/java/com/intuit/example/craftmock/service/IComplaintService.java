package com.intuit.example.craftmock.service;

import java.util.List;
import java.util.UUID;

import com.intuit.example.craftmock.entity.ComplaintEntity;
import com.intuit.example.craftmock.model.response.Complaint;
import com.intuit.example.craftmock.shared.dto.UserDto;

public interface IComplaintService {
	Complaint saveComplaint(Complaint complaint);
	List<ComplaintEntity> retriveComplaint(UUID complaint);
	UserDto retriveAll(UUID id);
}
