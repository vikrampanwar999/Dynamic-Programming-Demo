package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Amarendra {

	public static void main(String[] args) {
	
		List<Employee> list=Arrays.asList(new Employee(100,"Dean","ME","Bangalore",75000,96),
										  new Employee(101,"Micheal","IT","Bangalore",95000,100),
										  new Employee(102,"Christopher","IT","Mysore",120000,110),
										  new Employee(103,"Sam","ME","Bangalore",55000,105),
										  new Employee(104,"John","IT","Mysore",80000,70),
										  new Employee(105,"Philip","IT","Bangalore",55000,25),
										  new Employee(106,"Johnson","ME","Mysore",12000,10),
										  new Employee(107,"Carl","EC","Cochin",25000,10),
										  new Employee(108,"Sam","EC","Cochin",95000,75),
										  new Employee(109,"Vincent","ME","Mysore",50000,40),
										  new Employee(110,"Theon","IT","Cochin",85000,50),
										  new Employee(111,"Ned","ME","mysore",40000,40),
										  new Employee(112,"Robert","EC","Cochin",95000,35)
										  );
		Map<String, Double> avgSalaryByDepartment =list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingLong(Employee::getSalary)));
		System.out.println(avgSalaryByDepartment);
		//Map<String, Object> highestSalaryByLocation=list.stream().collect(Collectors.groupingBy(Employee::getOfficeLocation,Collectors.collectingAndThen(Collectors.averagingLong(Employee::getSalary), o->{System.out.println(o);list.stream().collect(Collectors.groupingBy(Employee::getOfficeLocation,Collectors.averagingInt(Employee::getExperience))).get();return o;})));
		List<Employee> listcopy=new ArrayList<>();
		for(Employee e:list) {Employee ne=new Employee(e.getId(),e.getName(),e.getDepartment(),e.getOfficeLocation(),e.getSalary(),e.getExperience());listcopy.add(ne);}
		Map<String, Double> highestSalaryByLocation=listcopy.stream().peek(t->t.setSalary(t.getSalary()/t.getExperience())).collect(Collectors.groupingBy(Employee::getOfficeLocation,Collectors.averagingLong(Employee::getSalary)));

		System.out.println(highestSalaryByLocation);
		long sum=list.stream().mapToLong(o->o.getSalary()).reduce(Long::sum).getAsLong();
		System.out.println(sum);
		String empWithMinSalary=list.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getSalary))).map(o->o.getName()).get();
		System.out.println(empWithMinSalary);
		String empWithMaxSalary=list.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).map(o->o.getName()).get();
		System.out.println(empWithMaxSalary);
		//emploees with salary greater than 60000
			//Map<String,Long>emp60=list.stream().collect(Collectors.toMap(y->y.getSalary()>=60000?y.getName():"", y->y.getSalary()));
			//System.out.println(emp60);
			list.stream().forEach(t->{if(t.getSalary()>=60000)System.out.println("salary 60+ "+t.getName());});
			list.stream().peek(t->{if(t.getSalary()>=100000)System.out.println("salary 100+ "+t.getName());}).count();
			//if there is an emp with 150+
			boolean is150 =list.stream().anyMatch(t->t.getSalary()>=150000);
			System.out.println("is there any emp with 150+ salary ?"+is150);
			//first emp with salary greater than 55k
			Employee e55=list.stream().filter(t->t.getSalary()>=55000).findFirst().get();
			System.out.println("first  emp with 55+ salary ?"+e55.getName());
			
			//displaying firstcharacter of eachlocation in uppercase
			list.stream().map(t->t.getOfficeLocation()).map(t->String.valueOf(Character.toUpperCase(t.charAt(0))+t.substring(1))).forEach(System.out::println);;
			
	}

}
