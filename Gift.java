package com.epam.firstmavenproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.firstmavenproject.comparators.PriceComparator;
import com.epam.firstmavenproject.comparators.WeightComparator;
import com.epam.firstmavenproject.sweets.Sweet;

public class Gift {
    
    private static final int MAX_WEIGHT = 1000;
    private int current_weight = 0;    
    private List<Sweet> sweets;
    private WeightComparator weightComparator;
    private PriceComparator priceComparator;
    
    public Gift() {
	sweets = new ArrayList<>();
	weightComparator = new WeightComparator();
	priceComparator = new PriceComparator();
    }
    
    public boolean putSweet(Sweet sweet) {
	if (MAX_WEIGHT - current_weight >= sweet.getWeight()) {
	    sweets.add(sweet);
	    current_weight += sweet.getWeight();
	    return true;
	}
	return false;
    }
    
    public int getTotalWeight() {
	return current_weight;
    }
    
    public List<Sweet> openGift() {
	return sweets;
    }
    
    public void sortByWeight() {
	Collections.sort(sweets, weightComparator);
    }
    
    public void sortByPrice() {
	Collections.sort(sweets, priceComparator);
    }

}
