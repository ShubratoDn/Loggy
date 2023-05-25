package loggy.servicesImple;

import org.springframework.beans.factory.annotation.Autowired;

import loggy.entities.PostMultimedia;
import loggy.repository.PostMultimediaRepo;
import loggy.services.PostMultimediaServices;

public class PostMultimediaServicesImple implements PostMultimediaServices{
	
    private final PostMultimediaRepo postMultimediaRepo;
    
    @Autowired
    public PostMultimediaServicesImple(PostMultimediaRepo postMultimediaRepo) {
    	this.postMultimediaRepo = postMultimediaRepo;
    }
	
    
	@Override
	public PostMultimedia getPostMultimediaByPostId(int postId) {
		PostMultimedia postMm = this.postMultimediaRepo.getPostMultimediaByPostId(postId);
		return postMm;
	}

	
	
}
