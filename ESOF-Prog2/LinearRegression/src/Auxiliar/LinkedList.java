package Auxiliar;

public class LinkedList<T> {
	
	// Internal Pointers
	private Node<T> first_node = null;
	private Node<T> last_node = null;
	private Node<T> actual_node = null;
	private int size = 0; /** Current elements count. */
	
	public LinkedList() {}
	
	/**
	 * Add a new Node to LinkedList.
	 * @param value value of the LinkedList to add
	 */
	public void addNode(T value1, T value2) {
		// Create a new Node. If there is no Node on list, this is the first Node.
		// Next node will be attached to the last Node on list.
		// Updates internal pointers.
		Node<T> new_node = new Node<T>(value1, value2);
		if (first_node == null) {
			first_node = new_node;
			actual_node = first_node;
		} else {
			last_node.setNext_node(new_node);
		}
		last_node = new_node;
		
		size++;
	}
	
	/**
	 * Moves internal LinkList pointer to next object.
	 * @return the current pointer object
	 */
	public void nextNode() {
		if (actual_node == null) return;
		Node<T> node = actual_node;
		actual_node = node.getNext_node();
	}

	/**
	 * Get current node value.
	 * @return
	 */
	public T getNodeValue1() {
		if (actual_node == null) return null;
		return actual_node.getValue1();
	}
	
	public T getNodeValue2() {
		if (actual_node == null) return null;
		return actual_node.getValue2();
	}
	
	/**
	 * Get next node of current node.
	 * @return next object related to current, or null if there is no next object. 
	 */
	public Node<T> getNextNode() {
		if (actual_node == null) return null;
		return actual_node.getNext_node();
	}

	/**
	 * Reset internal LinkedList current pointer to root.
	 */
	public void reset() {
		actual_node = first_node;
	}
	
	/**
	 * Returns the current size of the list
	 * @return Number of nodes in the LinkedList
	 */
	public int size(){
		return this.size;
	}
}

