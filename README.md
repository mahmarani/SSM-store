# 🛒 SSM Store — Tech E-Commerce Application

A Java-based desktop e-commerce application for buying and selling the latest technology products. SSM Store lets users browse, add to cart, and purchase tech items through a clean and intuitive GUI built with Java Swing.

---

## 📖 About the Project

SSM Store is an easy-to-use desktop e-commerce platform focused on the latest technology products — from gadgets to computer accessories. The store is designed to make shopping simple and fast, with clear product listings and a quick checkout flow.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Frontend | Java Swing + IntelliJ UI Designer |
| Backend | Java (OOP) |
| Database | MySQL |
| DB Connectivity | JDBC |

---

## 🧠 OOP Concepts Used

- **Exception Handling** — Input validation and error management
- **Interfaces** — Abstraction and contract-based design
- **Packages** — Organized modular code structure

---

## ✨ Features

### 🔐 Sign Up
- Register a new account with Name, Email & Password
- Validates that the email contains `@` and password is at least 6 characters
- New accounts are saved directly to the MySQL database

### 🔑 Log In
- Authenticate with registered credentials
- Credentials are verified against the database
- Shows an **Invalid Credentials** message on failed attempts

### 🏠 Home Page
- Displays **5 tech product categories** in the left sidebar
- Shows commonly purchased products at the center (across all categories)
- Top navigation includes **Cart** and **Logout** options

### 🛍️ Product Actions
Each product supports two actions:
- **Add to Cart** — Adds the product to your shopping cart
- **Buy Now** — Takes you directly to the checkout page

### 🧾 Checkout
- Enter a delivery address
- Review the total amount
- Confirm to place the order successfully

### 🚪 Logout
- Prompts a confirmation dialog
- Redirects back to the Login page on confirmation

---

## 🗂️ Project Structure

```
SSMStore/
├── src/
│   ├── signup/         # Sign up page & validation logic
│   ├── login/          # Login page & authentication
│   ├── home/           # Home page with product categories
│   ├── cart/           # Cart management
│   ├── checkout/       # Checkout & order placement
│   └── db/             # JDBC database connection
├── resources/          # Product images & assets
└── README.md
```

---

## ⚙️ Getting Started

### Prerequisites

- Java JDK 8 or higher
- MySQL Server
- IntelliJ IDEA (recommended)
- MySQL JDBC Driver (`mysql-connector-java`)

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/ssm-store.git
   cd ssm-store
   ```

2. **Set up the database**
   - Create a MySQL database (e.g., `ssm_store`)
   - Import the provided SQL schema file
   - Update the DB credentials in the JDBC connection file

3. **Add the JDBC driver**
   - Download `mysql-connector-java.jar`
   - Add it to your project's classpath in IntelliJ

4. **Run the application**
   - Open the project in IntelliJ IDEA
   - Run the `Main` class (or the `SignUp` entry point)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
