🌱 Community Garden Management System

A Java console-based application for managing community garden operations such as registering gardeners, allocating plots, and tracking maintenance tasks. The application uses Hibernate ORM for database persistence and follows a clean layered architecture.

📌 Project Overview

This Community Garden Management System allows administrators to:

➕ Register new gardeners

📋 View all gardeners or specific gardener by ID

🌿 Allocate plots for gardening with start and end dates

🔍 Track maintenance tasks for plots (watering, weeding, etc.)

⚠️ Prevent overlapping plot allocations and handle validation errors

The application follows a layered architecture:

Entity Layer – Represents database tables (Gardener, PlotTaskRow)

DAO Layer – Handles database interactions via Hibernate (GardenerDAO, PlotTaskDAO)

Service Layer – Contains business logic and validation (GardenService)

Application Layer – Main console interface (GardenMain)

Utility Layer – Hibernate configuration and custom exceptions (HibernateUtil, ValidationException, PlotAllocationConflictException)

🧩 Technologies Used

Java SE 1.8

Hibernate ORM

Oracle Database (configurable via hibernate.cfg.xml)

Maven for dependency management

Console-based UI

🔄 Application Flow

User runs the GardenMain console application

Menu options allow:

Register gardener

View gardeners

Update or delete gardener

Allocate plot or assign maintenance tasks

Input is validated by the Service Layer

DAO layer performs database operations via Hibernate

System prevents overlapping allocations using PlotTaskDAO.findOverlappingAllocation

Results and confirmations are displayed in the console

⚙️ Setup Instructions

1️⃣ Prerequisites

JDK 8 or above

Oracle Database (or any RDBMS supported by Hibernate)

Maven

2️⃣ Steps to Run

Clone the repository:

git clone <repository_url>

cd Hibernate

Configure your database connection in hibernate.cfg.xml:

<property name="hibernate.connection.url">jdbc:oracle:thin:@localhost:1521:xe</property>
<property name="hibernate.connection.username">system</property>
<property name="hibernate.connection.password">system</property>

Build the project with Maven:

mvn clean install

Run the console application:

java -cp target/Hibernate-1.0-SNAPSHOT.jar com.kce.app.GardenMain

Follow the console menu to manage gardeners, allocate plots, and track tasks.

🚀 Features

Console-based interactive menu

Auto-generated ROW_ID for plots using Hibernate sequence

Overlapping allocation check with custom exceptions

Track task type, date, notes, and status

Layered design for clean separation of concerns

Scalable structure for future web or desktop UI

👨‍💻 Author

Developed as part of Java Hibernate practice project for learning ORM, DAO design, and console-based application management.

Output:

<img width="1108" height="588" alt="Screenshot 2026-02-20 010109" src="https://github.com/user-attachments/assets/b807e380-f22a-4473-8162-fc90cce9d0a8" />

<img width="865" height="569" alt="Screenshot 2026-02-20 010149" src="https://github.com/user-attachments/assets/4a146ae8-1014-4983-98b0-8f7b677697e6" />

<img width="1436" height="591" alt="Screenshot 2026-02-20 005253" src="https://github.com/user-attachments/assets/759a39b2-d64a-48ef-a66d-e053a4b13f2f" />

<img width="1768" height="796" alt="Screenshot 2026-02-20 005406" src="https://github.com/user-attachments/assets/7ceb605f-9770-4583-984e-90069dfeb123" />

<img width="1660" height="773" alt="Screenshot 2026-02-20 005339" src="https://github.com/user-attachments/assets/c01382a0-2f8a-43a3-8911-a9c4c072b90a" />







