


# Project Name

A Task tracker with simple feature created as a learning project from [roadmap.sh](https://roadmap.sh/projects/task-tracker).
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
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="add 'laundry' "
```

### Option 2: Run the Compiled `.java` File Directly (Not Typical for Maven Projects)
If you're running via `java Filename.java args`, do this:

```bash
cd src/main/java/org/example/
java Main.java add "laundry"
```



## 🛠 Project Structure

```
your-repo/
├── src/
│   └── main/
│       └── java/
│           └── org/example/
│               └── Main.java
├── pom.xml
└── README.md
```

---

## 📝 Example Usage

You can run commands using Maven like this:

```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="<command> [arguments]"
```

Replace `<command>` and `[arguments]` with the specific operation you want to perform.


### 🔹 Adding a New Task
```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="add 'Buy groceries'"
```
**Output:**
```
Task added successfully (ID: 1)
```


### 🔹 Updating a Task
```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="update 1 'Buy groceries and cook dinner'"
```

---

### 🔹 Deleting a Task
```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="delete 1"
```


### 🔹 Marking a Task as In Progress
```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="mark-in-progress 1"
```


### 🔹 Marking a Task as Done
```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="mark-done 1"
```


### 🔹 Listing All Tasks
```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="list"
```

