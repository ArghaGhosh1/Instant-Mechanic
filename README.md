# 🚗 Instant Mechanic

Instant Mechanic is an Android application that helps users find mechanics and book vehicle services easily. The application provides a simple and user-friendly interface for browsing available mechanics, viewing mechanic details, selecting services, and confirming service requests.

---

## 📱 Screenshots

The following screenshots demonstrate the main features and user flow of the application.

### 🏠 Home Screen

![Home Screen](https://github.com/ArghaGhosh1/Instant-Mechanic/blob/main/Screenshot%202026-09-03%20225216.png?raw=true)

The Home Screen allows users to browse available services and mechanics using the available categories and filters.

---

### 🔧 Mechanic Details

![Mechanic Details](screenshots/mechanic-details.png)

Displays detailed information about a selected mechanic and the services provided.

---

### 📅 Book a Service

![Book a Service](screenshots/book-service.png)

Users can select a service and proceed with the booking process.

---

### ✅ Request Confirmed

![Request Confirmed](screenshots/request-confirmed.png)

Displays the confirmation after successfully submitting a service request.

> **Note:** Replace the image paths above with the actual screenshot filenames you upload to the `screenshots/` folder.

---

# 📌 Project Overview

Instant Mechanic is designed to simplify the process of finding and requesting vehicle repair and maintenance services.

The application allows users to:

- Browse available mechanics
- Explore different vehicle services
- Filter services
- View mechanic details
- Select a required service
- Book/request a mechanic service
- Receive confirmation after submitting a request

---

# ✨ Features

### 👨‍🔧 Mechanic Discovery
- View available mechanics
- Browse mechanics through the home screen
- View mechanic-related information

### 🔍 Service Filtering
- Filter available services
- Select services based on user requirements

### 📋 Mechanic Details
- View detailed information about a mechanic
- View available services
- Navigate to the booking process

### 📅 Service Booking
- Select a required service
- Submit a service request
- Navigate through the booking flow

### ✅ Request Confirmation
- Displays confirmation after a successful service request

### 🎨 User Interface
- Modern Android UI
- Built using Jetpack Compose
- Responsive layouts
- Reusable UI components

---

# 🛠️ Technology Stack

## Android

- **Language:** Kotlin
- **UI:** Jetpack Compose
- **Architecture:** MVVM
- **Networking:** Retrofit
- **JSON Parsing:** Gson
- **State Management:** ViewModel
- **Navigation:** Jetpack Compose Navigation
- **Build System:** Gradle / Kotlin DSL

## Backend / API

The Android application communicates with a backend REST API to retrieve and manage mechanic/service data.

- REST API
- HTTP communication
- JSON-based data exchange

---

# 🏗️ Architecture

The application follows the **MVVM (Model-View-ViewModel)** architecture.

```text
                ┌─────────────────────┐
                │     UI / Compose    │
                │                     │
                │  Home Screen        │
                │  Details Screen     │
                │  Booking Screen     │
                └──────────┬──────────┘
                           │
                           ▼
                ┌─────────────────────┐
                │      ViewModel      │
                │                     │
                │  UI State           │
                │  Business Logic     │
                └──────────┬──────────┘
                           │
                           ▼
                ┌─────────────────────┐
                │     Repository      │
                │                     │
                │ Data Management     │
                └──────────┬──────────┘
                           │
                           ▼
                ┌─────────────────────┐
                │     Retrofit API    │
                │                     │
                │     REST API        │
                └──────────┬──────────┘
                           │
                           ▼
                ┌─────────────────────┐
                │       Backend       │
                │                     │
                │ Mechanic Data       │
                │ Service Data        │
                └─────────────────────┘
