package com.onkar.coinassignment;

import com.onkar.coinassignment.exception.InvalidChoiceException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MainApp app = new MainApp();
		app.welcomemsg();
		app.execute();
	}

	private void welcomemsg() {
		System.out.println("This is Coin Management Application");
	}

	private void execute() throws Exception {
		int choice = 0;
		CoinMgmt cm = new CoinMgmt();
		while (choice != 5) {
			
			choice = acceptChoice();
			makeChoice(choice,cm);	
		}
	}

	private void makeChoice(int choice, CoinMgmt cm) throws Exception { 
		
		switch (choice) {

		case 1:
			cm.addCoin();
			break;
		case 2: 
			cm.displayCoin();
			break;
		case 3:
		{
			int ch=0;
			while(ch!=5)
			{
				ch=searchChoice();
				switch(ch)
				{
				case 1: 
					cm.searchCountryDeno();
					break;
				case 2: 
					cm.searchCountryYearOFMinting();
					break;
				case 3: 
					cm.searchCountryDenoYearOfMinting();
					break;
				case 4: 
					cm.searchCountryAcquiredDate();
					break;
				default:
				}
			}
		}
			break;
		case 4:
		{
			int chList=0;
			while(chList!=4)
			{
				chList=listChoice();
				switch(chList)
				{
				case 1: 
					cm.listCountry();;
					break;
				case 2: 
					cm.listYearOfMinting();;
					break;
				case 3: 
					cm.listCurrentValue();;
					break;
				default:
				}
			}
		}
			break;
		default:
			System.out.println("Exit");
		}

	}
	 
	private int listChoice() {
		// TODO Auto-generated method stub
		int chList=0;
		boolean listAnswer=false;
		while (listAnswer == false) {
			try {
				System.out.println("\nList coin based on following parameters");
				System.out.println("Choose one of the following");
				System.out.println("1. List by Country");
				System.out.println("2. List by Year of minting");
				System.out.println("3. List by Current value");
				System.out.println("4. Main menu\n");

				Scanner sc = new Scanner(System.in);
				chList = sc.nextInt();

				if (chList < 1 || chList > 4) {
					throw new InvalidChoiceException("Your choice is unknown, try again\n");
				}
				listAnswer = true;
			} catch (InputMismatchException ime) {
				System.out.println("Wrong datatype, only numbers are allowed\n");
			} catch (InvalidChoiceException ice) {
				// TODO Auto-generated catch block
				System.out.println(ice.getMessage());
			}
		}
		return chList;
	}

	private int searchChoice() {
		// TODO Auto-generated method stub
		int ch=0;
		boolean searchAnswer=false;
		while (searchAnswer == false) {
			try {
				System.out.println("\nSearch coin based on following parameters");
				System.out.println("Choose one of the following to search");
				System.out.println("1. Country and  Denomination");
				System.out.println("2. Country and Year of Minting");
				System.out.println("3. Country, Denomination and Year of Minting");
				System.out.println("4. Country and Acquired Date");
				System.out.println("5. Main Menu\n");

				Scanner sc = new Scanner(System.in);
				ch = sc.nextInt();

				if (ch < 1 || ch > 5) {
					throw new InvalidChoiceException("Your choice is unknown, try again\n");
				}
				searchAnswer = true;
			} catch (InputMismatchException ime) {
				System.out.println("Wrong datatype, only numbers are allowed\n");
			} catch (InvalidChoiceException ice) {
				// TODO Auto-generated catch block
				System.out.println(ice.getMessage());
			}
		}
		return ch;
	}

	private int acceptChoice() {
		int choice = 0;
		boolean answer = false;
		while (answer == false) {
			try {
				System.out.println("Choose one of the following");
				System.out.println("1. Add coin");
				System.out.println("2. Display");
				System.out.println("3. Search coin");
				System.out.println("4. List coin");
				System.out.println("5. Exit");

				Scanner sc = new Scanner(System.in);
				choice = sc.nextInt();

				if (choice < 1 || choice > 5) {
					throw new InvalidChoiceException("Your choice is unknown, try again\n");
				}
				answer = true;
			} catch (InputMismatchException ime) {
				System.out.println("Wrong datatype, only numbers are allowed\n");
			} catch (InvalidChoiceException ice) {
				// TODO Auto-generated catch block
				System.out.println(ice.getMessage());
			}
		}
		return choice;
	}

}
