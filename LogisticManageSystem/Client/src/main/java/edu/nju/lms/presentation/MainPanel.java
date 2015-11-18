package edu.nju.lms.presentation;

import java.util.ArrayList;

import javax.swing.JPanel;

import edu.nju.lms.presentation.config.ComponentConfig;
import edu.nju.lms.presentation.config.PanelConfig;
import edu.nju.lms.presentation.config.UnitConfig;

public class MainPanel extends JPanel{
	PanelConfig config;
	ArrayList<Component> components;
	public MainPanel(PanelConfig config) {
		this.config = config;
		createComponents();
		createUnits();
	}
	private void createComponents() {
		ArrayList<ComponentConfig> componentConfigs = config.getComponents();
		components = new ArrayList<Component>(componentConfigs.size());
		for(ComponentConfig c: componentConfigs) {
			Component component = new Component(c.getX(), c.getY(), c.getW(), c.getH(), c.getName());
			components.add(component);
		}
	}
	private void createUnits() {
		for(UnitConfig unit: config.getUnits()) {
			try {
				Class<?> myUnit = Class.forName(unit.getName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
