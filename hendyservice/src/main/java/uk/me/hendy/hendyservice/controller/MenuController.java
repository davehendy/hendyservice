package uk.me.hendy.hendyservice.controller;

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

import uk.me.hendy.hendyservice.menu.MenuDTO;
import uk.me.hendy.hendyservice.menu.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/{name}", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public @ResponseBody MenuDTO getMenuJson(@PathVariable("name") String name, ModelMap model) {
		logger.debug("getMenuJson(" + name + ")");
		MenuDTO menuDTO = new MenuDTO();
		menuDTO = menuService.getMenu("davetest");
		model.addAttribute("menu", menuDTO);
		return menuDTO;
	}
	
	@RequestMapping(value="/{name}", produces=MediaType.APPLICATION_XML_VALUE, method=RequestMethod.GET)
	public @ResponseBody MenuDTO getMenuXml(@PathVariable("name") String name, ModelMap model) {
		logger.debug("getMenuXml(" + name + ")");
		MenuDTO menuDTO = new MenuDTO();
		menuDTO = menuService.getMenu("davetest");
		model.addAttribute("menu", menuDTO);
		return menuDTO;
	}

}
