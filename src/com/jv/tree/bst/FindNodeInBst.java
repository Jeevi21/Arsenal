package com.jv.tree.bst;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class FindNodeInBst {
	
	public static int isPresent(Node root, int val){
		
		if(root!=null) {
			if(root.data==val)
				return 1;
			else if(val < root.data)
				return isPresent(root.left, val);
			else
				return isPresent(root.right, val);
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
	}

}
