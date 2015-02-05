package com.test.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.test.model.Employee;

public class Client {

	public static void main(String[] args) throws Exception {
		RestTemplate restTemplate= new RestTemplate();
		
		Employee account= new Employee(new Long(123), "AAAA", "aaa@test.com", "Bangalore", "India");
		
		HttpEntity<Object> responseEntity=
				restTemplate.postForEntity("http://localhost:8080/01restbasics/employee/", account, null);
		
		HttpHeaders httpHeaders=responseEntity.getHeaders();
		System.out.println(httpHeaders);
		//Account account=restTemplate.getForObject("http://localhost:4444/01restbasics/accounts/{accnum}", Account.class, 1);
		//System.out.println("Name : "+account.getName());
		/*Accounts account=restTemplate.getForObject("http://localhost:5555/01restbasics/accounts/allwithheaders", 
				Accounts.class);*/
		
		/*ResponseEntity<Accounts> responseEntity=restTemplate.getForEntity("http://localhost:5555/01restbasics/accounts/allwithheaders", Accounts.class);
		
		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println(headers);
		
		Accounts accounts=responseEntity.getBody();*/
		//restTemplate.postForLocation("http://localhost:7070/01restbasics/accounts",new Account());
		
		//restTemplate.postForObject("http://localhost:7070/01restbasics/accounts", new Account(), Accounts.class);
		
		//restTemplate.postForEntity(url, request, responseType)
		
		
		//restTemplate.postfor
		/*ResponseEntity<Account> responseEntity= 
				restTemplate.getForEntity("http://localhost:7070/01restbasics/accounts/1", Account.class);
		
		Account account=responseEntity.getBody();
		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println("Headers : "+headers);
		*/
		/*Account account=restTemplate.getForObject("http://localhost:7070/01restbasics/accounts/{accnum}/{}", 
					Account.class,1 );*/
		//Account account=restTemplate.getForObject("http://localhost:7070/01restbasics/accounts/1", Account.class);
		//System.out.println("Name : "+account.getName());
		
	/*	Map<String , String> urlVariables= new HashMap<String, String>();
		urlVariables.put("id", "1");
		ResponseEntity<Account> responseEntity=
				restTemplate.
				getForEntity("http://localhost:7070/01restbasics/accounts/{id}", 
						Account.class,urlVariables);
		
		System.out.println(responseEntity.getBody().getName());*/
		
		/*ResponseEntity<Accounts> responseEntity=
				restTemplate.getForEntity(
						new URI("http://localhost:7070/01restbasics/accounts/allwithheaders"),
				Accounts.class);
		//restTemplate.getForEntity(url, responseType, urlVariables)
		
		Accounts accounts=responseEntity.getBody();
		for(Account account:accounts.getAccounts()){
			System.out.println(account.getName());
		}
		
		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println(headers);*/
		
		/*Account account=restTemplate.getForObject(
				new URI("http://localhost:7070/01restbasics/accounts/1"), Account.class);

		System.out.println(account.getName());*/
	}

}
