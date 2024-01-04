package com.xworkz.session.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xworkz.session.dto.SessionDto;

@Repository
public interface SessionRepo extends CrudRepository<SessionDto, Integer>{
	
	@Modifying
	@Transactional
	@Query("update SessionDto dto set dto.course=:course where dto.id=:id")
	public int updateById(@Param("id") int id , @Param("course") String course);

}
