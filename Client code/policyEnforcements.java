package com.mugesh.softwareag.Model.Policy.policyEnforcements;

import java.util.ArrayList;

import com.mugesh.softwareag.Model.Policy.policyEnforcements.Enforcements.Enforcements;

public class policyEnforcements {

	public ArrayList<Enforcements>enforcements=new ArrayList<>();
	private String stageKey;
	public String getStageKey() {
		return stageKey;
	}
	public void setStageKey(String stageKey) {
		this.stageKey = stageKey;
	}
}
