public interface MyList {
	public void Append(int x);
	public void Prepend(int x);
	public boolean InsertAfter(int w, int x);
	public boolean Remove(int x);
	public MyNode Search(int x);
	public void Print();
	public void PrintReverse();
	public MySinglyLinkedList Sort();
	public boolean IsEmpty();
	public int GetLength();	
}
