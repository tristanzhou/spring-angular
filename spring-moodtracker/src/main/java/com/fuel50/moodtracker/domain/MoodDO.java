package com.fuel50.moodtracker.domain;

public class MoodDO {

	public static final String ID = "id";
	public static final String TRACK_DATE = "trackDate";
	public static final String MOOD = "mood";
	public static final String MESSAGE = "message";

	private int id;
	private String trackDate;
	private String mood;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrackDate() {
		return trackDate;
	}

	public void setTrackDate(String trackDate) {
		this.trackDate = trackDate;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
