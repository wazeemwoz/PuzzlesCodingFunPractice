import java.util.*;

/*
  Implement an algorithm to determine if a string has all unique characters.
  What if you cannot use additional data structures?
*/

public class UniqueChars{
  public static void main(String[] args){
        String s1 = "Helo Wrd";
        boolean b = test(s1);
        System.out.println(s1);
        System.out.println(b ? "True" : "False");
  }

  public static boolean test(String original){
    char[] s = original.toCharArray();
    Arrays.sort(s);
    
    if(s.length < 2){
      return true;
    }
    
    for(int i = 1; i < s.length; i++){
      if(s[i] == s[i-1]){
        return false;
      }
    }
    
    return true;
  }

}
