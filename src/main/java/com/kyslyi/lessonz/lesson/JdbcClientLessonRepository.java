package com.kyslyi.lessonz.lesson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientLessonRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcClientLessonRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientLessonRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Lesson> findAll() {
        return jdbcClient.sql("SELECT * FROM lesson")
                .query(Lesson.class)
                .list();
    }

    public Optional<Lesson> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM lesson WHERE id = :id")
                .param("id", id)
                .query(Lesson.class)
                .optional();
    }

    public void create(Lesson lesson) {
        var updated = jdbcClient.sql("INSERT INTO Lesson(id, title, subject, started_on, minutes_duration) VALUES (?, ?, ?, ?, ?)")
                .params(List.of(lesson.id(), lesson.title(), lesson.subject(), lesson.startedOn(), lesson.minutesDuration()))
                .update();
        Assert.state(updated == 1, "Failed to create lesson " + lesson.title());
    }

    public void update(Lesson lesson, Integer id) {
        var updated = jdbcClient.sql("UPDATE lesson SET title = ?, subject = ?, started_on = ?, minutes_duration = ? WHERE id = ?")
                .params(List.of(lesson.title(), lesson.subject(), lesson.startedOn(), lesson.minutesDuration(), id))
                .update();
        Assert.state(updated == 1, "Failed to update lesson " + lesson.title());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM lesson WHERE id = :id")
                .param("id", id)
                .update();
        Assert.state(updated == 1, "Failed to delete lesson " + id);
    }

    public int count() {
        return jdbcClient.sql("SELECT * FROM lesson")
                .query().listOfRows().size();
    }

    public void saveAll(List<Lesson> lessons) {
        lessons.stream().forEach(this::create);
    }

    public List<Lesson> findLessonsBySubject(String subject) {
        return jdbcClient.sql("SELECT * FROM lesson WHERE subject = :subject")
                .param("subject", subject)
                .query(Lesson.class)
                .list();
    }
}
