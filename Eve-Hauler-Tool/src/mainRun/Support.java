package mainRun;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import EveObjects.Constellation;
import EveObjects.SolarSystem;

public class Support {

	public static int getRegionofSystem(int system) {
		return getRegionofConstellation(getConstellationofSystem(system));
	}
	
	public static int getConstellationofSystem(int system) {
		Gson gson = new Gson();
		String sURL = "https://esi.evetech.net/latest/universe/systems/"+ system +"/?datasource=tranquility&language=en-us";
		URL url;
		int outInt = 0;
		try {
			url = new URL(sURL);
			URLConnection request = url.openConnection();
			request.connect();
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			SolarSystem ss = gson.fromJson(root, SolarSystem.class);
			outInt = ss.getConstellation_id();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outInt;
	}
	
	public static int getRegionofConstellation(int constellation) {
		Gson gson = new Gson();
		String sURL = "https://esi.evetech.net/latest/universe/constellations/"+ constellation +"/?datasource=tranquility&language=en-us";
		URL url;
		int outInt = 0;
		try {
			url = new URL(sURL);
			URLConnection request = url.openConnection();
			request.connect();
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			Constellation con = gson.fromJson(root, Constellation.class);
			outInt = con.getRegion_id();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outInt;
	}
	
}
