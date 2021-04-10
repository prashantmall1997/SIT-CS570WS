package hw3_P_Mall;

public class IDLListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Empty IDLL
		System.out.println("Initialized empty IDLL");
		IDLList<Integer> dll = new IDLList<Integer>();
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Add element at position 0
		System.out.println("Add 22 at index 0");
		dll.add(0, 22);
		// Add element at position 1
		System.out.println("Add 21 at index 1");
		dll.add(1, 21);
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Add element at position 1
		System.out.println("Add 21 at index 1");
		dll.add(1, 99);
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Add element at position 10 (ERROR)
		System.out.println("Add 21 at index 10");
		dll.add(10, 21);
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Add element at position -1 (ERROR)
		System.out.println("Add 21 at index -1");
		dll.add(-1, 21);
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Add element at head
		System.out.println("Add 3 at head");
		dll.add(3);
		// Add element at head
		System.out.println("Add 5 at head");
		dll.add(5);
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Add element at tail
		System.out.println("Add 6 at tail");
		dll.append(6);
		// Add element at tail
		System.out.println("Add 22 at tail");
		dll.append(22);
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Get element at index 0
		System.out.println("Element found at index 0: " + dll.get(0));
		// Get element at index 1
		System.out.println("Element found at index 1: " + dll.get(1));
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Get element at index 100 (ERROR)
		System.out.println("Element found at index 100: ");
		dll.get(100);
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Get element at head
		System.out.println("Element found at head: " + dll.getHead());
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Get element at tail
		System.out.println("Element found at tail: " + dll.getLast());
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Get size of IDLL
		System.out.println("Size of IDLL: " + dll.size());
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Remove element at head
		System.out.println("Element removed at head: " + dll.remove());
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Remove element at tail
		System.out.println("Element removed at tail: " + dll.removeLast());
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Remove element at index 2
		System.out.println("Element removed at index 2: " + dll.removeAt(2));
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");

		// Remove the first occurrence of element 22
		System.out.println("Element 22 removed: " + dll.remove(22));
		// Print IDLL
		System.out.println("IDLL: " + dll.toString());
		System.out.println("");
	}
}
