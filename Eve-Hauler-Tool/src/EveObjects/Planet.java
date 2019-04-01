package EveObjects;

import java.util.Arrays;

public class Planet {
	private int planet_id;
	private int[] moons;
	private int[] asteroid_belts;
	
	public int[] getAsteroid_belts() {
		return asteroid_belts;
	}

	public void setAsteroid_belts(int[] asteroid_belts) {
		this.asteroid_belts = asteroid_belts;
	}

	public Planet() {
		
	}
	
	public int getPlanet_id() {
		return planet_id;
	}
	public void setPlanet_id(int planet_id) {
		this.planet_id = planet_id;
	}
	public int[] getMoons() {
		return moons;
	}
	public void setMoons(int[] moons) {
		this.moons = moons;
	}

	@Override
	public String toString() {
		return "Planet [planet_id=" + planet_id + ", moons=" + Arrays.toString(moons) + ", asteroid_belts="
				+ Arrays.toString(asteroid_belts) + "]";
	}
	
}
