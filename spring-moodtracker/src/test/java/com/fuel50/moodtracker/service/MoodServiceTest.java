package com.fuel50.moodtracker.service;

import static org.junit.Assert.assertNotEquals;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fuel50.moodtracker.common.MoodEnum;
import com.fuel50.moodtracker.domain.MoodDO;

public class MoodServiceTest extends AbstractServiceTest {

	@Autowired
	private MoodService moodService;

	@Test
	public void testSaveMood() {
		MoodDO moodDo = new MoodDO();
		moodDo.setTrackDate(LocalDate.now().toString());
		moodDo.setMood(MoodEnum.GRUMPY.toString());
		moodDo.setMessage(null);
		moodService.saveMood(moodDo);
		assertNotEquals(0, moodDo.getId());
	}

}
