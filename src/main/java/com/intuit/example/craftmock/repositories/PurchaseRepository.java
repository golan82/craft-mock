package com.intuit.example.craftmock.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.intuit.example.craftmock.entity.PurchaseEntity;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseEntity, UUID> {
	
	PurchaseEntity findByUserId(UUID id);
	Optional<PurchaseEntity> findById(UUID id);
	PurchaseEntity findIdByUserId(UUID id);

	@Query(value = "SELECT * bin_to_uuid(user_id) as id from purchases where id = :user_id", nativeQuery = true)
	List<PurchaseEntity> findAllByUserId(@Param("user_id") UUID userId);

}
