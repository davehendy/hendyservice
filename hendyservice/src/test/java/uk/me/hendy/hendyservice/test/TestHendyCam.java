package uk.me.hendy.hendyservice.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.me.hendy.hendyservice.hendycam.HendyCamService;
import uk.me.hendy.hendyservice.image.ImageDTO;
import uk.me.hendy.hendyservice.menu.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hendyservice-spring-config.xml"})
public class TestHendyCam {
	
	
	@Autowired
	HendyCamService hendyCamService;

	@Test
	public void testGetImages() {
		System.out.println("Start testGetImages");
		
		List<ImageDTO> imageList = hendyCamService.getImagesSortedByDate();
		assertNotNull(imageList);
		
		for (ImageDTO image:imageList) {
			System.out.println("ImageDTO="+ image);
		}
		//System.out.println("imageList=" + imageList);
	}
	

}
