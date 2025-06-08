package com.edukid.backend.service;

import com.edukid.backend.model.News;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    private final Firestore db;

    public NewsService() {
        this.db = FirestoreClient.getFirestore();
    }

    public List<News> getAllNews() throws Exception {
        List<News> newsList = new ArrayList<>();
        ApiFuture<QuerySnapshot> future = db.collection("news").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot doc : documents) {
            News news = doc.toObject(News.class);
            newsList.add(news);
        }

        return newsList;
    }
}