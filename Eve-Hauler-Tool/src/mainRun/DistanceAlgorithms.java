package mainRun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DistanceAlgorithms {
	
	private static ArrayList<Integer> inRange;
	private static ArrayList<int[]> jumpList;
	
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
		jumpList = getAllJumps(conn);
		inRange = new ArrayList<Integer>();
		RecursiveAllInRange(new ArrayList<Integer>(), maxJumps, start);
		return inRange;
	}

	private static void RecursiveAllInRange(ArrayList<Integer> WhereIHaveBeen, int RemainingJumps, int newLocation) {
		if (RemainingJumps > 0) {
			WhereIHaveBeen.add(newLocation);
			for (int[] i:jumpList){
				if (i[0] == WhereIHaveBeen.get(WhereIHaveBeen.size() - 1) && !WhereIHaveBeen.contains(i[1])) {
					if (!inRange.contains(i[1])) {
						inRange.add(i[1]);
					}
					RecursiveAllInRange(new ArrayList<Integer>(WhereIHaveBeen), RemainingJumps - 1, i[1]);
				}
			}
		}
	}
}
