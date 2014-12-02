import java.util.*;

/*
  Given two strings, write a method to decide to decide if 
  one is a permutation of the other.
*/

public class PermutationTest{

  public static void main(String []args){
    String s1 = "abcde";
    String s2 = "bdcea";
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(isPerm(s1, s2) ? "True" : "False");
  }
  
  public static boolean isPerm(String o, String s){
    
    int[] c = new int[256];//Assuming it is ASCII
    
    if(s.length() !=  o.length()){
      return false;
    }
    
    for(int i = 0; i < o.length(); i++){
      c[o.charAt(i)]++;
    }

    for(int i = 0; i < s.length(); i++){
      if(c[s.charAt(i)] < 1){
        return false;
      }
      
      c[s.charAt(i)]--;
    }
    
    return true;
  }
}
