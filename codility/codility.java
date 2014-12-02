// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 1){
            return A[0];
        }
        long sum_left = 0;
        long sum_right = 0;
        long diff = 100000l*1000;
        for(int i = 0; i < A.length; i++){
            sum_right += A[i];
        }
        for(int i = 0; i < A.length-1; i++){
            sum_left += A[i];
            sum_right -= A[i];
            if(Math.abs(sum_left - sum_right) < diff){
                diff = Math.abs(sum_left - sum_right);
            }
        }
        return (int)diff;
    }
}


//3rd task lesson 1 Frog jumps

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        return (int)Math.ceil(((double)Y-X)/D);
    }
}

/*
-----------------LESSON 2
*/
//Task 1 permutation
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        boolean[] duplicateTrack = new boolean[A.length];
        for(int i = 0; i < A.length; i++){
            if(A[i] > A.length)
                return 0;
            if(duplicateTrack[A[i]-1])
                return 0;
            duplicateTrack[A[i]-1] = true;
        }
        return 1;
    }
}

//task 2 frog river one
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        boolean[] found = new boolean[X+1];
        long sum = 0;
        for(int i = 0; i < A.length; i++){
			if(i <= X){
				sum += i;
			}
            if(A[i] <= X && found[A[i]] == false){
                found[A[i]] = true;
                sum -= A[i];
                if(sum == 0 && i >= X)
                    return i;
            }
        }
        return -1;
    }
}

//task 3
// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int v = 1;
        Arrays.sort(A);
        
        for(int i = 0; i < A.length; i++){
            if(A[i] < 1){
                continue;
            }
            if(A[i] != v)
                return v;
            if(i+1 < A.length && A[i] != A[i+1])
                v++;
        }
        if(A[A.length-1] == v)
            v++;
        return v;
    }
	
//task 4
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
	Attempt 1: naive implementation N*M runtime, only 77%
	Attempt 2: To avoid running through M once, tried to track the max and add it to all M at the end, initializing the array everytime max operation is done. This only got 88% guess the initialization was too expensive :(
	Attempt 3: Had to google for what I was missing, found its a simple as tracking a min value :C sad I didnt see it myself
*/

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] M = new int[N];
        int max = 0, min = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] > N){
				min = max;
            }else{
                if(M[A[i]-1] < min){
					M[A[i]-1] = min+1;
				}else{
					M[A[i]-1]++;
				}
                if(M[A[i]-1] > max){
                    max = M[A[i]-1];
                }
            }
        }
		
        for(int i = 0; i < M.length; i++){
			if(M[i] < min){
				M[i] = min;
			}
        }
        return M;
    }
}

//lesson 3
//passing cars task 1; respectable
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int ones = 0;
        long sum = 0;
        
        /*for(int i = 0; i < A.length; i++){
            if(A[i] == 1){
                ones++;   
            }
        }*/
        for(int i = A.length-1; i > -1; i--){
            if(A[i] == 1){
                ones++;   
            }else{
                sum += ones;   
            }
            
            if(sum > 1000000000l)
                return -1;
        }
        return (int)sum;
    }
}

//task 2 countdivs
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        
        //int _b = (int)B/K;
        //System.out.println("B=" + B + "; b = " + _b + "; other = " + (int)((B/K)-((B-A)/K)));
        
        if(A == 0){
            return (A==B) ? 0 : (int)((B/K));
        }
        return (A==B) ? 0 : (int)((B/K)-((B-A)/K));
    }
}

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        int _b = (int)B/K;
        int _a = (A > 0) ? (int)((A-1)/K) : -1;
        
        /*int rightAnswer = count_div(A,B,K); 
        if(rightAnswer != _b-_a){
            System.out.println(rightAnswer + " is the right answer");
        }*/
        
        return _b-_a;
    }
    
    public static int count_div(int a, int b, int k) {
        int counter = 0;
        for (int i = a; i <= b; i++) {
            if (i % k == 0) {
                counter++;
            }
        }
        return counter;
    }
}

// task 3 
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");
// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int P = 0, low_sum = 100000*10000, sum_left = A[0], lowestP = 0;
        double average = 10000;
        for(int Q = 1; Q < A.length; Q++){
            sum_left += A[Q];
            
            if((sum_left / (Q-P+1.0)) < average){
                average = (sum_left / (Q-P+1.0));
                lowestP = P;
            }
            
            System.out.print("()=" + ((A[Q-1]+A[Q])/2.0) + " avg=" + average + " P=" + P);
            if(((A[Q-1]+A[Q])/2.0) <= average){
                sum_left = (A[Q-1]+A[Q]);
                if(((A[Q-1]+A[Q])/2.0) == average){
                    lowestP = P;   
                }else{
                    lowestP = Q-1;   
                }
                P = Q-1;
                average = (sum_left / (Q-P+1.0));
            }
            System.out.println(" avg=" + average + " P=" + P);
        }
        
        System.out.println("Right answer is " + naive(A));
        
        return lowestP;
    }
    
    public int naive(int[] A){
        int sum = 0, smallest = 0;
        double lowestAverage = 10000;
        for(int i = 0; i < A.length-1; i++){
            sum = A[i];
            for(int j = i+1; j < A.length; j++){
                sum += A[j];
                if(sum/(j-i+1.0) < lowestAverage){
                    lowestAverage = sum/(j-i+1.0);
                    //System.out.println(i + " = " + lowestAverage);
                    smallest = i;
                }
            }
        }
        return smallest;
    }
}

//task 4
// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] result = new int[P.length];
        
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> C = new ArrayList<Integer>();
        ArrayList<Integer> G = new ArrayList<Integer>();
        ArrayList<Integer> T = new ArrayList<Integer>();
        
        for(int i = 0; i < S.length(); i++){
            switch(S.charAt(i)){
                case 'A': A.add(i); break;
                case 'C': C.add(i); break;
                case 'G': G.add(i); break;
                default: T.add(i); break;
            }
        }
        
        ArrayList<Integer>[] neu = new ArrayList[4];
        neu[0] = A;
        neu[1] = C;
        neu[2] = G;
        neu[3] = T;
        
        for(int i = 0; i < P.length; i++){
            for(int n = 0; n < neu.length; n++){
                for(Integer a : neu[n]){
                    if(a >= P[i] && a <= Q[i]){
                        result[i] = n+1;
                        break;
                    }
                }
                if(result[i] > 0){
                    break;
                }
            }
        }
        return result;
    }
}

//Lesson 4
//task 1
// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length < 1){
            return 0;
        }
        
        Arrays.sort(A);
        int distinct = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] != A[i-1]){
                distinct++;   
            }
        }
        return distinct;
    }
}
//task 2
// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        
        return A[A.length-1] * A[A.length-2] * A[A.length-3];
    }
}

//task 3
// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        return naive(A);
    }
    
    public int naive(int[] A){
        for(int p = 0; p < A.length-2; p++){
            for(int q = p+1; q < A.length-1; q++){
                for(int r = q+1; r < A.length; r++){
                    if(A[p]+A[q] <= A[r])
                        break;
                    if(A[q]+A[r] <= A[p])
                        break;
                    if(A[r]+A[p] <= A[q])
                        break;
                    
                    System.out.println("p=" + A[p] + " q=" + A[q] + " r=" + A[r]);
                    return 1;
                }
            }
        }
        return 0;
    }
}

//lesson 5
// you can also use imports, for example:
import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        
        StringBuilder sb = new StringBuilder();
        
        if(S.length() % 2 > 0){
            return 0;
        }
        
        for(char c : S.toCharArray()){
            switch(c){
                case('}'): 
                    if(sb.length() == 0 || sb.charAt(sb.length()-1) != '{'){
                        return 0;
                    }
                    sb.setLength(sb.length()-1);
                    break;
                case(']'): 
                    if(sb.length() == 0 || sb.charAt(sb.length()-1) != '['){
                        return 0;
                    }
                    sb.setLength(sb.length()-1);
                    break;
                case(')'):
                    if(sb.length() == 0 || sb.charAt(sb.length()-1) != '('){
                        return 0;
                    }
                    sb.setLength(sb.length()-1);
                    break;
                default: sb.append(c); break;
            }
        }
        if(sb.length() > 0){
            return 0;
        }
        return 1;
    }
}