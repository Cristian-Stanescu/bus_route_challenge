package com.busroutes.direct;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"dep_sid", "arr_sid", "direct_bus_route"})
public class DirectBusRouteResponse {
	private int dep_sid;
	private int arr_sid;
	private boolean direct_bus_route;

	public DirectBusRouteResponse() {
	}

	public DirectBusRouteResponse(int dep_sid, int arr_sid, boolean direct_bus_route) {
		super();
		this.dep_sid = dep_sid;
		this.arr_sid = arr_sid;
		this.direct_bus_route = direct_bus_route;
	}

	@XmlElement
	public int getDep_sid() {
		return dep_sid;
	}

	public void setDep_sid(int dep_sid) {
		this.dep_sid = dep_sid;
	}

	@XmlElement
	public int getArr_sid() {
		return arr_sid;
	}

	public void setArr_sid(int arr_sid) {
		this.arr_sid = arr_sid;
	}

	@XmlElement
	public boolean isDirect_bus_route() {
		return direct_bus_route;
	}

	public void setDirect_bus_route(boolean direct_bus_route) {
		this.direct_bus_route = direct_bus_route;
	}
}