package com.huchcode.restclientexample;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Sample {

	public Sample() {
		
	}
	
	public static void main( String args[] ) {

		Employee e = sample();
		System.out.println(e);
		
	}
	
	static Employee sample() {
		/* In the case of post */
		Map<String, String> vars = new HashMap<String, String>();
        vars.put("username", "gikimiad@gmail.com");
        vars.put("password", "PASSWORD_FOR_PARKYONGGYU");

        //final String url = "http://192.168.0.215:5000/";
        final String url = "http://localhost:8080/SpringRestExample/rest/emp/dummy";
        try {
            //final String url = "http://192.168.1.103:8080/SpringRestExample/rest/emp/dummy";
            //final String url = "http://10.0.1.6:8080/SpringRestExample/rest/emp/dummy";
            //final String url = "http://192.168.0.215:5000/login";
            //final String url = "http://192.168.0.215:5000/login";
            RestTemplate restTemplate = new RestTemplate();                
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            return restTemplate.getForObject(url, Employee.class);
            
            /* In the case of post */
            /*
            Employee e = new Employee();
            e.setId(1);
            e.setName("박용규");
            return restTemplate.postForObject(url, e, Employee.class, vars);
            */
            
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return null;
    }
	
}
