package com.kyslyi.lessonz.lesson;

import jakarta.validation.constraints.NotEmpty;

import java.time.Duration;
import java.time.LocalDateTime;

public record Lesson(
        Integer id,
        @NotEmpty
        String title,
        String subject,
        LocalDateTime startedOn,
        Duration duration
) {

    public Lesson {
        if(subject.isEmpty()) {
            throw new IllegalArgumentException("Subject must not be empty");
        }
    }

}
