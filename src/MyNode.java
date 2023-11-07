
public class MyNode<T> {
	public T Data;
	public MyNode<T> NextNode;
	
	public MyNode()
	{
		this.Data = null;
		this.NextNode = null;
	}
	
	public boolean IsNull()
	{
		return this.Data == null;
	}
}
