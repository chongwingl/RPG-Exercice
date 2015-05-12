package com.project.rpg.models.items.material;

import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;


public abstract class AbstractMaterial extends AbstractItem {

    private static final long serialVersionUID = 86139421248075891L;

    private int mGatherTime;
	private Probability mProbabilityToFind;


    protected AbstractMaterial(String name, Probability probability) {
        super(name);
		mProbabilityToFind = probability;
    }

	public int getGatherTime() {
		return mGatherTime;
	}

	protected void setGatherTime(int mGatherTime) {
		this.mGatherTime = mGatherTime;
	}

    @Override
    protected void setItemType() {
        mItemType = ItemType.MATERIAL;
    }

}
