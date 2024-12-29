package com.kyslyi.lessonz.lesson;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonRepository lessonRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping("")
    List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @GetMapping("/{id}")
    Lesson findById(@PathVariable Integer id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        if(lesson.isPresent()) {
            return lesson.get();
        } else {
            throw new LessonNotFoundException(id);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Lesson lesson) {
        lessonRepository.create(lesson);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Lesson lesson, @PathVariable Integer id) {
        lessonRepository.update(lesson, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        lessonRepository.delete(id);
    }
}
