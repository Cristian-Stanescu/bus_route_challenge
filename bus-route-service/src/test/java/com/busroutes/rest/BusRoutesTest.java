package com.busroutes.rest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class BusRoutesTest {

    private BusRoutes busRoutes = BusRoutes.getInstance();

    /**
     * Test correctness of direct route check for two consecutive stations on the same route
     * @throws IOException 
     */
    @Test
    public void testDirectRouteConsecutiveStationsSameRoute() throws IOException {
    	busRoutes.initialize(null);
    	busRoutes.readRoute("0 0 1 2");
        assertEquals(true, busRoutes.isDirectRoute(0, 1));
        assertEquals(true, busRoutes.isDirectRoute(1, 0));
        assertEquals(true, busRoutes.isDirectRoute(2, 1));
    }
    
    /**
     * Test correctness of direct route check for two non-consecutive stations on the same route
     * @throws IOException 
     */
    @Test
    public void testDirectRouteNonConsecutiveStationsSameRoute() throws IOException {
    	busRoutes.initialize(null);
    	busRoutes.readRoute("0 0 1 2 3");
        assertEquals(true, busRoutes.isDirectRoute(0, 3));
        assertEquals(true, busRoutes.isDirectRoute(1, 3));
        assertEquals(true, busRoutes.isDirectRoute(0, 2));
    }
    
    /**
     * Test correctness of direct route check for two stations on different routes
     * @throws IOException 
     */
    @Test
    public void testDirectRouteStationsDifferentRoutes() throws IOException {
    	busRoutes.initialize(null);
    	busRoutes.readRoute("0 0 1 2 3");
    	busRoutes.readRoute("1 0 4 5");
        assertEquals(false, busRoutes.isDirectRoute(1, 4));
        assertEquals(false, busRoutes.isDirectRoute(2, 5));
        assertEquals(false, busRoutes.isDirectRoute(4, 3));
    }
}
