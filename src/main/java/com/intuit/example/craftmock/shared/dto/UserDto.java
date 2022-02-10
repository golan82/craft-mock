package com.intuit.example.craftmock.shared.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.intuit.example.craftmock.entity.ComplaintEntity;
import com.intuit.example.craftmock.entity.PurchaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

	private static final long serialVersionUID = -3578868220050986220L; // confirm DesginPattern

	private UUID id;
	private String fullName;
	private String emailAddress;
	private String physicalAddress;
	private PurchaseEntity purchases;
	private List<ComplaintEntity> complaints;

}
