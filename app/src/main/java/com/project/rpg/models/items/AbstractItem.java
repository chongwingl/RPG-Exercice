package com.project.rpg.models.items;

import android.content.Context;

import com.project.rpg.fragments.dialogs.UseItemDialogFragment;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.enumerations.Weight;

import java.io.Serializable;

public abstract class AbstractItem implements Serializable {

    private static final long serialVersionUID = 7993915847142984426L;

    private String mName;
	private int price;
	private Weight weight; // used for calculate the speed of the knight( lighter
	// -> faster)
    protected ItemType mItemType;


    public AbstractItem(String name) {
        mName = name;
        setItemType();
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

    public ItemType getItemType() {
        return mItemType;
    }

    protected abstract void setItemType();

    public abstract void use(AbstractCharacter character);

	public abstract UseItemDialogFragment getUseItemDialogFragment(Context context);
}
