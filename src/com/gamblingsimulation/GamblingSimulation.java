package com.gamblingsimulation;

import java.util.Random;

public class GamblingSimulation {

	public static final int STAKE = 100;
	public static final int BET = 1;
	public static final float STAKE_VALUE = 0.5f;
	public int stake=100, loosingAmount, winningAmount, totalAmountEarned = 0;
	
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
	
	public int resignStake() {
		loosingAmount = (int)Math.round(STAKE * STAKE_VALUE);
		winningAmount = (int)Math.round(STAKE + (STAKE * STAKE_VALUE));
		boolean stop = true;
		stake = STAKE;
		while(stop == true) {
			winOrLoss();
			if(stake == loosingAmount) {
				stop = false;
			}
			if(stake == winningAmount){
				stop = false;
			}
		}
		return stake;
	}
	
	public int getTotalAmountWonOrLoss() {
        int day_stake=0;
        for(int day=0;day<=20;day++) {
            day_stake=resignStake();
            totalAmountEarned=totalAmountEarned+day_stake;
        }
        System.out.println("Total Amount Earned or Loss by Gambler at End of given period:- " + totalAmountEarned);
        return totalAmountEarned;
    }

	public static void main(String[] args) {
		System.out.println("*****WELCOME TO GAMBLING SIMULATION PROBLEM*****");
		GamblingSimulation gambling = new GamblingSimulation();
		gambling.getTotalAmountWonOrLoss();
	}
}
