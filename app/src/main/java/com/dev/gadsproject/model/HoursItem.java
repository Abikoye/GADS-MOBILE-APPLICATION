package com.dev.gadsproject.model;

import com.google.gson.annotations.SerializedName;

public class HoursItem{

	@SerializedName("country")
	private String country;

	@SerializedName("hours")
	private int hours;

	@SerializedName("badgeUrl")
	private String badgeUrl;

	@SerializedName("name")
	private String name;

	public String getCountry(){
		return country;
	}

	public int getHours(){
		return hours;
	}

	public String getBadgeUrl(){
		return badgeUrl;
	}

	public String getName(){
		return name;
	}
}