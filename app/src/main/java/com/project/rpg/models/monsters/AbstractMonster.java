package com.project.rpg.models.monsters;

import android.widget.Toast;

import com.project.rpg.models.Stat;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.powers.AbstractPower;

public abstract class AbstractMonster extends AbstractCharacter {

	private AbstractPower power;
	private Stat stat;

	public AbstractMonster(String name, int maxLifePoints, int strength,
			int speed, int accuracy, int resistance) {
		super(name);
		stat = new Stat(maxLifePoints, strength, speed, accuracy, resistance);
	}

	public AbstractPower getPower() {
		return power;
	}

	protected void setPower(AbstractPower power) {
		this.power = power;
	}
	
	public Stat getStat(){
		return stat;
	}
	
	public void attack(){
		Toast.makeText(null, getName() + " has attacked !", Toast.LENGTH_LONG).show();
	}
}
