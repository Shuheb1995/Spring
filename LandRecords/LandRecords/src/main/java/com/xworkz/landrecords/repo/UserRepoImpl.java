package com.xworkz.landrecords.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.landrecords.dto.UserDto;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	private EntityManagerFactory emf;

	@Override
	public boolean saveUser(UserDto dto) {
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

	@Override
	public UserDto ifExist(String email1, String password) {

		EntityManager em = emf.createEntityManager();
		TypedQuery<UserDto> query = em.createNamedQuery("ifExist1", UserDto.class);
		query.setParameter("eml", email1);
		query.setParameter("pswrd", password);
		UserDto dto = query.getSingleResult();
        System.out.println("ifExist Repo");
		return dto;
	}

	@Override
	public UserDto emailExist(String email1) {

		EntityManager em = emf.createEntityManager();
		TypedQuery<UserDto> query = em.createNamedQuery("emailExist", UserDto.class);
		query.setParameter("eml", email1);
		UserDto dto = query.getSingleResult();

		return dto;
	}

	@Override
	public UserDto passwordExist(String password) {

		EntityManager em = emf.createEntityManager();
		TypedQuery<UserDto> query = em.createNamedQuery("passwordExist", UserDto.class);
		query.setParameter("pswrd", password);
		UserDto dto = query.getSingleResult();

		return dto;
	}

	@Override
	public boolean updateOtpByEmail(String otp, String email1) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updateOtp1");
		query.setParameter("op", otp);
		query.setParameter("eml", email1);
		query.executeUpdate();

		try {
			em.getTransaction().commit();
			System.out.println("OTP updated");
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public UserDto findOtp(String otp) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<UserDto> query = em.createNamedQuery("findOtp1", UserDto.class);
		query.setParameter("ot", otp);
		UserDto dto = query.getSingleResult();

		return dto;
	}

	@Override
	public boolean updatePasswordByEmail(String password, String confirmPassword, String email1) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updatePassword");
		query.setParameter("op", password);
		query.setParameter("cp", confirmPassword);
		query.setParameter("eml", email1);
		query.executeUpdate();
		try {
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}

	}

}
