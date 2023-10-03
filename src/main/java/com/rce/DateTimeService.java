package com.rce;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://worldtimeapi.org/api/ip")
public interface DateTimeService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "fallback")
    public Now getNow();

    default Now fallback(){
        return new Now("Parou de responder");
    }

}
