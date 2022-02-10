package com.intuit.example.craftmock.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "complaint")
public class ComplaintEntity {

	@Id
	@GeneratedValue
	private int id;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private UUID userId;

	private String subject;

	private String complaint;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private UUID purchaseId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

}
