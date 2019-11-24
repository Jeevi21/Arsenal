package com.jv.greedy;

import java.util.Comparator;

public class HuffManComparator implements Comparator<Node> {

	@Override
	public int compare(Node node1, Node node2) {
		
		if(node1!=null && node2!=null) {
			
			if(node1.frequency > node2.frequency)
				return 1;
			else if(node1.frequency== node2.frequency)
				return 0;
			else
				return -1;
			
		}
		
		return 0;
	}
	

}
