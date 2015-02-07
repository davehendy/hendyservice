package uk.me.hendy.service.menu;

import org.springframework.stereotype.Service;

/**
 * {@inheritDoc}
 */

public class MenuServiceDefault implements MenuService {

	public MenuDTO getMenu(String menuName) {
		MenuDTO menu = null;
		if (menuName.equals("davetest")){
			menu = getTestMenu();
		}
		return menu;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getMenuAsHtml(String menuName) {
		return this.getMenu(menuName).getHtml();
	}
	
	/**
	 * Just used for testing purposes
	 * @return a test Menu
	 */
	private MenuDTO getTestMenu() {
		MenuDTO menu = new MenuDTO();
		menu.setMenuName("davetest");
		
		MenuItemDTO menuItem = null;
		
		menuItem = new MenuItemDTO();
		menuItem.setMenuItemName("Home");
		menuItem.setMenuItemLink("home");
		menu.addMenuItem(menuItem);
		
		menuItem = new MenuItemDTO();
		menuItem.setMenuItemName("About");
		menuItem.setMenuItemLink("about");
		menu.addMenuItem(menuItem);
		
		menuItem = new MenuItemDTO();
		menuItem.setMenuItemName("News");
		menuItem.setMenuItemLink("news");
		menu.addMenuItem(menuItem);
		
		return menu;
	}

	public void insertMenu(MenuDTO menuDTO) {
		
	}
	
	public void deleteMenu(String id) {
		
	}
}
