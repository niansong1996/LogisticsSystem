package edu.nju.lms.presentation.config;

import org.dom4j.Element;

/**
 * config of a component
 * @see Component
 * @author cuihao
 * last modified: 2015-11-17 22:40:59
 */
public class ComponentConfig {
	private String name;
	private int x;
	private int y;
	private int w;
	private int h;
	public ComponentConfig(Element component){
		this.name = component.attributeValue("name");
		this.x = Integer.parseInt(component.attributeValue("x"));
		this.y = Integer.parseInt(component.attributeValue("y"));
		this.w = Integer.parseInt(component.attributeValue("w"));
		this.h = Integer.parseInt(component.attributeValue("h"));
	}
	public String getName() {
		return name;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
}
