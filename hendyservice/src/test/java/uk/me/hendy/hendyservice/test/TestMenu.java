package uk.me.hendy.hendyservice.test;

import static junit.framework.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.me.hendy.service.menu.MenuDTO;
import uk.me.hendy.service.menu.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hendyservice-spring-config.xml"})
public class TestMenu {
	@Autowired
	MenuService menuService;

	@Test
	public void testMenu() {
		System.out.println("Start testMenu");
		String menuName = "davetest";
		MenuDTO menu = getMenu(menuName);
		assertNotNull(menu);
		assertEquals(menu.getMenuName(),menuName);
		
		System.out.println("Menu=" + menu);
	}
	
	@Test
	public void testMenuHtml() {
		String menuName = "davetest";
		MenuDTO menu = getMenu(menuName);
		assertNotNull(menu);
		String menuHtml = menu.getHtml();
		
		System.out.println("HTML=" + menuHtml);
	}
	
	private MenuDTO getMenu(String menuName){
		return menuService.getMenu(menuName);
	}

}
