package com.project.rpg.models.items.material;

import android.content.Context;

import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.AbstractItem;


public abstract class AbstractMaterial extends AbstractItem {
	
	private int mGatherTime;
	private Probability mProbabilityToFind;


    protected AbstractMaterial(Context context, int nameRefId, Probability probability) {
        super(context, nameRefId);
		mProbabilityToFind = probability;
    }

	public int getGatherTime() {
		return mGatherTime;
	}

	protected void setGatherTime(int mGatherTime) {
		this.mGatherTime = mGatherTime;
	}

}
