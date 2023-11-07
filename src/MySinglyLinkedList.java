public class MySinglyLinkedList<T> implements MyList<T> {

	int Size;
	MyNode<T> Header;
	
	public MySinglyLinkedList() {
		this.Size = 0;
		this.Header = null;
		return;
	}
	//adds to end of linked list
	public void Append(T data) {
		MyNode<T> appendNode = new MyNode<T>();
		appendNode.Data = data;
		
		//if first element in linked list
		if(this.Header == null)
		{
			this.Header = appendNode;
			this.Size++;
			return;
		}
		MyNode<T> tempNode = this.Header;
		
		//sets tempNode equal to last node
		while(tempNode.NextNode != null)
		{
			tempNode = tempNode.NextNode;
		}
		//attaches additional node to last node
		tempNode.NextNode = appendNode;
		this.Size++;
		return;
	}
	//adds element to beginning of linked list
	public void Prepend(T data) 
	{
		//creates Node
		MyNode<T> newNode = new MyNode<T>();
		newNode.Data = data;
		newNode.NextNode = this.Header;
		
		//adds node to the beginning of list
		this.Header = newNode;
		this.Size++;
		return;
	}

	public boolean InsertAfter(T searchValue, T data) 
	{
		//finds the matching node
		MyNode<T> searchValueNode = this.Search(searchValue);
		
		//if a match is found
		if(searchValueNode != null)
		{
			//create new node
			MyNode<T> newNode = new MyNode<T>();
			newNode.Data = data;
			
			//adds node into place
			newNode.NextNode = searchValueNode.NextNode;
			searchValueNode.NextNode = newNode;
			this.Size++;
			return true;
		}
		// if no matching node found
		else
		{
			return false;
		}		
	}
	//removes first instance of number in list
	public boolean Remove(T searchValue) 
	{
		// tracks the current removal node and the node before
		MyNode<T> beforeRemoveNode = this.Header;
		MyNode<T> removeNode = this.Header.NextNode;
		
		//if match is found on first element
		if(beforeRemoveNode.Data.equals(searchValue))
		{
			//removes node
			this.Header = this.Header.NextNode;
			beforeRemoveNode.NextNode = null;			
			this.Size--;
			return true;
		}
		//iterates through all elements of list
		for(int i =0; i< this.Size; i++)
		{
			//if a match if found
			if(removeNode.Data.equals(searchValue))
			{
				//changes the nextNode of the previous node to skip over node being removed
				//removes the node by setting next node to null
				beforeRemoveNode.NextNode = removeNode.NextNode;
				removeNode.NextNode = null;
				this.Size--;
				
				return true;
			}
			//moves current and previous node forward one position
			beforeRemoveNode = removeNode;
			removeNode = beforeRemoveNode.NextNode;
		}
		// if no matches found
		return false;
	}

	public MyNode<T> Search(T searchValue) 
	{
		//checks if list is empty
		if(this.Header == null)
		{
			return null;
		}
		//creates tempNode
		MyNode<T> tempNode = this.Header;
		//iterates through all elements of list
		while(tempNode.NextNode != null)
		{
			//if a match is found
			if(tempNode.Data.equals(searchValue))
			{
				//returns the pointer of the node
				return tempNode;
			}
			//tempNode moves to next position
			tempNode = tempNode.NextNode;
		}
		//checks final element of list
		if(tempNode.Data.equals(searchValue))
		{
			return tempNode;
		}
		return null;
	}
	//prints all elements of list
	public void Print() 
	{
		MyNode<T> tempNode = this.Header;
		while(tempNode.NextNode != null)
		{
			System.out.print(tempNode.Data + " ");
			tempNode = tempNode.NextNode;
		}
		System.out.println(tempNode.Data);
		return;
	}
	
	//prints all elements of list in reverse order
	public void PrintReverse() 
	{
		MyNode<T> tempNode = this.Header;
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
	//sorts all elements of list in ascending order
	public MySinglyLinkedList<T> Sort() 
	{
		//checks if list has 0 or 1 elements
		if(this.Size < 2)
		{
			return this;
		}
		//creates temporary list
		MySinglyLinkedList<T> newList = new MySinglyLinkedList<T>();
		int totalSize = this.Size;
		//iterates # of times equal to # of elements in list
		for(int i = 0; i<totalSize; i++)
		{
			//sets the max value found equal to the value of the first element
			T max = this.Header.Data;
			MyNode<T> tempNode = this.Header;
			
			//searches through all remaining elements
			for(int j = i; j<totalSize; j++)
			{
				//searches for values larger than current max
				if(tempNode.Data.toString().compareTo(max.toString())< 0)
				{
					max = (tempNode.Data);
				}
				//moves to next element
				tempNode = tempNode.NextNode;
			}
			//adds largest element to temporary list
			newList.Append(max);
			//removes the largest element from source list
			this.Remove(max);
		}
		//returns temporary list
		return newList;
	}
	//returns true if no elements in list
	//returns false if 1 or more elements in list
	public boolean IsEmpty() 
	{
		if(this.Header == null)
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	//returns the number of elements in list
	public int GetLength() 
	{
		return this.Size;
	}

}
