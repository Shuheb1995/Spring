package com.xworkz.landrecords.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.landrecords.dto.AdminDto;

@Repository
public class AdminRepoImpl implements AdminRepo {
	
	@Autowired
	private EntityManagerFactory emf;

	@Override
	public boolean saveAdmin(AdminDto dto) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(dto);
		try {
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}


}
