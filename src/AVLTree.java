
public class AVLTree {
	
	static Node rooted;
	
	public static Node find(int target, Node root) {
		
		if(root.key == target) {
			return root;
		}
		else if(target < root.key) {
			if(root.left == null) {
				return root;
			}
			return find(target, root.left);
		}
		else {
			if(root.right == null) {
				return root;
			}
			return find(target, root.right);
		}
	}
	
	
	public static void insert(int key, Node root) {
		Node parent = find(key, root);
		Node newNode = new Node(key);
		newNode.parent = parent;
		newNode.height = 1;
		if(newNode.key < parent.key) {
			parent.left = newNode;
		}
		else {
			parent.right = newNode;
		}
		newNode.triggerHeights();
		rebalance(parent);
		
	}
	
	public static void rebalance(Node root) {
		
		
		int lHeight = (root.left != null) ? root.left.height : 0;
		int rHeight = (root.right != null) ? root.right.height : 0;
		
		
		if(Math.abs(lHeight-rHeight) <= 1) {}
		
		else if(rHeight > lHeight) {
			rotateRight(root);
		}
		else {
			rotateLeft(root);
		}
		
		if(root.parent != null) rebalance(root.parent);
	}
	
	public static void rotateRight(Node root) {
		Node pivot = root.right;
		
		Node oldPLeft = pivot.left;
		
		pivot.parent = root.parent;
		pivot.left = root;
		root.parent = pivot;
		root.right = oldPLeft;
		if(oldPLeft != null) {
			oldPLeft.parent = root;
		}
		
//		pivot.height++;
//		root.height--;
//		try {root.left.height--;} catch(NullPointerException e) {}
//		try {pivot.right.height++;} catch(NullPointerException e) {}
		
		if(pivot.parent == null) {
			rooted = pivot;
		}
		else if(pivot.parent.left == root) {
			pivot.parent.left = pivot;
		}
		else {
			pivot.parent.right = pivot;
		}
		
		adjustHeights(rooted);
	}
	
	public static void rotateLeft(Node root) {
		Node pivot = root.left;
		
		Node oldPRight = pivot.right;
		
		pivot.parent = root.parent;
		pivot.right = root;
		root.parent = pivot;
		root.left = oldPRight;
		if(oldPRight != null) {
			oldPRight.parent = root;
		}
		
//		pivot.height++;
//		root.height--;
//		
//		try {root.right.height--;} catch(NullPointerException e) {}
//		try {pivot.left.height++;} catch(NullPointerException e) {}
		
		if(pivot.parent == null) {
			rooted = pivot;
		}
		else if(pivot.parent.left == root) {
			pivot.parent.left = pivot;
		}
		else {
			pivot.parent.right = pivot;
		}
		
		adjustHeights(rooted);
	}
	
	public static int adjustHeights(Node root) {
		int lHeight = (root.left != null) ? adjustHeights(root.left) : 0;
		int rHeight = (root.right != null) ? adjustHeights(root.right) : 0;
		
		int newHeight = Math.max(lHeight, rHeight)+1;
		root.height = newHeight;
		
		return newHeight;
	}
	
	
	public static Node next(int key, Node root) {
		Node initial = find(key, root);
		if(initial.right != null) {
			Node current = initial.right;
			while(current.left != null) {
				current = current.left;
			}
			return current;
		}
		else {
			Node current = initial.parent;
			while(current != null) {
				if(current.key > initial.key) return current;
				if(current.parent == null) break;
				
				current = current.parent;
			}
		}
		
		return null;
	}
	
	public static void delete(int key, Node root) {
		Node toDelete = find(key, root);
		Node finParent = toDelete.parent;
		
		if(toDelete.left == null && toDelete.right == null) {
			eraseNode(toDelete);
		}
		else if(toDelete.left == null || toDelete.right == null) {
			Node child = (toDelete.left != null) ? toDelete.left : toDelete.right;
			child.parent = toDelete.parent;
			if(toDelete.parent.left == toDelete) {
				toDelete.parent.left = child;
			}
			else {
				toDelete.parent.right = child;
			}
			 toDelete.parent = null;
		}
		else {
			Node next = next(toDelete.key, root);
			int nextKey = next.key;
			delete(next.key, root);
			toDelete.key = next.key;
		}
		
		adjustHeights(root);
		rebalance(finParent);
	}
	
	private static void eraseNode(Node toDelete) {
		if(toDelete.parent != null) {
			if(toDelete.parent.left == toDelete) {
				toDelete.parent.left = null;
			}
			else {
				toDelete.parent.right = null;
			}
		}
		toDelete.parent = null;
	}
	
	

	
	public static void main(String[] args) {
		rooted = new Node(5);
		insert(4, rooted);
		insert(3, rooted);
		insert(7, rooted);
		insert(9, rooted);
		insert(11, rooted);
		insert(1, rooted);
		delete(7, rooted);
		
		System.out.println("Log");
	}
}

class Node {
	
	

	
	int key;
	int height;
	Node left;
	Node right;
	Node parent;
	
	
	Node(int key) {
		this.key = key;
		this.height = 1;
	}
	
	void triggerHeights() {
		int lHeight = (left != null) ? left.height : 0;
		int rHeight = (right != null) ? right.height : 0;
		height = Math.max(lHeight, rHeight)+1;
		if(parent != null) {
			parent.triggerHeights();
		}
	}

	
	@Override
	public String toString() {
		return String.valueOf(key) + ", H:"+String.valueOf(height);
	}
}