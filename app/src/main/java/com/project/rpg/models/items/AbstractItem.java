package com.project.rpg.models.items;

import android.content.Context;
import android.content.ContextWrapper;

import com.project.rpg.models.enumerations.Weight;

public abstract class AbstractItem extends ContextWrapper {
	
	private String mName;
	private int price;
	private Weight weight; // used for calculate the speed of the knight( lighter
	// -> faster)


    public AbstractItem(Context context, int nameRefId) {
        super(context);
        mName = context.getString(nameRefId);
    }
	
	public String getName() {
		return mName;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public Weight getWeight() {
		return weight;
	}

	protected void setWeight(Weight weight) {
		this.weight = weight;
	}

    @Override
    public String toString() {
        return mName;
    }
}
