package edu.nju.lms.presentation.config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import edu.nju.lms.presentation.Component;

/**
 * configure info of a panel, including all the component configures
 * @author cuihao
 * 2015-11-18 00:18:16
 */
public class PanelConfig {

	/**
	 * width of a panel
	 */
	private int width;
	/**
	 * height of a panel
	 */
	private int height;
	/**
	 * location x
	 */
	private int x;
	/**
	 * location y
	 */
	private int y;
	/**
	 * picture configure info of this panel a panel will show its picture
	 * according to {@link Component}
	 * 
	 * @see Component
	 */
	private ArrayList<Component> components;

	public PanelConfig(Element panel) {
		width = Integer.parseInt(panel.attributeValue("width"));
		height = Integer.parseInt(panel.attributeValue("height"));
		initializeComponents(getComponentConfigures(panel));
	}

	private ArrayList<ComponentConfig> getComponentConfigures(Element panel) {
		List<Element> elements = panel.elements("component");
		ArrayList<ComponentConfig> configs = new ArrayList<ComponentConfig>(elements.size());
		for (Element component : elements) {
			ComponentConfig config = new ComponentConfig(component);
			configs.add(config);
		}
		return configs;
	}

	private void initializeComponents(ArrayList<ComponentConfig> configs) {
		components = new ArrayList<Component>(configs.size());
		for (ComponentConfig config:configs) {
			Component c = new Component(config.getX(), config.getY(), config.getW(), config.getH(), config.getName());
			components.add(c);
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
