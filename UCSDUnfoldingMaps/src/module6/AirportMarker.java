package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(255,0,0);
		pg.ellipse(x, y, 5, 5);
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		pg.fill(255,255,255);
		pg.rect(x, y, 180, 100,10);
		
		String info = "Name: "+getStringProperty("name")+"\n"+"City: "+getStringProperty("city")+"\n"+"Country: "+getStringProperty("country")+"\n"+
		"Code : "+getStringProperty("code");
		pg.textSize(10);
		pg.fill(0,0,0);
		pg.text(info,x+5+radius,y+5+radius,280,90);
		// show routes
		
		
	}
	
}
