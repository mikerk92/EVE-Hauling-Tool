package mainRun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DistanceAlgorithms {
	
	private static ArrayList<Integer> inRange;
	
	private static ArrayList<int[]> getAllJumps(Connection conn){
		String sql = "SELECT * FROM mapSolarSystemJumps";
		ArrayList<int[]> outlist = new ArrayList<int[]>();
        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
            	int[] tempintarray = {rs.getInt("fromSolarSystemID"), rs.getInt("toSolarSystemID")};
            	outlist.add(tempintarray);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return outlist;
	}
	
	public static ArrayList<Integer> getAllInRange (int maxJumps, Connection conn, int start) {
		ArrayList<int[]> jumpList = getAllJumps(conn);
		//spider out all the things
		inRange = new ArrayList<Integer>();
		RecursiveAllInRange(new ArrayList<Integer>(), maxJumps, jumpList, start);
		System.out.println(inRange);
		return null;
	}
	
	private static void RecursiveAllInRange(ArrayList<Integer> WhereIHaveBeen, int RemainingJumps, ArrayList<int[]> jumpList, int newLocation) {
		System.out.println(RemainingJumps);
		boolean swit = false;
		if (RemainingJumps > 0) {
			//int iter = 0;
			WhereIHaveBeen.add(newLocation);
			for (int[] i:jumpList){
				if (swit == true){
					System.out.println("Still Going");
				}
				//System.out.println(iter++);
				if (i[0] == WhereIHaveBeen.get(WhereIHaveBeen.size() - 1)) {
					if (!WhereIHaveBeen.contains(i[1])) {
						inRange.add(i[1]);
						RecursiveAllInRange(WhereIHaveBeen, RemainingJumps - 1, new ArrayList<int[]>(jumpList), i[1]);
						System.out.println("Post Recursion");
						swit = true;
					}
				}
			}
		}
	}

}
