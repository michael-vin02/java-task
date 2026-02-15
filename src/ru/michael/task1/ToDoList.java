package ru.michael.task1;

import java.util.Scanner;

public class ToDoList {

    private static final String[] tasks = new String[100];


    public static void main(String[] args) {
        menu();
        program();
    }


    private static void menu() {
        System.out.println(">>> Меню:");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Показать все задачи");
        System.out.println("3. Удалить задачу (по номеру)");
        System.out.println("4. Отметить задачу как выполненную");
        System.out.println("0. Выход");
        System.out.println("\nВыберите пункт меню:");
    }


    private static void program() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (userErrorString(scanner)) {
                scanner.next();
                continue;
            }
            int userNumber = scanner.nextInt();
            if (userNumber == 1) {
                addTask();
            } else if (userNumber == 2) {
                viewTask();
            } else if (userNumber == 3) {
                deleteTask();
            } else if (userNumber == 4) {
                taskComplete();
            } else if (userNumber == 0) {
                System.out.println("Программа завершена!");
                break;
            } else if (userNumber < 0 || userNumber > 4) {
                System.out.println("Введите пункт меню ещё раз!\n\n");
                menu();
            } else {
                break;
            }
        }
    }


    private static void addTask() {
        System.out.println("Введите описание задачи:");
        Scanner scanner = new Scanner(System.in);
        String userTask = scanner.nextLine();
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[tasks.length - 1] != null) {
                System.out.println("Список задач переполнен!\n\n");
                break;
            }
            if (tasks[i] == null) {
                tasks[i] = ". [ ] " + userTask;
                System.out.println("Задача добавлена!\n\n");
                break;
            }
        }
        menu();
    }


    private static void viewTask() {
        if (tasks[0] == null) {
            System.out.println("Список задач пуст!\n\n");
            menu();
            return;
        }
        System.out.println("Список задач:");
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                break;
            }
            System.out.println(i + 1 + tasks[i]);
        }
        System.out.println("\n\n");
        menu();
    }


    private static void deleteTask() {
        System.out.println("Введите номер задачи для удаления:");
        Scanner scanner = new Scanner(System.in);
        if (userErrorString(scanner)) {
            return;
        }
        int deleteTask = scanner.nextInt();
        if (userError(deleteTask)) {
            return;
        }
        for (int i = 0; i < tasks.length; i++) {
            if ((deleteTask - 1) == i) {
                System.out.println("Задача \"" + tasks[deleteTask - 1].substring(6) + "\" удалена!\n\n");
                for (; i < tasks.length - 1; i++) {
                    tasks[i] = tasks[i + 1];
                }
                tasks[tasks.length - 1] = null;
                break;
            }
        }
        menu();
    }


    private static void taskComplete() {
        System.out.println("Введите номер задачи для отметки:");
        Scanner scanner = new Scanner(System.in);
        if (userErrorString(scanner)) {
            return;
        }
        int taskComplete = scanner.nextInt();
        if (userError(taskComplete)) {
            return;
        }
        for (int i = 0; i < tasks.length; i++) {
            if ((taskComplete - 1) == i) {
                if (tasks[i].startsWith(". [X]")) {
                    System.out.println("Задача уже выполнена!\n\n");
                    break;
                }
                String stringTasks = tasks[i].substring(6);
                tasks[i] = ". [X] " + stringTasks;
                System.out.println("Задача \"" + tasks[i].substring(6) + "\" отмечена как выполненная!\n\n");
                break;
            }
        }
        menu();
    }


    private static boolean userError(int userNumError) {
        if (userNumError <= 0) {
            System.out.println("Вы ввели некорректный номер задачи!\n\n");
            menu();
            return true;
        } else if (userNumError > tasks.length) {
            System.out.println("Максимальное число задач: " + tasks.length + "\n\n");
            menu();
            return true;
        } else if (tasks[userNumError - 1] == null) {
            System.out.println("Под этим номером нет задачи!\n\n");
            menu();
            return true;
        } else {
            return false;
        }
    }


    private static boolean userErrorString (Scanner scanner) {
        if (scanner.hasNextInt()) {
            return false;
        } else {
            System.out.println("Не корректный ввод! Попробуйте ещё раз!\n\n");
            menu();
            return true;
        }
    }
}
