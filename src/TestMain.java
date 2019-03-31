public class TestMain {

	public static void main(String[] args) {
		MyList<String> arrayList = new MyArrayList<>();
		MyList<String> linkedList = new MyLinkedList<>();

		MyList<String> arrayListForAddAll = new MyArrayList<>();
		arrayListForAddAll.add("1");
		arrayListForAddAll.add("6");
		arrayListForAddAll.add("4");

		// checking method addAll + insureCapacity + toString
		arrayList.addAll(arrayListForAddAll);
		arrayList.addAll(arrayListForAddAll);
		arrayList.addAll(arrayListForAddAll);
		arrayList.addAll(arrayListForAddAll);
		System.out.print(arrayList.toString() + "\n");

		// checking method remove with index and with T(object)
		arrayList.remove(8);
		arrayList.remove("4");
		System.out.println(arrayList.toString());

		// checking add in position
		arrayList.add("7", 5);
		System.out.println(arrayList.toString());

		// checking size + get with index + isEmpty?
		System.out.println("Size = " + arrayList.size() + " get index 5  = " + arrayList.get(5));
		System.out.println("IsEmpty? = " + arrayList.isEmpty() + "\n");

//		 // checking exception
//		System.out.println(arrayList.get(105));

		MyList<String> linkedListForAddAll = new MyArrayList<>();
		linkedListForAddAll.add("2");
		linkedListForAddAll.add("5");
		linkedListForAddAll.add("7");

		// checking method addAll + toString
		linkedList.addAll(linkedListForAddAll);
		linkedList.addAll(linkedListForAddAll);
		linkedList.addAll(linkedListForAddAll);
		System.out.println(linkedList.toString());

		// checking method remove with index and with T(object)
		linkedList.remove(6);
		linkedList.remove("5");
		System.out.println(linkedList.toString());

		// checking add in position
		linkedList.add("4", 3);
		System.out.println(linkedList.toString());

		// checking size + get with index
		System.out.println("Size = " + linkedList.size() + " get index 3  = " + linkedList.get(3));

		// checking exception
		System.out.println(linkedList.get(105));
	}
}

