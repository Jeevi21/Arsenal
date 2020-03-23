package com.jv.tree;

public class InorderSuccessor {
	
	/*
	 * This will not work.... If you see.. prev is not always you inorder predecessor...
	 * 
	public static TreeNode inorder(TreeNode prev , TreeNode cur, int target) {
		
		if(cur==null)
			return null;
		if(prev.getData()== target) 
			return cur;
		
		inorder(cur.getLeft(), prev, target);
		inorder(cur.getRight(), cur, target);
	
	}
	*/
	
	/**
	 * Just trying to print the cur , prev of inorder traversal
	 * 
	 * Output : 
	 *  prev : null cur : [1]
		prev : [1] cur : [2]
		prev : [2] cur : [4]
		prev : [2] cur : [5]
		prev : [1] cur : [3]

	 *  If you see the above output. when you are at node 2. your prev is 1 (root of 2) . 
	 *  this shows.. finding inorder sucessor will not work. 
	 *  
	 *  My prev is always root...
	 * 
	 * @param prev
	 * @param curr
	 * @param prepend
	 */
	public static void printPrevInorder(TreeNode prev , TreeNode curr , String prepend) {
		
		
		if(curr!=null) {
			System.out.println("prev : " + prev + " cur : " + curr);
			
			
			printPrevInorder(curr, curr.getLeft() , prepend+"-----");
			
			printPrevInorder(curr, curr.getRight() , prepend+"-----");
		
		}
		
	}
	
	
	/**
	 * What will be my brute force?
	 *   If a not has right subtree.. then successor is smallest of right subtree. 
	 * 	 else , it is ROOT.
	 * 	 
	 */
	public static TreeNode findSuccessor(TreeNode root , int target , TreeNode parent) {
		
		if(root==null)
			return root;
		
		if(root.getData()==target) {
			//If right is there.. Find min
			if(root.getRight()!=null) {
				return findMin(root.getRight());
			}
			else
				return parent;
		}
		else {
			
			TreeNode res = findSuccessor(root.getLeft(), target, root);
			if(res==null)
				res  = findSuccessor(root.getRight(), target, root);
			
			return res;
		}
		
	}
	
	
	public static TreeNode findMin(TreeNode root) {
		if (root != null) {
			
			while (root.getLeft() != null)
				root = root.getLeft();
		}

		return root;
	}
	
	
	public static void main(String [] args) {
		TreeNode  root = TreeBuilder.getDefault();
		
//		printPrevInorder(null, root, "|-----");
		
		TreeNode res = findSuccessor(root, 2, null);
		System.out.print("Successor : " + res==null?-1:res.getData());
	}

}
