package edu.nju.lms.main;

import edu.nju.lms.presentation.MainFrame;

public class UItest {
	MainFrame frame;
	public void mainFrameTest(){
		frame = new MainFrame();
		frame.changeTo("MainPanel");
		frame.repaint();
	}
	public static void main(String[] args) {
		UItest test = new UItest();
		test.mainFrameTest();
	}
}
