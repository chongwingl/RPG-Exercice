package com.project.rpg.models.characters.fighters;

import android.widget.Toast;

public class Knight extends AbstractFighter {

	public Knight() {
		super("Chevalier", 60, 20, 20, 20, 20);
	}
	
	public void attack(){
		Toast.makeText(null, getName() + " has attacked !", Toast.LENGTH_LONG).show();
	}

}
