# Group: SE-2224
# Creators: Ussenov Bekzat and Zhalgas Srymbetov
# Topic: Final Project

# PROJECT OVERVIEW

For the end of Software Design Patterns course we supposed to create a Java application,
which will cover the usage of 6 patterns and coding aspects like YAGNI, KISS, and DRY. 
So, we chose to build a task management app. Nowadays it is really needful to face deadlines
and pass the assignments at time in order not to lose points. Task Management System will be 
useful regardless gender, age, and purpose. 

First of all, we have been analyzing this sphere and other applications around 2 hours, to have a 
specific vision, and created mindmap. After that we build a plan, what should be created first, integrated and how
it should be connected with other classes and methods. Via navigation plan we created an application
without unnecessary movements, and effectively built it. 

With our program we would like to help people to be in time for deadlines. 

----------------------------------------------------------------------------------------------------

> [!IMPORTANT]
>  UML DIAGRAM 
>  [UML](https://github.com/aitushnik01/SomethingBad/blob/main/SomethingBad.png)

----------------------------------------------------------------------------------------------------

# CODE OVERVIEW

We used 6 patterns: Singleton, Adapter, Decorator, Observer, Factory, Strategy. 
        3 rules: YAGNI, KISS, DRY.

### Factory Pattern
///  Task ///

public interface Task {
    public void id();
    public String getTaskName();
    public String getDescription();
    public double dueDate();
    public Priority getPriority();
}

initialised how task should look like via interface.

///  Simple Task ///

public class SimpleTask implements Task {
    @Override
    public void id() {
        System.out.println("This is simple Task");
    }

    @Override
    public String getTaskName() {
        return "Task name";
    }

    @Override
    public String getDescription() {
        return "This is simple task desc";
    }

    @Override
    public double dueDate() {
        return 2025;
    }

    @Override
    public Priority getPriority() {
        return Priority.LOW;
    }
}

We wrote class Simple Task to implement task interface. 

///  Task Factory ///

public interface TaskFactory {
    Task createTask();
}

Initialised the interface for factory method

/// Simple Task Factory ///

public class SimpleTaskFactory implements TaskFactory {
    @Override
    public Task createTask() {
        return new SimpleTask();
    }
}

This is the implementation of factory method  

> [!NOTE]
> OK, of coursely we can go through every code snippet. However it is better to see once,
> rather than reading it twice. Here I showed the example of usage of how every pattern used.


/// Main ///
        while (!exit) {
            System.out.println(ANSI_YELLOW + "\nMenu:");
            System.out.println("1. " + ANSI_GREEN + "Create Task");
            System.out.println("2. " + ANSI_GREEN + "View Tasks");
            System.out.println("3. " + ANSI_GREEN + "Update Task Priority");
            System.out.println("4. " + ANSI_GREEN + "Delete Task");
            System.out.println("5. " + ANSI_RED + "Exit");
            System.out.print(ANSI_CYAN + "Enter your choice: ");
            }
To improve readability of CLI, We added ASCII colours for better user experience. 

/// CRUDTask ///
            public static void readTasks() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks")) {
            System.out.println("Tasks:");
            while (resultSet.next()) {
                String taskName = resultSet.getString("task_name");
                int priority = resultSet.getInt("priority");
                Date dueDate = resultSet.getDate("due_date");
                System.out.println("Task Name: " + taskName + ", Priority: " + priority + ", Due Date: " + dueDate);
            }
        } catch (SQLException e) {
            System.out.println("Read tasks error: " + e.getMessage());
        }
    }

Example of usage CRUD princples to retrieve information from database


--------------------------------------------------------------------------------------------------------

# CONCLUSION 

This project was really time consuming, because it required our understanding of princeples for better 
integration of patterns to our project. Although, we have been spending most of our time to connect database,
and finding out why it doesn't connect. If you are intesting why we used DB instead of List, because we
wanted to get highest mark as possible. 

In our project there are a lot of space to improve. Add more functionality for task management system, like user 
registration or login, sharing the same deadline with other users, etc. Convert CLI to GUI for better user experience.
Cover other patterns and implement it in future. 

This journey was interesting, it was full of challanges and tasks. We really enjoyed to learn new patterns, and program
at Java language. Futhermore, our teacher Arailym Bakenova inspired and motivated us to move forward and evolve in our 
prorammer's path. We would like to say big thanks for her patience and teaching skills. 

----------------------------------------------------------------------------------------------------------------

# References 
* [Gamma, E., Helm, R., Johnson, R. E., & Vlissides, J. (1993). Design Patterns: Abstraction and reuse of Object-Oriented design. In Lecture Notes in Computer Science (pp. 406–431).](https://doi.org/10.1007/3-540-47910-4_21)
* [H. Mu and S. Jiang, "Design patterns in software development," 2011 IEEE 2nd International Conference on Software Engineering and Service Science, Beijing, China, 2011, pp. 322-325, ](doi: 10.1109/ICSESS.2011.5982228.)
* [Edwin, N. M. (2014). Software frameworks, architectural and design patterns. Journal of Software Engineering and Applications, 07(08), 670–678. ](https://doi.org/10.4236/jsea.2014.78061)
