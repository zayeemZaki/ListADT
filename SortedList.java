

/*SortedList which extends BaseList class and implements ListInterface class
* In this class we define the add method which adds the new element to the current List
* in sorted manner, meaning if the the word isn't currently present in the list 
* it's added at the correct alphabetic position otherwise the count of the Node where it is present is incremented*/
public class SortedList extends BaseList implements ListInterface {
	/*There are two major conditions, first when the list is empty and
	 * the other when LinkedList isn't empty in which we have more sub cases */
	public void add(String word) {
		//if the LinkedList is empty 
		if (list == null) {
			//creates a newNode for the word
			LLNode<String> newNode = new LLNode<String>(word);
			//sets the link of the newNode to the current first element which is null
			newNode.setNext(list);
			//sets the new word as the first element and increments the count
			list = newNode;
			list.setCount(1);
		}
		//else condition which is used when the LinkedList isn't empty
		else {
			//creates two reference nodes, one for the current Node and other for the previous node
			LLNode<String> currNode = list;
			LLNode<String> prevNode = null;
			//while loop which goes through the LinkedList till the end, it has three conditions one when the word is found, 
			//when the word isn't found but the currNode is alphabetically greater than the word to be added and else which goes to next node
			while(currNode !=null) {
				//increments the count of compare everytime while loop is executed
				keyCompare++;
				//if the word is equal to currNode
				if(word.equals(currNode.getInfo())){
					//count for the word at currNode is incremented and exits the while loop
					currNode.setCount(currNode.getCount() + 1);
					break;
				}
				//when the word at the currNode is alphabetically greater than the word to be added
				else if (word.compareTo((String) currNode.getInfo()) < 0) {
					//if the currNode is first element of the LinkedList
					if (currNode == list) {
						//creates a newNode for the word and sets the link of it to the current first element
						LLNode<String> NewNode = new LLNode<String>(word);
						NewNode.setNext(list);
						//sets the newNode as the first element and increments the count and exits the while loop
						list = NewNode;
						list.setCount(1);
						break;
					}
					//if the currNode isn't the first element
					else {
						//creates a newNode for the word 
						LLNode<String> NewNode = new LLNode<String>(word);
						//sets the link of the newNode to the currNode and prevNode's link to the NewNode,
						//meaning the element is entered between the currNode and the newNode
						NewNode.setNext(currNode);
						prevNode.setNext(NewNode);
						//count of word at the NewNode is set to 1 and exits while loop
						NewNode.setCount(1);
						break;
					}
				}
				//if the word isn't found in the current iteration, currNode and prevNode are moved to the next Node respectively
				else {
					prevNode = currNode;
					currNode = currNode.getNext();
				}
				//executed if the conditions above aren't meant then the word is added to the end of the LinkedList
				if (currNode == null) {
					//creates a newNode for the word and adds it to the end of linked list
					//by setting the link of previous node which is current last element of the LinkedList to the word added and exits the while loop
					LLNode<String> NewNode = new LLNode<String>(word);
					NewNode.setNext(null);
					prevNode.setNext(NewNode);
					NewNode.setCount(1);
					break;
				}
			}
		}			
	}
}
