package com.project.rpg.engine.model;

import com.project.rpg.exceptions.NoMoreLifeException;

/**
 * Created by laetitia on 7/13/15.
 */
public class Life {
    private int mLife;
    private int MAX_LIFE;

    public Life() {
        MAX_LIFE = 0;
        mLife = 0;
    }

    public Life(int maxLife) {
        MAX_LIFE = maxLife;
        mLife = maxLife;
    }

    public void initMaxLife(int maxLife) {
        MAX_LIFE = maxLife;
        setLife(maxLife);
    }

    public void setMaxLife(int maxLife) {
        MAX_LIFE = maxLife;
    }

    public void setLife(int life) {
        mLife = life;
    }

    public int getMaxLife() {
        return MAX_LIFE;
    }

    public int getLife() {
        return mLife;
    }

    public void addLife(int life) {
        this.mLife += life;
        if (this.mLife > MAX_LIFE) {
            this.mLife = MAX_LIFE;
        }
    }

    public void removeLife(int life) throws NoMoreLifeException {
        this.mLife -= life;
        if (this.mLife <= 0) {
            this.mLife = 0;
            throw new NoMoreLifeException();
        }
    }
}
