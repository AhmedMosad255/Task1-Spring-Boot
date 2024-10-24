package com.springboot.workspace.service;

import com.springboot.workspace.repository.TeacherRepository;
import com.springboot.workspace.teacher.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findById(id).orElse(null);
    }
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public Teacher updateTeacher(Integer id, Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher updatedTeacher = optionalTeacher.get();
            updatedTeacher.setName(teacher.getName());
            updatedTeacher.setSalary(teacher.getSalary());
            return teacherRepository.save(updatedTeacher);
        }
        return null;
    }
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }
}
