
---

# 🎬 Book My Show - Java Console Application

## 📌 Project Overview

This project is a **Java-based console application** that mimics the core functionalities of a basic **movie ticket booking system** similar to *Book My Show*. It's built using **OOP principles**, and uses **HashMap** and **ArrayList** for efficient data handling along with **POJO classes** to structure entities like movies, users, and bookings.

The application provides a simple terminal-based interface to explore, select, and book movie tickets.

---

## ✨ Features

* 🎥 View Available Movies and Showtimes
* 🪑 Select Seats for a Show
* 👤 User Registration & Login
* 🎟️ Book Tickets and Get Booking Details
* 📜 View All Bookings by User
* 🗑️ Cancel Bookings
* 🛠️ Admin Panel

  * ➕ Add/Remove Movies
  * 📊 View All Bookings

---

## 🧠 Technologies Used

* **Java (Core)**
* **HashMap** – For mapping showtimes, users, and movie data
* **ArrayList** – To maintain bookings, movie lists, and seat allocations
* **POJO Classes** – Clean data modeling using plain Java objects (`Movie`, `User`, `Booking`, `Seat`, etc.)

---

## 🗂️ Project Structure

```plaintext
|-- Movie.java         // POJO class for movie details
|-- User.java          // POJO class for user information
|-- Booking.java       // POJO class for bookings
|-- Show.java          // Contains showtime and seat management
|-- AdminAction.java   // Admin operations
|-- UserAction.java    // User interactions and booking logic
|-- BookMyShow.java    // Main class with menu-driven execution
```

---

## 🚀 Getting Started

### ✅ Prerequisites

* Java JDK 11+
* Command-line terminal
* Git (for cloning the repo)

### 📥 Setup & Run

```bash
git clone https://github.com/mithun1018/Java-Console-BookMyShow
cd Java-Console-BookMyShow
javac BookMyShow.java
java BookMyShow
```

---

## 📸 Console Demo


https://github.com/user-attachments/assets/7ce09c61-e435-4426-aefb-f9e5550dd5c2




## 📸 Class Structure
![Screenshot 2025-04-22 224308](https://github.com/user-attachments/assets/c1dfda26-8076-4dc6-8513-0fcc0d2ca0d7)


## 🔮 Future Enhancements

* [ ] Integrate **file/database** storage for persistent data
* [ ] Build a **GUI using Java Swing or JavaFX**
* [ ] Implement **payment simulation** for booking confirmation
* [ ] Add **seat map visualizations** in the terminal

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork the repo, create a new branch, and submit a pull request for any improvements or new features.

---


