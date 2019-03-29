package com.mugesh.softwareag.Model.Policy;

import java.util.ArrayList;

import com.mugesh.softwareag.Model.Policy.Descriptions.Descriptions;
import com.mugesh.softwareag.Model.Policy.Name.Name;
import com.mugesh.softwareag.Model.Policy.Scope.Scope;
import com.mugesh.softwareag.Model.Policy.policyEnforcements.policyEnforcements;

public class Policy {
	private String id;
	public ArrayList<Name> names = new ArrayList<>();
	public ArrayList<Descriptions> descriptions = new ArrayList<>();
	Scope ScopeObject;
	public ArrayList<policyEnforcements> policyEnforcements = new ArrayList<>();
	private String policyScope;
	private boolean active;
	private boolean global;
	private boolean systemPolicy;

	public String getId() {
		return id;
	}

	public Scope getScope() {
		return ScopeObject;
	}

	public String getPolicyScope() {
		return policyScope;
	}

	public boolean getActive() {
		return active;
	}

	public boolean getGlobal() {
		return global;
	}

	public boolean getSystemPolicy() {
		return systemPolicy;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setScope(Scope scopeObject) {
		this.ScopeObject = scopeObject;
	}

	public void setPolicyScope(String policyScope) {
		this.policyScope = policyScope;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	public void setSystemPolicy(boolean systemPolicy) {
		this.systemPolicy = systemPolicy;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public void setNames(ArrayList<Name> names) {
		this.names = names;
	}
}


