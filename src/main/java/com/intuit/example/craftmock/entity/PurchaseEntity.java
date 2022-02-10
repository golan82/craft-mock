package com.intuit.example.craftmock.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "purchases")
@Immutable
public class PurchaseEntity implements Serializable {

	private static final long serialVersionUID = -839363438061882493L;

	@Id
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;

	@Column(name = "userId", columnDefinition = "BINARY(16)")
	private UUID userId;

	@Column(name = "productId", columnDefinition = "BINARY(16)")
	private UUID productId;

	private String productName;

	private double pricePaidAmount;

	private String priceCurrency;

	private double discountPercent;

	// @Column(name = "merchantId", columnDefinition = "BINARY(16)")
	private UUID merchantId;

	private Date purchaseDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;


	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "userId", insertable = false, updatable = false) private
	 * UserEntity userDetails;
	 */
}
