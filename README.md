# QResto – Desktop App 

### Overview  
QResto Desktop App is the **admin and faculty-side JavaFX application** of the QResto Attendance System.  
It allows **administrators** to manage users and **faculty members** to generate unique QR codes for marking attendance.  
This desktop interface connects directly to the backend REST API (Spring Boot + MongoDB).

---

### Features
-  **Admin Login** using secure DB password  
-  **Faculty Login** with individual credentials  
-  **Add Students / Faculty** to the MongoDB database  
-  **Generate QR Codes** based on Course Name and Code  
-  **Connected to Cloud Backend** via REST API (OkHttp client)  
-  Built using **JavaFX + SceneBuilder UI**

---

###  Tech Stack
| Layer | Technology |
|-------|-------------|
| Frontend | JavaFX, SceneBuilder |
| Networking | OkHttp (REST API Client) |
| Backend API | Spring Boot (Deployed on Railway) |
| Database | MongoDB Atlas |
| Build Tool | Maven |

---

###  Architecture Flow
Frontend Apps (JavaFX + Android)
↓
REST API (Spring Boot)
↓
MongoDB Atlas Cloud Database

---

###  Project Structure
Admin Login → Add Student/Faculty → Data Sent via API → Stored in MongoDB
Faculty Login → Generate QR → Display on Screen → Student Scans via Android App

---


