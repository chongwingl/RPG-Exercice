package com.project.rpg.models.stores;

import android.content.Context;

import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.material.AbstractMaterial;
import com.project.rpg.models.items.weapons.AbstractWeapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmithStoreBuilder extends AbstractStoreBuilder {

    private static int WEAPONS_MAX_NUMBER = 20;
	private static int ARMORS_MAX_NUMBER = 20;
	private static int MATERIALS_MAX_NUMBER = 50;

	private List<AbstractWeapon> weapons = new ArrayList<>();
	private List<AbstractArmor> armors = new ArrayList<>();
	private List<AbstractMaterial> materials = new ArrayList<>();

    public SmithStoreBuilder(Context base) {
        super(base);
    }

	public boolean addWeapon(AbstractWeapon weapon){
		if(weapons.size() < WEAPONS_MAX_NUMBER){
			weapons.add(weapon);
			return true;
		}
		return false;
	}
	
	public boolean addArmor(AbstractArmor armor){
		if(armors.size() < ARMORS_MAX_NUMBER){
			armors.add(armor);
			return true;
		}
		return false;
	}
	
	public boolean addMaterial(AbstractMaterial material){
		if(materials.size() < MATERIALS_MAX_NUMBER){
			materials.add(material);
			return true;
		}
		return false;
	}
	
	public boolean removeWeapon(AbstractWeapon weapon){
		return weapons.remove(weapon);
	}
	
	public boolean removeArmor(AbstractArmor armor){
		return armors.remove(armor);
	}
	
	public boolean removeMaterial(AbstractMaterial material){
		return materials.remove(material);
	}
	
	public int getWeaponsNumber(){
		return weapons.size();
	}
	
	public int getArmorsNumber(){
		return armors.size();
	}
	
	public int getMaterialsNumber(){
		return materials.size();
	}

    @Override
    public AbstractItem buildItem(Class<?> clss) {
        return null;
    }

    @Override
    public HashMap<String, Class<?>> buildCategory(ItemType itemType) {
        return null;
    }
}
