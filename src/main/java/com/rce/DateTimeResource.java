package com.rce;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Optional;

@Path("hello")
public class DateTimeResource {

    @ConfigProperty(name = "config")
    private Optional<String> config;

    @RestClient
    DateTimeService dateTimeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello, " + config.orElse("Sem config") + ": " +
                dateTimeService.getNow().getDatetime() + " ";
    }
}
