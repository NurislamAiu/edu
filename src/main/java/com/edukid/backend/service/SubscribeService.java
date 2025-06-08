package com.edukid.backend.service;

import com.edukid.backend.model.Subscriber;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {

    public void savePhone(Subscriber subscriber) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("subscribers").add(subscriber);
    }
}