


# Project Name

A Task tracker with simple feature created as a learning project.

## 🚀 Features

- add/remove task
- update task descriptions
- set task as in progress or done

## 📦 Prerequisites

- Java JDK 17+ 
- Maven 3.6+
- Git (optional, if you need to clone the repo)

## 🔧 Build Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/Abenezer-Daniel-W/task_tracker_cli_java.git
   cd task_tracker_cli_java
   ```

2. **Build the project using Maven**
   ```bash
   mvn clean compile
   ```

3. **(Optional) Package the project into a `.jar` file**
   ```bash
   mvn package
   ```

   The generated JAR file will be located in the `target/` directory.

## ▶️ Run the Application

### Option 1: Run Directly with Maven
If your application has a `main` method, you can run it like this:

```bash
mvn exec:java -Dexec.mainClass="com.yourpackage.Main" -Dexec.args="arg1 arg2"
```

### Option 2: Run the Compiled `.java` File Directly (Not Typical for Maven Projects)
If you're running via `java Filename.java args`, do this:

```bash
cd src/main/java
java your/package/Filename.java arg1 arg2
```

### Option 3: Run the Packaged `.jar` File
```bash
java -jar target/your-app-name-version.jar arg1 arg2
```

## 🛠 Project Structure

```
your-repo/
├── src/
│   └── main/
│       └── java/
│           └── your/package/
│               └── Main.java
├── pom.xml
└── README.md
```

## 📝 Example Usage

```bash
java -jar target/your-app-name-version.jar input.txt output.txt
```

## 🧑‍💻 Contributing

1. Fork the repo
2. Create a new branch (`git checkout -b feature-name`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature-name`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

---

## Notes:
- Update the `mainClass` in the Maven command with your actual fully-qualified class name.
- If you used Maven plugins like `exec-maven-plugin`, you can simplify the run command and include that setup in the README.
- If people should *not* run with `java Filename.java` but rather via Maven or jar, clarify that for them.

---

Want me to tailor this README to your exact project name and main class? Let me know your GitHub repo name (if any), main class name, and any example arguments, and I can fill that in for you.