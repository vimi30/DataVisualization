package GUIModule;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeEx extends PApplet {
	
	private UnfoldingMap map;
	
	Map<String, Float> lifeExbyCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	public void setup() 
	{
		size(852,480,OPENGL);
		
		map = new UnfoldingMap(this,50,50,700,400,new MBTilesMapProvider("blankLight-1-3.mbtiles"));
		MapUtils.createDefaultEventDispatcher(this, map);
		
		lifeExbyCountry = loadLifeExFromCSV("LifeExpectancyWorldBankModule3.csv");
		
		countries = GeoJSONReader.loadData(this, "countries.geo.json");// these are helper method provided by Unfolding map
		
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		map.addMarkers(countryMarkers);
		
		shadeCountries();
		
		
		
		
	}
	
	private void shadeCountries() {
		
		for(Marker marker: countryMarkers) 
		{
			String countryId = marker.getId();
			
			if(lifeExbyCountry.containsKey(countryId)) {
				float lifeEx = lifeExbyCountry.get(countryId);
				
				int colorLevel = (int) map(lifeEx,40,90,0,255);// map method
				
				marker.setColor(color(255-colorLevel,100,colorLevel));// setting color of the country according to life expectancy 
				
			}else {
				
				marker.setColor(color(150,150,150));// Default color (grey)
			}
			
		}
		// TODO Auto-generated method stub
		
	}

	private Map<String, Float> loadLifeExFromCSV(String fileName) {
		
		Map<String, Float> lifeExMap = new HashMap<String, Float>();
		
		String[] rows = loadStrings(fileName);// reading data from the file
		for(String row: rows) 
		{
			String[] columns = row.split(",");
			
			if(columns.length == 6 && !columns[5].equals("..")) 
			{
				float value = Float.parseFloat(columns[5]);
				lifeExMap.put(columns[4], value);
			}
			
		}
		
		// TODO Auto-generated method stub
		return lifeExMap;
	}

	

	public void draw() 
	{
		map.draw();
		
		
	}

}
