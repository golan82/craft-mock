package com.intuit.example.craftmock.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.intuit.example.craftmock.entity.ComplaintEntity;

@Repository
public interface ComplaintRepository extends CrudRepository<ComplaintEntity, UUID> {
	
	 @Query ( value = "SELECT bin_to_uuid(user_id) as userId from complaint_new where user_id = :user_id", nativeQuery = true ) 
	ComplaintEntity findComplaintByuserId(@Param("user_id") UUID userId);
	 
	 List<ComplaintEntity> findByUserId(UUID id);
}
