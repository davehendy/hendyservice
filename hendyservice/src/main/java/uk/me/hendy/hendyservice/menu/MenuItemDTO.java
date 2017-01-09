package uk.me.hendy.hendyservice.menu;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A menu item for a Hendy Menu.
 * @author Dave Hendy
 *
 */
		
public class MenuItemDTO {
	
	String menuItemName;
	int menuItemSeq;
	String menuItemLink;
	
	public String getMenuItemName() {
		return menuItemName;
	}
	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}
	public String getMenuItemLink() {
		return menuItemLink;
	}
	public void setMenuItemLink(String menuItemLink) {
		this.menuItemLink = menuItemLink;
	}
	/**
	 * @return the menuItemSeq
	 */
	public int getMenuItemSeq() {
		return menuItemSeq;
	}
	/**
	 * @param menuItemSeq the menuItemSeq to set
	 */
	public void setMenuItemSeq(int menuItemSeq) {
		this.menuItemSeq = menuItemSeq;
	}
	/**
	 * Gets the MenuItem as a String of HTML.
	 * @return a String.
	 */
	/*public String getHtml() {
		StringBuilder menuItemHtml = new StringBuilder();
		
		menuItemHtml.append("<li>");
		menuItemHtml.append("<a href='" + menuItemLink + "'>");
		menuItemHtml.append(menuItemName);
		menuItemHtml.append("</a>");
		menuItemHtml.append("</li>");
		
		return menuItemHtml.toString();
	}*/
	
	@Override
	public String toString() {
		return "MenuItem [menuItemName=" + menuItemName + 
				       ", menuItemSeq=" + menuItemSeq +
				       ", menuItemLink=" + menuItemLink + "]";
	}

	
}
