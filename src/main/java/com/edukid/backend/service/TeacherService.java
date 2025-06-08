package com.edukid.backend.service;

import com.edukid.backend.model.Teacher;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class TeacherService {

    public List<Teacher> getAllTeachers() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("teachers").get();

        List<QueryDocumentSnapshot> docs = future.get().getDocuments();
        List<Teacher> teachers = new ArrayList<>();

        for (QueryDocumentSnapshot doc : docs) {
            teachers.add(doc.toObject(Teacher.class));
        }

        return teachers;
    }
}