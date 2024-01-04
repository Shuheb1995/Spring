package com.xworkz.session.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.session.dto.SessionDto;
import com.xworkz.session.repository.SessionRepo;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepo repo;
	
	public SessionDto addData(SessionDto dto) {
		
		SessionDto save = repo.save(dto);
		return save;	
	}
	
	public Optional<SessionDto> findById(int id){

		return repo.findById(id);	
	}
	
	public boolean deleteById(int id) {
		
		repo.deleteById(id);
		return true;
		
	}
	
	public Iterable<SessionDto> readAll(){
		Iterable<SessionDto> read = repo.findAll();
		return read;
	}
	
	public int updateCourseById(int id , String course) {
		return repo.updateById(id, course);
	}

}
