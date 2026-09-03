# 🚗 Instant Mechanic

Instant Mechanic is an Android application designed to make it easier for users to find mechanics and request vehicle repair and maintenance services.

The application provides a simple and user-friendly interface where users can browse available services, explore mechanic details, select a required service, and submit a service request.

---

## 📱 Project Resources

### 📱 Android Application

This repository contains the Android application source code.

👉 **GitHub Repository:**  
https://github.com/ArghaGhosh1/Instant-Mechanic

### ⚙️ Backend

The backend is developed separately using Spring Boot and provides the REST APIs required by the Android application.

👉 **Backend Repository:**  
[View Backend GitHub Repository](YOUR_BACKEND_GITHUB_LINK)

### 🎥 Demo Video

A short demo video demonstrating the main application flow is available here:

👉 **[▶️ Watch Instant Mechanic Demo](YOUR_DEMO_VIDEO_LINK)**

---

# 📌 Project Overview

Finding a reliable mechanic and requesting vehicle services can be inconvenient. Instant Mechanic aims to simplify this process through a mobile application.

Users can:

- Browse available mechanics
- Explore vehicle services
- Filter services
- View mechanic details
- Select a required service
- Submit a service request
- View request confirmation

The Android application communicates with the backend through REST APIs using Retrofit.

---

# ✨ Features

## 👨‍🔧 Mechanic Discovery

- Browse available mechanics
- View mechanic-related information
- Explore available services

## 🔍 Service Filtering

- Filter services according to user requirements
- Easily find the required vehicle service

## 📋 Mechanic Details

- View detailed mechanic information
- View services offered by the mechanic
- Proceed to service booking

## 📅 Book a Service

- Select a required service
- Submit a service request
- Navigate through the booking flow

## ✅ Request Confirmation

- Displays confirmation after successfully submitting a service request
- Provides a clear indication that the request has been completed

## 🎨 Modern User Interface

- Built using Jetpack Compose
- Clean and modern UI
- Reusable Compose components
- Responsive layouts
- Simple navigation between screens

---

# 🛠️ Technology Stack

## 📱 Android

| Technology | Usage |
|---|---|
| Kotlin | Application development |
| Jetpack Compose | UI development |
| MVVM | Application architecture |
| ViewModel | UI state and business logic |
| Retrofit | REST API communication |
| Gson | JSON parsing |
| Jetpack Compose Navigation | Screen navigation |
| Gradle Kotlin DSL | Build configuration |

## ⚙️ Backend

| Technology | Usage |
|---|---|
| Java | Backend development |
| Spring Boot | REST API development |
| REST API | Client-server communication |
| JSON | Data exchange |

---

# 🏗️ Architecture

The Android application follows the **MVVM (Model-View-ViewModel)** architecture.

```text
                    ┌─────────────────────┐
                    │     UI Layer        │
                    │                     │
                    │  Jetpack Compose    │
                    │                     │
                    │  Home Screen        │
                    │  Details Screen      │
                    │  Booking Screen     │
                    │  Confirmation       │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │     ViewModel       │
                    │                     │
                    │  UI State           │
                    │  Business Logic     │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │     Repository      │
                    │                     │
                    │  Data Management    │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │      Retrofit       │
                    │                     │
                    │     REST Client     │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │       Backend       │
                    │                     │
                    │    Spring Boot      │
                    │      REST API       │
                    └─────────────────────┘
