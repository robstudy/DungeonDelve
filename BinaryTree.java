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

	public void print() {
		System.out.println("Placeholder");
	}
}
