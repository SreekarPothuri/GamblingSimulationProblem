package com.gamblingsimulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GamblingSimulation {

	public static final int STAKE = 100;
	public static final int BET = 1;
	public static final float STAKE_VALUE = 0.5f;
	public static int stake=100;
	public int loosingAmount;
	public int winningAmount;
	public int totalAmountEarned = 0;
	public int LostDays=0,WonDays=0;
	
	public String winOrLoss() {
		Random random = new Random();
		int value = random.nextInt(2);
		if(value == 1) {
			stake++;
			return "won the game";
		}else {
			stake--;
			return "lost the game";
		}
	}
	
	public Integer resignStake(int day) {
		loosingAmount = (int)Math.round(STAKE * STAKE_VALUE);
		winningAmount = (int)Math.round(STAKE + (STAKE * STAKE_VALUE));
		boolean stop = true;
		stake = STAKE;
		while(stop == true) {
			winOrLoss();
			if(stake == loosingAmount) {
				LostDays++;
				stop = false;
			}
			if(stake == winningAmount){
				WonDays++;
				stop = false;
			}
		}
		return stake;
	}
	
	public int getTotalAmountWonOrLoss() {
        int day_stake=0;
        for(int day=1;day<=20;day++) {
            day_stake=resignStake(day);
            System.out.println("Day: "+day+" amount: "+day_stake);
            totalAmountEarned=totalAmountEarned+day_stake;
        }
        System.out.println("Total Amount Earned or Loss by Gambler at End of given period:- " + totalAmountEarned);
        return totalAmountEarned;
    }
	
	public int calculateForMonth() {
        getTotalAmountWonOrLoss();
        System.out.println("Days Won in  month: "+WonDays);
        System.out.println("Days Loss in  month: "+LostDays);
        return totalAmountEarned;
    }
	
	public void maximumMinimumEarnedDays() {
		ArrayList<Integer> day_stake = new ArrayList<Integer>();
		for(int day=1;day<=20;day++) {
            day_stake.add(resignStake(day));
        }
		Collections.sort(day_stake);
		int size = day_stake.size();
		System.out.println("The luckiest day with maximum earnings: "+day_stake.get(size-1));
		System.out.println("The unluckiest day with minimum earnings: "+day_stake.get(0));
	}
	
	public void continuePlaying() {
		String result = winOrLoss();
		Scanner sc = new Scanner(System.in);
		if (result.contains("won"))
		{
			System.out.println("if you want to continue...Choose Y/N");
			char res = sc.next().charAt(0);
			if(res == ('Y' | 'y')) {
				System.out.println("Continue for next month");
				play();
			}else if(res == ('N' | 'n')){
				System.out.println("Thank you for playing");
			}else {
				System.out.println("Please enter right choice");
			}
		}
	}
	
	public void play() {
		winOrLoss();
		resignStake(20);
		getTotalAmountWonOrLoss();
		calculateForMonth();
		maximumMinimumEarnedDays();
		continuePlaying();
	}
	
	public static void main(String[] args) {
		System.out.println("*****WELCOME TO GAMBLING SIMULATION PROBLEM*****");
		GamblingSimulation gambling = new GamblingSimulation();
		gambling.play();
	}
}
