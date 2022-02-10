package com.intuit.example.craftmock.service.impl;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.intuit.example.craftmock.PurchaseService;
import com.intuit.example.craftmock.entity.ComplaintEntity;
import com.intuit.example.craftmock.entity.PurchaseEntity;
import com.intuit.example.craftmock.entity.UserEntity;
import com.intuit.example.craftmock.model.response.Complaint;
import com.intuit.example.craftmock.model.response.Purchase;
import com.intuit.example.craftmock.repositories.PurchaseRepository;
import com.intuit.example.craftmock.service.IPurchaseService;
import com.intuit.example.craftmock.shared.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService { // extends PurchaseService

	private final PurchaseRepository purchaseRepository;
	private final PurchaseService purchaseService;

	@Override
	public Purchase savePurchase(Complaint complaint) {

		Purchase returnValue = null;
		
		// check if purchase is empty
		if (purchaseService.getPurchase(complaint.getPurchaseId()) != null) {
			
			// check if userId of purchase and userId of complaint are equals
			if (purchaseService.getPurchase(complaint.getPurchaseId()).getUserId().equals(UUID.fromString(complaint.getUserId()))) {
				PurchaseEntity purchaseEntity = new PurchaseEntity();
				returnValue = purchaseService.getPurchase(complaint.getPurchaseId());
				
				BeanUtils.copyProperties(returnValue, purchaseEntity);
				
				purchaseEntity.setCreatedDate(new Date());
				PurchaseEntity storedUserDetails = purchaseRepository.save(purchaseEntity);
				
				BeanUtils.copyProperties(storedUserDetails, returnValue);
			}
		}
		return returnValue;
	}

	@Override
	public Optional<PurchaseEntity> retrivePurchase(UUID id) {

		Optional<PurchaseEntity> pe = Optional.empty();

		pe = purchaseRepository.findById(id);

		return pe;
	}

}
