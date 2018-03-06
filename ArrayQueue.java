public class ArrayQueue<T> implements Queue<T>
{
	private T[] Queue = (T[]) new Object[10];//Queue backed by a circular array
	private T[] newQueue;
	T thingToRemove;
	int front = 0;
	int back = 0;
	int size = 0;

	public void add(T thing)//adds the parameter to the index of back in the circular array
	{
		ensureCapacity();
		Queue[back] = thing;
	//	System.out.println("ADD");
		back++;
		size++;
		if(back == Queue.length)//this means back reached the end of the circular array 
		{
			back = 0;	
		}
	}

	public T remove() throws UnsupportedOperationException//moving the front pointer back 1 
	{
		if(isEmpty())
		{
			throw new UnsupportedOperationException();
		}
		else
		{
			ensureCapacity();
			thingToRemove = Queue[front];
		//	System.out.println("REMOVE");
			front++;
			size--;
			if(front == Queue.length)//this means front reached the end of the circular array
			{
				front = 0;	
			}
			return (T) thingToRemove;
		}
	}

	public T peek()//returning just the first element in the Queue
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return (T) Queue[front];
		}
	}

	private void ensureCapacity()//checks to see if we need to resize the Queue
	{
	//	printArray();
		//System.out.println("printArray Called");

		/*if(back == Queue.length)//this means the Queue is full
		{
			back = 0;	
		}*/
		if(back == front && size != 0)//when back == front we need to resize the array to not lose the first element in the Queue
		{
		//	System.out.println("Hello");
		//	System.out.print(Queue);
			newQueue = (T[]) new Object[size * 2 + 1];
			System.arraycopy(Queue, back, newQueue, 0, Queue.length - back);
			System.arraycopy(Queue, 0, newQueue, Queue.length - back, back);
			front = 0;
			back = Queue.length;
			Queue = newQueue;
		//	System.out.print(Queue);
		}
	}

	public boolean isEmpty()//size is 0 only when your Queue is empty
	{
		return size == 0 ;
	}

	/*public void printArray()
	{
		for(int i = 0; i < Queue.length; i++)
		{
			System.out.print(i + "\t");
		}

		System.out.println();

		for(int i = 0; i < Queue.length; i++)
		{
			System.out.print(Queue[i] + "\t");
		}
		System.out.println();
		System.out.println("front: " + front);
		System.out.println("back: " + back);
		System.out.println();
	}*/
}