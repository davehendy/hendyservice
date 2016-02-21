package uk.me.hendy.hendyservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.me.hendy.hendyservice.hendycam.HendyCamService;
import uk.me.hendy.hendyservice.image.ImageDTO;
import uk.me.hendy.hendyservice.menu.MenuDTO;

@Controller
@RequestMapping("/hendycam")
public class HendyCamController {
	
	private static final Logger logger = LoggerFactory.getLogger(HendyCamController.class);
	
	@Autowired
	private HendyCamService hendyCamService;
	
	@RequestMapping(value="/list", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public @ResponseBody List<ImageDTO> getHendyCamJson(ModelMap model) {
		logger.debug("getHendyCamJson()");
		return hendyCamService.getImagesSortedByDate();
		
		//model.addAttribute("menu", menuDTO);
		//return menuDTO;
	}
	@RequestMapping(value="/list", produces=MediaType.APPLICATION_XML_VALUE, method=RequestMethod.GET)
	public @ResponseBody List<ImageDTO> getHendyCamXml(ModelMap model) {
		logger.debug("getHendyCamJson()");
		List<ImageDTO> imageList = hendyCamService.getImagesSortedByDate();
		model.addAttribute("hendycamlist", imageList);
		return imageList;
		
		//model.addAttribute("menu", menuDTO);
		//return menuDTO;
	}
	
	
}
