import java.util.Scanner;

public class StudentGradeCalculator {
    private static final int MAX_MARKS = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int subjectCount = readPositiveInt(scanner, "Enter number of subjects: ");
        int[] marks = new int[subjectCount];

        for (int i = 0; i < subjectCount; i++) {
            marks[i] = readMarks(scanner, "Enter marks for subject " + (i + 1) + ": ");
        }

        int total = calculateTotal(marks);
        double percentage = calculatePercentage(total, subjectCount);
        String grade = calculateGrade(percentage);

        System.out.println();
        System.out.println("----- Student Grade Report -----");
        System.out.println("Total Marks: " + total + "/" + (subjectCount * MAX_MARKS));
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value > 0) {
                    return value;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Enter a positive integer.");
        }
    }

    private static int readMarks(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int marks = scanner.nextInt();
                if (marks >= 0 && marks <= MAX_MARKS) {
                    return marks;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid marks. Enter a value between 0 and 100.");
        }
    }

    private static int calculateTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calculatePercentage(int total, int subjectCount) {
        return (double) total / (subjectCount * MAX_MARKS) * 100;
    }

    private static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "F";
        }
    }
}
