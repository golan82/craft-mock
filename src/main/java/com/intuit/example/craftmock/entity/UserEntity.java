package com.intuit.example.craftmock.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ColumnTransformer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -7054638675137506778L;

	@Id
	@ColumnTransformer(read = "uuid_from_bin(id)")
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;

	@Column(nullable = true, length = 30)
	private String fullName;

	@Column(unique = true, nullable = true, length = 50)
	private String emailAddress;

	@Column(nullable = true, length = 100)
	private String physicalAddress;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;


	/*
	 * @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) List<PurchaseEntity> purchases = new
	 * ArrayList<PurchaseEntity>();
	 */

}
