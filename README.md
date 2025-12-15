# Airport Flight Management System

## 1. Project Overview
For this project, I chose the topic of an **Airport Flight Management System**. There are 4 entity sets: **Airport, Flight, Seat, and Customer**.

The front-end was implemented using **JavaScript & HTML** and the back-end was implemented using **Java Spring Boot** with **MySQL** for the database.

The application allows users to:
* View, Add, Edit, and Delete Airports.
* View Flights departing from specific airports.
* Manage Seats on a flight and assign Passengers.
* Manage Customer information.

## 2. Configuration (.env)
This project uses a `.env` file to manage database credentials securely. This file is not included in the source code (it is git-ignored).

**You must create this file manually to run the project.**

1.  Create a file named `.env` in the of the project.
2.  Add the following lines to the file, replacing the values with your local MySQL configuration:

```properties
DB_URL=jdbc:mysql://localhost:3306/flight_system
DB_USER=root
DB_PASS=password
```

## 3. How to Run the Project

Please follow these steps in order to start the application successfully.

### Step 1: Initialize the Database
Before running the Java code, the database schema must exist in your MySQL server.

1.  Start **MySQL Workbench**.
2.  Open a new query tab and run the following command:

```sql
CREATE DATABASE flight_system;
```

### Step 2: Run the Backend

1. Open the project.
2. Locate the file FlightSystemApplication.java.
3. Run the file.
4. Go to http://localhost:8080.