package com.jv.graph.unionfind;

/**
 * 
 * @author Jeevi.Natarajan
 * 
 *  I am using weighted union-find 
 *  
 *  Flattening i will add later..  - added
 * 
 *
 */
public class DisjointSet {

	private int [] ids ;
	private int [] size;
	
	public void makeSet(int N) {
		this.ids = new int[N];
		this.size = new int[N];
		
		for(int i=0;i<N;i++) {
			ids[i]=i;
			size[i]=1;
		}
	
	}
	
	private int getRoot(int a) {
		
		int node = a;
		while(ids[node]!=node) {
			node = ids[node];
		}
		
		return node;
		
	}
	
	public boolean find(int a , int b) { //Check if these nodes are connected
		int aRoot  = getRoot(a);
		int bRoot = getRoot(b);
		
		//Path compression  - Idea is to attach the a directly to root of a.
							//So that next time we need not traverse the tree to get the root.
		ids[a] = aRoot;
		ids[b] = bRoot;
		
		return aRoot == bRoot;
	}
	
	public void union(int a , int b) { //Merge these two sets
		//make the smaller sized set as child.
		int aRep = getRoot(a);
		int bRep = getRoot(b);
		
		if(size[aRep]<size[bRep]) {
			ids[aRep] = bRep;
			size[bRep]+=size[aRep];
		}
		else {
			ids[bRep] = aRep;
			size[aRep]+=size[bRep];
		}
	}

	public static void main(String[] args) {
		
	}
	

}
