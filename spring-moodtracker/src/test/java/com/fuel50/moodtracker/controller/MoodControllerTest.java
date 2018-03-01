package com.fuel50.moodtracker.controller;

import static org.hamcrest.core.IsNot.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.apache.commons.text.RandomStringGenerator;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fuel50.moodtracker.common.MoodEnum;
import com.fuel50.moodtracker.domain.MoodDO;

public class MoodControllerTest extends AbstractControllerTest {

	@Test
	public void testSaveMood() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add(MoodDO.TRACK_DATE, LocalDate.now().toString());
		params.add(MoodDO.MOOD, MoodEnum.GRUMPY.name());
		params.add(MoodDO.MESSAGE, null);
		mvc.perform(post("/moods").params(params)).andExpect(status().isOk())
				.andExpect(jsonPath("$.success").value(true)).andExpect(jsonPath("$.payload." + MoodDO.ID, not(0)))
				.andExpect(jsonPath("$.payload." + MoodDO.TRACK_DATE).value(LocalDate.now().toString()))
				.andExpect(jsonPath("$.payload." + MoodDO.MOOD).value(MoodEnum.GRUMPY.name()))
				.andExpect(jsonPath("$.payload." + MoodDO.MESSAGE).isEmpty());
	}

	@Test
	public void testSaveMoodWithError() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add(MoodDO.TRACK_DATE, LocalDate.now().toString());
		params.add(MoodDO.MESSAGE, null);
		mvc.perform(post("/moods").params(params)).andExpect(status().isOk())
				.andExpect(jsonPath("$.success").value(false)).andExpect(jsonPath("$.error").isString());
	}

	@Test
	public void testSaveMoodWithLongMessage() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add(MoodDO.TRACK_DATE, LocalDate.now().toString());
		params.add(MoodDO.MOOD, MoodEnum.GRUMPY.name());
		params.add(MoodDO.MESSAGE, new RandomStringGenerator.Builder().withinRange('a', 'z').build().generate(350));
		mvc.perform(post("/moods").params(params)).andExpect(status().isOk())
				.andExpect(jsonPath("$.success").value(true)).andExpect(jsonPath("$.payload." + MoodDO.ID, not(0)))
				.andExpect(jsonPath("$.payload." + MoodDO.TRACK_DATE).value(LocalDate.now().toString()))
				.andExpect(jsonPath("$.payload." + MoodDO.MOOD).value(MoodEnum.GRUMPY.name()))
				.andExpect(jsonPath("$.payload." + MoodDO.MESSAGE).value(params.getFirst(MoodDO.MESSAGE)));

		params.set(MoodDO.MESSAGE, new RandomStringGenerator.Builder().withinRange('a', 'z').build().generate(351));
		mvc.perform(post("/moods").params(params)).andExpect(status().isOk())
				.andExpect(jsonPath("$.success").value(false)).andExpect(jsonPath("$.error").isString());
	}

	@Test
	public void testGetMoodsOfToday() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add(MoodDO.TRACK_DATE, LocalDate.now().toString());
		params.add(MoodDO.MOOD, MoodEnum.GRUMPY.name());
		params.add(MoodDO.MESSAGE, null);
		mvc.perform(post("/moods").params(params)).andExpect(status().isOk())
				.andExpect(jsonPath("$.success").value(true)).andExpect(jsonPath("$.payload." + MoodDO.ID, not(0)))
				.andExpect(jsonPath("$.payload." + MoodDO.TRACK_DATE).value(LocalDate.now().toString()))
				.andExpect(jsonPath("$.payload." + MoodDO.MOOD).value(MoodEnum.GRUMPY.name()))
				.andExpect(jsonPath("$.payload." + MoodDO.MESSAGE).isEmpty());

		mvc.perform(get("/moods")).andExpect(status().isOk()).andExpect(jsonPath("$.success").value(true))
				.andExpect(jsonPath("$.payload").isNotEmpty());
	}

}
