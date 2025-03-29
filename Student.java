package Lab1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> marks;

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Alice", "B110", 2, List.of(3, 4, 5, 3, 2)),
                new Student("Maria", "B110", 1, List.of(3, 3, 5, 2, 2)),
                new Student("Alex", "B120", 4, List.of(3, 4, 1, 3, 2)),
                new Student("Jack", "B140", 2, List.of(1, 4, 2, 3, 2)),
                new Student("Tom", "B100", 3, List.of(4, 4, 2, 2, 2))
        ));
        for (int j=0; j<students.size(); j++){
            double avgMark = 0.0;
            for(int i: students.get(j).getMarks()){
                avgMark += i;
            }
            avgMark /= 5;
            if (avgMark < 3){
                students.remove(students.get(j));
            }
            else students.get(j).setCourse(students.get(j).getCourse()+1);
        }
        printStudents(students, 3);
    }

    public static void printStudents(List<Student> students, int course){
        for(Student s : students){
            if (s.getCourse() == course) System.out.println(s.getName());
        }
    }
}
