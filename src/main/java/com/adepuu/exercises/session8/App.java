package com.adepuu.exercises.session8;

import java.util.*;

class User {
    private String username;
    private String password;
    private List<String> tasks;
    private Date lastLogin;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.tasks = new ArrayList<>();
        this.lastLogin = null; // Set initially to null
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void addTask(String task) {
        tasks.add(task);
        Collections.sort(tasks); // Sort tasks chronologically
    }

    public void deleteTask(int taskNumber) {
        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.remove(taskNumber);
            System.out.println("Task " + (taskNumber + 1) + " deleted successfully by " + username + ".");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setLastLogin() {
        this.lastLogin = new Date();
    }

    public Date getLastLogin() {
        return lastLogin;
    }
}

public class ToDoListApp {
    private Map<String, User> users;
    private Scanner scanner;

    public ToDoListApp() {
        this.users = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public boolean register() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return false;
        }
        users.put(username, new User(username, password));
        System.out.println("Account created successfully.");
        return true;
    }

    public User login() {
        System.out.println("Registered users:");
        for (String username : users.keySet()) {
            System.out.println("- " + username);
        }
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            user.setLastLogin(); // Update last login time
            return user;
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    public void addTask(User user) {
        System.out.println(user.getUsername() + " is adding a task:");
        System.out.println("Enter task:");
        String task = scanner.nextLine();
        user.addTask(task);
        System.out.println("Task added successfully.");
    }

    public void viewTasks(User user) {
        System.out.println(user.getUsername() + "'s tasks:");
        List<String> tasks = user.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            System.out.println("-------------------------------");
            System.out.println("| No. | Task                |");
            System.out.println("-------------------------------");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.printf("| %-3d | %-20s |\n", (i + 1), tasks.get(i));
            }
            System.out.println("-------------------------------");
        }
    }

    public void deleteTask(User user) {
        System.out.println(user.getUsername() + " is deleting a task:");
        List<String> tasks = user.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }

        System.out.println("Enter task number to delete:");
        int taskNumber = Integer.parseInt(scanner.nextLine()) - 1; // Adjusted for zero-based indexing
        user.deleteTask(taskNumber);
    }

    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            int choice = Integer.parseInt(app.scanner.nextLine());

            switch (choice) {
                case 1:
                    app.register();
                    break;
                case 2:
                    User user = app.login();
                    if (user != null) {
                        System.out.println("Logged in successfully as " + user.getUsername() + ". Last login time: " + user.getLastLogin());
                        while (true) {
                            System.out.println("1. Add Task\n2. View Tasks\n3. Delete Task\n4. Logout");
                            int taskChoice = Integer.parseInt(app.scanner.nextLine());
                            switch (taskChoice) {
                                case 1:
                                    app.addTask(user);
                                    break;
                                case 2:
                                    app.viewTasks(user);
                                    break;
                                case 3:
                                    app.deleteTask(user);
                                    break;
                                case 4:
                                    System.out.println("Logged out successfully.");
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                            if (taskChoice == 4) {
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

