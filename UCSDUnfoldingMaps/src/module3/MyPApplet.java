package module3;

import processing.core.*;

public class MyPApplet extends PApplet
{
	private String URL = "https://www.designyourway.net/drb/wp-content/uploads/2015/05/Beach-Wallpaper-Desktop-Background-4-1600x900.jpg";
	private PImage backgroudImg;
	
	public void setup() 
	{
		size(852,480);
		background(255);
		stroke(0);
		backgroudImg = loadImage(URL,"jpg");
		backgroudImg.resize(0,height);
		image(backgroudImg,0,0);
	}
	
	public void draw() 
	{
		
		int[] color = sunColorSec(hour());
		
		fill(color[0],color[1],color[2]);
		ellipse(width/5,width/6,width/5,width/4);
		
	}
	
	public int[] sunColorSec(float hours) 
	{
		int[] rgb = new int[3];
		
		
		float differFrom30 = Math.abs(12-hours);
		
		float ratio = differFrom30/12;
		
		rgb[0] = (int) (255*ratio);
		rgb[1] = (int) (255*ratio);
		rgb[2] = 0;
		
		return rgb;
		
	}
	
	
}