package com.fuel50.moodtracker;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@TestPropertySource(locations="classpath:test.properties")
public class AbstractTest {

}
