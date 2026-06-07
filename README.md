# Eternal Care: Funeral Home Management System

A Java-based console application developed for **IT112 - Computer Programming 1**
at **Davao del Norte State College**, BSIT 1D.

---

## 👥 Developers
- Gabriel Benedict Lauron
- Kylle Vincent Coliano
- Lander Ace Tuquib
- Alfredo Soco

**Presented to:** Jerson M. Viagedor
**Date:** December 18, 2024

---

## 📋 Description

Eternal Care is a Funeral Home Management System that provides a platform for
families and individuals to avail funeral services and products, while allowing
staff to manage inventory and client records efficiently.

---

## ✨ Features

### 👤 Customer
- Browse available services and products
- Select preferred services and products
- Submit personal information via digital form
- View pricing details and total costs

### 👷 Employee *(Password: `employee123`)*
- Update service and product names/prices
- Approve pending client request forms
- View approved forms
- Check inventory

### 🔧 Admin *(Password: `admin123`)*
- Create new services and products
- Delete existing services and products
- Update service and product names/prices
- Approve pending client request forms
- View approved forms
- Check inventory

---

## 🚀 How to Run

### Requirements
- Java JDK 8 or higher
- Any IDE (VS Code with Java Extension Pack, IntelliJ IDEA, NetBeans) or terminal

### Option 1: VS Code
1. Install the **Extension Pack for Java** from the VS Code marketplace
2. Open the project folder in VS Code
3. Place `FinalFuneral.java` inside:
   ```
   src/main/java/com/mycompany/finalfuneral/
   ```
4. Open the file and click **Run** above the `main` method

### Option 2: Terminal / Command Line
```bash
# Compile
javac FinalFuneral.java

# Run
java com.mycompany.finalfuneral.FinalFuneral
```

### Option 3: NetBeans (original environment)
1. Create a new Java project named `finalfuneral`
2. Replace the default main class with `FinalFuneral.java`
3. Run the project

---

## 🗂️ Project Structure

```
finalfuneral/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── mycompany/
│                   └── finalfuneral/
│                       └── FinalFuneral.java
└── README.md
```

---

## 📌 Notes
- All data is stored in-memory (ArrayLists) and resets when the program exits
- Passwords are hardcoded for demo purposes: `employee123` and `admin123`
- Built with pure Java standard library — no external dependencies required
