package SQL;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TaskCRUD {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/SDP_Final";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Qqwerty1!";

    public static void createTasksTable() {
        try {
            Class.forName("org.postgresql.Driver"); // Load PostgreSQL JDBC driver
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            if (conn != null) {
                System.out.println("Connected to the PostgreSQL database!");

                // Create a table query for tasks
                String createTableSQL = "CREATE TABLE IF NOT EXISTS tasks (" +
                        "id SERIAL PRIMARY KEY," +
                        "task_name TEXT NOT NULL," +
                        "priority INT NOT NULL," +
                        "due_date DATE" +
                        ")";

                try (Statement statement = conn.createStatement()) {
                    // Execute the query to create the tasks table
                    statement.execute(createTableSQL);
                    System.out.println("Table 'tasks' created or already exists!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Table creation error: " + e.getMessage());
        }
    }

    public static void createTask(String taskName, int priority, String dueDate) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            // Check if the task already exists
            PreparedStatement checkStatement = conn.prepareStatement("SELECT task_name FROM tasks WHERE task_name = ?");
            checkStatement.setString(1, taskName);
            ResultSet resultSet = checkStatement.executeQuery();

            if (!resultSet.next()) { // Task doesn't exist, proceed to insert
                PreparedStatement preparedStatement = conn.prepareStatement(
                        "INSERT INTO tasks (task_name, priority, due_date) VALUES (?, ?, ?)");
                preparedStatement.setString(1, taskName);
                preparedStatement.setInt(2, priority);
                preparedStatement.setDate(3, Date.valueOf(dueDate));
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Task '" + taskName + "' inserted successfully");
                }
            } else {
                System.out.println("Task '" + taskName + "' already exists");
            }
        } catch (SQLException e) {
            System.out.println("Create task error: " + e.getMessage());
        }
    }

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

    public static void updateTaskPriority(String taskName, int newPriority) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "UPDATE tasks SET priority = ? WHERE task_name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, newPriority);
            preparedStatement.setString(2, taskName);

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows > 0) {
                System.out.println("Task priority updated successfully!");
            } else {
                System.out.println("Task '" + taskName + "' not found.");
            }
        } catch (SQLException e) {
            System.out.println("Update task priority error: " + e.getMessage());
        }
    }

    public static void deleteTask(String taskName) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM tasks WHERE task_name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, taskName);

            int deletedRows = preparedStatement.executeUpdate();

            if (deletedRows > 0) {
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("Task '" + taskName + "' not found.");
            }
        } catch (SQLException e) {
            System.out.println("Delete task error: " + e.getMessage());
        }
    }
}

