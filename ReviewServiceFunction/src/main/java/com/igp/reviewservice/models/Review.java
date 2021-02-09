package com.igp.reviewservice.models;

import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

public class Review {

    @SerializedName("review_id")
    private int reviewId;

    @SerializedName("event_id")
    private String eventId;

    private int rating;

    private String description;

    @SerializedName("creation_date")
    private DateTime creationDate;

    @SerializedName("last_modification_date")
    private DateTime lastModificationDate;

    public Review(int reviewId, String eventId, int rating, String description, DateTime creationDate, DateTime lastModificationDate) {
        this.reviewId = reviewId;
        this.eventId = eventId;
        this.rating = rating;
        this.description = description;
        this.creationDate = creationDate;
        this.lastModificationDate = lastModificationDate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public DateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(DateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }
}
