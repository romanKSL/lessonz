package com.kyslyi.lessonz.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface LessonRepository extends ListCrudRepository<Lesson, Integer> {

	@Query("SELECT * FROM lesson WHERE minutes_duration >= :minutesDuration")
	List<Lesson> findAllByMinutesDuration(Integer minutesDuration);
	
}
