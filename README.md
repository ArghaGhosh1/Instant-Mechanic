# 🚗 Instant Mechanic

Instant Mechanic is an Android application designed to help users find mechanics and request vehicle repair and maintenance services easily.

The application provides a simple and user-friendly interface where users can browse available services, explore mechanic details, select a required service, and submit a service request.

---

## 📱 Project Links

### 📱 Android Application

**GitHub Repository:**  
https://github.com/ArghaGhosh1/Instant-Mechanic

### ⚙️ Backend

The backend of the application is developed separately using Spring Boot and provides REST APIs for the Android application.

**Backend Repository:**  
[🔗 View Backend Repository](YOUR_BACKEND_GITHUB_LINK)

### 🎥 Demo Video

A complete demonstration of the application can be viewed below.

**▶️ [Watch Instant Mechanic Demo Video](YOUR_DEMO_VIDEO_LINK)**

---

# ✨ Features

- 🏠 Modern and user-friendly home screen
- 🔧 Browse available mechanics
- 🛠️ Browse different vehicle services
- 🔍 Filter services
- 👨‍🔧 View mechanic details
- 📅 Book/request a vehicle service
- ✅ Request confirmation screen
- 🔄 Navigation between different application screens
- 🌐 REST API integration with backend
- 📱 Responsive Jetpack Compose UI

---

# 🛠️ Technology Stack

## Android

- **Kotlin**
- **Jetpack Compose**
- **MVVM Architecture**
- **ViewModel**
- **Repository Pattern**
- **Retrofit**
- **Gson**
- **Jetpack Compose Navigation**
- **Gradle Kotlin DSL**

## Backend

- **Java**
- **Spring Boot**
- **REST API**
- **JSON**

---

# 🏗️ Architecture

The Android application follows the **MVVM (Model-View-ViewModel)** architecture.

```text
                 ┌─────────────────────┐
                 │      UI Layer       │
                 │                     │
                 │  Jetpack Compose    │
                 │                     │
                 │  Home Screen        │
                 │  Details Screen     │
                 │  Booking Screen     │
                 │  Confirmation       │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │     ViewModel       │
                 │                     │
                 │   UI State          │
                 │   Logic             │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │     Repository      │
                 │                     │
                 │   Data Management   │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │      Retrofit       │
                 │                     │
                 │    REST Client      │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │      Backend        │
                 │                     │
                 │    Spring Boot      │
                 │      REST API       │
                 └─────────────────────┘
