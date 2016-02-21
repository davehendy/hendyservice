package uk.me.hendy.hendyservice.hendycam;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import uk.me.hendy.hendyservice.image.ImageDTO;
import uk.me.hendy.hendyservice.utility.RepositoryUtility;
import uk.me.hendy.repository.RepositoryApplication;
import uk.me.hendy.repository.hendycam.model.HendyCamImage;

/**
 * HendyRepository implementation of HendyCam services
 * 
 * @author Dave
 *
 */
@Service("HendyCamService")
public class HendyCamServiceHendyRepository implements HendyCamService {
	private static final Logger logger = LoggerFactory.getLogger(HendyCamServiceHendyRepository.class);

	RepositoryApplication repositoryApplication = RepositoryUtility.getInstance();
	@Override
	/**
	 * Images are already sorted by date in repository - just bung then in the DTO
	 */
	public List<ImageDTO> getImagesSortedByDate() {
		logger.debug("getImagesSortedByDate");
		LinkedList<ImageDTO> imageDTOList = new LinkedList<ImageDTO>();
		List<HendyCamImage> imageList = repositoryApplication.getHendyCamImages();
		for (HendyCamImage image : imageList) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setDateCreated(image.getDateCreated());
			imageDTO.setName(image.getName());
			imageDTO.setPath(image.getPath());
			imageDTOList.add(imageDTO);
		}
		return imageDTOList;
	}

}
