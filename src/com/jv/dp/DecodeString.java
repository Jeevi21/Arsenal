package com.jv.dp;
import java.util.HashMap;
import java.util.Map;

class DecodeString {
  
  static int decodeVariationsUtil(String str,Map<String , Integer> cache){
    
    if(cache.containsKey(str))
      return cache.get(str);
   
    if(str.length()<=1){
     
      return 1;
    }
    else{
      
        int num = decodeVariationsUtil(str.substring(1) , cache); //1 char
        
        if(Integer.parseInt(str.substring(0,2)) <=26)
          num += decodeVariationsUtil(str.substring(2) , cache);
      
       cache.put(str,num);
       return num;
    }
    
  }
  
	static int decodeVariations(String S) {
		Map<String , Integer> cache = new HashMap<String, Integer>();
    return decodeVariationsUtil(S ,cache);
    
	}

	public static void main(String[] args) {
	  String str ="12";

	  int a =Integer.parseInt("00");
	  
	  System.out.println(a);
    System.out.println(decodeVariations(str));
    
	}
  

      
}