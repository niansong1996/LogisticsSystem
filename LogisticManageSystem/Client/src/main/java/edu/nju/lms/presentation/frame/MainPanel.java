package edu.nju.lms.presentation.frame;

import java.awt.Graphics;
import java.awt.ItemSelectable;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.dom4j.Element;

import edu.nju.lms.presentation.UIController.UIController;
import edu.nju.lms.presentation.components.Component;
import edu.nju.lms.presentation.config.ComponentConfig;
import edu.nju.lms.presentation.config.PanelConfig;
import edu.nju.lms.presentation.config.UnitConfig;

/**
 * General panel<br>
 * The panel will show pictures and add components according to "UIConfig.xml"
 * @author cuihao 
 * @date 2015-11-19 00:04:34
 */
public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 5802205870400021451L;
	/**
	 * configure info of this panel
	 * 
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

	public static final String packageName = "edu.nju.lms.presentation.";
	private int x;
	private int y;
	private int h;
	private int w;
	private String name;

	public MainPanel(PanelConfig config, UIController controller) {
		this.controller = controller;
		this.config = config;
		units = new ArrayList<java.awt.Component>();
		setLayout(null);
		Element button = config.getElement();
		w = Integer.parseInt(button.attributeValue("w"));
		h = Integer.parseInt(button.attributeValue("h"));
		x = Integer.parseInt(button.attributeValue("x"));
		y = Integer.parseInt(button.attributeValue("y"));
		name = button.attributeValue("name");
		setBounds(x, y, w, h);
		createComponents();
		createUnits();
	}

	/**
	 * initialize picture {@link Component} by {@link ComponentConfig}
	 */
	private void createComponents() {
		ArrayList<ComponentConfig> componentConfigs = config.getComponents();
		components = new ArrayList<Component>(componentConfigs.size());
		for (ComponentConfig c : componentConfigs) {
			Component component = new Component(c.getX(), c.getY(), c.getW(), c.getH(), c.getName(), c.getClassName());
			components.add(component);
		}
	}

	/**
	 * initialize {@link java.awt.Component} using {@link UnitConfig} if
	 * type==1, initialize Listener extends {@link MouseListener} or {@link ItemListener}
	 */
	private void createUnits() {
		for (UnitConfig unit : config.getUnits()) {
			try {
				/**
				 * create and initialize components(units)
				 */
				Class<?> myUnit = Class.forName(packageName + "components." + unit.getClassName());
				java.awt.Component com;
				Constructor<?> ctr = myUnit.getConstructor(Element.class, UIController.class);
				com = (java.awt.Component) ctr.newInstance(unit.getElement(), controller);
				add(com);
				units.add(com);
				/**
				 * add listener
				 */
				if (unit.getElement().attributeValue("type").equals("1")) {
					Class<?> listenner = Class
							.forName(packageName + "mouseListener." + unit.getElement().attributeValue("listenerName"));
					MouseListener mouseListener;
					Constructor<?> ct = listenner.getConstructor(ArrayList.class, UIController.class,
							java.awt.Component.class);
					mouseListener = (MouseListener) ct.newInstance(units, controller, com);
					com.addMouseListener(mouseListener);
				} else if (unit.getElement().attributeValue("type").equals("itemListener")) {
					Class<?> listenner = Class
							.forName(packageName + "mouseListener." + unit.getElement().attributeValue("listenerName"));
					ItemListener itemListener;
					Constructor<?> ct = listenner.getConstructor(ArrayList.class, UIController.class,
							java.awt.Component.class);
					itemListener = (ItemListener) ct.newInstance(units, controller, com);
					((ItemSelectable) com).addItemListener(itemListener);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create panel and add it to this panel
	 * @param panelName
	 */
	public void createPanels(String panelName) {
		for (PanelConfig panel : config.getPanels()) {
			if (panel.getElement().attributeValue("name").equals(panelName)) {
				try {
					Class<?> myUnit = Class.forName(packageName + "MainPanel");
					java.awt.Component com;
					Constructor<?> ctr = myUnit.getConstructor(PanelConfig.class, UIController.class);
					com = (java.awt.Component) ctr.newInstance(panel, controller);
					com.setVisible(true);
					add(com);
					units.add(com);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * draw pictures
	 */
	@Override
	protected void paintComponent(Graphics g) {
		for (Component com : components) {
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

	public String getName() {
		return name;
	}
}
