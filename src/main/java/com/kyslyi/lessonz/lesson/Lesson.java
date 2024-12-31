package com.kyslyi.lessonz.lesson;

import ch.qos.logback.core.util.InvocationGate;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Lesson(
        @Id
        Integer id,
        @NotEmpty
        String title,
        String subject,
        LocalDateTime startedOn,
        int minutesDuration,
        @Version
        Integer version
) {

    public Lesson {
        if(subject.isEmpty()) {
            throw new IllegalArgumentException("Subject must not be empty");
        }
    }

}
