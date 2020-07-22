package com.epam.firstmavenproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.firstmavenproject.sweets.Chocolate;
import com.epam.firstmavenproject.sweets.Jelly;
import com.epam.firstmavenproject.sweets.Sweet;
import com.epam.firstmavenproject.sweets.Toffee;

public class Main {
    
    private static void putSweetsRandomly(Gift gift, String[] availableSweets) {
	Random randomSweet = new Random();
	Sweet sweet = null;
	boolean isSpaceLeft = true;
	do {
	    switch(availableSweets[randomSweet.nextInt(availableSweets.length)]) {
	    case "Jelly" : sweet = new Jelly();
	    break;
	    case "Chocolate" : sweet = new Chocolate();
	    break;
	    case "Toffee" : sweet = new Toffee();
	    break;
	    }
	    isSpaceLeft = gift.putSweet(sweet);
	} while(isSpaceLeft);
    }

    public static void main(String[] args) {
	List<Gift> gifts = new ArrayList<>();
	String[] availableSweets = new String[] {"Jelly", "Chocolate", "Toffee"};
	while(gifts.size() != 5) {
	    Gift gift = new Gift();
	    gifts.add(gift);
	    putSweetsRandomly(gift, availableSweets);
	}
	System.out.println("Sweets in the gifts before sorting:");
	gifts.forEach(gift -> {
	    System.out.println("\nGift Number: " + new Integer(gift.hashCode()).toString().substring(0, 4) + "\n");
	    gift.openGift().forEach(sweet -> System.out.println(sweet.getClass().getSimpleName()));
	    });
	System.out.println("Sweets in the gifts after sorting by price:");
	gifts.forEach(gift -> {
	    gift.sortByPrice();
	    System.out.println("\nGift Number: " + new Integer(gift.hashCode()).toString().substring(0, 4) + "\n");
	    gift.openGift().forEach(sweet -> System.out.println(sweet.getClass().getSimpleName()));
	    });
	System.out.println("Sweets in the gifts after sorting by weight:");
	gifts.forEach(gift -> {
	    gift.sortByWeight();
	    System.out.println("\nGift Number: " + new Integer(gift.hashCode()).toString().substring(0, 4) + "\n");
	    gift.openGift().forEach(sweet -> System.out.println(sweet.getClass().getSimpleName()));
	    });
    }

}
