//package edu.nju.lms.presentation.button;
//
//import java.awt.Graphics;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//
//import edu.nju.lms.presentation.panel.AddPanel;
//
//public class ButtonAdd extends JPanel implements MouseListener{
//	private boolean isIn=false;
//	private AddPanel addPanel;
//	
//	public ButtonAdd(int x,int y) {
//		this.setBounds(x,y,110, 23);
//		
//	}
//
//	public void paintComponent(Graphics g){
//		if(isIn){
//			g.drawImage(new ImageIcon("pictures/add.png").getImage(), 0,0,this.getWidth(),this.getHeight(), this);
//		}else{
//			g.drawImage(new ImageIcon("pictures/add1.png").getImage(),0,0, this.getWidth(), this.getHeight(), this);
//		}
//	}
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		isIn=true;
//		this.repaint();
//	}
//
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		isIn=false;
//		this.repaint();
//	}
//
//}
