public class MyLinkedList<T> implements MyList<T> {

	private Node firstNode;
	private Node lastNode;
	private int size = 0;

	public MyLinkedList() {
		size = 0;
	}

	public Node<T> getFirstNode() {
		return firstNode;
	}

	public Node<T> getLastNode() {
		return lastNode;
	}

	@Override
	public void add(T value) {
		if (firstNode == null) {
			firstNode = new Node(null, null, value);
			lastNode = firstNode;
		} else {
			Node currentNode = new Node(lastNode, null, value);
			lastNode.next = currentNode;
			lastNode = currentNode;
		}
		size++;
	}

	@Override
	public void add(T value, int index) {
		checkIndex(index);
		Node<T> bufferNode = getNode(index);
		Node<T> newNode = new Node<>(bufferNode.prev, bufferNode, value);
		bufferNode.prev.next = newNode;
		bufferNode.prev = newNode;
	}

	@Override
	public T get(int index) {
		checkIndex(index);
		Node<T> requiredNode = firstNode;
		for (int i = 0; i < index; i++) {
			requiredNode = requiredNode.next;
		}
		return requiredNode.value;
	}

	public Node<T> getNode(int index) {
		checkIndex(index);
		Node<T> requiredNode = firstNode;
		for (int i = 0; i < index; i++) {
			requiredNode = requiredNode.next;
		}
		return requiredNode;
	}

	@Override
	public void set(T value, int index) {
		checkIndex(index);
		Node<T> bufferNode = getNode(index);
		bufferNode.value = value;
	}

	@Override
	public T remove(int index) {
		checkIndex(index);
		Node<T> bufferNode = getNode(index);
		if (index == 0) {
			firstNode = firstNode.next;
			firstNode.prev = null;
			bufferNode.next = null;
		} else {
			bufferNode.prev.next = bufferNode.next;
			bufferNode.next.prev = bufferNode.prev;
			bufferNode.prev = null;
			bufferNode.next = null;
		}
		size--;
		return bufferNode.value;
	}

	@Override
	public void remove(T value) {
		Node<T> bufferNode = firstNode;
		for (int i = 0; i < size; i++) {
			if (bufferNode.value.equals(value)) {
				remove(i);
				break;
			} else {
				bufferNode = bufferNode.next;
			}
		}
	}

	@Override
	public void addAll(MyList<T> list) {
		for (int i = 0; i < list.getLastElementIndex(); i++) {
			add(list.get(i));
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}


	@Override
	public int getLastElementIndex() {
		return size;
	}

	@Override
	public String toString() {
		Node<T> currentNode = firstNode;
		StringBuilder result = new StringBuilder(currentNode.value.toString());
		while (currentNode.next != null) {
			currentNode = currentNode.next;
			result.append(" ").append(currentNode.value.toString());
		}
		return result.toString();
	}

	private class Node<T> {
		private Node prev;
		private Node next;
		private T value;

		public Node(Node prev, Node next, T value) {
			this.prev = prev;
			this.next = next;
			this.value = value;
		}
	}

	private void checkIndex(int index) {
		if (size < index || index < 0) {
			throw new ArrayIndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
	}
}