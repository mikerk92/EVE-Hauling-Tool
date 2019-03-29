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
import java.sql.SQLException;

public class Run {

	public static void main(String[] args) {
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
		connect();
		
	}
	
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Support libraries\\sde-20190219-TRANQUILITY\\sde\\fsd\\universe\\eve\\Aridia\\region.staticdata";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            System.out.println(conn.);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */

}
