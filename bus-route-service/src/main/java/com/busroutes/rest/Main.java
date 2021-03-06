package com.busroutes.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8088/api/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.busroutes.rest package
        final ResourceConfig rc = new ResourceConfig().packages("com.busroutes.direct", "com.fasterxml.jackson.jaxrs.json");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        final HttpServer server = startServer();
        if(args.length > 0) {
            try {
				BusRoutes.getInstance().initialize(args[0]);
		        System.out.println(String.format("Service started.\nHit enter to stop it..."));
		        System.in.read();
			} catch (IOException e) {
		        System.out.println("Error reading routes file: " + e.getMessage());
		        server.shutdown();
			}
        } else {
	        System.out.println("Please specify location of routes file.");
        }
        server.shutdown();
    }
}

