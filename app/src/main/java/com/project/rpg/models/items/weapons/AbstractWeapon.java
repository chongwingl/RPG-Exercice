package com.project.rpg.models.items.weapons;

import android.content.Context;

import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.powers.AbstractPower;

public abstract class AbstractWeapon extends AbstractItem {

	private Strength mStrength; // en pourcentage
	private Strength mStrengthWhenBroken;
	private Accuracy mAccuracy; // en pourcentage
	private Accuracy mAccuracyWhenBroken;
	private int mNumberOfSharpening;
	private int mHitsBeforeSharpening;
	private AbstractPower mPower;

    protected AbstractWeapon(Context context, int nameRefId) {
        super(context, nameRefId);
    }

	public Strength getStrength() {
		return mStrength;
	}

	protected void setStrength(Strength strength) {
		this.mStrength = strength;
	}

	public Strength getStrengthWhenBroken() {
		return mStrengthWhenBroken;
	}

	protected void setStrengthWhenBroken(Strength strengthWhenBroken) {
		this.mStrengthWhenBroken = strengthWhenBroken;
	}

	public Accuracy getAccuracy() {
		return mAccuracy;
	}

	protected void setAccuracy(Accuracy accuracy) {
		this.mAccuracy = accuracy;
	}

	public Accuracy getmAccuracyWhenBroken() {
		return mAccuracyWhenBroken;
	}

	protected void setmAccuracyWhenBroken(Accuracy mAccuracyWhenBroken) {
		this.mAccuracyWhenBroken = mAccuracyWhenBroken;
	}

	public int getNumberOfSharpening() {
		return mNumberOfSharpening;
	}

	protected void setNumberOfSharpening(int numberOfSharpening) {
		this.mNumberOfSharpening = numberOfSharpening;
	}

	public int getmHitsBeforeSharpening() {
		return mHitsBeforeSharpening;
	}

	protected void setmHitsBeforeSharpening(int mHitsBeforeSharpening) {
		this.mHitsBeforeSharpening = mHitsBeforeSharpening;
	}

	public AbstractPower getmPower() {
		return mPower;
	}

	protected void setmPower(AbstractPower mPower) {
		this.mPower = mPower;
	}

}
