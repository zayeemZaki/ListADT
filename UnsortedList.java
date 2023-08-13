/*UnsortedList which extends BaseList class and implements ListInterface class
 * In this class we define the add method which adds the new element to the current List
 * in unsorted manner, meaning if the the word isn't currently present in the list 
 * it's added at the front otherwise the count of the Node where it is present is incremented*/

public class UnsortedList extends BaseList implements ListInterface{

	/*There are two major conditions, first when the list is empty and
	 * the other when LinkedList isn't empty in which we have more sub cases */
	public void add(String word) {
		//if statement which adds the word to the empty list.
		if (list == null){
			//create a newNode of the word to be added and sets the link to the list(first element of the list which is null).
			LLNode<String> newNode = new LLNode<String>(word);
			newNode.setNext(list);
			//sets the newNode(new Word) as the list
			list = newNode;
			//sets the count of the word as 1 in the Node.
			list.setCount(1);
		}
		//else statement which deals with the case when list isn't empty
		else{
			//stores the current first element in tmpNode
			LLNode<String> tmpNode = list;
			//while loop which goes to the end of LinkedList unless the word is found before the end of LinkedList
			while(tmpNode != null){
				//increments the count of compare each time while loop is executed
				keyCompare++;
				//if the word to be added isn't equal to the current node we are iterating through
				if(!word.equals(tmpNode.getInfo())){
					//goes to the new Node.
					tmpNode = tmpNode.getNext();
				}
				//if the word is equal to the currentNode element
				else{
					//increments the count of the word for the currentNode and exits from the while loop
					tmpNode.setCount(tmpNode.getCount()+1);
					break;
				}
				
			}
			//this condition is used only if the word isn't currently present in the LinkedList
			if(tmpNode == null){
				//creates a node for the word
				LLNode<String> newNode = new LLNode<String>(word);
				//sets the link of the word to the first element of the LinkedList and sets the word as the new first element
				newNode.setNext(list);
				list = newNode;
				//sets the count of word as 1
				list.setCount(1);
			}
		}
	}
}
