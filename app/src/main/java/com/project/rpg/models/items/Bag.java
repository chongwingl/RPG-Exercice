package com.project.rpg.models.items;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {

	private int maxSize;
	private int currentNumber;
	private Node<Item> first;

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	/**
	 * Initializes an empty bag.
	 */
	public Bag(int maxSize) {
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
	public boolean add(Item item){ // TODO lancer une exception quand la taille maximum est atteinte
		if(currentNumber < maxSize){
			Node<Item> oldfirst = first;
			first = new Node<Item>();
			first.item = item;
			first.next = oldfirst;
			currentNumber++;
			return true;
		}
		return false;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
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
