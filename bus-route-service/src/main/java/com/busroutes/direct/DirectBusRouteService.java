package com.busroutes.direct;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.busroutes.rest.BusRoutes;

/**
 * Root resource (exposed at "direct" path)
 */
@Path("direct")
public class DirectBusRouteService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as JSON media type.
     *
     * @return String that will be returned as a JSON object.
     */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public DirectBusRouteResponse method(@QueryParam("dep_sid") int dep_sid, @QueryParam("arr_sid") int arr_sid) {
		DirectBusRouteResponse response = new DirectBusRouteResponse();
		response.setDep_sid(dep_sid);
		response.setArr_sid(arr_sid);
		response.setDirect_bus_route(BusRoutes.getInstance().isDirectRoute(dep_sid, arr_sid));
		return response;
	}
}
