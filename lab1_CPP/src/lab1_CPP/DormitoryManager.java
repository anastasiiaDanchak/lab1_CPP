package lab1_CPP; 

import java.util.*;
import java.util.stream.Collectors;

public class DormitoryManager {
    private List<Student> students;

    public DormitoryManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // Розділити студентів на пільговиків і непільговиків (без Stream API)
    public Map<Boolean, List<Student>> splitByBeneficiary() {
        Map<Boolean, List<Student>> result = new HashMap<>();
        result.put(true, new ArrayList<>());
        result.put(false, new ArrayList<>());

        for (Student student : students) {
            if (student.isBeneficiary()) {
                result.get(true).add(student);
            } else {
                result.get(false).add(student);
            }
        }
        return result;
    }

    // Розділити студентів на пільговиків і непільговиків (з Stream API)
    public Map<Boolean, List<Student>> splitByBeneficiaryStream() {
        return students.stream()
                .collect(Collectors.partitioningBy(Student::isBeneficiary));
    }

    // Згрупувати студентів за гуртожитками (без Stream API)
    public Map<String, List<Student>> groupByDormitory() {
        Map<String, List<Student>> result = new HashMap<>();

        for (Student student : students) {
            result.computeIfAbsent(student.getDormitory(), k -> new ArrayList<>()).add(student);
        }
        return result;
    }

    // Згрупувати студентів за гуртожитками (з Stream API)
    public Map<String, List<Student>> groupByDormitoryStream() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getDormitory));
    }

    // Кількість студентів у кімнатах (без Stream API)
    public Map<Integer, Long> countStudentsByRoom() {
        Map<Integer, Long> result = new HashMap<>();

        for (Student student : students) {
            result.put(student.getRoomNumber(), result.getOrDefault(student.getRoomNumber(), 0L) + 1);
        }
        return result;
    }

    // Кількість студентів у кімнатах (з Stream API)
    public Map<Integer, Long> countStudentsByRoomStream() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getRoomNumber, Collectors.counting()));
    }

    // Сортування студентів за віком (без Stream API)
    public List<Student> sortStudentsByAge() {
        List<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort(Comparator.comparingInt(Student::getAge));
        return sortedStudents;
    }

    // Сортування студентів за віком (з Stream API)
    public List<Student> sortStudentsByAgeStream() {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());
    }

    // Унікальні номери кімнат (без Stream API)
    public Set<Integer> getUniqueRoomNumbers() {
        Set<Integer> roomNumbers = new HashSet<>();

        for (Student student : students) {
            roomNumbers.add(student.getRoomNumber());
        }
        return roomNumbers;
    }

    // Унікальні номери кімнат (з Stream API)
    public Set<Integer> getUniqueRoomNumbersStream() {
        return students.stream()
                .map(Student::getRoomNumber)
                .collect(Collectors.toSet());
    }

    // Студент з найбільшою платою за проживання
    public Optional<Student> findMaxRentStudent(){
    	if(students.isEmpty())
    	{
    		return Optional.empty();
    	}
    	
    	Student maxRentStudent = students.get(0);
    	for(Student student : students)
    	{
    		if(student.getRentFee()>maxRentStudent.getRentFee())
    		{
    			maxRentStudent = student;
    		}
    	}
    	return Optional.of(maxRentStudent);
    }

    // Студент з найбільшою платою за проживання (з Stream API)
   public Optional<Student> findMaxRentStudentStream(){
	   return students.stream()
			   .max(Comparator.comparingDouble(Student::getRentFee));
   }

   // Шукаємо однофамільців у кожній кімнаті 
  public Map<Integer, List<Student>> findSurnamesInEachRoomStream(){
	  return students.stream()
			  .collect(Collectors.groupingBy(Student::getRoomNumber))
			  .entrySet().stream()
			  .collect(Collectors.toMap(
					  Map.Entry::getKey, 
					  entry->entry.getValue().stream()
					  .collect(Collectors.groupingBy(Student::getLastName))
					  .values().stream()
					  .filter(list->list.size()>1)
					  .flatMap(List::stream)
					  .collect(Collectors.toList())
					  ));
	  }
  
   // Шукаємо однофамільців у всіх кімнатах
   public Map<String, List<Student>> findSurnamesInAllRoomsStream(){
	return students.stream()
			.collect(Collectors.groupingBy(Student::getLastName))
			.entrySet().stream()
			.filter(entry -> entry.getValue().size()>1)
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}
   
   

}
