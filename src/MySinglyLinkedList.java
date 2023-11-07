public class MySinglyLinkedList implements MyList {

	int Size;
	MyNode Header;
	
	public MySinglyLinkedList() {
		this.Size = 0;
		this.Header = null;
		return;
	}

	public void Append(int data) {
		MyNode appendNode = new MyNode();
		appendNode.Data = data;
		if(this.Header == null)
		{
			this.Header = appendNode;
			this.Size++;
			return;
		}
		MyNode tempNode = this.Header;
		while(tempNode.NextNode != null)
		{
			tempNode = tempNode.NextNode;
		}
		tempNode.NextNode = appendNode;
		this.Size++;
		return;
	}

	public void Prepend(int data) {
		MyNode newNode = new MyNode();
		newNode.Data = data;
		newNode.NextNode = this.Header;
		this.Header = newNode;
		this.Size++;
		return;
	}

	public boolean InsertAfter(int searchValue, int data) {
		MyNode searchValueNode = this.Search(searchValue);
		if(searchValueNode != null)
		{
			MyNode newNode = new MyNode();
			newNode.Data = data;
			newNode.NextNode = searchValueNode.NextNode;
			searchValueNode.NextNode = newNode;
			this.Size++;
			return true;
		}
		else
		{
			return false;
		}		
	}
	//removes first instance of number in list
	public boolean Remove(int searchValue) {
		MyNode beforeRemoveNode = this.Header;
		if(this.Header.Data == searchValue)
		{
			this.Header = this.Header.NextNode;
			beforeRemoveNode.NextNode = null;			
			this.Size--;
			return true;
		}
		int counter  = 0;
		while(counter < this.Size)
		{
			if(beforeRemoveNode.NextNode.Data == searchValue)
			{
				MyNode deleteNode = beforeRemoveNode.NextNode;
				beforeRemoveNode.NextNode = deleteNode.NextNode;
				deleteNode.NextNode = null;
				this.Size--;
				return true;
			}
			counter++;
		}
		return false;
	}

	public MyNode Search(int searchValue) {
		if(this.Header == null)
		{
			return null;
		}
		MyNode tempNode = this.Header;
		while(tempNode.NextNode != null)
		{
			if(tempNode.Data == searchValue)
			{
				return tempNode;
			}
			tempNode = tempNode.NextNode;
		}
		if(tempNode.Data == searchValue)
		{
			return tempNode;
		}
		return null;
	}

	public void Print() {
		MyNode tempNode = this.Header;
		
		while(tempNode.NextNode != null)
		{
			System.out.print(tempNode.Data + " ");
			tempNode = tempNode.NextNode;
		}
		System.out.println(tempNode.Data);
		return;
	}

	public void PrintReverse() {
		MyNode tempNode = this.Header;
		String reverseString = "";
		while(tempNode.NextNode != null)
		{
			reverseString = tempNode.Data + " " + reverseString;
			tempNode = tempNode.NextNode;
		}
		reverseString = tempNode.Data + " " + reverseString;
		System.out.println(reverseString);
		return;
	}

	public MySinglyLinkedList Sort() {
		if(this.Size < 2)
		{
			return this;
		}
		MySinglyLinkedList newList = new MySinglyLinkedList();
		int totalSize = this.Size;
		for(int i = 0; i<totalSize; i++)
		{
			int max = -1;
			MyNode tempNode = this.Header;
			for(int j = i; j<totalSize; j++)
			{
				if(tempNode.Data > max)
				{
					max = tempNode.Data;
				}
				tempNode = tempNode.NextNode;
			}
			newList.Prepend(max);
			this.Remove(max);
		}
		return newList;
	}

	public boolean IsEmpty() {
		if(this.Header == null)
		{
			return true;
		}
		else
		{
			return false;
		}		
	}

	public int GetLength() {
		return this.Size;
	}

}
