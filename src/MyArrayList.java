import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
	private T[] array;
	private int lastIndex = 0;
	private final int INITIAL_ARRAY_LENGTH = 10;

	public MyArrayList() {
		array = (T[]) new Object[INITIAL_ARRAY_LENGTH];
	}

	public MyArrayList(int size) {
		array = (T[]) new Object[size];
	}


	@Override
	public void add(T value) {
		array[lastIndex] = value;
		lastIndex++;
		insureOrDecreaseCapacityIfNeed();
	}

	@Override
	public void add(T value, int index) {
		checkIndex(index);
		System.arraycopy(array, index, array, index + 1, ++lastIndex);
		array[index] = value;
		insureOrDecreaseCapacityIfNeed();
	}

	@Override
	public void addAll(MyList<T> list) {
		for (int i = 0; i < list.getLastElementIndex(); i++) {
			insureOrDecreaseCapacityIfNeed();
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
	public void remove(T value) {
		for (int i = 0; i < lastIndex; i++) {
			if (value.equals(array[i])) {
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
		return lastIndex == 0;
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
			throw new ArrayIndexOutOfBoundsException("Index: " + index + " size: " + lastIndex);
		}
	}

	private void insureOrDecreaseCapacityIfNeed() {
		if (array.length < lastIndex + 2) {
			array = Arrays.copyOf(array, array.length << 1);
		} else if (array.length > ((lastIndex << 1) + 3)) {
			array = Arrays.copyOf(array, array.length >> 1);
		}
	}
}
