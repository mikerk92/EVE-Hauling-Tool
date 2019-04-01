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
	
	private static int Range = 1; // Simulate input
	private static int FinanceLimit = 1000000; //sim input
	private static int HullSize = 5000; //sim input
	private static int CurrentLocation = 30003555; //sim input
	
	public static void main(String[] args) {
		getJumps();
	}
	public static void getJumps() {
        System.out.println(DistanceAlgorithms.getAllInRange(Range, connect(), CurrentLocation));      
	}
	
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\Support libraries\\sqlite-latest.sqlite\\sqlite-latest.sqlite";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
}
