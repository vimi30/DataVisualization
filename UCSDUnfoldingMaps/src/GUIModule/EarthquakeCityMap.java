package GUIModule;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class EarthquakeCityMap extends PApplet
{
	
	private UnfoldingMap map;
	
	public void setup() 
	{
		size(900,600,OPENGL);
		map = new UnfoldingMap(this,200,40,700,500,new Microsoft.AerialProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		
		Location valLoc = new Location(-38.14f,-73.03f);
		Location AlskLoc = new Location(61.02f,-147.65f);
		Location NsumtrLoc = new Location(3.30f,95.78f);
		Location JpnLoc = new Location(38.22f,142.36f);
		Location kmchkLoc = new Location(52.76f,160.06f);
		
		Feature valEq = new PointFeature(valLoc) ;
		valEq.addProperty("title", "valdivia, Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 20, 1960");
		valEq.addProperty("Year", "1960");
		
		Feature AlskEq = new PointFeature(AlskLoc) ;
		AlskEq.addProperty("title", "Great Alaska EQ");
		AlskEq.addProperty("magnitude", "9.2");
		AlskEq.addProperty("date", "March 28, 1964");
		AlskEq.addProperty("Year", "1964");
		
		Feature NsumtrEq = new PointFeature(NsumtrLoc) ;
		NsumtrEq.addProperty("title", "West Coast of Northern Sumatra");
		NsumtrEq.addProperty("magnitude", "9.1");
		NsumtrEq.addProperty("date", "December 26, 2004");
		NsumtrEq.addProperty("Year", "2004");
		
		Feature JpnEq = new PointFeature(JpnLoc) ;
		JpnEq.addProperty("title", "East Coast of Honshu, Japan");
		JpnEq.addProperty("magnitude", "9.0");
		JpnEq.addProperty("date", "March 11, 2011");
		JpnEq.addProperty("Year", "2011");
		
		Feature KmchkEq = new PointFeature(kmchkLoc) ;
		KmchkEq.addProperty("title", "Kamchatka");
		KmchkEq.addProperty("magnitude", "9.0");
		KmchkEq.addProperty("date", "November 04, 1952");
		KmchkEq.addProperty("Year", "1952");
		
		List<PointFeature> bigEqs = new ArrayList();
		bigEqs.add((PointFeature) valEq);
		bigEqs.add((PointFeature) AlskEq);
		bigEqs.add((PointFeature) NsumtrEq);
		bigEqs.add((PointFeature) JpnEq);
		bigEqs.add((PointFeature) KmchkEq);
		
		List<Marker> markers = new ArrayList();
		
		for(PointFeature eq:bigEqs) 
		{
			markers.add(new SimplePointMarker(eq.getLocation(),eq.getProperties()));
		}
		
		int yellow = color(255,255,0);
		int red = color(255,0,0);
		int green = color(0,255,0);
		
		for(Marker mk: markers) 
		{
			if( Integer.valueOf((String) mk.getProperty("Year"))> 2000 ) 
			{
			
				mk.setColor(red);
				mk.setStrokeWeight(3);
				mk.setStrokeColor(red);
			}else if(Integer.valueOf((String) mk.getProperty("Year"))< 2000 && Integer.valueOf((String) mk.getProperty("Year"))> 1960) 
			{
				mk.setColor(yellow);
				mk.setStrokeColor(yellow);
				mk.setStrokeWeight(8);
			}else 
			{
				mk.setColor(green);
			}
		}
		
		//Marker valMk = new SimplePointMarker(valLoc,valEq.getProperties());
		
		//SimplePointMarker val = new SimplePointMarker(valLoc);
		map.addMarkers(markers);
		
	}
	
	public void draw() 
	{
		background(200,200,200);
		map.draw();
		//addKey();
		
	}

}
