package com.kyslyi.lessonz.lesson;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LessonNotFoundException extends RuntimeException {

    public LessonNotFoundException(Integer id) {
        super("Could not find run " + id);
    }
}
