package com.fuel50.moodtracker.dao;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Test;

import com.fuel50.moodtracker.model.Mood;

public class MoodDaoTest extends AbstractDaoTest {

	@Test
	public void testSaveMood() {
		Mood mood = new Mood();
		mood.setTrackDate(LocalDate.now());
		mood.setMood("Happy");
		mood.setMessage(null);
		moodDao.saveMood(mood);
		assertNotEquals(0, mood.getId());
	}

	@Test
	public void testGetMoodOfDate() {
		List<Mood> moods = moodDao.findByTrackDate(LocalDate.now());
		assertNotNull(moods);
		assertTrue(moods.size() > 0);
	}

}
