package uk.me.hendy.hendyservice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.me.hendy.service.menu.MenuService;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("hendyservice-spring-config.xml");
		MenuService menuService = (MenuService) context.getBean("MenuService");
		menuService.getMenu("davetest");

	}

}
