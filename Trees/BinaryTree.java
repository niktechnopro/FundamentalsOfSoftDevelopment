import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E extends Comparable<E>> {
	// Root of Binary Tree 
	protected Node root = null;
	static int [] testArray = new int[] {8,6,4,16,2,20,10,12,9};
	static BinaryTree tree;
	
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			System.out.println("does this method ever run? ");
			if ((obj instanceof BinaryTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinaryTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	
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
	
	
	//next 2 methods are to properly add the node to the tree
    public boolean add(E val) {
		if (root == null) {//if there is no root - we create root first
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
		if (cmp == 0) {// this ensures that the same value does not appear more than once
			return false; 
		} else if (cmp < 0) {//if new value is less than parent node(root)
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);//recursive
			} 	
		} else {
			if (n.rightChild == null) {//if new value is more than parent(root)
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);//recursive
			} 	
		}
	}
    
    //next 2 methods are to remove node
    public boolean remove(E val) {
		return remove(root, null, val);
	}
    
    protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
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
    //end of methods to remove node
    
    /*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	
	// Method #1.
    //next 2 methods are for finding the node
	public Node findNode(E val) {
		/* IMPLEMENT THIS METHOD! */
		//System.out.println(findNode(root, val).value);
		return findNode(root, val); // this line is here only so this code will compile if you don't modify it

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
	//end of methods for finding the node;
	
	// Method #2.
	//next 2 methods are to find the depth
	// Method #2.
		protected int depth(E val) {
			/* IMPLEMENT THIS METHOD! */
			if(val == null) return -1;
			int d = traverseInOrder(root, val);
			System.out.println("depth: " + d + " for value " + val);
			return d; // this line is here only so this code will compile if you don't modify it

		}
	        
	    private int traverseInOrder(Node n, E val) {    
	        if (n != null && findNode(val) != null) {
				if (val.equals(n.value)) {
					return 0;
				} else if (val.compareTo(n.value) > 0) {
					return 1 + traverseInOrder(n.rightChild, val);
				} else if (val.compareTo(n.value) < 0) {
					return 1 + traverseInOrder(n.leftChild, val);
				}
			}
			return -1;
		}
	//end of finding depth
	
	// Method #3. which is the greatest number of nodes between that node and any descendant node that is a leaf
	protected int height(E val) {//height of the leaf = 0
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
	
	//end of METHOD#3
	
	// Method #4.
	protected boolean isBalanced(Node n) {
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
//			Node n = null;
//			for(int i = 0; i < testArray.length; i++) {//populate/create binary tree
////				tree.add(testArray[i]);
//				n = tree.findNode(testArray[i]);
//				if(n != null && isBalanced(n)) {
//					return false;
//				}
//			}
//			return true; // this line is here only so this code will compile if you don't modify it
			
			return isBalanced(root);
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tree = new BinaryTree();
//		tree.add(6);
//		tree.add(2);
//	    tree.add(4);
//	    tree.add(8);
//	    tree.add(3);
//	    tree.add(5);
//	    tree.add(7);
//	    tree.add(9);
		for(int i = 0; i < testArray.length; i++) {//populate/create binary tree
			tree.add(testArray[i]);
		}
	    
	    
	    System.out.println("root value: " + tree.root.value);
	    tree.findNode(24);
//	    tree.depth(6);
//	    tree.height(16);
//	    tree.isBalanced(tree.findNode(4));
	    System.out.println("is tree balanced? " + tree.isBalanced());//checking if tree is balanced
	}

}
