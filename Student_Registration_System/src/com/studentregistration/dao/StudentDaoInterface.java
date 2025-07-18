package com.studentregistration.dao;

import com.studentregistration.model.Student;

public interface StudentDaoInterface {
    boolean insertStudent(Student s);
    boolean delete(int rollNum);
    boolean update(int rollNum, String update, int ch, Student s);
    void showAllStudent();
    boolean showStudentById(int rollNum);
}
