package com.gamblingsimulation;

import java.util.Random;

public class GamblingSimulation {

	public static final int STAKE = 100;
	public static final int BET = 1;
	public int stake=100;
	
	public int winOrLoss() {
		Random random = new Random();
		int value = random.nextInt(2);
		if(value == 1) {
			System.out.println("***GAMBLER WON***");
			stake++;
		}else {
			System.out.println("***GAMBLER LOST***");
			stake--;
		}
		return stake;
	}
	

	public static void main(String[] args) {
		System.out.println("*****WELCOME TO GAMBLING SIMULATION PROBLEM*****");
		GamblingSimulation gambling = new GamblingSimulation();
		System.out.println("Remaining Stake: "+gambling.winOrLoss());
	}
}
