package EveObjects;

import java.util.Arrays;

public class SolarSystem {
	private int constellation_id;
	private String name;
	private Planet[] planets;
	private Position position;
	private String security_class;
	private float security_status;
	private int star_id;
	private int[] stargates;
	private int[] stations;
	private int system_id;
	
	public SolarSystem() {
		
	}
	public int getConstellation_id() {
		return constellation_id;
	}
	public void setConstellation_id(int constellation_id) {
		this.constellation_id = constellation_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Planet[] getPlanets() {
		return planets;
	}
	public void setPlanets(Planet[] planets) {
		this.planets = planets;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getSecurity_class() {
		return security_class;
	}
	public void setSecurity_class(String security_class) {
		this.security_class = security_class;
	}
	public float getSecurity_status() {
		return security_status;
	}
	public void setSecurity_status(float security_status) {
		this.security_status = security_status;
	}
	public int getStar_id() {
		return star_id;
	}
	public void setStar_id(int star_id) {
		this.star_id = star_id;
	}
	public int[] getStargates() {
		return stargates;
	}
	public void setStargates(int[] stargates) {
		this.stargates = stargates;
	}
	public int[] getStations() {
		return stations;
	}
	public void setStations(int[] stations) {
		this.stations = stations;
	}
	public int getSystem_id() {
		return system_id;
	}
	public void setSystem_id(int system_id) {
		this.system_id = system_id;
	}
	@Override
	public String toString() {
		return "SolarSystem [constellation_id=" + constellation_id + ", name=" + name + ", planets="
				+ Arrays.toString(planets) + ", position=" + position + ", security_class=" + security_class
				+ ", security_status=" + security_status + ", star_id=" + star_id + ", stargates="
				+ Arrays.toString(stargates) + ", stations=" + Arrays.toString(stations) + ", system_id=" + system_id
				+ "]";
	}	
}

