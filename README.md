# 🌧️ SG Weather API (Spring Boot)

A simple backend application built with Spring Boot that fetches real-time rainfall data from Singapore’s public data API and exposes it through clean REST endpoints.

---

## 🚀 Features

* Fetch real-time rainfall data from external API
* Expose REST endpoints for client consumption
* Simple and clean project structure
* Designed for extension (filtering, caching, frontend integration)

---

## 🧱 Tech Stack

* Java 25+
* Spring Boot 4.0+
* Spring Web
* Spring Data JPA (for future DB integration)
* H2 Database (initial setup)
* Gradle

---

## 📂 Project Structure

```
src/main/java/com/example/demo/
│
├── controller/    # REST controllers
├── service/       # Business logic
├── model/         # Data models / DTOs
├── repository/    # Database layer (future use)
```

---

## ▶️ Getting Started

TBC

---

## 🌐 API Endpoints

### Get rainfall data

```
GET /weather/rainfall
```

### Example response (raw)

```json
{
  "items": [
    {
      "timestamp": "2026-04-05T10:00:00+08:00",
      "readings": [
        { "station_id": "S107", "value": 0 },
        { "station_id": "S109", "value": 0.2 }
      ]
    }
  ]
}
```

---

## 🔄 Future Improvements

* Parse and transform API response into cleaner DTOs
* Map station IDs to human-readable locations
* Add filtering (e.g. nearest location)
* Integrate PostgreSQL database
* Add caching for API responses
* Add authentication (JWT)
* Build frontend dashboard (React)

---

## 🧪 Testing

* Use Postman or browser:

```
http://localhost:8080/weather/rainfall
```

---

## 🧠 Learning Goals

This project demonstrates:

* REST API development
* External API integration
* JSON parsing and transformation
* Backend architecture fundamentals

---

## 📌 Notes

* This project is for learning and portfolio purposes
* External API is publicly available and may have rate limits

---

## ✨ Author

Built as part of backend and interview preparation.
