package com.shuuriye.Students;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {
    //map as fake database
    Map<Long , Student> students = new ConcurrentHashMap<>();
    AtomicLong autoId = new AtomicLong();

    //all operations

    //get all students
    public Collection<Student> getStudents() {
        return students.values();
    }

    //get student by id
    public Student getStudentById(Long id) {
        return students.get(id);
    }

    //delete student
    public void deleteStudent(Long id) {
        students.remove(id);
    }

    //save student
    public void saveStudent(Student student) {
        Long id = student.studentID() != null ?
                student.studentID() :
                autoId.incrementAndGet();

     Student newStd = new Student(id , student.name());

        students.put(id, newStd);
    }

    //update student
    public void updateStudent(Long id, Student student) {
        if(students.containsKey(id)){
            Student oldStudent = students.get(id);

            //update student
         Student newUdated = new Student(id , student.name());

            students.put(id, newUdated);
        }
    }
}
