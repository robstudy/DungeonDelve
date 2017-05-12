public class BinaryTree<T extends Comparable<? super T>> {

	private class Node {
		private T data;
		private Node left;
		private Node right;
		
		Node() {
			data = null;
			left = null;
			right = null;
		}
		
		Node(T new_data) {
			data = new_data;
			right = null;
			left = null;
		}

		public Node get_right() {
			return right;
		}

		public Node get_left() {
			return left;
		}

		public T get_data() {
			return data;
		}

		public void set_right(Node n_right) {
			right = n_right;
		}

		public void set_left(Node n_left) {
			left = n_left;
		}
	}

	private Node root;
	private int size;

	BinaryTree() {
		root = null;
		size = 0;
	}

	public int return_size() {
		return size;
	}

	public void insert(T new_data) {
		if (root == null) {
			root = new Node(new_data);
			size++;
		} else {
			insert_n(new_data, root);
		}
	}

	private void insert_n(T new_data, Node ptr) {
		int comparison = ptr.data.compareTo(new_data);
		if(new_data == ptr.get_data()) return;
		if(comparison > 0) {
			if(ptr.get_left() != null) insert_n(new_data, ptr.get_left());
			else {
				ptr.set_left(new Node(new_data));
				size++;
			}
		}
		else if (comparison < 0) {
			if(ptr.get_right() != null) insert_n(new_data, ptr.get_right());
			else {
				ptr.set_right(new Node(new_data));
				size++;
			}
		}
	}

	public boolean search_tree(T s_data) {
		if(root == null) return false;
		else if (size == 1 && s_data != root.get_data()) return false;
		else return search(s_data, root);
	}

	private boolean search(T s_data, Node ptr) {
		if(ptr == null) return false;
		if(s_data == ptr.get_data()) {
			System.out.println("Found " + s_data + ". Retrace your steps to the entrance.");
			return true;
		}
		int comparison = ptr.data.compareTo(s_data);
		if(comparison > 0) {
			System.out.println("Take the left door at the " + ptr.get_data() + ".");
			return search(s_data, ptr.get_left());
		} else {
			System.out.println("Take the right door at the " + ptr.get_data() + "."); 
			return search(s_data, ptr.get_right());
		}
	}

	public void print_tree() {
		if(root != null) System.out.println(root.get_data());
		if(root.get_left() != null) print_node(root.getleft());
		if(root.get_right() != null) print_node(root.get_right());
	}

	private void print_node(Node ptr) {
		System.out.println(ptr.get_data());
		if(ptr.get_left() != null) print_node(ptr.get_left());
		if(ptr.get_right() != null) print_node(ptr.get_right());
	}
}
