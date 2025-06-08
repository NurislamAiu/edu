# Используем официальный образ JDK 17
FROM eclipse-temurin:17-jdk

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем всё в контейнер
COPY . .

# Собираем проект
RUN ./mvnw clean package -DskipTests

# Запускаем собранный jar
CMD ["java", "-jar", "target/edukid-0.0.1-SNAPSHOT.jar"]