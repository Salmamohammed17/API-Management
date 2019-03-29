package com.mugesh.softwareag.Model.PostJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;


import com.mugesh.softwareag.Model.Policy.Policy;
import com.mugesh.softwareag.Model.Policy.Descriptions.Descriptions;
import com.mugesh.softwareag.Model.Policy.Name.Name;
import com.mugesh.softwareag.Model.Policy.policyEnforcements.policyEnforcements;
import com.mugesh.softwareag.Model.Policy.policyEnforcements.Enforcements.Enforcements;

public class PostJson {
	
	static Policy policy=new Policy();
	public static void main(String[] args) throws IOException {
		
		System.out.println(policy);
		
		policy.setId("f7d124c5-f377-4fb7-80ee-68254f30ddbe");
		
		Name name=new Name();
		name.setValue("Default Policy for API StudentAPI");
		name.setLocale("English");
		policy.names.add(name);
		
		Descriptions description=new Descriptions();
		description.setLocale("");
		description.setValue("English");
		policy.descriptions.add(description);
		
		policyEnforcements policyenforcement=new policyEnforcements();
		Enforcements enforce=new Enforcements();
		enforce.setEnforcementObjectId("90d4202a-3557-4769-8405-b0de80184144");
		enforce.setOrder(null);
		policyenforcement.enforcements.add(enforce);
		policyenforcement.setStageKey("routing");
		policy.policyEnforcements.add(policyenforcement);
		
		policy.setPolicyScope("SERVICE");
		policy.setActive(false);
		policy.setGlobal(false);
		policy.setSystemPolicy(false);
		PostJson.PostPayload();
	}

	public static void PostPayload() throws IOException {
		
		System.out.println(policy);

		URL url = new URL("http://localhost:5555/rest/apigateway/policies/f7d124c5-f377-4fb7-80ee-68254f30ddbe");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

		String name = "Administrator";
		String password = "manage";
		String authStr = name + ":" + password;
		String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());

		conn.setRequestProperty("Authorization", "Basic " + authEncoded);

		// String authString = name + ":" + password;

		OutputStream writer = conn.getOutputStream();
		System.out.println("working");
		writer.write(policy.getBytes());
		writer.flush();
		writer.close();

		int responseCode = conn.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode);
		System.out.println("POST Response Message : " + conn.getResponseMessage());
		if (responseCode == HttpURLConnection.HTTP_CREATED) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println(response.toString());
		} else {
			System.out.println("POST NOT WORKED");
		}

	}
}
