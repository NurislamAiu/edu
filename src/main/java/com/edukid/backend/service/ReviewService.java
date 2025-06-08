package com.edukid.backend.service;

import com.edukid.backend.model.Review;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ReviewService {

    public List<Review> getAllReviews() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("reviews").get();

        List<Review> reviews = new ArrayList<>();
        for (QueryDocumentSnapshot doc : future.get().getDocuments()) {
            reviews.add(doc.toObject(Review.class));
        }

        return reviews;
    }
}