package com.fuel50.moodtracker.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fuel50.moodtracker.AbstractTest;
import com.fuel50.moodtracker.configuration.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public abstract class AbstractDaoTest extends AbstractTest {

	@Autowired
	protected MoodDao moodDao;

}
