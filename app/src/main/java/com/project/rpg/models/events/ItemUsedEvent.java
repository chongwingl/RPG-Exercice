package com.project.rpg.models.events;

/**
 * Created by laetitia on 6/30/15.
 */
public class ItemUsedEvent {

    private final String mName;

    public ItemUsedEvent(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
