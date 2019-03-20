import java.util.NoSuchElementException;

//Stack implementation using arrays.
public class ArrayStack<T> implements Stack<T>
{
	Object[] tempArray = new Object[10];
	T[] arr;
	int top;

	//Constructor
	public ArrayStack()
	{
		arr = (T[]) tempArray;
		top = -1;
	}
	
	//Checks to see if stack is empty.
	public boolean empty()
	{
		if (top == -1)
		{
			return true;
		}
		return false;	
	}

	//Adds an item into the stack.
	public void push(T item)
	{
		if (top == arr.length - 1)		//Checks to see if array is too small (and keeps one slot open).
		{
			grow_array();		//Makes the array bigger.
		}
		arr[++top] = item;		//Increments top, then pushes item to top.
	}

	//Removes and returns element at top of the stack.
	public T pop()
	{
		if (empty())		//Checks to see if array is empty.
		{
			throw new NoSuchElementException();
		}
		return arr[top--];		//Returns element at top and decrements top.
	}
	
	//Returns element at top of stack.
	public T peek()
	{
		if (empty())	//Checks to see if array is empty.
		{
			throw new NoSuchElementException();
		}
		return arr[top];	//Returns element at top.
	}
	
	//Makes the array larger.
	protected void grow_array()
	{
		Object[] tempObject = new Object[arr.length * 2];	//Creates a temporary array 2x the size.
		T[] temp = (T[]) tempObject;

		for (int i = 0; i < arr.length; i++)	//Iterates through every element in original stack.
		{
			temp[i] = arr[i];		//Copies each element into new larger stack.
		}

		arr = temp;		//Assigns the new array to the old one.
	}			
}