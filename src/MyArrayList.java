import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
	private T[] array;
	private int lastIndex;

	public MyArrayList() {
		array = (T[]) new Object[10];
		lastIndex = 0;
	}

	@Override
	public void add(T value) {
		insureCapacityIfNeed();
		array[lastIndex] = value;
		lastIndex++;
	}

	@Override
	public void add(T value, int index) {
		insureCapacityIfNeed();
		checkIndex(index);
		System.arraycopy(array, index, array, index + 1, ++lastIndex);
		array[index] = value;
	}

	@Override
	public void addAll(MyList<T> list) {
		for (int i = 0; i < list.getLastElementIndex(); i++) {
			insureCapacityIfNeed();
			add(list.get(i));
		}
	}

	@Override
	public T get(int index) {
		checkIndex(index);
		return array[index];
	}

	@Override
	public void set(T value, int index) {
		checkIndex(index);
		array[index] = value;
	}

	@Override
	public T remove(int index) {
		checkIndex(index);
		T buffer = array[index];
		System.arraycopy(array, index + 1, array, index, --lastIndex);
		return buffer;
	}

	@Override
	public void remove(T o) {
		for (int i = 0; i < lastIndex; i++) {
			if (o.equals(array[i])) {
				remove(i);
				break;
			}
		}
	}

	@Override
	public int size() {
		return lastIndex;
	}

	@Override
	public boolean isEmpty() {
		if (lastIndex == 0 && array[lastIndex] == null) {
			return true;
		}
		return false;
	}

	@Override
	public int getLastElementIndex() {
		return lastIndex;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < lastIndex; i++) {
			result.append(array[i] + " ");
		}
		return result.toString();
	}

	private void checkIndex(int index) {
		if (lastIndex < index || index < 0) {
			throw new NoSuchElementException();
		}
	}

	private void insureCapacityIfNeed() {
		if (array.length < lastIndex + 2) {
			T[] arrayBuffer = (T[]) new Object[array.length << 1];
			System.arraycopy(array, 0, arrayBuffer, 0, lastIndex);
			array = arrayBuffer;
		}
	}
}
