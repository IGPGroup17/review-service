package com.igp.reviewservice.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.igp.reviewservice.config.DynamoDBConfig;
import com.igp.reviewservice.dao.ReviewCrudDao;
import com.igp.reviewservice.model.Review;

import java.util.HashMap;
import java.util.Map;

public class ReviewServiceDaoImpl implements ReviewCrudDao {
    private DynamoDBMapper dynamoDBMapper;

    public ReviewServiceDaoImpl() {
        this.dynamoDBMapper = DynamoDBConfig.dynamoDBMapper();
    }

    @Override
    public Review createReview(Review review) {
        dynamoDBMapper.save(review);
        return review;
    }

    @Override
    public Review readReview(String reviewId) {
        return dynamoDBMapper.load(Review.class, reviewId);
    }

    @Override
    public Review updateReview(Review review) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("reviewId", new ExpectedAttributeValue(new AttributeValue().withS(review.getReviewId())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        dynamoDBMapper.save(review, saveExpression);
        return review;
    }

    @Override
    public void deleteReview(String reviewId) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("reviewId", new ExpectedAttributeValue(new AttributeValue().withS(reviewId)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        Review review = Review.builder()
                .reviewId(reviewId)
                .build();
        dynamoDBMapper.delete(review, deleteExpression);
    }
}