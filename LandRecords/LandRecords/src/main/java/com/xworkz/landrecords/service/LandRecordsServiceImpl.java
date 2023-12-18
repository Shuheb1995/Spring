package com.xworkz.landrecords.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.landrecords.dto.AdminDto;
import com.xworkz.landrecords.dto.LandRecordsDto;
import com.xworkz.landrecords.repo.LandRecordsRepo;

@Service
public class LandRecordsServiceImpl implements LandRecordsService {

	@Autowired
	private LandRecordsRepo repo;

	@Override
	public AdminDto findByEmail(String email, Model model) {

		if (email != null && !email.isEmpty()) {
			try {
				AdminDto dto = repo.findByEmail(email);

				return dto;

			} catch (Exception e) {
				System.out.println("No Result found");
				return null;
			}
		}
		model.addAttribute("emailNotValidated", "Email is not Valid");
		return null;
	}

	public String generateOtp() {
		int randomNumber = (int) ((Math.random() * 90000) + 1000);
		String otp = String.valueOf(randomNumber);
		return otp;
	}

	@Override
	public boolean signIn(String email, Model model) {
		if (email != null && !email.isEmpty()) {
			AdminDto dto = findByEmail(email, model);
			if (dto != null) {
				String otp = generateOtp();
				if (otp != null) {
					boolean sendOtp = sendOtpToEmail(otp, email, model);
					System.out.println(sendOtp);
				}
				boolean updateOtp = repo.updateOtpByEmail(otp, email);
				System.out.println(updateOtp);
				return true;
		}
			System.out.println("Not Updated");
			return false;
		}
		model.addAttribute("email", "Email is not valid");
		return false;
	}

	@Override
	public AdminDto otpValidator(String otp, Model model) {
		try {
			if(otp != null) {
				AdminDto dto = repo.findOtp(otp);
				if(dto.getOtp().equals(otp)) {
					return dto;
				}else {
					model.addAttribute("otpMatch", "Otp is incorrect");
					return null;
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println("OTP is Incorrect");
			model.addAttribute("otpValidate", "OTP is Incorrect");
			return null;

		}
		model.addAttribute("findOtp", "otp not found");
        return null;
	}

	public boolean validate(LandRecordsDto dto, Model model) {

		boolean valid = true;
		if (dto != null) {
			if (dto.getState() == null || dto.getState().isEmpty()) {
				System.out.println("Enter State");
				model.addAttribute("state", "Enter State");
				valid = false;
			}
			if (dto.getDistrict() == null || dto.getDistrict().isEmpty()) {
				System.out.println("Enter District");
				model.addAttribute("District", "Enter District");
				valid = false;
			}
			if (dto.getTaluk() == null || dto.getTaluk().isEmpty()) {
				System.out.println("Enter Taluk");
				model.addAttribute("Taluk", "Enter Taluk");
				valid = false;
			}
			if (dto.getHobli() == null || dto.getHobli().isEmpty()) {
				System.out.println("Enter Hobli");
				model.addAttribute("Hobli", "Enter Hobli");
				valid = false;
			}
			if (dto.getVillage() == null || dto.getVillage().isEmpty()) {
				System.out.println("Enter Village");
				model.addAttribute("Village", "Enter Village");
				valid = false;
			}
			if (dto.getOwnerName() == null || dto.getOwnerName().isEmpty() || dto.getOwnerName().length() <= 2) {
				System.out.println("Enter Owner Name or Owner Name is invalid");
				model.addAttribute("OwnerName", "Enter Owner Name or Owner Name is invalid ");
				valid = false;
			}
			if (dto.getMobileNumber() == null || dto.getMobileNumber().isEmpty()
					|| dto.getMobileNumber().length() <= 9) {
				System.out.println("Enter Mobile Number or Mobile Number is invalid");
				model.addAttribute("MobileNumber", "Enter Mobile Number or Mobile Number is invalid");
				valid = false;
			}
			if (dto.getAadhaarNumber() == null || dto.getAadhaarNumber().isEmpty()
					|| dto.getAadhaarNumber().length() <= 11) {
				System.out.println("Enter Aadhar Number or Aadhaar Number is invalid");
				model.addAttribute("AadhaarNumber", "Enter Aadhar Number or Aadhaar Number is invalid");
				valid = false;
			}
			if (dto.getSurveyNumber() == null || dto.getSurveyNumber().isEmpty()) {
				System.out.println("Enter Survey Number");
				model.addAttribute("SurveNumber", "Enter Survey Number");
				valid = false;
			}
			if (dto.getHissaNumber() == null || dto.getHissaNumber().isEmpty()) {
				System.out.println("Enter Hissa Number");
				model.addAttribute("HissaNumber", "Enter Hissa Number");
				valid = false;
			}
			if (dto.getYear() == null || dto.getYear().isEmpty() || dto.getYear().length() <= 3) {
				System.out.println("Enter Year");
				model.addAttribute("Year", "Enter Year");
				valid = false;
			}

		} else {
			System.out.println("Dto is valid Ready to save");
			valid = false;
		}
		return valid;

	}

	@Override
	public boolean saveRecords(LandRecordsDto dto, Model model) {
		if (validate(dto, model)) {
			System.out.println("Saving is in progress");
			LandRecordsDto record = ifExist(dto.getHissaNumber(), dto.getSurveyNumber(), 0, model);
			if (record == null) {
				return repo.saveRecords(dto);
			}
			model.addAttribute("exist", "Record with this Hissa or Survey number is already exist");
			return false;
		}
		return false;
	}

	@Override
	public boolean sendOtpToEmail(String otp, String email, Model model) {

		String senderEmail = "shuheb.xworkz@outlook.com";
		String senderPassword = "Shuheb@1995";
		String recipientEmail = email;
		String subject = "Your LandRecords OTP";
		String messageText = "Your LandRecords OTP is : " + otp + " valid for only 10 minuites";
		System.out.println(otp);

		// Set up JavaMail Properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.office365.com");// simple mail transfer protocol
		properties.put("mail.smtp.port", "587");

		// Create a session with Authentication
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});

		try {
			// Create MimmeMessage object
			Message message = new MimeMessage(session);

			// set the sender, recipient, subject and message body
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject(subject);
			message.setText(messageText);

			// send the email
			Transport.send(message);

			System.out.println("OTP sent to email successfully");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean deleteBySurveyNumber(String hissaNumber, String surveyNumber) {
		if (hissaNumber != null && !hissaNumber.isEmpty()) {
			if (surveyNumber != null && !surveyNumber.isEmpty()) {
				return repo.deleteBySurveyNumber(hissaNumber, surveyNumber, 1);
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateDetailsByHissaAndSurveyNumber(LandRecordsDto dto, Model model) {

		if (dto.getOwnerName() != null && !dto.getOwnerName().isEmpty()) {
			if (dto.getMobileNumber() != null && !dto.getMobileNumber().isEmpty()) {
				if (dto.getAadhaarNumber() != null && !dto.getAadhaarNumber().isEmpty()) {
					if (dto.getYear() != null && !dto.getYear().isEmpty()) {
						if (dto.getHissaNumber() != null && !dto.getHissaNumber().isEmpty()) {
							if (dto.getSurveyNumber() != null && !dto.getSurveyNumber().isEmpty()) {
								System.out.println("Ready to edit");
								return repo.updateDetailsByHissaAndSurveyNumber(dto.getOwnerName(),
										dto.getMobileNumber(), dto.getAadhaarNumber(), dto.getYear(),
										dto.getHissaNumber(), dto.getSurveyNumber(), 0);
							}
							System.out.println("surveyNumber is not valid");
							return false;
						}
						System.out.println("hissaNumber is not valid");
						return false;
					}
					System.out.println("Year is not valid");
					return false;
				}
				System.out.println("aadhaarNumber is not valid");
				return false;
			}
			System.out.println("mobileNumber is not valid");
			return false;
		}
		System.out.println("Owner Name is not valid");
		return false;
	}

	@Override
	public List<LandRecordsDto> findByVillage(String village, Model model) {

		System.out.println("service starts");

		if (village != null && !village.isEmpty()) {
			try {
				return repo.findByVillage(village, 0);
			} catch (Exception e) {
				System.out.println("No result found");
				return null;
			}

		}
		System.out.println("Entered Village is invalid");
		return null;
	}

	@Override
	public LandRecordsDto ifExist(String hissaNumber, String surveyNumber, int status, Model model) {

		if (hissaNumber != null && !hissaNumber.isEmpty()) {
			if (surveyNumber != null && !surveyNumber.isEmpty()) {
				try {
					LandRecordsDto dto = repo.ifExist(hissaNumber, surveyNumber, 0);
					System.out.println(dto);
					return dto;
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			return null;
		}

		return null;
	}

	@Override
	public List<LandRecordsDto> findByHobliAndVillage(String hobli, String village) {

		if (hobli != null) {
			if (village != null) {
				try {
					return repo.findByHobliAndVillage(hobli, village);
				} catch (Exception e) {
					System.out.println("No result found Exception");
					e.printStackTrace();
				}

			}
			System.out.println("village is invalid");
			return null;
		}
		System.out.println("Hobli is invalid");
		return null;
	}

}
