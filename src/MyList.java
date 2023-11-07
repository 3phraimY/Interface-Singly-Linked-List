public interface MyList<T> {
	public void Append(T x);
	public void Prepend(T x);
	public boolean InsertAfter(T w, T x);
	public boolean Remove(T x);
	public MyNode<T> Search(T x);
	public void Print();
	public void PrintReverse();
	public MySinglyLinkedList<T> Sort();
	public boolean IsEmpty();
	public int GetLength();	
}
