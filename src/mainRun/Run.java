package mainRun;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Run {
	
	public static void main(String[] args) {
		HashMap<Integer, ArrayList<Integer>> jumps = new HashMap<Integer, ArrayList<Integer>>();
		Gson gson = new Gson();
		String sURL = "https://esi.evetech.net/latest/universe/regions/?datasource=tranquility";
		URL url;
		try {
			url = new URL(sURL);
			URLConnection request = url.openConnection();
			request.connect();
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			String[] RegionIds = gson.fromJson(root, String[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getJumps(jumps);
		
		
	}
	public static void getJumps(HashMap<Integer, ArrayList<Integer>> jumps) {
		String sql = "SELECT * FROM mapSolarSystemJumps";
		ArrayList<int[]> testlist = new ArrayList<int[]>();
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
            	int[] tempintarray = {rs.getInt("fromSolarSystemID"), rs.getInt("toSolarSystemID")};
            	testlist.add(tempintarray);
            	if (rs.getInt("fromSolarSystemID") == 30003555) {
            		System.out.println(rs.getInt("toSolarSystemID"));
            	}
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(testlist.get(13000)[0]);
        DistanceAlgorithms.getAllInRange(2, connect(), 30003555);
        //System.out.println(jumps);
        
	}
	
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Support libraries\\sqlite-latest.sqlite\\sqlite-latest.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            //System.out.println(conn.);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
}
