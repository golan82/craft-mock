package com.intuit.example.craftmock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.example.craftmock.PurchaseService;
import com.intuit.example.craftmock.model.response.Purchase;

import java.util.UUID;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/{purchaseId}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable UUID purchaseId) {
        Purchase purchase = purchaseService.getPurchase(purchaseId);
        if (purchase == null) {
            ResponseEntity.notFound();
        }
        return ResponseEntity.ok(purchase);
    }
}
