package com.rce;

import com.sun.source.tree.ReturnTree;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    DateTimeService dateTimeService;

    @Override
    public HealthCheckResponse call() {
        if (dateTimeService.getNow().getDatetime() == null) {
            return HealthCheckResponse.down("Not is done");
        }
        else {
            return HealthCheckResponse.up("Ok");
        }
    }
}
