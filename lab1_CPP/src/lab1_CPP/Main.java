package lab1_CPP; 
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DormitoryManager dormitoryManager = new DormitoryManager();

        //Додаємо студентів
        dormitoryManager.addStudent(new Student("Anastasiia", "Danchak", "Dorm8", 101, 500.0, 20, true));
        dormitoryManager.addStudent(new Student("Iryna", "Danchak", "Dorm8", 101, 450.0, 19, false));
        dormitoryManager.addStudent(new Student("Olena", "Hnidets", "Dorm3", 102, 450.0, 19, false));
        dormitoryManager.addStudent(new Student("Nazar", "Shchepaniak", "Dorm8", 101, 480.0, 21, true));
        dormitoryManager.addStudent(new Student("Ostap", "Hnativ", "Dorm14", 103, 550.0, 22, false));
        dormitoryManager.addStudent(new Student("Oleh", "Shchepaniak", "Dorm14", 103, 550.0, 22, false)); 
        dormitoryManager.addStudent(new Student("Marta", "Danchak", "Dorm8", 101, 520.0, 21, true)); 
        dormitoryManager.addStudent(new Student("Ivan", "Hnidets", "Dorm3", 102, 470.0, 20, false)); 
        dormitoryManager.addStudent(new Student("Yulia", "Hnidets", "Dorm3", 102, 490.0, 19, true)); 


        // Розділити студентів на пільговиків і непільговиків
        System.out.println("Divide students into beneficiaries and non-beneficiaries:");
        Map<Boolean, List<Student>> splitStudents = dormitoryManager.splitByBeneficiary();
        System.out.println("Beneficiaries: " + splitStudents.get(true));
        System.out.println("Non-beneficiaries: " + splitStudents.get(false));

        // Згрупувати студентів за гуртожитками (без Stream API)
        System.out.println("\nGroup students by dormitories (without Stream API):");
        Map<String, List<Student>> groupedStudents = dormitoryManager.groupByDormitory();
        System.out.println(groupedStudents);

        // Згрупувати студентів за гуртожитками (з Stream API)
        System.out.println("\nGroup students by dormitories (with Stream API):");
        Map<String, List<Student>> groupedStudentsStream = dormitoryManager.groupByDormitoryStream();
        System.out.println(groupedStudentsStream);

        // Кількість студентів у кімнатах (без Stream API)
        System.out.println("\nNumber of students in rooms (without Stream API):");
        Map<Integer, Long> roomCount = dormitoryManager.countStudentsByRoom();
        System.out.println(roomCount);

        // Кількість студентів у кімнатах (з Stream API)
        System.out.println("\nNumber of students in rooms (with Stream API):");
        Map<Integer, Long> roomCountStream = dormitoryManager.countStudentsByRoomStream();
        System.out.println(roomCountStream);

        // Сортування студентів за віком (без Stream API)
        System.out.println("\nSorting students by age (without Stream API):");
        List<Student> sortedStudents = dormitoryManager.sortStudentsByAge();
        System.out.println(sortedStudents);

        // Сортування студентів за віком (з Stream API)
        System.out.println("\nSorting students by age (with Stream API):");
        List<Student> sortedStudentsStream = dormitoryManager.sortStudentsByAgeStream();
        System.out.println(sortedStudentsStream);

        // Унікальні номери кімнат (без Stream API)
        System.out.println("\nUnique room numbers (without Stream API):");
        Set<Integer> uniqueRoomNumbers = dormitoryManager.getUniqueRoomNumbers();
        System.out.println(uniqueRoomNumbers);

        // Унікальні номери кімнат (з Stream API)
        System.out.println("\nUnique room numbers (with Stream API):");
        Set<Integer> uniqueRoomNumbersStream = dormitoryManager.getUniqueRoomNumbersStream();
        System.out.println(uniqueRoomNumbersStream);

        // Найбільша плата за проживання (без Stream API)
        System.out.println("\nThe student with the highest accommodation fee (without Stream API):");
        Optional<Student> maxRentStudent = dormitoryManager.findMaxRentStudent();
        maxRentStudent.ifPresent(student -> System.out.println(student));

        // Найбільша плата за проживання (з Stream API)
        System.out.println("\nThe student with the highest accommodation fee (with Stream API):");
        Optional<Student> maxRentStudentStream = dormitoryManager.findMaxRentStudentStream();
        maxRentStudentStream.ifPresent(student -> System.out.println(student));
        
     // Пошук однофамільців у кожній кімнаті
        System.out.println("\nSurnames in each room:");
        Map<Integer, List<Student>> surnamesInEachRoom = dormitoryManager.findSurnamesInEachRoomStream();
        for (Map.Entry<Integer, List<Student>> entry : surnamesInEachRoom.entrySet()) {
            System.out.println("Room " + entry.getKey() + ": " + entry.getValue());
        }

        // Пошук однофамільців у всіх кімнатах
        System.out.println("\nSurnames in all rooms:");
        Map<String, List<Student>> surnamesInAllRooms = dormitoryManager.findSurnamesInAllRoomsStream();
        for (Map.Entry<String, List<Student>> entry : surnamesInAllRooms.entrySet()) {
            System.out.println("Surname " + entry.getKey() + ": " + entry.getValue());
        }
  
    }
}
