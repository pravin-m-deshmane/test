package com.vpd.db.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vpd.db.entity.UserEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {
	List<UserEntity> findByUserId(long userName);
	List<UserEntity> findByUserName(String userName);
	List<UserEntity> findByUserEmpNo(long userName);
	List<UserEntity> findByUserEmpNoLessThan(long userName);
	
	
	@Query("select u from UserEntity u where u.userName in (:names)")
	List<UserEntity> findByMultipleUserName(@Param("names") List<String> names);
}
