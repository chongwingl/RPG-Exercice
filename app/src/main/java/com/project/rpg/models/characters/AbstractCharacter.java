package com.project.rpg.models.characters;

import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.items.Bag;

import java.util.Iterator;

public abstract class AbstractCharacter {
	private String name;
	private int level;
	private int money;
	private Bag<AbstractItem> bag;

	public AbstractCharacter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMoney() {
		return money;
	}

	protected void setMoney(int money) {
		this.money = money;
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public boolean removeMoney(int money) {
		if (this.money - money > 0) {
			this.money -= money;
			return true;
		}
		return false;
	}
	
	public boolean addToBag(AbstractItem item){
		return bag.add(item);
	}
	
	public Bag getBag(){
		return bag;
	}
	
	public void removeItem(AbstractItem item){
		Iterator<AbstractItem> iterator = bag.iterator();
		while(iterator.hasNext()){
			AbstractItem currentItem = iterator.next();
			if(currentItem == item){
				iterator.remove();
			}
		}
	}

}
