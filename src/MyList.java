public interface MyList<T> {
	void add(T value);

	void add(T value, int index);

	void addAll(MyList<T> list);

	T get(int index);

	void set(T value, int index);

	T remove(int index); // возвращаем элемент, который удалили

	void remove(T t); // удалять первый, который встретится

	int size();

	boolean isEmpty();

	int getLastElementIndex();

}
