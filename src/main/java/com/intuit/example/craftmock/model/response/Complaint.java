package com.intuit.example.craftmock.model.response;

import java.io.Serializable;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint implements Serializable{

	private static final long serialVersionUID = 1842584139225699490L;

	@NotBlank(message = "userId is mandatory")
	private String userId;
	
	@NotBlank(message = "subject is mandatory")
	private String subject;
	
	@NotBlank(message = "complaint is mandatory")
	private String complaint;
	
	private UUID purchaseId;
	
}
