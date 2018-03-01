package com.fuel50.moodtracker.dao;

import java.util.List;

import org.joda.time.LocalDate;

import com.fuel50.moodtracker.model.Mood;

public interface MoodDao {

	void saveMood(Mood mood);

	List<Mood> findByTrackDate(LocalDate now);

}
