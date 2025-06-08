package com.edukid.backend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;

@Component
public class FirebaseInitializer {

    @PostConstruct
    public void init() {
        try {
            // ✅ Используем путь, в который Render кладёт secret-файлы
            FileInputStream serviceAccount = new FileInputStream("/etc/secrets/firebase-key.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("✅ Firebase initialized!");
        } catch (IOException e) {
            System.err.println("❌ Firebase initialization failed:");
            e.printStackTrace();
        }
    }
}