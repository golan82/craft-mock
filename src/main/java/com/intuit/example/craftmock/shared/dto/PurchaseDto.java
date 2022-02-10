package com.intuit.example.craftmock.shared.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto implements Serializable {

	private static final long serialVersionUID = 3276940833291048381L;
	private UUID id;
	private UUID userId;
	private UUID productId;
	private String productName;
	private double pricePaidAmount;
	private String priceCurrency;
	private double discountPercent;
	private UUID merchantId;
	private Date purchaseDate;
	private UserDto userDetails;

}
