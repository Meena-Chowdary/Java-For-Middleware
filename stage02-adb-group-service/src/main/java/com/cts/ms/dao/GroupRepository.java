package com.cts.ms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ms.entity.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity,String> {

}
//not using service here directly controller communicates with dao as it is an example