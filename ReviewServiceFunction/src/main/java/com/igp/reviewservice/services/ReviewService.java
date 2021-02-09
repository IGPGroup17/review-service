package com.igp.reviewservice.services;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.reviewservice.models.Review;
import com.igp.reviewservice.util.ResponseEntity;

import java.util.List;

public interface ReviewService {

    ResponseEntity<List<Review>> getReviewsByOrganiser(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<List<Review>> getReviewsByCreator(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Review> updateReview(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Review> deleteReview(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Review> createReview(APIGatewayProxyRequestEvent event, Context context);

}
