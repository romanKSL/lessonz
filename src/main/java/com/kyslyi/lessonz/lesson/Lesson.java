package com.kyslyi.lessonz.lesson;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Lesson(
        Integer id,
        @NotEmpty
        String title,
        String subject,
        LocalDateTime startedOn,
        int minutesDuration
) {

    public Lesson {
        if(subject.isEmpty()) {
            throw new IllegalArgumentException("Subject must not be empty");
        }
    }

}
