package com.fuel50.moodtracker.service;

import java.util.List;

import org.joda.time.LocalDate;

import com.fuel50.moodtracker.domain.MoodDO;
import com.fuel50.moodtracker.model.Mood;

public interface MoodService {

	void saveMood(MoodDO moodDo);

	List<Mood> getMoodOfDate(LocalDate now);

}
