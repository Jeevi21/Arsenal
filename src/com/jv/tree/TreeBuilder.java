package com.jv.tree;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class TreeBuilder {
	
	public static TreeNode getDefault() {
		
		TreeNode root = new TreeNode(1);
		
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		
		return root;

	}
	
	public static void inorder(TreeNode root) {
		
		if(root!=null) {
			inorder(root.getLeft());
			System.out.print(root.getData() +"  ");
			inorder(root.getRight());
		}
	}

}
