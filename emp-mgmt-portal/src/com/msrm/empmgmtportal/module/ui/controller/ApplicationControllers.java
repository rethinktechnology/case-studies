package com.msrm.empmgmtportal.module.ui.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class ApplicationControllers {

	public enum Type {
		testController, applicationUIController
	}

	@Autowired
	private ListableBeanFactory listableBeanFactory;

	private Map<String, Object> controllers;

	@PostConstruct
	public void init() {
		System.out.println("Init");
		if (controllers == null) {
			controllers = new HashMap<>();
		}
		if (controllers.isEmpty() && null != listableBeanFactory) {
			controllers = listableBeanFactory.getBeansWithAnnotation(Controller.class);
		}
	}

	public Object getController(Type type) {
		return controllers.get(type.name());
	}

}
