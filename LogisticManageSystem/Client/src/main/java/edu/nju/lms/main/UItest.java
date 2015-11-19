package edu.nju.lms.main;

import edu.nju.lms.presentation.MainFrame;
import edu.nju.lms.presentation.MainPanel;
import edu.nju.lms.presentation.UIController;
import edu.nju.lms.presentation.config.ConfigReader;
import edu.nju.lms.presentation.config.PanelConfig;

public class UItest {
	UIController ui;
	public void mainFrameTest(){
		ui = new UIController();
		ConfigReader reader = new ConfigReader();
		PanelConfig panelConfig = reader.readPanel("MainPanel");
		MainPanel mainPanel = new MainPanel(panelConfig,ui);
		ui.getFrame().getContentPane().add(mainPanel);
	}
	public static void main(String[] args) {
		UItest test = new UItest();
		test.mainFrameTest();
	}
}
