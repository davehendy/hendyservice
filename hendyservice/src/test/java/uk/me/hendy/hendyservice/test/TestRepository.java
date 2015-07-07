package uk.me.hendy.hendyservice.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.me.hendy.hendyservice.menu.MenuDTO;
import uk.me.hendy.hendyservice.menu.MenuItemDTO;
import uk.me.hendy.hendyservice.menu.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hendyservice-spring-config.xml"})
public class TestRepository {
	@Autowired
	MenuService menuService;

	@Test
	public void test() {
		MenuDTO menuDto = menuService.getMenu("davetest");
		System.out.println("MenuDTO="+menuDto);
	}

	@Test
	public void testinsert() {
		System.out.println("Starting testinsert");
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setMenuName("davetest");
		menuDTO.setMenuDescription("A test insert");
		menuDTO.setMenuLink("test");

		MenuItemDTO menuItemDTO = new MenuItemDTO();
		menuItemDTO.setMenuItemSeq(1);
		menuItemDTO.setMenuItemName("item1");
		menuItemDTO.setMenuItemLink("item 1 link");
		menuDTO.getMenuItemArray().add(menuItemDTO);
		
		menuService.insertMenu(menuDTO);
	}
	
	@Test
	public void test3() {
		System.out.println("Starting test3");
		menuService.deleteMenu("daveyyy");
	}
}
