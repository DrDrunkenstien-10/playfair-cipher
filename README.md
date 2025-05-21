# 🔐 Playfair Cipher - Java Implementation

This project provides a simple implementation of the **Playfair Cipher** for both encryption and decryption of messages using a keyword. It is built using Java and organized as a Maven project.

---

## 📖 What is the Playfair Cipher?

The **Playfair Cipher** is a manual symmetric encryption technique and was the first digraph substitution cipher. Invented in 1854 by Charles Wheatstone and popularized by Lord Playfair, it encrypts pairs of letters (digraphs), offering more complexity than traditional monoalphabetic ciphers.

---

## 💡 Features

- Encrypt plaintext using a keyword
- Decrypt ciphertext back to the original message
- Structured as a Maven project
- Clean and modular Java classes for encryption and decryption
- Interactive command-line interface

---

## 🚀 Getting Started

### 📋 Prerequisites

- Java 8 or higher
- Maven 3.x

### 🛠️ Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name

2. **Build the Project**
   ```bash
   mvn clean install

3. **Run the Program**
   ```bash
   mvn exec:java -Dexec.mainClass="com.playfair.PlayFair"

### 💬 Usage

Enter the encryption key:

monarchy

Enter the plain text:

instruments

Cipher Text: 

GATLMZCLRQXA

Decrypted Plain Text: 

INSTRUMENTS

### 📚 Motivation
I created this project after watching a YouTube video demonstrating the Playfair Cipher. I found the algorithm interesting and thought it would be a great learning experience to implement it in Java.

### 🧪 Testing
Feel free to extend this project by writing unit tests using JUnit or any testing framework of your choice.

### 📄 License
This project is licensed under the MIT License. You are free to use, modify, and distribute it.

### 🤝 Contributing
Contributions are welcome! If you'd like to improve the code, fix bugs, or add features:

- Fork the repository
- Create a new branch
- Make your changes
- Submit a pull request

### 🙌 Acknowledgments

- Charles Wheatstone (Inventor)
- Lord Playfair (Popularized the cipher)
- Java and the open-source community

Feel free to ⭐ this repository if you find it useful!
