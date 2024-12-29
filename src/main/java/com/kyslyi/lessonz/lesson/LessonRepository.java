package com.kyslyi.lessonz.lesson;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LessonRepository {

    private List<Lesson> lessons = new ArrayList<>();

    List<Lesson> findAll() {
        return lessons;
    }

    Optional<Lesson> findById(Integer id) {
        return lessons.stream()
                .filter(lesson -> lesson.id().equals(id))
                .findFirst();
    }

    void create(Lesson lesson) {
        lessons.add(lesson);
    }

    void update(Lesson lesson, Integer id) {
        Optional<Lesson> existingLesson = findById(id);
        if(existingLesson.isPresent()) {
            lessons.set(lessons.indexOf(existingLesson.get()), lesson);
        }
    }

    void delete(Integer id) {
        lessons.removeIf(lesson -> lesson.id().equals(id));
    }

    @PostConstruct
    private void init() {
        lessons.add(new Lesson(1,
                "Main method",
                "Java",
                LocalDateTime.of(2024, 12, 22, 15, 0),
                Duration.ofHours(1)));
        lessons.add(new Lesson(2,
                "Constructors",
                "Java",
                LocalDateTime.of(2024, 12, 24, 16, 0),
                Duration.ofHours(2)));
    }
}
