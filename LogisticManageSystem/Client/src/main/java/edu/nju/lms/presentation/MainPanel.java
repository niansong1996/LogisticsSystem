package edu.nju.lms.presentation;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import edu.nju.lms.presentation.button.MainButton;
import edu.nju.lms.presentation.config.ComponentConfig;
import edu.nju.lms.presentation.config.PanelConfig;
import edu.nju.lms.presentation.config.UnitConfig;

/**
 * general panel
 * @author cuihao
 * 2015-11-19 00:04:34
 */
public class MainPanel extends JPanel{
	/**
	 * configure info of this panel
	 * @see PanelConfig
	 */
	private PanelConfig config;
	/**
	 * pictures of this panel
	 */
	private ArrayList<Component> components;
	/**
	 * {@link java.awt.Component} of this panel
	 */
	private ArrayList<java.awt.Component> units;
	/**
	 * @see UIController
	 */
	private UIController controller;
	
	public MainPanel(PanelConfig config, UIController controller) {
		this.controller = controller;
		this.config = config;
		units = new ArrayList<java.awt.Component>();
		setLayout(null);
		createComponents();
		createUnits();
	}
	
	/**
	 * initialize picture {@link Component} by {@link ComponentConfig}
	 */
	private void createComponents() {
		ArrayList<ComponentConfig> componentConfigs = config.getComponents();
		components = new ArrayList<Component>(componentConfigs.size());
		for(ComponentConfig c: componentConfigs) {
			Component component = new Component(c.getX(), c.getY(), c.getW(), c.getH(), c.getName(), c.getClassName());
			components.add(component);
		}
	}
	
	/**
	 * initialize {@link java.awt.Component} using {@link UnitConfig}
	 * if type==1, initialize Listener extends {@link MouseListener}
	 */
	private void createUnits() {
		for (UnitConfig unit : config.getUnits()) {
			try {
				Class<?> myUnit = Class.forName(unit.getClassName());
				java.awt.Component com;
				Constructor<?> ctr = myUnit.getConstructor(Element.class, UIController.class);
				com = (java.awt.Component) ctr.newInstance(unit.getElement(),controller);
				add(com);
				units.add(com);
				if(unit.getElement().attributeValue("type").equals("1")){
					Class<?> listenner = Class.forName(unit.getElement().attributeValue("listenerName"));
					MouseListener mouseListener;
					Constructor<?> ct = listenner.getConstructor(ArrayList.class,UIController.class, java.awt.Component.class);
					mouseListener = (MouseListener) ct.newInstance(units,controller,com);
					com.addMouseListener(mouseListener);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * draw pictures
	 */
	@Override
	protected void paintComponent(Graphics g) {
		for(Component com: components) {
			com.createComponent(g);
		}
	}
	public PanelConfig getConfig() {
		return config;
	}
	public void setConfig(PanelConfig config) {
		this.config = config;
	}
	public ArrayList<java.awt.Component> getUnits() {
		return units;
	}
	public void setUnits(ArrayList<java.awt.Component> units) {
		this.units = units;
	}
	
}
