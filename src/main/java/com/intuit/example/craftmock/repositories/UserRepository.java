package com.intuit.example.craftmock.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.intuit.example.craftmock.entity.UserEntity;

@Repository												///UserDto
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
	/*
	 * UserEntity findUserById(UUID userId);
	 * 
	 * @Query( value =
	 * "SELECT bin_to_uuid(id) as id from users_new_a where id = :id", nativeQuery =
	 * true )
	 */

	UserEntity findByEmailAddress(String emailAddress);
	UserEntity findUserByFullName(String fullName );

	List<UserEntity> findByPhysicalAddress(String physicalAddress);
	List<UserEntity> findAllById(UUID ids);
}
