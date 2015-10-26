package edu.nju.lms.presentation.button;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ButtonFind extends JPanel implements MouseListener{
	private boolean isIn=false;
	private Image btnFind;
	private Image btnFind1;
	
	public ButtonFind(int x,int y) {
		this.setBounds(x,y,110, 23);
		btnFind=new ImageIcon("pictures/find.png").getImage();
		btnFind1=new ImageIcon("pictures/find1.png").getImage();
	}

	public void paintComponent(Graphics g){
		if(isIn){
			g.drawImage(btnFind, 0,0,this.getWidth(), this.getWidth(), null);
		}else{
			g.drawImage(btnFind1,0,0, this.getWidth(), this.getHeight(), null);
		}
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn=true;
		repaint();
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn=false;
		repaint();
	}

}
