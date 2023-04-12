import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static LinkedList<StudentModel> init() throws FileNotFoundException {
        LinkedList<StudentModel> link = new LinkedList<>();
        Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\src\\resources\\initData.csv"));

        while (scan.hasNextLine()) {
            String[] data = scan.nextLine().split(",");
            StudentModel temp = new StudentModel(data[0], data[1], data[2], data[3], data[4], data[5], "0");
            link.add(temp);
        }

        return link;
    }

    private static StudentModel insert() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter student (Name,Account Number,Degree,Year Level,Student Contact no.,Student Email Address): ");
        String student = scan.nextLine();
        String[] data = student.split(",");

        return new StudentModel(data[0], data[1], data[2], data[3], data[4], data[5], "0");
    }

    private static StudentModel addEdit() {
        Scanner scan = new Scanner(System.in);
        System.out.print("""
                Enter student (Name,Account Number,Degree,Year Level,Student Contact no.,Student Email Address,Position):\040""");
        String student = scan.nextLine();
        String[] data = student.split(",");

        return new StudentModel(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        LinkedList<StudentModel> database = init();

        while (true) {
            System.out.println("""
                    0: exit
                    1: insert front data
                    2: insert last data
                    3: insert middle data
                    4: edit data
                    5: delete data
                    6: display data""");

            System.out.print("Choice: ");
            int choice = 0;

            try {
                choice = scan.nextInt();
                switch (choice) {
                    case 1 -> database.addFirst(insert());
                    case 2 -> database.addLast(insert());
                    case 3 -> {
                        StudentModel student = addEdit();
                        database.add(Integer.parseInt(student.getPos()), student);
                    }
                    case 4 -> {
                        StudentModel student = addEdit();
                        database.set(Integer.parseInt(student.getPos()), student);
                    }
                    case 5 -> {
                        System.out.print("""
                                Enter position of student to remove:\040""");
                        scan = new Scanner(System.in);
                        int n = scan.nextInt();
                        database.remove(n);
                    }
                    case 6 -> {
                        System.out.println();
                        System.out.println("Display:");
                        for (StudentModel studentModel : database) System.out.println(studentModel);
                        System.out.println();
                    }
                    default -> {
                        System.exit(0);
                    }
                }
            } catch (InputMismatchException | IndexOutOfBoundsException ignored) {
                main(args);
            }
        }
    }
}