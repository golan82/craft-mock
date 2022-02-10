package com.intuit.example.craftmock.service;

import java.util.UUID;
import com.intuit.example.craftmock.model.response.Complaint;
import com.intuit.example.craftmock.model.response.User;
import com.intuit.example.craftmock.shared.dto.UserDto;

public interface IUserService  {

	User saveUser(UUID id);
	UserDto savePurchase(Complaint complaint);
}
