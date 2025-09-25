# ☕ JAVA Projects

<p align="center">
  <img src="https://img.shields.io/github/actions/workflow/status/ValhallaRising1974/JAVA/java-ci.yml?branch=main" />
  <img src="https://img.shields.io/badge/language-Java-blue" />
  <img src="https://img.shields.io/github/last-commit/ValhallaRising1974/JAVA" />
  <img src="https://img.shields.io/github/license/ValhallaRising1974/JAVA" />
</p>

---

## 🌍 About (EN-CA)

This repository is a growing collection of **Java projects** created during my FullStack development journey.  
Each project is built with **Maven**, tested with **JUnit**, and automated with **GitHub Actions**.  
The aim is to demonstrate not only coding skills, but also **professional project organization** and **CI/CD integration**.

---

## 🌍 À propos (FR-CA)

Ce dépôt est une collection évolutive de **projets Java**, créés dans le cadre de mon parcours en développement FullStack.  
Chaque projet est construit avec **Maven**, testé avec **JUnit**, et automatisé avec **GitHub Actions**.  
L’objectif est de démontrer non seulement des compétences en programmation, mais aussi une **organisation professionnelle** et une **intégration CI/CD**.

---

## 📂 Projects

### 1. **bank-simulator/**
A simple banking system with:
- Deposit, withdrawal, and balance operations.
- Object-oriented design (Account class).
- Automated tests with JUnit.
- CI pipeline that compiles, tests, and runs a demo.

👉 [Open project](bank-simulator)

---

## ⚙️ How to Run (Local)

```bash
cd bank-simulator
mvn clean test package
java -cp target/classes com.marcelo.bank.Demo
