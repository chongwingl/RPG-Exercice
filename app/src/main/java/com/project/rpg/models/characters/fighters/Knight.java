package com.project.rpg.models.characters.fighters;

import android.widget.Toast;

import com.project.rpg.models.enumerations.CharacterType;

public class Knight extends AbstractFighter {

    private static final long serialVersionUID = -4324249331855726182L;
    private static Knight knight;

	private Knight(String name) {
		super(CharacterType.KNIGHT, name, 100, 20, 20, 20, 20);
	}

    public static Knight getKnight(String name) {
        if (knight == null) {
            knight = new Knight(name);
        }
        return knight;
    }

	public void attack(){
		Toast.makeText(null, getName() + " has attacked !", Toast.LENGTH_LONG).show();
	}

}
