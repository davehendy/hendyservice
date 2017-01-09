package uk.me.hendy.hendyservice.menu;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A Menu is a holder for a Hendy menu and its associated menu items.
 * @author Dave
 *
 */
@XmlRootElement(name="Menu")
public class MenuDTO {

	String menuName;
	String menuDescription;
	String menuLink;
	ArrayList <MenuItemDTO>menuItemArray = new ArrayList<MenuItemDTO>();
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	/**
	 * @return the menuDescription
	 */
	public String getMenuDescription() {
		return menuDescription;
	}
	/**
	 * @param menuDescription the menuDescription to set
	 */
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	public String getMenuLink() {
		return menuLink;
	}
	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}
	public ArrayList<MenuItemDTO> getMenuItemArray() {
		return menuItemArray;
	}
	public void setMenuItemArray(ArrayList <MenuItemDTO> menuItemArray) {
		this.menuItemArray = menuItemArray;
	}
	public void addMenuItem(MenuItemDTO menuItem){
		menuItemArray.add(menuItem);
	}
	
	/*public String getHtml() {
		StringBuilder menuHtml = new StringBuilder();
		
		menuHtml.append("<ul id='" + menuName + "'>");
		for (MenuItemDTO menuItem : menuItemArray) {
			menuHtml.append(menuItem.getHtml());
		}
		menuHtml.append("</ul>");
		
		return menuHtml.toString();
	}*/
	
	
	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", " +
				     "menuLink=" + menuLink	+ ", +" +
				     "menuItemArray=" + menuItemArray + "]";
	}

}
