package com.fuel50.moodtracker.service;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuel50.moodtracker.dao.MoodDao;
import com.fuel50.moodtracker.domain.MoodDO;
import com.fuel50.moodtracker.model.Mood;

@Service("moodService")
@Transactional
public class MoodServiceImpl implements MoodService {

	@Autowired
	private MoodDao moodDao;

	@Override
	public void saveMood(MoodDO moodDo) {
		Mood mood = new Mood();
		mood.setTrackDate(LocalDate.parse(moodDo.getTrackDate()));
		mood.setMood(moodDo.getMood());
		mood.setMessage(moodDo.getMessage());
		moodDao.saveMood(mood);
		moodDo.setId(mood.getId());
	}

	@Override
	public List<Mood> getMoodOfDate(LocalDate now) {
		return moodDao.findByTrackDate(now);
	}
	
	public static void main(String[] args) {
		System.out.println(LocalDate.parse("2018-02-23"));
	}

}
