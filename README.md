

---

````markdown
# 🔐 Smart Password Manager with AI 🔐

A secure, full-featured password manager built with **Java**, **Spring Boot**, **MySQL**, and optional **AI-powered password suggestions** using **local logic** or the **OpenAI API**.

> ✅ Inspired by real-world password managers like LastPass & 1Password — built for learning, practicing, and showcasing backend skills.

---

## 📸 Demo

![demo](https://user-images.githubusercontent.com/your-demo.gif) <!-- optional demo GIF -->

---

## ✨ Features

- 🔐 User Registration & Login (JWT-based)
- 🧠 AI Password Suggestions (via Local Logic or OpenAI)
- 🔒 Save, retrieve, and delete passwords securely
- 🔑 AES Encryption & Decryption
- 🔎 Search by website/username (optional)
- ✅ Tested with Postman

---

## ⚙️ Tech Stack

| Tech             | Description                         |
|------------------|-------------------------------------|
| Java 17+         | Programming language                |
| Spring Boot 3+   | Backend Framework                   |
| Spring Security  | Authentication + Authorization      |
| MySQL            | Relational database                 |
| JPA/Hibernate    | ORM for database access             |
| JWT              | Token-based Authentication          |
| AES              | Password encryption logic           |
| OpenAI API       | (Optional) Generate secure passwords|
| Postman          | API testing                         |

---

## 🚀 Getting Started

### 📦 Clone the Repository

```bash
git clone https://github.com/yourusername/smart-password-manager.git
cd smart-password-manager
````

### 🧠 Reset to the latest code (if needed)

```bash
git reset --hard origin/main
```

### 🧱 MySQL Setup

```sql
CREATE DATABASE smartpass_db;
```

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smartpass_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

### 🔧 Run the App

```bash
./mvnw spring-boot:run
```

Or via IntelliJ: Run `PasswordManagerApplication.java`

---

### 📮 API Testing with Postman

| Endpoint                                    | Method | Auth Required | Description                         |
| ------------------------------------------- | ------ | ------------- | ----------------------------------- |
| `/api/auth/signup`                          | POST   | ❌             | Register a new user                 |
| `/api/auth/login`                           | POST   | ❌             | Login and get JWT                   |
| `/api/passwords`                            | POST   | ✅             | Save a new password                 |
| `/api/passwords`                            | GET    | ✅             | Get all saved passwords             |
| `/api/passwords/suggest`                    | GET    | ✅             | Generate secure password (local AI) |
| `/api/passwords/suggest-ai?purpose=banking` | GET    | ✅             | Generate password (via OpenAI)      |

---

## 💡 AI-Powered Suggestions

### ✅ Option 1: Local AI Logic

* Generates random strong passwords using letters, symbols, and digits.
* Fast, offline, customizable.

### ✅ Option 2: OpenAI API

* Prompts GPT to suggest strong passwords.
* Add this to `application.properties`:

```properties
openai.api.key=your-openai-key
```

---

## 📁 Project Structure

```
src/
├── config             # Security, JWT setup
├── controller         # REST APIs
├── dto               # Request/Response DTOs
├── model             # User & PasswordEntry entities
├── repository        # Spring Data JPA Repos
├── service           # AuthService, OpenAI (if used)
├── utils             # Encryption, JWT, Password Generator
└── PasswordManagerApplication.java
```

---

## 📷 Screenshots

> Add screenshots of:

* Signup/Login
* Save/Fetch password
* AI password generation

---

## 🔒 Security Note

> ⚠️ For demo/educational use only.
> Always store production secrets in secure vaults (not in `.properties`).

---

## 📌 Future Improvements

* [ ] Frontend UI (React or Angular)
* [ ] Password expiry notifications
* [ ] 2FA/MFA login support
* [ ] Browser extension

---

## ❤️ Credits

Built with 💻 by [Prakhar Tripathi](https://github.com/gurawliprakhar)

---

## 🧠 License

MIT License. Feel free to fork, use, or improve.

```

---


```
