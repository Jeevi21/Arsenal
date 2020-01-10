package com.jv.tree;

/**
 * https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 * @author Jeevi.Natarajan
 *
 */
public class MirrorTree {

	public static void convertToMirror(TreeNode root) {
		
		if(root!=null) {
			
			TreeNode tmp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(tmp);
			
			convertToMirror(root.getLeft());
			convertToMirror(root.getRight());
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = TreeBuilder.getDefault();
		TreeBuilder.inorder(root);
		convertToMirror(root);
		System.out.println();
		TreeBuilder.inorder(root);
	}
}

