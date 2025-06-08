package com.edukid.backend.service;

import com.edukid.backend.model.Banner;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class BannerService {

    public Banner getBanner() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentSnapshot snapshot = db.collection("banners")
                .document("main-banner")
                .get()
                .get();

        if (snapshot.exists()) {
            String ru = snapshot.getString("ru");
            return new Banner(ru);
        }

        // fallback если нет данных в Firebase
        return new Banner("🎉 Приём заявок 20–24 апреля! 🎉");
    }
}