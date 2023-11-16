package com.xworkz.landrecords.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.landrecords.dto.UserDto;
import com.xworkz.landrecords.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;

	@Override
	public boolean saveUser(UserDto dto, Model model) throws Exception {

		if (mailExist(dto.getEmail1()) == null) {
			if (passwordExist(dto.getPassword()) == null) {
				if (validateUser(dto, model)) {
					String epwd = encryptPWD(dto.getPassword(), "ThisIsSecretKey");
					System.out.println(epwd);
					dto.setPassword(epwd);
					dto.setConfirmPassword(epwd);
					return repo.saveUser(dto);
				}
				System.out.println("Dto is not valid");
				return false;
			}
			model.addAttribute("pswrd", "Pasword already Exist , try different Password");
			return false;
		}
		model.addAttribute("emailCheck", "Email already Exist");
		return false;
	}

	@Override
	public boolean validateUser(UserDto dto, Model model) {

		boolean valid = true;

		if (dto != null) {
			if (dto.getUserName() == null || dto.getUserName().isEmpty() || dto.getUserName().length() <= 2) {
				System.out.println("username not valid");
				model.addAttribute("userName", "Please enter valid Name");
				valid = false;
			}
			if (dto.getEmail1() == null || dto.getEmail1().isEmpty() || dto.getEmail1().length() <= 15) {
				System.out.println("email not valid");
				model.addAttribute("userEmail", "Please Enter valid Email");
				valid = false;
			}
			if (dto.getMobileNumber() == null || dto.getMobileNumber().isEmpty()
					|| dto.getMobileNumber().length() <= 9) {
				System.out.println("mobilenumber not valid");
				model.addAttribute("mobileNumber", "Please enter valid Mobile Number");
				valid = false;
			}
			if (dto.getAadhaarNumber() == null || dto.getAadhaarNumber().isEmpty()
					|| dto.getAadhaarNumber().length() != 12) {
				System.out.println("aadhaar not valid");
				model.addAttribute("aadhaarNumber", "Please enter valid Aadhaar Number");
				valid = false;
			}
			if (dto.getPassword() == null || dto.getPassword().isEmpty() || dto.getPassword().length() <= 7) {
				System.out.println("password not valid");
				model.addAttribute("password",
						"Please enter valid Password, Password should contain minimum 8 characters");
				valid = false;
			}
			if (dto.getConfirmPassword() == null || !dto.getConfirmPassword().equals(dto.getPassword())) {
				System.out.println("cnfrm pswrd not valid");
				model.addAttribute("confirmPassword", "Confirm Password should be same as Password");
				valid = false;
			}
		} else {
			System.out.println("Dto should not be null");
			valid = false;
		}
		return valid;
	}

	@Override
	public UserDto mailExist(String email1) {
		try {
			UserDto eml = repo.emailExist(email1);
			if (eml != null) {
				return eml;
			}
		} catch (Exception e) {
			System.out.println("Emailexception occured");
		}
		return null;
	}

	@Override
	public UserDto passwordExist(String password) {
		try {
			UserDto pwd = repo.passwordExist(password);
			if (pwd != null) {
				return pwd;
			}
		} catch (Exception e) {
			System.out.println("Password exception occured");
		}
		return null;
	}

	@Override
	public UserDto ifExist(String email1, String password, Model model) {
		try {
			UserDto exist = repo.ifExist(email1, password);

			if (exist != null) {
				model.addAttribute("exist", "Account already exist");
				return exist;
			}
		} catch (NoResultException e) {

		}
		return null;
	}

	@Override
	public UserDto signIn(String email1, String password, Model model) {

		try {
			if (email1 != null) {
				if (password != null) {
					UserDto dataExist = ifExist(email1, password, model);
					if (dataExist != null) {
						return dataExist;
					}
					model.addAttribute("data", "Account not found");
					return null;
				}
				model.addAttribute("psd", "Password is incorrect");
				System.out.println("Password is incorrect");
				return null;
			}
			model.addAttribute("eml", "Email is incorrect");
			System.out.println("Email is incorrect");
			return null;

		} catch (NoResultException e) {
			System.out.println("Exception Occured");
		}
		return null;
	}

	@Override
	public String randomOtp(int length) {

		String numbers = "0123456789";
		Random random = new Random();
		char[] otp = new char[length];
		for (int i = 0; i < length; i++) {
			otp[i] = numbers.charAt(random.nextInt(numbers.length()));
		}
		System.out.println(otp);
		return new String(otp);
	}

	public boolean sendOtpToEmail(String otp, String email1, Model model) {

		String senderEmail = "shuheb.xworkz@outlook.com";
		String senderPassword = "Shuheb@1995";
		String recipientEmail = email1;
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

	public boolean checkOtp(String email1, Model model) {

		UserDto check = mailExist(email1);
		if (check != null) {
			String otp = randomOtp(6);
			System.out.println(otp);

			boolean update = repo.updateOtpByEmail(otp, email1);
			System.out.println(update);

			boolean send = sendOtpToEmail(otp, email1, model);
			System.out.println(send);
			model.addAttribute("otpSent", "OTP sent");
			return true;
		}
		System.out.println("no email found to send otp");
		model.addAttribute("emailfound", "Email not found");
		return false;
	}

	@Override
	public UserDto otpValidate(String otp, Model model) {

		try {
			if (otp != null) {
				UserDto validate = repo.findOtp(otp);
				if (validate.getOtp().equals(otp)) {
					return validate;
				} else {
					model.addAttribute("otpValidate", "otp is incorrect");
					return null;
				}
			}
		} catch (NoResultException e) {
			System.out.println("OTP Exception occured");
			return null;
		}
		System.out.println("otp should not be null");
		return null;
	}

	@Override
	public boolean updatePasswordByEmail(String password, String confirmPassword, String email1, Model model) {

		if (password != null && !password.isEmpty() && password.length() > 7) {
			if (confirmPassword != null && confirmPassword.equals(password)) {
				
				System.out.println("Password is ready to update");
				return repo.updatePasswordByEmail(password, confirmPassword, email1);
			}
			model.addAttribute("cpsrd", "Password mismatch");
			return false;
		}
		model.addAttribute("psrd", "Password is incorrect");
		return false;
	}
	
	@Override
	public String encryptPWD(String password, String Secretkey) throws Exception {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(Secretkey.toCharArray(), Secretkey.getBytes(), 65536, 256);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		byte[] iv = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();

		byte[] encryptedPassword = cipher.doFinal(password.getBytes("UTF-8"));
		byte[] combined = new byte[iv.length + encryptedPassword.length];
		System.arraycopy(iv, 0, combined, 0, iv.length);
		System.arraycopy(encryptedPassword, 0, combined, iv.length, encryptedPassword.length);

		return Base64.getEncoder().encodeToString(combined);

	}

	@Override
	public String decryptPWD(String encryptPwd, String Secretkey) {

		byte[] combined = Base64.getDecoder().decode(encryptPwd);

		byte[] iv = new byte[16];
		byte[] encrypted = new byte[combined.length - 16];
		System.arraycopy(combined, 0, iv, 0, 16);
		System.arraycopy(combined, 16, encrypted, 0, encrypted.length);

		SecretKeyFactory factory;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

			KeySpec spec = new PBEKeySpec(Secretkey.toCharArray(), Secretkey.getBytes(), 65536, 256);
			SecretKey secret;

			secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
			Cipher cipher;

			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));

			return new String(cipher.doFinal(encrypted), "UTF-8");

		} catch (UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException
				| InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | NoSuchAlgorithmException e) {
			
			e.printStackTrace();

		}
		return null;

	}

}
