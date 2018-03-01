package com.fuel50.moodtracker.response;

public class Result {

	private boolean success;
	private Object payload;
	private Object error;

	public Result(boolean success, Object payload, Object error) {
		this.success = success;
		this.payload = payload;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

}
