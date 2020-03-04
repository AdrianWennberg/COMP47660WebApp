package com.ed.webapp.exception;

import com.ed.webapp.model.Student;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(long student_id) {
        super(String.format("Book not found with id: %s", student_id));

    }
    public StudentNotFoundException(String student_username) {
        super(String.format("Book not found with id: %s", student_username));

    }
}
