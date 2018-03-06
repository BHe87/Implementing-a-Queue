public class LinkedQueue<T> implements Queue<T>
{
	Node<T> head = null;//head node of the queue
	Node<T> tail = null;//tail node of the queue 
	Node<T> nodeToRemove, newNode;
	int size = 0;

	private class Node<T>//inner class to make nodes
	{
		public T value;
		public Node<T> next;

		private Node(T value, Node next)//constructor for node
		{
			this.value = value;
			this.next = next;
		}
	}

	public T remove() throws UnsupportedOperationException//removing the node at the head of the Queue
	{
		if(isEmpty())
		{
			throw new UnsupportedOperationException();
		}

		else
		{
			nodeToRemove = head;//node at the front is the head of the list
			head = head.next;//points the node at the front to the second node effectively removing it from the list
			size--;
			return (T) nodeToRemove.value;
		}
	}

	public T peek()//looking at the head of the list
	{
		return head.value;
	}

	public void add(T thing)//adding to the tail end of the list
	{
		newNode = new Node<T>(thing, head);//making a new node

		if(isEmpty())//case if the node we're adding is the first node in the list
		{
			head = newNode;// these are the same because there's only one node in the list
			tail = newNode;//therefore, this one node is both the head and tail
		}

		else
		{
			tail.next = newNode;//set the last node to point to this new last node
			tail = newNode;//tail now points to the new last node
		}
		size++;
	}

	public boolean isEmpty()//we keep track of the size of the list to make this a O(1) operation
	{
		return size == 0;
	}
}