package com.igp.reviewservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.reviewservice.model.Examples;
import com.igp.reviewservice.model.Review;
import com.igp.reviewservice.util.ResponseEntity;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Override
    public ResponseEntity<List<Review>> getReviewsByOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(List.of(Examples.EXAMPLE_REVIEW));
    }

    @Override
    public ResponseEntity<List<Review>> getReviewsByCreator(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(List.of(Examples.EXAMPLE_REVIEW));
    }

    @Override
    public ResponseEntity<Review> updateReview(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_REVIEW);
    }

    @Override
    public ResponseEntity<Review> deleteReview(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_REVIEW);
    }

    @Override
    public ResponseEntity<Review> createReview(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_REVIEW);
    }
}
