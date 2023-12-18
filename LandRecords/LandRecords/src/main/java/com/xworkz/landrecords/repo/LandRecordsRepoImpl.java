package com.xworkz.landrecords.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.landrecords.dto.AdminDto;
import com.xworkz.landrecords.dto.LandRecordsDto;

@Repository
public class LandRecordsRepoImpl implements LandRecordsRepo {
	
	@Autowired
	private EntityManagerFactory emf;

	@Override
	public AdminDto findByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<AdminDto> query = em.createNamedQuery("findEmail", AdminDto.class);
		query.setParameter("em", email);
		AdminDto dto = query.getSingleResult();
		return dto;
	}

	@Override
	public boolean updateOtpByEmail(String otp, String email) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updateOtp");
		query.setParameter("op", otp);
		query.setParameter("eml", email);
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
	public AdminDto findOtp(String otp) throws NoResultException {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AdminDto> query = em.createNamedQuery("findOtp", AdminDto.class);
		query.setParameter("ot", otp);
		AdminDto dto = query.getSingleResult();

		return dto;
	}

	@Override
	public boolean saveRecords(LandRecordsDto dto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateDetailsByHissaAndSurveyNumber(String ownerName, String mobileNumber, String aadhaarNumber, String year,
			String hissaNumber, String surveyNumber , int status) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updateDto");
		query.setParameter("on" ,ownerName);
		query.setParameter("mn" ,mobileNumber);
		query.setParameter("an" ,aadhaarNumber);
		query.setParameter("yr" ,year);
		query.setParameter("hn" ,hissaNumber);
		query.setParameter("sn" ,surveyNumber);
		query.setParameter("st", status);
		query.executeUpdate();
		try {
			em.getTransaction().commit();
			System.out.println("Successfully updated");
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
		
		
	}

	@Override
	public boolean deleteBySurveyNumber(String hissaNumber, String surveyNumber , int status ) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("delete");
		query.setParameter("hn", hissaNumber);
		query.setParameter("sn", surveyNumber);
//		query.setParameter("st", status);
		query.executeUpdate();
		em.getTransaction().commit();
		
		return true;
	}

	@Override
	public List<LandRecordsDto> findByVillage(String village , int status) {
		System.out.println("Repo starts");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<LandRecordsDto> query = em.createNamedQuery("findVillage", LandRecordsDto.class);
		System.out.println(village);
		query.setParameter("vg", village);
		query.setParameter("st", status);
		List<LandRecordsDto> dto = query.getResultList();
		return dto;
	}

	@Override
	public LandRecordsDto ifExist(String hissaNumber, String surveyNumber, int status) {
		
		EntityManager em = emf.createEntityManager();
		TypedQuery<LandRecordsDto> query = em.createNamedQuery("ifExist", LandRecordsDto.class);
		query.setParameter("hn", hissaNumber);
		query.setParameter("sn", surveyNumber);
		query.setParameter("st", status);
		LandRecordsDto dto = query.getSingleResult();
		return dto;
	}

	@Override
	public List<LandRecordsDto> findByHobliAndVillage(String hobli, String village) {
		System.out.println("findByHobliAndVillage repo method starts");
		EntityManager em = emf.createEntityManager();
		TypedQuery<LandRecordsDto> query = em.createNamedQuery("findHobliAndVillage", LandRecordsDto.class);
		query.setParameter("hbl", hobli);
		query.setParameter("vg", village);
		List<LandRecordsDto> dto = query.getResultList();
		return dto;
	}

}
