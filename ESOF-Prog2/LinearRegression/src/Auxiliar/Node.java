package Auxiliar;

public class Node<T> {

	private Node<T> next_node = null; /** Pointer to next node. */
	private T value1; /** Node value 1. */
	private T value2; /** Node value 2. */
	
	/**
	 * Constructor. Sets Node value.
	 * @param value1 Node value 1
	 * @param value2 Node value 2
	 */
	public Node(T value1, T value2) {
		setValue(value1, value2);
	}
	
	/**
	 * Set next Node.
	 * @param next_node the next_node to set
	 */
	public void setNext_node(Node<T> next_node) {
		this.next_node = next_node;
	}

	/**
	 * Get next Node.
	 * @return the next_node
	 */
	public Node<T> getNext_node() {
		return next_node;
	}
	/**
	 * Set Node value.
	 * @param value1 Node value 1
	 * @param value2 Node value 2
	 */
	public void setValue(T value1, T value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	/**
	 * Get Node value 1.
	 * @return the value 1
	 */
	public T getValue1() {
		return value1;
	}
	
	/**
	 * Get Node value 2.
	 * @return the value 2
	 */
	public T getValue2() {
		return value2;
	}
}

