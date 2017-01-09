package uk.me.hendy.hendyservice.menu;

/**
 * 
 * @author Dave Hendy
 * 
 * Provides Menu services
 *
 */
public interface MenuService {
	
	/**
	 * Gets a Menu object.
	 * @param menuName is the name of the menu.
	 * @return a Menu object.
	 */
	MenuDTO getMenu(String menuName);
	
	/**
	 * Gets a Menu as HTML.
	 * <br />
	 * Returned like:
	 * <br />
	 * <ul id="menuName">
	 * 		<li><a href="link">menuItemName</li>
	 * </ul>
	 * @param menuName is the name of the menu.
	 * @return a String with HTML.
	 */
	//String getMenuAsHtml(String menuName);
	
	/**
	 * 
	 * @param menuName
	 * @return Json String
	 */
	String getMenuAsJson(String menuName);
	
	void insertMenu(MenuDTO menuDTO);
	
	void deleteMenu(String id);

}
