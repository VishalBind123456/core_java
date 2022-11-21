package Linked_List;

public class linked_list {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		LinkedList linkedList = new LinkedList();
		linkedList.addFirst(10).addFirst(20).addLast(30).addLast(30).addLast(30).addAt(3 , 35).addLast(40).addLast(40).addAt(1 , 5);

		LinkedList linkedList2 = new LinkedList();
		linkedList2.addFirst(11).addFirst(21).addLast(31).addAt(3 , 35).addLast(41).addAt(1 , 5).addLast(7).addLast(9);
		
		linkedList.print();
		System.out.println("------------------------------------------");
		linkedList2.print();
		
		System.out.println("------------------------------------------");
		//linkedList.removeFirst();
		//linkedList.removeAt(2);
		//linkedList.removeLast();
		//linkedList.reverseIterative();
		//linkedList.reversePointer();
		//System.out.println(linkedList.get_Kth_element_from_end(3).data);
		//System.out.println(linkedList.middle_of_linklist_using_2_pointer().data);
		//linkedList.print();
		
		//linkedList = sortLinkedList(linkedList , 0 , linkedList.size - 1);
		//linkedList2 = sortLinkedList(linkedList2 , 0 , linkedList2.size - 1);
		//removeDuplicatesInSortedLinkedList(linkedList).print();
		// K_reverse_in_linkedlist(linkedList2 , 3).print();
		// display_reverse_linkedlist(linkedList2);  //-----> only display using recursion --------
		// reverse_linklist_recursion_pointer(linkedList2);

		reverse_linklist_data_recursive(linkedList2);


	}

	private static void reverse_helper(Node node , int size , int current_node)
	{
		if(node == null)
		{
			return;
		}
		reverse_helper(node.next , size , current_node + 1);

		if(current_node >= Math.floor(size/2))
		{
			int temp = node.data;
			node.data = right.data;
			right.data = temp;
			right = right.next;

		} 

	}

	public static Node right;	//-----> to keep track to node from right ------

	public static void reverse_linklist_data_recursive(LinkedList list)
	{
		right = list.head;
		reverse_helper(list.head , list.size - 1 , 0);
		list.print();

	}



	private static void reverse(Node node)
	{
		if(node == null)
		{
			return ;
		}

		reverse(node.next);

		if(node.next == null )
		{
			//---> for tail do nothing ---
		}
		else  
		{
			node.next.next = node;
		}

	}

	public static void reverse_linklist_recursion_pointer(LinkedList list)
	{
		reverse(list.head);
		list.head.next = null;
		Node temp = list.head;
		list.head = list.tail;
		list.tail = temp;

		list.print();

	}

	private static void display_reverse(Node n)
	{
		if(n == null)
		{
			return;
		}
		display_reverse(n.next);
		System.out.println(n.data);
	}

	public static void display_reverse_linkedlist(LinkedList list)
	{

		display_reverse(list.head);

	}

	public static LinkedList K_reverse_in_linkedlist(LinkedList list , int k)
	{
		LinkedList prev = new LinkedList();
		LinkedList curr = new LinkedList();
		while(list.size >= 3 )
		{
			if(prev.size == 0)
			{
				for(int i = 0 ; i < k ; i++)
				{
					Node n = list.getNodeAt(0);
					list.removeFirst();
					prev.addFirst(n.data);
				}
			}
			else  
			{
				for(int i = 0 ; i < k ; i++)
				{
					Node n = list.getNodeAt(0);
					list.removeFirst();
					curr.addFirst(n.data);
				}
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				curr = new LinkedList();
				prev.size = prev.size + curr.size; 
			}
		}
		while(list.size != 0)
		{
			Node n = list.getNodeAt(0);
			list.removeFirst();
			prev.addLast(n.data);
		}

		return prev;

	}

	public static LinkedList removeDuplicatesInSortedLinkedList(LinkedList list)
	{
		if(list.size <= 1)
		{
			return list;
		}

		LinkedList res = new LinkedList();	
		Node previous = list.head ;
		Node current = list.head.next;
		res.addLast(previous.data);

		for( ; current != null ; )
		{
			if(previous.data != current.data)
			{
				res.addLast(current.data);
				//previous.next = current.next;
			}
			previous = previous.next;
			current = current.next;

		}
		return res;
	}


	public static LinkedList mergeTwoLinkedList(LinkedList list1 , LinkedList list2)
	{
		Node n1 = list1.head;
		Node n2 = list2.head;

		LinkedList list3 = new LinkedList();

		for( ; n1 != null && n2 != null ; )
		{
			if(n1.data < n2.data)
			{
				list3.addNodeAtLast(n1);
				n1 = n1.next;
			}
			else 
			{
				list3.addNodeAtLast(n2);
				n2 = n2.next;	
			}
		}

		for( ; n1 != null ; )
		{
			list3.addNodeAtLast(n1);
			n1 = n1.next;
		}

		for( ; n2 != null ; )
		{
			list3.addNodeAtLast(n2);
			n2 = n2.next;
		}

		return list3;

	}

	public static LinkedList sortLinkedList(LinkedList list , int start , int end)
	{
		if(end <= start)
		{
			return list;
		}

		int i = start , j = end;
		int p = (start+end)/2;
		//System.out.println(p);

		for( ; j >= i  ; )
		{
			if(list.getNodeAt(i).data <= list.getNodeAt(p).data)
			{
				i++;
			}
			if(list.getNodeAt(j).data >= list.getNodeAt(p).data)
			{
				j--;
			}
		}
		if(p < i)
		{
			int temp = list.getNodeAt(i-1).data; 
			list.getNodeAt(i-1).data = list.getNodeAt(p).data; 
			list.getNodeAt(p).data = temp;
			p = i-1; 
		}
		if(p > i)
		{
			int temp = list.getNodeAt(j+1).data; 
			list.getNodeAt(j+1).data = list.getNodeAt(p).data; 
			list.getNodeAt(p).data = temp; 
			p = j+1;
		}

		sortLinkedList(list , start , p-1);
		sortLinkedList(list , p+1 , end);

		return list;
	}

	public static class Node{

		public int data ;
		public Node next = null;
	}

	public static class LinkedList{

		Node head = null;
		Node tail = null;
		int size = 0;

		public void print()
		{
			Node current = head;
			if(size == 0)
			{
				System.out.println("Empty.....");
			}
			while(current != null)
			{
				System.out.println(current.data);
				current = current.next;
			}
		}


		public Node get_Kth_element_from_end(int k)
		{
			Node p = head;
			Node current = head;
			for(int i = 0 ; i < k ; i++)
			{
				current = current.next;
			}
			for( ; current != null ; )
			{
				current = current.next;
				p = p.next;
			}

			return p;

		}

		public Node middle_of_linklist_using_2_pointer()
		{
			Node p = head;
			Node current = head;
			for(  ; current.next != null && current.next.next != null ; )
			{
				current = current.next.next;
				p = p.next;
			}

			return p;

		}  

		public Node getNodeAt(int idx)
		{
			Node current = head;
			for(int i = 0 ; i < idx ; i++)
			{
				current = current.next;
			}
			return current;
		}

		public LinkedList reverseIterative()
		{
			Node left = head;
			Node right = tail;
			for(int i = 0 , j = size - 1 ; i <= j ; )
			{
				int temp ;
				temp = left.data;
				left.data = right.data; 
				right.data = temp;

				i++;  left = left.next;
				j--;  right = getNodeAt(j);
			}

			return this;
		}

		public LinkedList reversePointer()
		{	
			Node prev = null;
			Node next = null;
			Node current = head;

			for( ; current != null ; )
			{
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}

			Node temp = tail;
			tail = head;
			head = temp;
			
			return this;
		}

		public LinkedList addFirst(int val)
		{
			Node node = new Node();
			node.data = val;
			if(size == 0)
			{
				head = tail = node;
			}
			else 
			{
				node.next = head;
				head = node;
			}
			size++;
			return this;
		}

		public LinkedList addNodeAtLast(Node node)
		{
			if(size == 0)
			{
				head = tail = node;
			}
			else 
			{
				tail.next = node;
				tail = node;
			}
			size++;
			return this;
		}

		public LinkedList addLast(int val)
		{
			Node node = new Node();
			node.data = val;
			if(size == 0)
			{
				head = tail = node;
			}
			else 
			{
				tail.next = node;
				tail = node;
			}
			size++;
			return this;
		}

		public LinkedList addAt(int idx , int val)
		{
			Node node = new Node();
			node.data = val;
			{
				if(idx < 0 || idx > size)
				{
					System.out.println("Inappropriate Index");
				}
				else if(size == 0)
				{
					head = tail = node;
					size++;
				}
				else if(idx == 1)
				{
					addFirst(val);
				}
				else 
				{
					Node current = new Node();
					current = head;
					for(int i = 0 ; i < idx - 2 ; i++)
					{
						current = current.next;
					}
					node.next = current.next;
					current.next = node;
					size++;
				}
				return this;
			}

		}

		public LinkedList removeFirst()
		{
			if(size == 0)
			{
				System.out.println(" linkedlist underflows ");
			}
			else if(size == 1)
			{
				head = tail = null;
				size = 0;
			}
			else 
			{
				head = head.next;
				size--;
			}

			return this;
		}

		public LinkedList removeLast()
		{
			if(size == 0)
			{
				System.out.println(" linkedlist underflows ");
			}
			else 
			{
				Node current = head;
				for(int i = 0 ; i < size-2 ; i++)
				{
					current = current.next;
				}
				current.next = null;
				tail = current;
				size--;
			}
			
			return this;
		}

		public LinkedList removeAt(int idx)
		{
			if(size == 0)
			{
				System.out.println(" linkedlist underflows ");
			}
			else if(idx == 1)
			{
				removeFirst();
			}
			else 
			{
				Node current = head;
				for(int i = 0 ; i < idx-2 ; i++)
				{
					current = current.next;
				}
				current.next = current.next.next;
				size--;
			}
			
			return this;
		}






	}

}
