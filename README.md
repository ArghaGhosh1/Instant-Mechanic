# 🔧 Instant Mechanic

Instant Mechanic is an Android application that helps users discover nearby mechanics/garages, view their services and details, and submit a service request.

The application is built using **Kotlin and Jetpack Compose** for the Android frontend and **Spring Boot with MongoDB** for the backend.

---

## 📱 Features

### 🏠 Home Screen
- Displays available mechanics/garages.
- Shows:
  - Garage name
  - Rating
  - Distance
  - Location
  - Available services
  - Open/Closed status
- Search mechanics by:
  - Garage name
  - Location
  - Service
- Filter mechanics based on service category.

### 🔧 Mechanic Details
Users can view:
- Garage name
- Rating
- Address
- Available services
- Working hours
- Phone number
- Open/Closed status

### 📋 Book a Service
Users can submit a service request by providing:
- Customer name
- Phone number
- Vehicle number
- Selected service
- Problem description

### ✅ Request Confirmation
After submitting a service request, the user is shown a confirmation screen.

### 📞 Contact Mechanic
Users can use the Call button to open the device dialer with the mechanic's phone number.

### 🔎 Search & Filter
The application supports searching mechanics by garage name, location, and services.

Service filtering is also available through filter chips.

### 🧪 Unit Testing
JUnit tests have been added for the mechanic search functionality.

The current test suite covers:

- Search by garage name
- Search by location
- Search by service
- Empty search
- No matching results

All **5 unit tests pass successfully**.

---

# 🛠️ Tech Stack

## Android

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **MVVM-style architecture**
- **Retrofit**
- **Gson**
- **Kotlin Coroutines**
- **Navigation Compose**
- **JUnit**

## Backend

- **Java**
- **Spring Boot**
- **REST API**
- **MongoDB**
- **MongoDB Atlas**
- **GridFS** for mechanic image storage

---

# 🏗️ Architecture

The application follows an MVVM-inspired architecture with separation between UI, business logic, data access, and backend communication.

```text
                ┌──────────────────────┐
                │     Jetpack Compose  │
                │         UI           │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │     ViewModel        │
                │                      │
                │ UI State             │
                │ Loading/Error State  │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │     Repository       │
                │                      │
                │ Data access layer    │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │       Retrofit       │
                │      API Client      │
                └──────────┬───────────┘
                           │
                           │ HTTP/JSON
                           ▼
                ┌──────────────────────┐
                │    Spring Boot API   │
                │                      │
                │ REST Controllers     │
                │ Service Layer        │
                └──────────┬───────────┘
                           │
                           ▼
                ┌──────────────────────┐
                │      MongoDB         │
                │    MongoDB Atlas     │
                └──────────────────────┘
