package uk.me.hendy.hendyservice.menu;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uk.me.hendy.hendyservice.message.Message;
import uk.me.hendy.hendyservice.utility.JsonUtility;
import uk.me.hendy.hendyservice.utility.RepositoryUtility;
import uk.me.hendy.repository.RepositoryApplication;
import uk.me.hendy.repository.model.Menu;
import uk.me.hendy.repository.model.MenuItem;

/**
 * {@inheritDoc}
 */
@Service("menuService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class MenuServiceHendyRepository implements MenuService {
	private static final Logger logger = LoggerFactory.getLogger(MenuServiceHendyRepository.class);
	//@Autowired
	//RepositoryApplicationFactory repositoryApplicationFactory;
	RepositoryApplication repositoryApplication = RepositoryUtility.start();
	//private static RepositoryApplicationFactory fact = new RepositoryApplicationFactory();

	public MenuDTO getMenu(String menuName) {
		logger.debug("getMenu(" + menuName + ")");
		//RepositoryApplicationFactory fact = new RepositoryApplicationFactory();
		//repositoryApplication = RepositoryUtility.start();
		//repositoryApplication = repositoryApplicationFactory.getInstance();
		
		MenuDTO menuDto = new MenuDTO();
		MenuItemDTOComparator comparator = new MenuItemDTOComparator();
		Menu menu = repositoryApplication.getMenu(menuName);
		if (menu != null) {
			menuDto.setMenuName(menu.getName());
			
			for (MenuItem menuItem : menu.getMenuItemSet()){
				MenuItemDTO menuItemDto = new MenuItemDTO();
				menuItemDto.setMenuItemName(menuItem.getName());
				menuItemDto.setMenuItemLink(menuItem.getLinkUrl());
				menuItemDto.setMenuItemSeq(menuItem.getMenuSeq());
				menuDto.getMenuItemArray().add(menuItemDto);
			}
			Collections.sort(menuDto.getMenuItemArray(), comparator);
		} else {
			logger.error("Menu " + menuName + " not found.");
			menuDto.setMenuName(menuName);
			menuDto.setMenuDescription(Message.NO_MENU.toString());
		}
					
		return menuDto;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getMenuAsHtml(String menuName) {
		return this.getMenu(menuName).getHtml();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getMenuAsJson(String menuName) {
		logger.debug("getMenuAsJson("+menuName+")");
		
		return JsonUtility.toJson(this.getMenu(menuName), false);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void insertMenu(MenuDTO menuDTO) {
		logger.debug("insertMenu");
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
		//menu.setMenuItemSet(menuItemSet);
		
		repositoryApplication.createMenu(menu);
		
	}
	

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteMenu(String id) {
		Menu menu = new Menu();
		menu.setName(id);
		repositoryApplication.removeMenu(menu);
		
	}
}
