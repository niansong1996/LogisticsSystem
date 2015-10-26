package edu.nju.lms.presentation.button;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ButtonAdd extends JPanel implements MouseListener{
	private boolean isIn;
	private Image btnAdd;
	private Image btnAdd1;
	
	public ButtonAdd(int x,int y) {
		this.setLayout(null);
		this.setBounds(x, y, 100, 50);
		btnAdd=new ImageIcon("picture/add.png").getImage();
		btnAdd1=new ImageIcon("picture/add1.png").getImage();
	}

	public void paintComponent(Graphics g){
		if(isIn){
			g.drawImage(btnAdd, 0,0,this.getWidth(),this.getHeight(), this);
		}else{
			g.drawImage(btnAdd1,0,0, this.getWidth(), this.getHeight(), this);
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
		this.repaint();
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn=false;
		this.repaint();
	}

}
