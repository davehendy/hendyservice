package uk.me.hendy.hendyservice.hendycam;

import java.util.List;

import uk.me.hendy.hendyservice.image.ImageDTO;

/**
 * Interface describing HendyCam services
 * 
 * @author Dave
 *
 */
public interface HendyCamService {
	
	List<ImageDTO> getImagesSortedByDate();

}
