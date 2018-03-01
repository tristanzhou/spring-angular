package com.fuel50.moodtracker.controller;

import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuel50.moodtracker.domain.MoodDO;
import com.fuel50.moodtracker.model.Mood;
import com.fuel50.moodtracker.response.Result;
import com.fuel50.moodtracker.service.MoodService;

@CrossOrigin
@Controller
public class MoodController {

	private static Logger LOGGER = LoggerFactory.getLogger(MoodController.class);

	@Autowired
	MoodService moodService;

	@GetMapping("/moods")
	@ResponseBody
	public ResponseEntity<Result> listMoods() {
		try {
			List<Mood> moodsOfToday = moodService.getMoodOfDate(LocalDate.now());
			return ResponseEntity.ok().body(new Result(true, moodsOfToday, null));
		} catch (Exception exp) {
			LOGGER.error("failed to get moods of today", exp);
			return ResponseEntity.ok().body(new Result(false, null, "failed to get moods of today"));
		}
	}

	@PostMapping("/moods")
	@ResponseBody
	public ResponseEntity<Result> saveMood(@ModelAttribute("moodRequest") MoodDO moodDo) {
		try {
			this.moodService.saveMood(moodDo);
			return ResponseEntity.ok().body(new Result(true, moodDo, null));
		} catch (Exception exp) {
			LOGGER.error("failed to create a mood", exp);
			return ResponseEntity.ok().body(new Result(false, null, "failed to create a mood"));
		}
	}

}
