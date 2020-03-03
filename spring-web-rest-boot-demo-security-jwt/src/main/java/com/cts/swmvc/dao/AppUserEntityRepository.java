package com.cts.swmvc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.swmvc.model.AppUserEntity;

@Repository
public interface AppUserEntityRepository extends CrudRepository<AppUserEntity, Integer> {
	AppUserEntity findByUsername(String username);				//CrudRepository is super type for JPARepository
	boolean existsByUsername(String username);
}
