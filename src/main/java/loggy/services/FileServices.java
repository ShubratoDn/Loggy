package loggy.services;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public interface FileServices {

	//imageValidation
	List<String> userImageValidation(CommonsMultipartFile file);
	
	//blog image validation
	List<String> blogMultiMediaValidation(CommonsMultipartFile image);
	
	//uploading User image
	String uploadUserImage(CommonsMultipartFile file);
	
	//uploading post file
	String uploadPostFile(CommonsMultipartFile image);

}
