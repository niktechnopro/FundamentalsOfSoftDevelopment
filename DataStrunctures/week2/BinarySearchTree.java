


public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	
	// Method #1.
	public Node findNode(E val) {

		/* IMPLEMENT THIS METHOD! */
		
		return return findNode(root, val); // this line is here only so this code will compile if you don't modify it

	}

	protected Node findNode(Node n, E val) {
		if(n == null) return null;
		if(n.value.compareTo(val) == 0) {
//			System.out.println("the node we were looking for: " + n.value);
			return n;
		}else if(n.value.compareTo(val) > 0) {
			return findNode(n.leftChild, val);
		}else {
			return findNode(n.rightChild, val);
		}
	}
	
	// Method #2.
	protected int depth(E val) {

		/* IMPLEMENT THIS METHOD! */
		if(val == null) return -1;
		int depth = 0;
		int d = traverseInOrder(root, depth, val);
		System.out.println("depth: " + d + " for value " + val);
		return d; // this line is here only so this code will compile if you don't modify it

	}

	protected int traverseInOrder(Node n, int depth, E val) {
		
		if(n.value.compareTo(val) == 0 ) return depth;
		depth ++;	
		if(n.value.compareTo(val) > 0){
			return traverseInOrder(n.leftChild, depth, val);
		}else{
			return traverseInOrder(n.rightChild, depth, val);
//			System.out.println(n.leftChild.value + " " + depth + " " + val);
//			System.out.println(n.rightChild.value + " " + depth + " " + val);
		}
	}
	
	// Method #3.
	protected int height(E val) {

		/* IMPLEMENT THIS METHOD! */
		if (val == null) return -1; 
		//we just need to check if node has children and keep going down
		//let's get the Node that contains that value and check if it has children
		Node ourNode = findNode(val);
		//next we can invoke traverseInOrder
		int heightLeft = 0;
		int heightRight = 0;
		if (ourNode.leftChild != null) {
			heightLeft = traverseInOrderHeight(ourNode, 0, true);//where 0 is a starting height
		}
		if (ourNode.rightChild != null) {
			heightRight = traverseInOrderHeight(ourNode, 0, false);
		}
		int height = (heightLeft > heightRight) ? heightLeft : heightRight;
		System.out.println("height: " + height + " for value: " + val);
		return height; // this line is here only so this code will compile if you don't modify it

	}

	protected int traverseInOrderHeight(Node n, int height, boolean left) {
		if(n.leftChild != null && left) {//check if left child exists
			height ++;
			return traverseInOrderHeight(n.leftChild, height, left);
		}
		if (n.rightChild != null && left){//check if right child exists
			height ++;
			return traverseInOrderHeight(n.rightChild, height, left);
		}
		return height;
	}


	// Method #4.
	protected boolean isBalanced(Node n) {

		/* IMPLEMENT THIS METHOD! */
		if(n.value == null) return false;
		if(n.leftChild == null || n.rightChild == null) return false;
		//if |height of left child - height of right child| < = 1 - Node considered balanced
		//let's check the height of left branch
		int heightLeftChild = traverseInOrderHeight(n, 0, true);		
		int heightRightChild = traverseInOrderHeight(n, 0, false);
		if(heightLeftChild > 0) {
			heightLeftChild --;
		}
		if(heightRightChild > 0) {
			heightRightChild --;
		}
		if (Math.abs(heightLeftChild - heightRightChild) > 1 ) {
			System.out.println("is Node: " + n.value + "balanced? " + false);
			return false;
		}
		//let's check the height of right branch
//		System.out.println("is Node: " + n.value + " balanced? " + true);		
				
		return true; // this line is here only so this code will compile if you don't modify it

	}
	
	// Method #5. .
	public boolean isBalanced() {

		/* IMPLEMENT THIS METHOD! */
		Node n = null;
			for(int i = 0; i < testArray.length; i++) {//populate/create binary tree
//				tree.add(testArray[i]);
				n = tree.findNode(testArray[i]);
				if(n != null && isBalanced(n)) {
					return false;
				}
			}
			
			
			return true; // this line is here only so this code will compile if you don't modify it

	}

}
