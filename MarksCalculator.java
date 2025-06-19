import java.util.Scanner;

public class MarksCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUM_SUBJECTS = 6;
        final int MAX_MARKS_PER_SUBJECT = 100;
        final int MAX_TOTAL = NUM_SUBJECTS * MAX_MARKS_PER_SUBJECT;

        // 1. How many students?
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        if (numStudents <= 0) {
            System.out.println("Number of students must be positive.");
            scanner.close();
            return;
        }

        // 2. For each student, read 6 marks, compute total & percentage, assign grade
        for (int student = 1; student <= numStudents; student++) {
            System.out.printf("%n--- Student %d --- %n", student);

            int totalMarks = 0;
            // Read marks for each of the 6 subjects
            for (int subj = 1; subj <= NUM_SUBJECTS; subj++) {
                int mark;
                while (true) {
                    System.out.printf("Enter marks for subject %d (0-100): ", subj);
                    mark = scanner.nextInt();
                    if (mark >= 0 && mark <= MAX_MARKS_PER_SUBJECT) {
                        break;
                    }
                    System.out.println("Invalid entry. Please enter a value between 0 and 100.");
                }
                totalMarks += mark;
            }

            // Calculate percentage out of 600
            double percentage = (double) totalMarks / MAX_TOTAL * 100.0;

            // Determine grade by percentage
            String grade;
            if (percentage >= 90) {
                grade = "A";
            } else if (percentage >= 80) {
                grade = "B";
            } else if (percentage >= 70) {
                grade = "C";
            } else if (percentage >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            // 3. Display this student's results
            System.out.printf("Total Marks    : %d out of %d%n", totalMarks, MAX_TOTAL);
            System.out.printf("Percentage     : %.2f%%%n", percentage);
            System.out.printf("Grade          : %s%n", grade);
        }

        scanner.close();
    }
}
