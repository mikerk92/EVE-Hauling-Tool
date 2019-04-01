package EveObjects;

import java.util.Arrays;

public class Constellation {
	private int constellation_id;
	private String name;
	private Position position;
	private int region_id;
	private int[] systems;
	public Constellation() {
		super();
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
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public int[] getSystems() {
		return systems;
	}
	public void setSystems(int[] systems) {
		this.systems = systems;
	}
	@Override
	public String toString() {
		return "Constellation [constellation_id=" + constellation_id + ", name=" + name + ", position=" + position
				+ ", region_id=" + region_id + ", systems=" + Arrays.toString(systems) + "]";
	}
	
}
