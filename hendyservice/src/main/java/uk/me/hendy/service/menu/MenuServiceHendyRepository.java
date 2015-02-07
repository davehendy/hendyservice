package uk.me.hendy.service.menu;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uk.me.hendy.repository.RepositoryApplication;
import uk.me.hendy.repository.model.Menu;
import uk.me.hendy.repository.model.MenuItem;

/**
 * {@inheritDoc}
 */
@Service("menuService")
public class MenuServiceHendyRepository implements MenuService {
	
	@Autowired
	RepositoryApplication repositoryApplication;

	public MenuDTO getMenu(String menuName) {
		MenuDTO menuDto = new MenuDTO();
		Menu menu = repositoryApplication.getMenu(menuName);
		
		menuDto.setMenuName(menu.getName());
			
		return menuDto;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getMenuAsHtml(String menuName) {
		return this.getMenu(menuName).getHtml();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void insertMenu(MenuDTO menuDTO) {
		Menu menu = new Menu();
		menu.setName(menuDTO.getMenuName());
		menu.setDescription(menuDTO.getMenuLink());
		Set<MenuItem> menuItemSet = new HashSet<MenuItem>();
		for (MenuItemDTO menuItemDTO : menuDTO.getMenuItemArray()) {
			MenuItem menuItem = new MenuItem();
			menuItem.setMenuName(menu.getName());
			menuItem.setMenuSeq(menuItemDTO.getMenuItemSeq());
			menuItem.setName(menuItemDTO.getMenuItemName());
			menuItem.setLinkUrl(menuItemDTO.getMenuItemLink());
			menuItemSet.add(menuItem);
		}
		menu.setMenuItemSet(menuItemSet);
		
		repositoryApplication.createMenu(menu);
	}
	

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteMenu(String id) {
		Menu menu = new Menu();
		menu.setName(id);
		repositoryApplication.removeMenu(menu);
	}
}
