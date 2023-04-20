package com.onkar.coinassignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CoinMgmt {
	List<Coin> list;
	File file;
	ObjectOutputStream oout=null;
	ObjectInputStream oin=null;
	
	public CoinMgmt() {
		list = new ArrayList<Coin>();
		file = new File("coin.txt");
	}

	public void addCoin() throws Exception {
		
		if(file.isFile())
		{
				oin = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<Coin>)oin.readObject();
				oin.close();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Country:");
		String country = sc.nextLine();
		System.out.println("Enter Denomination:");
		String denomination = sc.nextLine();
		System.out.println("Enter Year of minting:");
		int yearOfMinting = sc.nextInt();
		System.out.println("Enter Current value:");
		float currentValue = sc.nextFloat();
		System.out.println("Enter Acquired date(yyyy-mm-dd):");
		String ad;
		ad = sc.next();
		
		DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate acquiredDate=LocalDate.parse(ad, dateFormatter);
		
		list.add(new Coin(country, denomination, yearOfMinting, currentValue, acquiredDate));
		System.out.println("Coin added successfully");
		
		oout = new ObjectOutputStream(new FileOutputStream(file));
		oout.writeObject(list);
		oout.close();
		
	}
	
	public void displayCoin() throws Exception {
		
		if(file.isFile())
		{
			oin = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Coin>)oin.readObject();
			oin.close();
		
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.printf("%8s%17s%20s%20s%20s","Country name","Denomination","Year of minting","Current Value","Acquired Date\n");
			System.out.println("----------------------------------------------------------------------------------------");
			Iterator<Coin> itr = list.iterator();
			while(itr.hasNext())
			{
				Coin obj=itr.next();
				System.out.printf("%8s%17s%20s%20s%22s",obj.getCountry(),obj.getDenomination(),obj.getYearOfMinting(),obj.getCurrentValue(),obj.getAcquiredDate()+"\n");
			}
			System.out.println("----------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("File does not exists");
		}
	}
	
	//searching functions
	public void searchCountryDeno() throws Exception
	{
		if(file.isFile())
		{
			oin = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Coin>)oin.readObject();
			oin.close();
			
			boolean found=false;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter country name to be search:");
			String countryName= s.next();
			System.out.println("Enter Denomination to be search:");
			String deno=s.next();
			
			Iterator<Coin> itr = list.iterator();
			while(itr.hasNext())
			{
				Coin obj=itr.next();
				if(countryName.equals(obj.getCountry()) && deno.equals(obj.getDenomination()))
				{
					found = true;
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%8s%17s%20s%20s%20s","Country name","Denomination","Year of minting","Current Value","Acquired Date\n");
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%8s%17s%20s%20s%22s",obj.getCountry(),obj.getDenomination(),obj.getYearOfMinting(),obj.getCurrentValue(),obj.getAcquiredDate()+"\n");	
				}
			}
			System.out.println("----------------------------------------------------------------------------------------");
			if(!found)
			{
				System.out.println("No record found");
			}
		}
		else {
			System.out.println("File does not exists");
		}
	}
	
	public void searchCountryYearOFMinting() throws Exception
	{
		if(file.isFile())
		{
			oin = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Coin>)oin.readObject();
			oin.close();
			
			boolean found=false;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter country name to be search:");
			String countryName= s.next();
			System.out.println("Enter Year of minting to be search:");
			int mintYear=s.nextInt();
			
			Iterator<Coin> itr = list.iterator();
			while(itr.hasNext())
			{
				Coin obj=itr.next();
				if(countryName.equals(obj.getCountry()) && mintYear==obj.getYearOfMinting())
				{
					found = true;
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%8s%17s%20s%20s%20s","Country name","Denomination","Year of minting","Current Value","Acquired Date\n");
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%8s%17s%20s%20s%22s",obj.getCountry(),obj.getDenomination(),obj.getYearOfMinting(),obj.getCurrentValue(),obj.getAcquiredDate()+"\n");	
				}
			}
			System.out.println("----------------------------------------------------------------------------------------");
			if(!found)
			{
				System.out.println("No record found");
			}
		}
		else {
			System.out.println("File does not exists");
		}
	}
	
	public void searchCountryDenoYearOfMinting() throws Exception
	{
		if(file.isFile())
		{
			oin = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Coin>)oin.readObject();
			oin.close();
			
			boolean found=false;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter country name to be search:");
			String countryName= s.next();
			System.out.println("Enter Denomination to be search:");
			String deno=s.next();
			System.out.println("Enter Year of minting to be search:");
			int mintYear=s.nextInt();
			
			Iterator<Coin> itr = list.iterator();
			while(itr.hasNext())
			{
				Coin obj=itr.next();
				if(countryName.equals(obj.getCountry()) && deno.equals(obj.getDenomination()) && mintYear==obj.getYearOfMinting())
				{
					found = true;
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%8s%17s%20s%20s%20s","Country name","Denomination","Year of minting","Current Value","Acquired Date\n");
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%8s%17s%20s%20s%22s",obj.getCountry(),obj.getDenomination(),obj.getYearOfMinting(),obj.getCurrentValue(),obj.getAcquiredDate()+"\n");;	
				}
			}
			System.out.println("----------------------------------------------------------------------------------------");
			if(!found)
			{
				System.out.println("No record found");
			}
		}
		else {
			System.out.println("File does not exists");
		}
	}
	
	public void searchCountryAcquiredDate() throws Exception
	{
		if(file.isFile())
		{
			oin = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Coin>)oin.readObject();
			oin.close();
			
			boolean found=false;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter country name to be search:");
			String countryName= s.next();
			System.out.println("Enter Date to be search(yyyy-mm-dd):");
			String sd = s.next();
			
			DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate newDate=LocalDate.parse(sd, dateFormatter);
			
			Iterator<Coin> itr = list.iterator();
			while(itr.hasNext())
			{
				Coin obj=itr.next();
				if(countryName.equals(obj.getCountry()) && newDate.compareTo(obj.getAcquiredDate())==0)
				{
					found = true;
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%8s%17s%20s%20s%20s","Country name","Denomination","Year of minting","Current Value","Acquired Date\n");
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%8s%17s%20s%20s%22s",obj.getCountry(),obj.getDenomination(),obj.getYearOfMinting(),obj.getCurrentValue(),obj.getAcquiredDate()+"\n");	
				}
			}
			System.out.println("----------------------------------------------------------------------------------------");
			if(!found)
			{
				System.out.println("No record found");
			}
		}
		else {
			System.out.println("File does not exists");
		}
	}

	//listing functions
	public void listCountry() throws Exception 
	{
		if(file.isFile())
		{
			oin = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Coin>)oin.readObject();
			oin.close();
			
			List<Coin>sortedCountry=list.stream().sorted(Comparator.comparing(Coin::getCountry)).collect(Collectors.toList());
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.printf("%8s%17s%20s%20s%20s","Country name","Denomination","Year of minting","Current Value","Acquired Date\n");
			System.out.println("----------------------------------------------------------------------------------------");
			Iterator<Coin> itr = sortedCountry.iterator();
			while(itr.hasNext())
			{
				Coin obj=itr.next();
				System.out.printf("%8s%17s%20s%20s%22s",obj.getCountry(),obj.getDenomination(),obj.getYearOfMinting(),obj.getCurrentValue(),obj.getAcquiredDate()+"\n");
			}
			System.out.println("----------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("File does not exists");
		}
		
	}
	
	public void listYearOfMinting() throws Exception
	{
		if(file.isFile())
		{
			oin = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Coin>)oin.readObject();
			oin.close();
			
			List<Coin>sortedYearOfMinting=list.stream().sorted(Comparator.comparing(Coin::getYearOfMinting)).collect(Collectors.toList());
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.printf("%8s%17s%20s%20s%20s","Country name","Denomination","Year of minting","Current Value","Acquired Date\n");
			System.out.println("----------------------------------------------------------------------------------------");
			Iterator<Coin> itr = sortedYearOfMinting.iterator();
			while(itr.hasNext())
			{
				Coin obj=itr.next();
				System.out.printf("%8s%17s%20s%20s%22s",obj.getCountry(),obj.getDenomination(),obj.getYearOfMinting(),obj.getCurrentValue(),obj.getAcquiredDate()+"\n");
			}
			System.out.println("----------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("File does not exists");
		}
	}
	
	public void listCurrentValue() throws Exception
	{
		if(file.isFile())
		{
			oin = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Coin>)oin.readObject();
			oin.close();
			
			List<Coin>sortedCurrentValue=list.stream().sorted(Comparator.comparing(Coin::getCurrentValue)).collect(Collectors.toList());
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.printf("%8s%17s%20s%20s%20s","Country name","Denomination","Year of minting","Current Value","Acquired Date\n");
			System.out.println("----------------------------------------------------------------------------------------");
			Iterator<Coin> itr = sortedCurrentValue.iterator();
			while(itr.hasNext())
			{
				Coin obj=itr.next();
				System.out.printf("%8s%17s%20s%20s%22s",obj.getCountry(),obj.getDenomination(),obj.getYearOfMinting(),obj.getCurrentValue(),obj.getAcquiredDate()+"\n");
			}
			System.out.println("----------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("File does not exists");
		}
	}
	
}
