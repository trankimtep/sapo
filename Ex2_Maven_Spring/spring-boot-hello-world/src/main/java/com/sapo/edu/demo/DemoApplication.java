package com.sapo.edu.demo;
//import
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Menu: ");
		System.out.println("1: Su dung method 'containsAny'");
		System.out.println("2: Su dung method 'containsIgnoreCase'");
		System.out.println("3: Su dung method 'countMatches'");
		System.out.println("4: Su dung method 'appendIfMissing'");
		System.out.println("5: Su dung method 'prependIfMissing'");
		System.out.println("6: Su dung method 'uppercase'");
		System.out.println("7: Su dung method 'lowercase'");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter an input string:");
		String name=null;
		if (scanner.hasNext()) {
			name = scanner.nextLine();
		}
		System.out.println("Enter an input option:");
		Scanner sc = new Scanner(System.in);
		int options = sc.nextInt();
		switch(options){
			case 1:
				String searchString = "ABC";
				if (StringUtils.containsAny(name, searchString)==false){
					System.out.println("The name " + name + " doesn't contain any character of " + searchString);
				}
				else{
					System.out.print("The name " + name + " contain some of character of '" + searchString + "'");
				}
				break;
			case 2:
				String searchString2 = "ABC";
				if (StringUtils.containsAnyIgnoreCase(name, searchString2)==true){
					System.out.println("The name " + name + " contain '" + searchString2 + "'");
				}
				else{
					System.out.println("The name " + name + " doesn't contain '" + searchString2 + "'");
				}
				break;
			case 3:
				char charToBeCounted = 'e';
				System.out.println(charToBeCounted + " is present " + StringUtils.countMatches(name, charToBeCounted) + " times in '" + name + "'");
				break;
			case 4:
				String suffix = "deptrai";
				System.out.println(StringUtils.appendIfMissing(name, suffix));	
				break;
			case 5:
				String suffix2 = "deptrai";
				System.out.println(StringUtils.prependIfMissing(name, suffix2));		
				break;
			case 6:
				System.out.println(StringUtils.upperCase(name));
				break;
			case 7:
				System.out.println(StringUtils.lowerCase(name));
				break;

		}
		scanner.close();
		sc.close();
	}
}
