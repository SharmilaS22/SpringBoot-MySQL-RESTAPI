package com.test.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//has business logic
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        // check if email already exist
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already registered");
        }

        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {

        // check if id exist
        boolean isStudentExist = studentRepository.existsById(studentId);
        if (!isStudentExist) {
            throw new IllegalStateException("Student with the given id doesn't exists");
        }

        studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, Student updatedStudent) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with the given Id didn't exist"));

        String name = updatedStudent.getName();
        if (name != null && name.length() > 0 ){
            student.setName(name);
        }

        String email = updatedStudent.getEmail();
        if (email != null && email.length() > 0)
            student.setEmail(email);

        LocalDate dob = updatedStudent.getDob();
        if (dob != null)
            student.setDob(dob);

    }

}

