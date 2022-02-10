package com.intuit.example.craftmock.service;

import java.util.Optional;
import java.util.UUID;

import com.intuit.example.craftmock.entity.PurchaseEntity;
import com.intuit.example.craftmock.model.response.Complaint;
import com.intuit.example.craftmock.model.response.Purchase;


public interface IPurchaseService  { 
	
	Purchase savePurchase(Complaint complaint);
	Optional<PurchaseEntity> retrivePurchase(UUID userId);
}
