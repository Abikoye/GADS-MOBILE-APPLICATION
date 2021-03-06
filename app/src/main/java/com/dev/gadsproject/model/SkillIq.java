package com.dev.gadsproject.model;

import com.google.gson.annotations.SerializedName;

public class SkillIq{

	@SerializedName("score")
	private int score;

	@SerializedName("country")
	private String country;

	@SerializedName("badgeUrl")
	private String badgeUrl;

	@SerializedName("name")
	private String name;

	public int getScore(){
		return score;
	}

	public String getCountry(){
		return country;
	}

	public String getBadgeUrl(){
		return badgeUrl;
	}

	public String getName(){
		return name;
	}
}