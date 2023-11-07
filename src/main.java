
public class main {

	public static void main(String[] args) {
		
		MySinglyLinkedList newList = new MySinglyLinkedList();
		newList.Append(3);
		newList.Prepend(6);
		newList.Append(5);
		newList.InsertAfter(3, 4);
		newList.Print();
		newList = newList.Sort();
		newList.Print();		
	}

}
