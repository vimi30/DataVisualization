package GUIModule;

import processing.core.PApplet;

public class MyDisplay extends PApplet {
	
	public void setup() 
	{
		size(852,480);
		background(200,200,200);
		
		
	}
	
	public void draw() 
	{
		fill(255,255,0);
		ellipse(400,200,300,300);
		fill(0,0,0);
		ellipse(320,140,30,50);
		ellipse(470,140,30,50);
		arc(400,230,90,150,0 ,PI);
		
		
	}

}
