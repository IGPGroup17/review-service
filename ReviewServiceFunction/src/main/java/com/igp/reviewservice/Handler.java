package com.igp.reviewservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.igp.reviewservice.services.ReviewService;
import com.igp.reviewservice.services.ReviewServiceImpl;
import com.igp.reviewservice.util.EnvironmentLogger;
import com.igp.reviewservice.util.ResponseEntity;
import com.igp.reviewservice.util.pattern.PatternMatcher;

/**
 * Handler for requests to Lambda function.
 */
public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {


    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        EnvironmentLogger.log(event, context);
        return routeRequest(event, context, new ReviewServiceImpl()).toApiGatewayProxyResponseEvent();
    }

    private ResponseEntity<?> routeRequest(APIGatewayProxyRequestEvent event, Context context, ReviewService service) {

        return new PatternMatcher<String, ResponseEntity<?>>()
                .defineCase(
                        "/v1/reviews/organiser/{id}", service.getReviewsByOrganiser(event, context),
                        () -> event.getHttpMethod().equals("GET"))

                .defineCase(
                        "/v1/reviews/creator/{id}", service.getReviewsByCreator(event, context),
                        () -> event.getHttpMethod().equals("GET"))

                .defineCase(
                        "/v1/reviews/delete/{id}", service.deleteReview(event, context),
                        () -> event.getHttpMethod().equals("DELETE"))

                .defineCase(
                        "/v1/reviews/create", service.createReview(event, context),
                        () -> event.getHttpMethod().equals("POST"))

                .defineCase(
                        "/v1/reviews/update/{id}", service.updateReview(event, context),
                        () -> event.getHttpMethod().equals("POST"))

                .defaultCase(ResponseEntity.notFound())

                .match(event.getResource());
    }
}
