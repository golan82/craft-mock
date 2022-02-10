package com.intuit.example.craftmock.service.impl;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.intuit.example.craftmock.UserService;
import com.intuit.example.craftmock.entity.UserEntity;
import com.intuit.example.craftmock.model.response.Complaint;
import com.intuit.example.craftmock.model.response.User;
import com.intuit.example.craftmock.repositories.UserRepository;
import com.intuit.example.craftmock.service.IUserService;
import com.intuit.example.craftmock.shared.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

	private final UserRepository userRepository;
	private final UserService userService;

	@Override
	public User saveUser(UUID id) {
		UserEntity userEntity = new UserEntity();

		User returnValue = userService.getUser(id);
		BeanUtils.copyProperties(returnValue, userEntity);

		userEntity.setCreatedDate(new Date());
		UserEntity storedUserDetails = userRepository.save(userEntity); 

		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}


	@Override
	public UserDto savePurchase(Complaint complaint) {		
		
		userService.getUser(UUID.fromString(complaint.getUserId())).getId();
		UserDto returnValue = new UserDto();
		UserEntity userEntity = new UserEntity();

		User user = userService.getUser(UUID.fromString(complaint.getUserId()));

		BeanUtils.copyProperties(user, userEntity);
		
		return returnValue;
	}
}
