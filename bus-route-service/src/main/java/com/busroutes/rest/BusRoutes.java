package com.busroutes.rest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class BusRoutes {

	private static BusRoutes instance = null;

	private static HashMap<Integer, LinkedList<Integer>> routes = new HashMap<Integer, LinkedList<Integer>>();

	protected BusRoutes() {
	}

	public static BusRoutes getInstance() {
		if (instance == null) {
			instance = new BusRoutes();
		}
		return instance;
	}

    /**
     * Initialize routes data structure from file at filePath
     * 
     */	
	public void initialize(String filePath) throws IOException {
		routes = new HashMap<Integer, LinkedList<Integer>>();

		if (filePath != null) {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			int nrRoutes = Integer.parseInt(line);

			for (int i = 0; i < nrRoutes; i++) {
				line = br.readLine();
				readRoute(line);
			}
			br.close();
		}
	}

    /**
     * Read a route from a string a add it into the routes data structure
     * 
     */	
	protected void readRoute(String line) {
		String[] ids = line.split(" ");
		Integer routeId = Integer.parseInt(ids[0]);
		LinkedList<Integer> busStopIds = new LinkedList<Integer>();
		for (int i = 1; i < ids.length; i++) {
			busStopIds.add(Integer.parseInt(ids[i]));
		}
		routes.put(routeId, busStopIds);
	}

    /**
     * Check if two stations given by their ids are directly connected by a route
     * @param dep_sid ID of departure station
     * @param arr_sid ID of arrival station 
     * @return true if a route contains both stations
     */	
	public boolean isDirectRoute(Integer dep_sid, Integer arr_sid) {
		boolean directRouteExists = false;
		for (LinkedList<Integer> route : routes.values()) {
			if (route.contains(dep_sid) && route.contains(arr_sid)) {
				directRouteExists = true;
				break;
			}
		}
		return directRouteExists;
	}

}
