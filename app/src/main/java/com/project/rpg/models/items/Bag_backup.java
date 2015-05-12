package com.project.rpg.models.items;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag_backup<AbstractItem> implements Iterable<AbstractItem> {

    private static final int MAX_SIZE = 50;
//    private static Bag<AbstractItem> bag;
	private int maxSize;
	private int currentNumber;
	private Node<AbstractItem> first;

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

//    public static Bag<AbstractItem> getInstance(){
//
//        if (bag == null) {
//            bag = new Bag<>(MAX_SIZE);
//        }
//        return bag;
//    }

	/**
	 * Initializes an empty bag.
	 */
	private Bag_backup(int maxSize) {
		first = null;
		currentNumber = 0;
		this.maxSize = maxSize;
	}

	/**
	 * Is this bag empty?
	 * 
	 * @return true if this bag is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in this bag.
	 * 
	 * @return the number of items in this bag
	 */
	public int size() {
		return currentNumber;
	}

	/**
	 * Adds the item to this bag.
	 * 
	 * @param item
	 *            the item to add to this bag
	 */
	public boolean add(AbstractItem item){ // TODO lancer une exception quand la taille maximum est atteinte
		if(currentNumber < maxSize){
			Node<AbstractItem> oldfirst = first;
			first = new Node<AbstractItem>();
			first.item = item;
			first.next = oldfirst;
			currentNumber++;
			return true;
		}
		return false;
	}

	@Override
	public Iterator<AbstractItem> iterator() {
		return new ListIterator<AbstractItem>(first);
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public void remove() {
			current.next = current.next.next;
		}

		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

}
