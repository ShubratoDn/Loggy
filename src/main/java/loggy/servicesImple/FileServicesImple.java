package loggy.servicesImple;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import loggy.services.FileServices;

public class FileServicesImple implements FileServices {

	public List<String> userImageValidation(CommonsMultipartFile file) {

		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getStorageDescription());
		
		
		
		return null;
	}

	public List<String> blogMultiMediaValidation(CommonsMultipartFile image) {
		// TODO Auto-generated method stub
		return null;
	}

	public String uploadUserImage(CommonsMultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	public String uploadPostFile(CommonsMultipartFile image) {
		// TODO Auto-generated method stub
		return null;
	}

}
