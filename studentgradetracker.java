import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class studentgradetracker {
    private ArrayList<Integer> grades;

    public studentgradetracker() {
        grades = new ArrayList<>();
    }

    // Method to add a grade to the tracker
    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Grade must be between 0 and 100.");
        }
    }

    // Method to calculate the average of all grades
    public double calculateAverage() {
        if (grades.isEmpty()) return 0;

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find the highest grade
    public int findHighestGrade() {
        if (grades.isEmpty()) return 0;
        return Collections.max(grades);
    }

    // Method to find the lowest grade
    public int findLowestGrade() {
        if (grades.isEmpty()) return 0;
        return Collections.min(grades);
    }

    // Method to display all grades
    public void displayGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades recorded.");
        } else {
            System.out.println("Grades: " + grades);
            System.out.println("Average: " + calculateAverage());
            System.out.println("Highest: " + findHighestGrade());
            System.out.println("Lowest: " + findLowestGrade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studentgradetracker tracker = new studentgradetracker();

        while (true) {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("1. Add a grade");
            System.out.println("2. Display grades");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter grade (0-100): ");
                    int grade = scanner.nextInt();
                    tracker.addGrade(grade);
                    break;
                case 2:
                    tracker.displayGrades();
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
