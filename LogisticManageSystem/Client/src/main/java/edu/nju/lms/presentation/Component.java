package edu.nju.lms.presentation;

import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

/** 
 *basic property of a single picture
 *last modified:2015-11-17 22:30:50
 */
public class Component {
	private int x;
	private int y;
	private int width;
	private int height;
	private String path="pictures/";
	private String name;
	public Component(int x,int y,int width,int height,String name){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.name=name;
		path=path+name+".png";
	}
	public void createComponent(Graphics g){
		Image image;
		try {
			image = ImageIO.read(new FileInputStream(path));
			g.drawImage(image, x, y, width,height,null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void changePath(){
		path="pictures/"+name+"1"+".png";
	}
	public void setPath(){
		path="pictures/"+name+".png";
	}
	public void setPath(String path){
		this.path=path;
	}

}
