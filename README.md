
# NMIMSGo 🎓📱

**NMIMSGo** is a campus utility app designed for students and faculty. It centralizes daily campus needs into one mobile app — from **mess menus** and **faculty cabin locations** to **lab/classroom routes**, **weather updates**, and **support contact options**. Built with **Java (Android)** for a smooth and reliable experience.

---

## 📌 Table of Contents
- [About](#about)  
- [Features](#features)  
- [Screenshots](#screenshots)  
- [Tech Stack](#tech-stack)  
- [Prerequisites](#prerequisites)  
- [Installation](#installation)  
- [Build & Release](#build--release)  
- [Configuration](#configuration)  
- [Usage](#usage)  
- [Testing](#testing)  
- [Contributing](#contributing)  
- [Roadmap](#roadmap)  
- [License](#license)  
- [Contact](#contact)

---

## 📖 About
NMIMSGo simplifies campus life by putting all essential information in one app. No more confusion about mess menus, running around to find classrooms or cabins, or missing important support information — everything is now accessible with a few taps.  

---

## ✨ Features
- 🍴 **Mess Menu** — check today’s or weekly mess food menu  
- 🗺 **Campus Map & Routes** — interactive map with guidance to faculty cabins, labs, and classes  
- 👨‍🏫 **Faculty Directory** — search and find cabin details & office hours  
- ⏰ **Class Timetable** — access class schedules instantly  
- 🌦 **Weather Updates** — live campus weather information with alerts  
- 📞 **Support** — contact campus support directly via app  
- 🔐 **Login/Logout** — secure login with option to stay signed in  

---

## 🖼 Screenshots  

<p align="center">
  <img src="https://github.com/user-attachments/assets/dfc6b141-5b32-4041-bfa1-971c5ae10fef" alt="Screenshot 1" width="200"/>
  <img src="https://github.com/user-attachments/assets/e1ae6004-7d01-46ee-81e2-6735cc811814" alt="Screenshot 2" width="200"/>
  <img src="https://github.com/user-attachments/assets/1030c9ad-e496-4b59-bc36-30cc7a6e0053" alt="Screenshot 3" width="200"/>
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/4d937805-723a-44a2-a66c-6a4d77eda5d3" alt="Screenshot 4" width="200"/>
  <img src="https://github.com/user-attachments/assets/d36ecae9-4bce-46dd-a66a-e569ea9d5e4c" alt="Screenshot 5" width="200"/>
</p>

---

## ⚙️ Tech Stack
- **Language:** Java  
- **Platform:** Android (API Level 21+)  
- **Build Tool:** Gradle  
- **Maps:** Google Maps SDK (if enabled)  
- **Backend (optional):** Firebase / REST API  
- **Analytics (optional):** Firebase Analytics / Google Analytics  

---

## 🔑 Prerequisites
- Android Studio (Arctic Fox or newer)  
- JDK 11+  
- Android SDK (API 21 or higher)  
- Google Maps API Key (if maps are used)  
- Firebase account (if authentication or cloud services are used)  

---

## 🚀 Installation

1. Clone the repository  
   ```bash
   git clone https://github.com/<your-username>/NMIMSGo.git
   cd NMIMSGo
````

2. Open in **Android Studio**

   * File → Open → select the project folder
   * Let Gradle sync

3. Configure API keys (see [Configuration](#configuration))

4. Run on an emulator or connected Android device

---

## 📦 Build & Release

To generate APKs:

```bash
./gradlew assembleDebug      # Debug APK
./gradlew assembleRelease    # Release APK (requires signingConfigs)
```

---

## ⚙️ Configuration

* Add API keys inside `app/src/main/res/values/strings.xml`
* Place `google-services.json` in `app/` if Firebase is used
* Configure constants like API endpoints in `Config.java`

**Environment variables (example):**

* `MAPS_API_KEY` — Google Maps
* `WEATHER_API_KEY` — OpenWeatherMap (if used)
* `API_BASE_URL` — backend service for menus/timetables

---

## 📲 Usage

* Open app → Login → Access features from home screen
* Quick tiles for **Menu, Maps, Weather, Support**
* Navigate to faculty cabins or labs directly via search
* Check mess menu or timetable in a single tap
* Get support through in-app contact

---

## 🧪 Testing

Run unit tests:

```bash
./gradlew test
```

Run instrumentation tests:

```bash
./gradlew connectedAndroidTest
```

---

## 🤝 Contributing

Contributions are welcome!

Steps:

1. Fork the repository
2. Create a new branch:

   ```bash
   git checkout -b feat/your-feature
   ```
3. Commit changes:

   ```bash
   git commit -m "Add new feature"
   ```
4. Push:

   ```bash
   git push origin feat/your-feature
   ```
5. Submit a Pull Request

---

## 🛣 Roadmap

* ✅ Basic mess menu & maps
* 🔄 Add chat-based support
* 🔄 Floor-level navigation in maps
* 🔄 Multi-language support
* 🔄 Push notifications for timetable & weather

---

## 📜 License

This project is licensed under the **MIT License**.

---

## 📧 Contact

Maintainer: **Your Name**
📍 Repo: [NMIMSGo GitHub](https://github.com/<Swarup5751>/NMIMSGo)
✉️ Email: `<swarupms48301@gmail.com>`

```

---

👉 Do you want me to also **add captions below each screenshot** (like *Home*, *Mess Menu*, *Map*, etc.) so the gallery looks labeled in your README?
```
