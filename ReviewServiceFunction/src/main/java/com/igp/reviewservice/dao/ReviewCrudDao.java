package com.igp.reviewservice.dao;

import com.igp.reviewservice.model.Review;

public interface ReviewCrudDao {
    Review createReview(Review review);
    Review readReview(String reviewId);
    Review updateReview(Review review);
    void deleteReview(String reviewId);
}