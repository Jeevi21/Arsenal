package com.jv.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 
 * Huffman encoding  , decoding..
 * @author Jeevi.Natarajan
 *
 */
public class HuffmanCoding {
	
	
	public static Map<Character, Integer> getFrequency(String input){
		
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		
		char [] strArr = input.toCharArray();
		
		for(char c : strArr) {
			frequency.putIfAbsent(c, 0);
			frequency.put(c, frequency.get(c)+1);
		}
		return frequency;
	}
	
	public static PriorityQueue<Node> initializeQueue(Map<Character, Integer> frequency) {
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(frequency.size() , new HuffManComparator());
		
		for(Entry<Character, Integer> freq :  frequency.entrySet()) {
			queue.add(new Node(freq.getKey(),freq.getValue()));
		}
		
//		while(!queue.isEmpty()) {
//			Node node = queue.poll();
//			System.out.println(node.frequency);
//		}
		
		/*
				https://stackoverflow.com/a/3048584/2279170    
				--- I don't think the iterator from PriorityQueue provides the same ordering assurances that the overall class does
				The ordering assurance only applies to offer, take, poll, peek, and possibly some other methods.
			
		*/
		
		return queue;

	}
	
	public static Node buildHuffManTree(PriorityQueue<Node> queue) {
		
		//i take first two nodes and make them left and right sub-trees of the root which is sum of both.. 
		
		while(queue.size()>1) {
			
			Node left = queue.poll();
			Node right  = queue.poll();
			
			Node root = new Node(left.frequency + right.frequency);
			root.left = left;
			root.right = right;
			
			queue.add(root);			
			
		}
		
		
		return queue.poll();
		
	}
	
	private static void buildNewEncodingTableUtil(Node root , Map<Character,String> newTable , List<Character> path) {
		
		//This would be printing all paths till leaf..  My tree is binary tree only..
		
		if(root!=null) {
			
			if(root.left==null && root.right==null) {//Leaf.. Put the sequence into the map.
				
				String encoding = path.stream().map(e->e.toString()).collect(Collectors.joining()); //Good stuff
//				System.out.println("--encoding : " + encoding);
				newTable.put(root.data, encoding);
			}
			else {
				path.add('0');
				buildNewEncodingTableUtil(root.left, newTable, path);
				path.remove(path.size()-1);
				path.add('1');
				buildNewEncodingTableUtil(root.right, newTable, path);
				path.remove(path.size()-1);
						
			}
			
		}

	}
	
	public static Map<Character, String> buildNewEncodingTable(Node root) {
		
		Map<Character, String> hufmanEncodingTable = new HashMap<>();
		
		List<Character> path = new ArrayList<Character>();
		
		buildNewEncodingTableUtil(root, hufmanEncodingTable, path); //Consider using List.
		
		
		System.out.println("--New mapping" + hufmanEncodingTable);
		
		return hufmanEncodingTable;
	}
	
	
	public static Node buildHufffmanTree(String input) {

		 //1.Find frequency
		 Map<Character, Integer> frequencyMap = getFrequency(input);
	
		 //2.Create Nodes and put it into priority queue
		 PriorityQueue<Node> queue = initializeQueue(frequencyMap);
		 
		 //3.Build tree
		 Node root =  buildHuffManTree(queue);
		 
		 return root;
	}
	
	public static String encode(String input) {  
		
		//We are going to use huffman encoding.. Inorder to use hufman encoding .. we need to build tree.
		Node root = buildHufffmanTree(input);
		 
		 //4.Get the encoding table
		 Map<Character,String> encodingTable = buildNewEncodingTable(root);
		 
		 //5.Build the encoded string
		 StringBuffer sb = new StringBuffer();
		for(char c: input.toCharArray()) {
			sb.append(encodingTable.get(c));
		}
		
		return sb.toString();

	}
	
	
	public static void decodeUtil(String encodedString , Node root , StringBuffer sb) {
		
		if(encodedString.isEmpty())
			return;
		
		if(root!=null) {
			
			if(root.left==null && root.right==null) {
				System.out.println(root.data);
				sb.append(root.data);
			}
			else {
				
				char c = encodedString.charAt(0);
				
				if(c=='0')
					decodeUtil(encodedString.substring(1), root.left, sb);
				else
					decodeUtil(encodedString.substring(1), root.right, sb);
		
			}
			
			
		}
		
	}
	
	/**
	 * On decoding .. we receive the encoded string + the tree ---> here.. serializing , deserializing trees - plays a role.. {Try this next}
	 * @param encodedString
	 * @param root
	 */
	public static String decode(String encodedString , Node root) {
	
		StringBuffer sb = new StringBuffer();
		decodeUtil(encodedString, root, sb);
		
		return sb.toString();
		
	
	}

	
	
	
	public static void main(String[] args) {
		String str = "ADDBCADCCDCDCCC";
		
		//10111111000101110011011000
		
		//A -2  , B - 2 , C - 3 , D -1 , E -5
	
		String encodedString = encode(str);
		
		System.out.println("---- Input string  : " +  str);
		
		System.out.println("---- Encoded String : " +  encodedString);
		
		System.out.println("---- Decoded String : " + decode(encodedString, buildHufffmanTree(str)));
		
		
	}

}



class Node{
	Character data;
	int frequency;
	
	Node left,right;
	
	public Node(Character data , int frequency) {
		this.data = data;
		this.frequency = frequency;
	}
	
	public Node(int frequency) {
		this.data = null;
		this.frequency = frequency;
	}
	
}