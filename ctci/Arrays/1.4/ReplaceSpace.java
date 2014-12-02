import java.util.*;

/*
  Write a method to replace all spaces in a string with '%20'.
  You may assume that the string has a sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementation in Java, please use a character array so that you can perform this operation in place.)
*/

public class ReplaceSpace{
  public static void main(String[] args){
    char[] s = "This is a message        ".toCharArray(); //17
    int length = 17;
    char c = ' ';
    String replaceWith = "%20";
    
    System.out.println(s);
    System.out.println(replaceChar(s, length, c, replaceWith));
  }
  
  public static String replaceChar(char[] s, int l, char c, String r){
    int i;
    int c_cnt = 0;
    boolean count = false;
    
    for(int n = s.length-1; n >= 0;n--){
      if(s[n] == c){
        if(count){
          c_cnt++;
        }
      }else{
        count = true;
      }
    }
    
    i = l + (r.length() * (c_cnt-1)) -1;// c_cnt is minused since we dont want to count the space for the character again. Ending -1 is because of 0 based index array.
    
    for(l = l-1; l >= 0; l--){
      if(s[l] == c){
        for(int y = r.length()-1; y >= 0; y--, i--){
          s[i] = r.charAt(y);
        }
      }else{
        s[i] = s[l];
        i--;
      }
    }
    
    return new String(s);
  }
}
