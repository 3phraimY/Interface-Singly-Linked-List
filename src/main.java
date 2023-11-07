
public class main {

	public static void main(String[] args) {
		MySinglyLinkedList<String> newList = new MySinglyLinkedList<String>();
		newList.Append("Simon");
		newList.Append("Andrew");
		newList.Append("James-Z");
		newList.Append("John");
		newList.Append("Philip");
		newList.Append("Bartholomew");
		newList.Append("Thomas");
		newList.Append("Matthew");
		newList.Append("James-A");
		newList.Append("Thaddaeus");
		newList.Append("Simon");
		newList.Append("Judas");
		
		newList.Print();
		newList = newList.Sort();
		newList.Remove("Judas");
		newList.Print();
		return;
	}

}
