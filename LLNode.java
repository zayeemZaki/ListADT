//----------------------------------------------------------------------------
// LLNode.java               
//
// Implements <T> nodes for a Linked List.
//----------------------------------------------------------------------------

public class LLNode<T>{
	
	protected LLNode<T> link;
	protected T info;
	int count = 0;
  
	public LLNode(T info)
	{	
		this.info = info;
		link = null;
	}
	
	//setInfo method which sets the element at current Node position
	public void setInfo(T info)
	{ 
		this.info = info;
	}
	//getInfo methof which gets the element at current Node position
	public T getInfo()
	{ 
		return info;
	}
	//setLink method which sets the link of the current Node
	public void setLink(LLNode<T> link)
	{
		this.link = link;
	}
	//getLink method which gets the link of the current Node
	public LLNode<T> getLink()
	{
		return link;
	}
	//setNext method which sets the link of the current Node to the new Node
	public void setNext(LLNode<T> link)
	{
		this.link = link;
	}
	//getNext method which gets the next Node linked to the current Node
	public LLNode<T> getNext()
	{
		return this.link;
	}
	//setNext method which sets the count of elements at current Node
	public void setCount(int count)
	{
		this.count = count;
	}
	//getCount method which gets the count of elements at current Node.
	public int getCount()
	{
		return count;
	}
}
 
 