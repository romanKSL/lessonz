package com.kyslyi.lessonz.lesson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class LessonJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(LessonJsonDataLoader.class);
    private final JdbcClientLessonRepository lessonRepository;
    private final ObjectMapper objectMapper;

    public LessonJsonDataLoader(JdbcClientLessonRepository lessonRepository, ObjectMapper objectMapper) {
        this.lessonRepository = lessonRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(lessonRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/lessons.json")) {
                Lessons allLessons = objectMapper.readValue(inputStream, Lessons.class);
                log.info("Reading {} lessons from JSON data and saving to a database.", allLessons.lessons().size());
                lessonRepository.saveAll(allLessons.lessons());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Lessons from JSON data because the collection contains data.");
        }
    }
}
