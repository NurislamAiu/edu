FROM eclipse-temurin:17-jdk-alpine

# Установка рабочей директории
WORKDIR /app

# Копирование JAR-файла
COPY target/*.jar app.jar

# 🔐 Копирование Firebase-ключа (убедись, что он рядом с Dockerfile)
COPY firebase-key.json /etc/secrets/firebase-key.json

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]