package com.project.rpg.engine.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laetitia on 7/16/15.
 */
public class Equipment {

    private List<Item> mEquipments;
    private List<String> mSlots;

    public Equipment() {
        mEquipments = new ArrayList<>();
        mSlots = new ArrayList<>();
    }

    public List<Item> getEquipment() {
        return mEquipments;
    }

    public void addEquipment(Item equipment) {
        String slot = equipment.getSlot();
        if (mSlots.contains(slot)) {
            for (Item item : mEquipments) {
                if (item.getSlot().equals(slot)) {
                    removeEquipement(item);
                    break;
                }
            }
        }
        mSlots.add(slot);
        mEquipments.add(equipment);
    }

    public void removeEquipement(Item equipment) {

        if (mEquipments.contains(equipment)) {
            int position = mEquipments.indexOf(equipment);
            mEquipments.remove(position);
            position = mSlots.indexOf(equipment.getSlot());
            mSlots.remove(position);
        } else {
            // TODO throw no such item exception
        }
    }
}
