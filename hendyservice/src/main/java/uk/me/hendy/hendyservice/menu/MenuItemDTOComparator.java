package uk.me.hendy.hendyservice.menu;

import java.util.Comparator;

public class MenuItemDTOComparator implements Comparator<MenuItemDTO> {
	public int compare(MenuItemDTO item1, MenuItemDTO item2) {
		return item1.getMenuItemSeq() - item2.getMenuItemSeq();
	}

}
