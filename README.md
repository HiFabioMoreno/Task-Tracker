# Task-Tracker-Cli #

A terminal-based application designed to help manage tasks efficiently. 


## ✨Funcionalidades✨ ##

- 📌 Add tasks.
- ✅ Mark tasks as to-do, in progress or done.
- ✏️ Edit task descriptions.
- 🔎 Filter tasks by status.
- 🗑️ Delete tasks.

Each created task includes a creation date and a last update timestamp.

## Technologies ##
This project is built using Java, SQLite, and Apache Commons CLI.

### Uso ###

``` bash

# Clone 
git clone https://github.com/HiFabioMoreno/Task-Tracker.git
cd Task-Tracker

```

```bash

# Copy the absolute path of the task.db file located in the db folder.
# Create the resources folder inside src/main/:

   mkdir -p src/main/resources

# Create the config.properties file inside src/main/resources/:

   touch src/main/resources/config.properties

# Open the file src/main/resources/config.properties and
# paste the path into the file, making sure it follows this format:

# Example on Windows
database.path=C:/Users/YourUser/Project/db/task.db

#Example on Linux/Mac
database.path=/home/youruser/project/db/task.db
```
``` java
# Compilar
mvn package

# Run 

mvn exec:java -Dexec.args="-add 'Ir al supermercado' " # add task
mvn exec:java -Dexec.args="-update 'Call to Maria' 1 " # update task by ID
mvn exec:java -Dexec.args="-delete '1' " # delete task by ID

# List task

mvn exec:java -Dexec.args="-list "
mvn exec:java -Dexec.args="-list-todo "
mvn exec:java -Dexec.args="-list-in-progress"
mvn exec:java -Dexec.args="-list-done "

# Mark task

mvn exec:java -Dexec.args="-mark-todo "
mvn exec:java -Dexec.args="-mark-in-progress"
mvn exec:java -Dexec.args="-mark-done "

```
If you have any feedback, feel free to share it. Your comments will help me improve as a developer. All suggestions are welcome!




