import java.util.NoSuchElementException;

//Circular queue implementation using arrays.
public class ArrayQueue<T> implements Queue<T>
{
	Object[] tempArray = new Object[10];
	T[] arr;
	int head;
	int tail;

	//Constructor
	public ArrayQueue()
	{
		arr = (T[]) tempArray;
		head = 0;
		tail = 0;
	}
	
	//Checks to see if queue is empty.
	public boolean empty()
	{
		if (head == tail)
		{
			return true;
		}
		return false;
	}

	//Removes and returns the first element in the queue.
	public T dequeue()
	{
		if (empty())
		{
			throw new NoSuchElementException();
		}

		T temp = arr[head];		//Holds element at head to be returned.
		head = (head + 1) % arr.length;		//Moves value of head to next index in queue.

		return temp;
	}

	//Adds item to the end of the queue.
	public void enqueue(T item)
	{
		if ((tail + 1) % arr.length == head)	//If array is too small, tail will reach the head and we must make a bigger circular array.
		{										//We have (tail + 1) to keep at least one slot open in queue.
			grow_array();
		}

		arr[tail++] = item;		//Copies item to the tail, and increments tail.
		tail = tail % arr.length;	//Re-initializes tail to fit within the circular array.
	}

	//Makes the array bigger to fit more elements.
	protected void grow_array()
	{
		Object[] tempObject = new Object[arr.length * 2];	//Creates a temporary array that's 2x bigger.
		T[] temp = (T[]) tempObject;

		for (int i = 0; i < arr.length; i++)		//Iterates through each slot in queue.
		{
			temp[i] = arr[(head + i) % arr.length];		//Copies each item in queue to temp array, starting at head.
		}

		arr = temp;			//Assigns new larger array to queue.
		tail = tail + head + 1;		//Re-initializes tail for new array.
		head = 0;		//Re-initializes head.
	}			
}