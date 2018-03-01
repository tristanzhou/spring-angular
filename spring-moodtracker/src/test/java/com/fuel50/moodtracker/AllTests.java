package com.fuel50.moodtracker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fuel50.moodtracker.controller.MoodControllerTest;
import com.fuel50.moodtracker.dao.MoodDaoTest;
import com.fuel50.moodtracker.service.MoodServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ MoodControllerTest.class, MoodServiceTest.class, MoodDaoTest.class })
public class AllTests {

}
