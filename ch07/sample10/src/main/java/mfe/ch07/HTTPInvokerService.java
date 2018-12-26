package mfe.ch07;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.*;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.HashMap;
import java.util.Map;


public class HTTPInvokerService extends AbstractVerticle {

    private Map<String, JsonObject> products = new HashMap<>();

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.get("/invoker").handler(this::passthru);

        vertx.createHttpServer().requestHandler(router::accept).listen(9090);
    }


    private void passthru(RoutingContext routingContext) {
        HttpClientOptions options = new HttpClientOptions().setDefaultHost("localhost").setDefaultPort(8080);
        HttpClient client = vertx.createHttpClient(options);


        client.getNow("/products/100500", response -> {
            System.out.println("Received response with status code " + response.statusCode());
            HttpServerResponse serverResponse = routingContext.response();
            response.bodyHandler(buffer -> serverResponse.end(buffer.getString(0, buffer.length())));
        });



    }

    private void sendError(int statusCode, HttpServerResponse response) {
        response.setStatusCode(statusCode).end();
    }

}
