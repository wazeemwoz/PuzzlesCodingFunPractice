
public long sumMultiples(int max, int[] values){
	long total = 0;
	for(int i = 0; i < max; i++){
		if(isMultiple(i, values))
			total += i;
	}
	return total;
}

public boolean isMultiple(int n, int[] values){
	for(int i = 0; i < values.length; i++){
		if(n % values[i] == 0)
			return true;
	}
	return false;
}

public long sumMultiples2(int max, int[] values){
	long total = 0;
	for(int i = 0; i < values.length; i++){
		for(long m = values[i]; m < max; m+=values[i]){
			if(isMultiple(m, i, values))
				total += m;
		}
	}
	return total;
}

public boolean isMultiple2(long n, int value, int[] values){
	for(int i = 0; i < value; i++){
		if(n % values[i] == 0)
			return false;
	}
	return true;
}

//Problem 2
public static long sumFibonaccis(long max){
	long total = 0;
	long buffer = 0;
	long prev = 0;
	for(long i = 1; i < max;buffer=i, i+=prev){
		prev = buffer;
		total += i%2 == 0 ? i : 0;
	}
	return total;
}

//problem 3
public static long largestPrime(long n){
	PriorityQueue<Long> queue = new PriorityQueue<Long>();
	for(int m = 2; m < n; m++){
		if(n % m == 0){
			if(isPrime((long)n/m)){
				return (long)n/m;
			}
			n /= m;
		}
	}
	return 1;
}

public static boolean isPrime(long n){
	long limit = (long) n/2;
	for(int m = 2; m < limit; m++){
		if(n % m == 0)
			return false;
	}	
	return true;
}
//(Working solution)

	//problem 3
	public static long largestPrime(long n){
		long root = (long) (Math.sqrt(n)+1);
		for(int m = 2; m < root; m++){
			if(n % m == 0){
				if(isPrime((long)n/m))
					return (long)n/m;
			}
		}
		return 1;
	}
	
	public static boolean isPrime(long n){
		long limit = (long) n/2;
		for(int m = 2; m < limit; m++){
			if(n % m == 0)
				return false;
		}	
		return true;
	}
//problem 4

	public static long largestPalindromeProduct(int digitCount){
		long smallest = (long)Math.pow(10, digitCount-1);
		long largest = 0;
		for(long l=(long)Math.pow(10, digitCount)-1; l > smallest; l--){
			for(long r=(long)Math.pow(10, digitCount)-1; r > smallest; r--){
				if(isPalindrome(l*r) && l*r > largest){
					//System.out.println(l + " * " + r);
					largest = l*r;
				}
			}
		}
		return largest;
	}
	
	public static boolean isPalindrome(long product){
		int buffer = 0;
		long reversed = 0;
		long p = 0;
		for(p = product; p > 9; p /= 10){
			buffer = (int)(p % 10);
			reversed = (reversed*10)+buffer;
		}
		reversed = (reversed*10)+p;
		if(product == reversed){
			return true;
		}
		return false;
	}

//problem 5

	public static long smallestCommonProduct(int start, int end){
		long commonProduct = 1;
		long remainder = 0;
		for(int x = start; x <= end; x++){
			if(!isPrime(x)){
				remainder = commonProduct % x;
				if(remainder > 0){
					commonProduct *= (long)(x/remainder);
				}
			}else{
				commonProduct *= x;
			}
		}
		return commonProduct;
	}
	
	public static boolean isPrime(long n){
		long limit = (long) n/2;
		for(int m = 2; m < limit; m++){
			if(n % m == 0)
				return false;
		}	
		return true;
	}
	
// problem 6

	public static long sumSquares(int size){
		long sum = 0;
		long y = 0;
		for(int x = 1; x <= size; x++){
			sum+=(x*x);
			y+=x;
		}
		
		return (y*y)-sum;
	}
	
//problem 7
	public static long findPrime(int n){
		ArrayList<Long> primes = new ArrayList<Long>();
		for(long m = 2; primes.size() != n; m++){
			updatePrime(m, primes);
		}
		return primes.get(n-1);
	}
	
	public static boolean updatePrime(long n, ArrayList<Long> primes){
		long limit = ((long)Math.sqrt(n))+1;
		for(Long prime: primes){
			if(prime.longValue() > limit)
				break;
			if(n % prime.longValue() == 0)
				return false;
		}
		primes.add(new Long(n));
		return true;
	}
	
//problem 8
	public static String largeNumber = ("73167176531330624919225119674426574742355349194934" +
"96983520312774506326239578318016984801869478851843" +
"85861560789112949495459501737958331952853208805511" +
"12540698747158523863050715693290963295227443043557" +
"66896648950445244523161731856403098711121722383113" +
"62229893423380308135336276614282806444486645238749" +
"30358907296290491560440772390713810515859307960866" +
"70172427121883998797908792274921901699720888093776" +
"65727333001053367881220235421809751254540594752243" +
"52584907711670556013604839586446706324415722155397" +
"53697817977846174064955149290862569321978468622482" +
"83972241375657056057490261407972968652414535100474" +
"82166370484403199890008895243450658541227588666881" +
"16427171479924442928230863465674813919123162824586" +
"17866458359124566529476545682848912883142607690042" +
"24219022671055626321111109370544217506941658960408" +
"07198403850962455444362981230987879927244284909188" +
"84580156166097919133875499200524063689912560717606" +
"05886116467109405077541002256983155200055935729725" +
"71636269561882670428252483600823257530420752963450" );
	public static long largestProductInSeries(String s, int pSize){
		String largestDigits = "";
		long largestProduct = 0;
		String digits = "";
		long product = 0;
		for(int i = 0; i+pSize < s.length(); i++){
			digits = s.substring(i, i+pSize);
			product = product(digits);
			if(product > largestProduct){
				largestProduct = product;
				largestDigits = digits;
			}
		}
		return largestProduct;
	}
	
	public static long product(String sDigits){
		long product = 1;
		for(int i = 0; i < sDigits.length();i++){
			int d = ((int)sDigits.charAt(i))-48;
			if(d == 0){
				return 0;
			}
			product *= d;
		}
		return product;
	}

//problem 9

	/*
	Wrong solution doesnt do what is asked
	*/
	public static int pythogoreanTriplet(int n){
		int a, b=2, c=3, p;
		for(a = 1; a < b; a++){
			for(b = (a+1); b < c; b++){
				for(c = (b+1); c < n; c++){
					p = (a*a)+(b*b)+(c*c);
					if(p == n){
						return a*b*c;
					}
					if(p > 1000){
						break;
					}
				}
			}
		}
		return a*b*c;
	}
	/* Correct solution */
	public static int pythogoreanTriplet(int n){
		int a, b=2, c=3;
		for(a = 1; a < b; a++){
			for(b = (a+1); b < c; b++){
				for(c = (b+1); c < n; c++){
					if((a*a)+(b*b) == (c*c) && a+b+c == n){
						return a*b*c;
					}
				}
			}
		}
		return a*b*c;
	}
	
//Problem 10
	public static long sumPrimes(long n){
		ArrayList<Long> primes = new ArrayList<Long>();
		long total = 0;
		for(long m = 2; m < n; m++){
			total += updatePrime(m, primes);
		}
		return total;
	}
	
	public static long updatePrime(long n, ArrayList<Long> primes){
		long limit = ((long)Math.sqrt(n))+1;
		for(Long prime: primes){
			if(prime.longValue() > limit)
				break;
			if(n % prime.longValue() == 0)
				return 0;
		}
		primes.add(new Long(n));
		return n;
	}
	
//problem 11

	public static String stringGrid = ("08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 " +
"49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 " +
"81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 " +
"52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 " +
"22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 " +
"24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 " +
"32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 " +
"67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 " +
"24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 " +
"21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 " +
"78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 " +
"16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 " +
"86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 " +
"19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 " +
"04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 " +
"88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 " +
"04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 " +
"20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 " +
"20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 " +
"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48");

	public static long largestProductInGrid(int x_s, int y_s, String s_grid, int pSize){
		int[][] grid = convertToIntGrid(x_s, y_s, s_grid);
		long largestProduct = 0;
		long dbproduct, dproduct, dfproduct, fproduct;
		
		for(int x = 0; x < x_s; x++){
			for(int y = 0; y < y_s; y++){
				dbproduct=1; dproduct=1; dfproduct=1; fproduct=1;
				for(int p = 0; p < pSize; p++){
					dbproduct *= getFromGrid(x-p,y+p,grid);
					dproduct *= getFromGrid(x,y+p,grid);
					dfproduct *= getFromGrid(x+p,y+p,grid);
					fproduct *= getFromGrid(x+p,y,grid);
				}
				largestProduct = Math.max(largestProduct, dbproduct);
				largestProduct = Math.max(largestProduct, dproduct);
				largestProduct = Math.max(largestProduct, dfproduct);
				largestProduct = Math.max(largestProduct, fproduct);
			}
		}
		return largestProduct;
	}

	public static int getFromGrid(int x, int y, int[][] grid){
		if(x < 0 || x >= grid.length)
			return 0;
			
		if(y < 0 || y >= grid[x].length)
			return 0;
		
		return grid[x][y];
	}
	
	
	public static int[][] convertToIntGrid(int x_s, int y_s, String s_grid){
		int[][] int_grid = new int[x_s][y_s];
		String[] grid = s_grid.split(" ");
		
		for(int x = 0; x < x_s; x++){
			for(int y = 0; y < y_s; y++){
				int_grid[x][y] = Integer.parseInt(grid[(x_s*y)+x]);
			}
		}
		
		return int_grid;
	}
	
//problem 12
	public static long divisibleTriangleNumber(int divisorsNeeded){
		long triangleNumber = 0;
		long divCount = 0;
		for(int i = 0; divCount < divisorsNeeded; i++){
			triangleNumber += i;
			divCount = divisorCount(triangleNumber);
		}
		return triangleNumber;
	}

	public static int divisorCount(long n){
		long limit = ((long)Math.sqrt(n))+1;
		int counter = 0;
		for(long m = 1; m < limit; m++){
			if(n % m == 0)
				counter += 2;
		}
		return counter;
	}

//problem 13

	public static String getLargeSum(String[] s_nums){
		StringBuilder acc = new StringBuilder(s_nums[0]);
		for(int i = 1; i < s_nums.length; i++){
			for(int posm = s_nums[i].length()-1, acc_idx = 0; posm > -1; posm--, acc_idx++){
				acc = addCharNumToStringNum(acc, ((int)s_nums[i].charAt(posm))-48, (acc.length()-1)-acc_idx);
			}
		}
		return acc.toString();
	}

	public static StringBuilder addCharNumToStringNum(StringBuilder n, int i, int index){
		int a = 0;
		if(index > -1){
			a = ((int)n.charAt(index))-48;
			a = a+i;
			if(a > 9){ // 57 = '9'
				a -= 10;
				n.setCharAt(index, (char)(a+48));
				n = addCharNumToStringNum(n, 1, index-1);
			}else{
				n.setCharAt(index, (char)(a+48));
			}
		}else{
			n.insert(0, Integer.toString(i));
		}
		return n;
	}
	
static String[] st_nums = {"37107287533902102798797998220837590246510135740250" ,
"46376937677490009712648124896970078050417018260538" ,
"74324986199524741059474233309513058123726617309629" ,
"91942213363574161572522430563301811072406154908250" ,
"23067588207539346171171980310421047513778063246676" ,
"89261670696623633820136378418383684178734361726757" ,
"28112879812849979408065481931592621691275889832738" ,
"44274228917432520321923589422876796487670272189318" ,
"47451445736001306439091167216856844588711603153276" ,
"70386486105843025439939619828917593665686757934951" ,
"62176457141856560629502157223196586755079324193331" ,
"64906352462741904929101432445813822663347944758178" ,
"92575867718337217661963751590579239728245598838407" ,
"58203565325359399008402633568948830189458628227828" ,
"80181199384826282014278194139940567587151170094390" ,
"35398664372827112653829987240784473053190104293586" ,
"86515506006295864861532075273371959191420517255829" ,
"71693888707715466499115593487603532921714970056938" ,
"54370070576826684624621495650076471787294438377604" ,
"53282654108756828443191190634694037855217779295145" ,
"36123272525000296071075082563815656710885258350721" ,
"45876576172410976447339110607218265236877223636045" ,
"17423706905851860660448207621209813287860733969412" ,
"81142660418086830619328460811191061556940512689692" ,
"51934325451728388641918047049293215058642563049483" ,
"62467221648435076201727918039944693004732956340691" ,
"15732444386908125794514089057706229429197107928209" ,
"55037687525678773091862540744969844508330393682126" ,
"18336384825330154686196124348767681297534375946515" ,
"80386287592878490201521685554828717201219257766954" ,
"78182833757993103614740356856449095527097864797581" ,
"16726320100436897842553539920931837441497806860984" ,
"48403098129077791799088218795327364475675590848030" ,
"87086987551392711854517078544161852424320693150332" ,
"59959406895756536782107074926966537676326235447210" ,
"69793950679652694742597709739166693763042633987085" ,
"41052684708299085211399427365734116182760315001271" ,
"65378607361501080857009149939512557028198746004375" ,
"35829035317434717326932123578154982629742552737307" ,
"94953759765105305946966067683156574377167401875275" ,
"88902802571733229619176668713819931811048770190271" ,
"25267680276078003013678680992525463401061632866526" ,
"36270218540497705585629946580636237993140746255962" ,
"24074486908231174977792365466257246923322810917141" ,
"91430288197103288597806669760892938638285025333403" ,
"34413065578016127815921815005561868836468420090470" ,
"23053081172816430487623791969842487255036638784583" ,
"11487696932154902810424020138335124462181441773470" ,
"63783299490636259666498587618221225225512486764533" ,
"67720186971698544312419572409913959008952310058822" ,
"95548255300263520781532296796249481641953868218774" ,
"76085327132285723110424803456124867697064507995236" ,
"37774242535411291684276865538926205024910326572967" ,
"23701913275725675285653248258265463092207058596522" ,
"29798860272258331913126375147341994889534765745501" ,
"18495701454879288984856827726077713721403798879715" ,
"38298203783031473527721580348144513491373226651381" ,
"34829543829199918180278916522431027392251122869539" ,
"40957953066405232632538044100059654939159879593635" ,
"29746152185502371307642255121183693803580388584903" ,
"41698116222072977186158236678424689157993532961922" ,
"62467957194401269043877107275048102390895523597457" ,
"23189706772547915061505504953922979530901129967519" ,
"86188088225875314529584099251203829009407770775672" ,
"11306739708304724483816533873502340845647058077308" ,
"82959174767140363198008187129011875491310547126581" ,
"97623331044818386269515456334926366572897563400500" ,
"42846280183517070527831839425882145521227251250327" ,
"55121603546981200581762165212827652751691296897789" ,
"32238195734329339946437501907836945765883352399886" ,
"75506164965184775180738168837861091527357929701337" ,
"62177842752192623401942399639168044983993173312731" ,
"32924185707147349566916674687634660915035914677504" ,
"99518671430235219628894890102423325116913619626622" ,
"73267460800591547471830798392868535206946944540724" ,
"76841822524674417161514036427982273348055556214818" ,
"97142617910342598647204516893989422179826088076852" ,
"87783646182799346313767754307809363333018982642090" ,
"10848802521674670883215120185883543223812876952786" ,
"71329612474782464538636993009049310363619763878039" ,
"62184073572399794223406235393808339651327408011116" ,
"66627891981488087797941876876144230030984490851411" ,
"60661826293682836764744779239180335110989069790714" ,
"85786944089552990653640447425576083659976645795096" ,
"66024396409905389607120198219976047599490197230297" ,
"64913982680032973156037120041377903785566085089252" ,
"16730939319872750275468906903707539413042652315011" ,
"94809377245048795150954100921645863754710598436791" ,
"78639167021187492431995700641917969777599028300699" ,
"15368713711936614952811305876380278410754449733078" ,
"40789923115535562561142322423255033685442488917353" ,
"44889911501440648020369068063960672322193204149535" ,
"41503128880339536053299340368006977710650566631954" ,
"81234880673210146739058568557934581403627822703280" ,
"82616570773948327592232845941706525094512325230608" ,
"22918802058777319719839450180888072429661980811197" ,
"77158542502016545090413245809786882778948721859617" ,
"72107838435069186155435662884062257473692284509516" ,
"20849603980134001723930671666823555245252804609722" ,
"53503534226472524250874054075591789781264330331690" };

//problem 14
	// Naive implementation (works and takes 3.79 seconds on ideone)
	public static long getLongestCollatz(int limit){
		boolean[] checked = new boolean[limit];
		long max = 0, value = 0, cntr = 0;
		for(int i = 2; i < limit; i++){
			cntr = 1;
			if(checked[i] != true){
				for(long n = i; n != 1; cntr++){
					if(n < limit){
						checked[(int)n] = true;
					}
					n = (n%2==0) ? (long)n/2 : n*3+1;
				}
				if(cntr > max){
					value = i;
					max = cntr;
				}
			}
		}
		return value;
	}
	
	// better implementation (not really, it only managed 3.44) :( also uses more memory so its not really better at all.
	public static long getLongestCollatz(int limit){
		Map<Long, Long> checked = new HashMap<Long, Long>();
		ArrayList<Long> chain = new ArrayList<Long>();
		long max = 0, value = 0, cntr = 0;;
		for(int i = 2; i < limit; i++){
			cntr = 1;
			if(checked.get(i) == null){
				chain = new ArrayList<Long>();
				for(long n = i; n != 1; cntr++){
					Long existingCount = checked.get(n);
					if(existingCount != null){
						cntr+=existingCount;
						break;
					}else{
						chain.add(n);
					}
					n = (n%2==0) ? (long)n/2 : n*3+1;
				}
				if(cntr > max){
					value = i;
					max = cntr;
				}
				for(int l = 0; l < chain.size()-1; l++, cntr--){
					checked.put(chain.get(l), cntr);
				}
			}
		}
		return value;
	}
	
// problem 15
	// Naive implementation (works and takes 3.79 seconds on ideone)
	public static long getTotalLaticePathsAvailable(int grid_sx, int grid_sy){
		grid_sx++;
		grid_sy++;
		long[][] grid = new long[grid_sx][grid_sy];
		int limit = grid_sx > grid_sy ? grid_sx : grid_sy;
		grid[0][0] = 1;
		for(int i = 0; i < limit; i++){
			for(int x = i; x < grid_sx; x++){
				if(x-1 > -1){
					grid[x][i<grid_sy?i:grid_sy] += grid[x-1][i<grid_sy?i:grid_sy];
				}
				if(i-1 > -1 && i-1 < grid_sy){
					grid[x][i<grid_sy?i:grid_sy] += grid[x][i-1];
				}
			}
			
			for(int y = i+1; y < grid_sy; y++){
				if(y-1 > -1){
					grid[i<grid_sx?i:grid_sx][y] += grid[i<grid_sx?i:grid_sx][y-1];
				}
				if(i-1 > -1 && i-1 < grid_sx){
					grid[i<grid_sx?i:grid_sx][y] += grid[i-1][y];
				}
			}
		}
		printGrid(grid, grid_sx);
		return grid[grid_sx-1][grid_sy-1];
	}
	
	public static void printGrid(long[][] grid, int size){
		for(int y = 0; y < size; y++){
			for(int x = 0; x < size; x++){
				System.out.print(grid[x][y] + " ");
			}
			System.out.println();
		}
	}

//problem 16
	/* This is cheating, I need to redo this exercise without the big integer :( */
	public static long powerDigitSum(int n, int pow){
		long total = 0;
		BigInteger bi = new BigInteger(Integer.toString(n));
		char[] large_num = bi.pow(pow).toString().toCharArray();
		for(int i = 0; i < large_num.length; i++){
			total += ((int)large_num[i]-48);
		}
		return total;
	}

//problem 17
/* Attempt without programming (wrong)
ten = 3*10 = 30

twenty thirty forty fifty sixty seventy eighty ninety = 46*10*10=4600

one two three four five six seven eight nine = (36*100)+(36*9*10) = 6840

eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen = 67*10 = 670

and = 3 * (1000-109) = 3000 - 110 = 2673

hundred = 7*900

onethousand = 11

30+4600+6840+670+2673+11+900=15824 //wrong
*/

/*
	Really not happy with this solution. Does not feel elegent at all :(
*/
	public static long numberLetterCount(int valBegin, int valEnd){
		long total = 0;
		StringBuilder snums = new StringBuilder();
		for(int i = valBegin; i <= valEnd; i++){
			if(i == 1000){
				snums.append("onethousand");
				continue;
			}
			StringBuilder snum = new StringBuilder(Integer.toString(i));
			if(snum.length() > 2){
				snums = hundredToString(snum.charAt(0), snum, snums);
				snum.deleteCharAt(0);
			}
			if(snum.length() > 1){
				snums = tenToString(snum.charAt(0), snum.charAt(1), snums);
			}else{
				snums = unitToString(snum.charAt(0), snums);
			}
		}
		return snums.length();
	}
	
	public static StringBuilder hundredToString(char c, StringBuilder sn, StringBuilder sb){
		sb = unitToString(c, sb);
		sb.append("hundred");
		if(sn.charAt(1) != '0' || sn.charAt(2) != '0'){
			sb.append("and");
		}
		return sb;
	}
	
	public static StringBuilder unitToString(char c, StringBuilder sb){
		switch(c) {
			case('1'): sb.append("one"); break;
			case('2'): sb.append("two"); break;
			case('3'): sb.append("three"); break;
			case('4'): sb.append("four"); break;
			case('5'): sb.append("five"); break;
			case('6'): sb.append("six"); break;
			case('7'): sb.append("seven"); break;
			case('8'): sb.append("eight"); break;
			case('9'): sb.append("nine");break;
		}
		return sb;
	}
	
	public static StringBuilder tenToString(char ct, char cu, StringBuilder sb){
		if(ct == '0'){
			return unitToString(cu, sb);
		}
		if(ct == '1'){
			switch(cu){
				case('0'): return sb.append("ten"); 
				case('1'): return sb.append("eleven"); 
				case('2'): return sb.append("twelve"); 
				case('3'): return sb.append("thirteen"); 
				case('4'): return sb.append("fourteen"); 
				case('5'): return sb.append("fifteen"); 
				case('6'): return sb.append("sixteen"); 
				case('7'): return sb.append("seventeen"); 
				case('8'): return sb.append("eighteen"); 
				case('9'): return sb.append("nineteen");
			}
		}else{
			switch(ct){
				case('2'): sb.append("twenty"); break;
				case('3'): sb.append("thirty"); break;
				case('4'): sb.append("forty"); break;
				case('5'): sb.append("fifty"); break;
				case('6'): sb.append("sixty"); break;
				case('7'): sb.append("seventy"); break;
				case('8'): sb.append("eighty"); break;
				case('9'): sb.append("ninety"); break;
			}
			if(cu != '0'){
				return unitToString(cu, sb);
			}
		}
		return sb;
	}
	
//problem 18
/*
	This is efficient (I think) but not sure if the loc increasing is okay :/
*/
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
		System.out.println("Total:" + findLargestPath(triangle));
		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
	
	public static String[] triangle = {"75",
"95 64",
"17 47 82",
"18 35 87 10",
"20 04 82 47 65",
"19 01 23 75 03 34",
"88 02 77 73 07 63 67",
"99 65 04 28 06 16 70 92",
"41 41 26 56 83 40 80 70 33",
"41 48 72 33 47 32 37 16 94 29",
"53 71 44 65 25 43 91 52 97 51 14",
"70 11 33 28 77 73 17 78 39 68 17 57",
"91 71 52 38 17 14 91 43 58 50 27 29 48",
"63 66 04 68 89 53 67 30 73 16 69 87 40 31",
"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"};

	private static class Node{
		Node left, right;
		long nodeCost, pathCost=-1;
		
		public Node(long cost){
			this.nodeCost = cost;
		}
		
		public void setChilds(Node n1, Node n2){
			this.left = n1; this.right = n2;
		}
		
		public Node getLargerNode(){
			if(left == null && right == null){
				return null;
			}
			if(left == null)
				return right;
			if(right == null)
				return left;
		
			if(right.pathCost > left.pathCost){
				return right;
			}
			return left;
		}
		
		public long getPathCosts(){		
			long lCost = 0, rCost = 0;
			if(pathCost > -1)
				return pathCost;
			if(left == null && right == null){
				pathCost = nodeCost;
				return nodeCost;
			}
			if(left != null)
				lCost = left.getPathCosts();
			if(right != null)
				rCost = right.getPathCosts();
			if(lCost > rCost){
				pathCost = lCost+nodeCost;
				return lCost+nodeCost;
			}
			pathCost = rCost+nodeCost;
			return rCost+nodeCost;
		}
	}
	
	public static Node buildTree(String[] tri){
		Node[][] nodes = new Node[tri.length][];
		for(int i = tri.length-1; i > -1; i--){
			String[] sNums = tri[i].split(" ");
			nodes[i] = new Node[sNums.length];
			for(int n = 0; n < sNums.length; n++){
				nodes[i][n] = new Node(Integer.parseInt(sNums[n]));
				if(i < tri.length-1){
					nodes[i][n].setChilds(nodes[i+1][n], nodes[i+1][n+1]);
				}
			}
		}
		return nodes[0][0];
	}
	
	public static long findLargestPath(String[] triangle){
		long total = 0;
		Node tree = buildTree(triangle);
		tree.getPathCosts();
		while(tree != null){
			total += tree.nodeCost;
			System.out.print(tree.nodeCost + " -> ");
			tree = tree.getLargerNode();
		}
		System.out.println("END");
		return total;
	}
	
// problem 19
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
			System.out.println(countDay(1900, 0, 1901, 2000, 0));
		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
	
	public static enum Month{
		JAN, FEB, MAR, APR, 
		MAY, JUN, JUL, AUG,
		SEP, OCT, NOV, DEC;
	}
	public static int numOfDays(int year, Month m){
		switch(m){
			case APR:;
			case JUN:;
			case SEP:;
			case NOV:return 30;
			case JAN:;
			case MAR:;
			case MAY:;
			case JUL:;
			case AUG:;
			case OCT:;
			case DEC:return 31;
			default:
				if(year % 400 == 0 || (year % 100 > 0 && year % 4 == 0)){
					return 29;
				}else{
					return 28;
				}
		}
	}
	public static long countDay(int initYear, int initDay, int beginYear, int endYear, int day){
		long monthDays = initDay;
		long dayCount = 0;
		for (int year = initYear; year < beginYear; year++) {
			for(Month m : Month.values()){
				monthDays += numOfDays(year, m);
			}
		}
		
		for (int year = beginYear; year <= endYear; year++) {
			for(Month m : Month.values()){
				if((monthDays+1) % 7 == day){
					dayCount++;
				}
				monthDays += numOfDays(year, m);
			}
		}
		return dayCount;
	}

//problem 20
	public static long factDigitSum(int input){
		BigInteger result = new BigInteger("1");
		long digitSum = 0;
		for (int i = input; i > 1; i--) {
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}
		char[] numChars = result.toString().toCharArray();
		for(int i = 0; i < numChars.length; i++){
			digitSum += Character.getNumericValue(numChars[i]);
		}
		return digitSum;
	}

// problem 21

	public static long sumAmicables(int limit){
		long[] sums = new long[limit];
		long sum = 0;
		for(int a = 1; a < limit; a++){
			long b = 0;
			if(sums[a] == 0){
				sums[a] = sumDivisors(a);
				//System.out.println("reached" + a + " = " + sums[a]);
			}
			if(sums[a] == a){
				continue;
			}
			b = sums[a];
			if(b < limit){
				if(sums[(int)b] == 0){
					sums[(int)b] = sumDivisors(b);
				}
				if(sums[(int)b] == a){
					//System.out.println("found amicable " + a + " = " + sums[a]);
					sum += a;
				}
			}else{
				if(sumDivisors(b) == a){
					//System.out.println("found amicable " + a + " = " + sums[a]);
					sum += a;
				}
			}
		}
		
		return sum;
	}

	public static long sumDivisors(long n){
		if(n < 2){
			return 0;
		}
	
		int nsqrt = (int)Math.ceil(Math.sqrt(n));
		//System.out.println("nsqrt = " + nsqrt);
		long sum = 1;
		for(int i = 2; i <= nsqrt && i < n; i++){
			//System.out.println("i = " + i);
			if(n % i == 0){
				sum += i;
				if((int)n/i != i){
				//System.out.println("n/i = " + n/i);
					sum += (int)n/i;
				}
				//System.out.println("sum = " + sum);
			}
		}
		return sum;
	}

//problem 23
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
			problem23(28123);
		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
	
	public static long problem23(int n){
		ArrayList<Integer> abds = getAbundants(n);
		boolean[] ab_sum = new boolean[n+1];
		long sum = 0;
		for(Integer i : abds){
			for(Integer j : abds){
				if(i+j > n){
					break;
				}
				ab_sum[i+j] = true;
				//System.out.println(i + " " + j + " " + (i+j) + " ");
			}
		}
		
		for(int i = 1; i <= n; i++){
			if(!ab_sum[i]){
				sum += i;
				//System.out.print(i + " ");
			}
		}
		System.out.print("= " + sum);
		return sum;
	}

	public static ArrayList<Integer> getAbundants(int n){
		ArrayList<Integer> abundants = new ArrayList<Integer>();
		for(int i = 1; i < n;i++){
			int aff = getAffinity(i);
			if(aff > 0){
				abundants.add(i);
			}
		}
		return abundants;
	}
	
	public static int getAffinity(long n){
		if(n < 2){
			return 0;
		}
		int nsqrt = (int)Math.floor(Math.sqrt(n));
		long sum = 1;
		for(int i = 2; i <= nsqrt && i < n; i++){
			if(n % i == 0){
				sum += i;
				if((int)n/i != i){
					sum += (int)n/i;
				}
			}
			if(sum > n){
				return 1;
			}
		}
		if(sum > n){
			return 1;
		}
		if(sum < n){
			return 0;
		}
		return 0;
	}

//problem 24

	public static void main (String[] args) throws java.lang.Exception
	{
		try{
			int[] symbs = {0,1,2,3,4,5,6,7,8,9};
			System.out.println(lexicographic_perm(symbs, 1000000));
		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
	
	public static long lexicographic_perm(int[] symbols, int posToGet){
		ArrayList<Long> perms = new ArrayList<Long>();
		boolean[] used = new boolean[symbols.length];
		findPerms(used, symbols, perms, 0, 0);
		Collections.sort(perms);
		Long l = perms.get(posToGet-1);
		return Long.valueOf(l);
	}

	public static void findPerms(boolean[] used, int[] symbols, ArrayList<Long> A, long prefix, int used_count){
		if(used_count == used.length){
			A.add(prefix);
		}else{
			for(int i = 0; i < symbols.length; i++){
				if(!used[i]){
					used[i] = true;
					prefix *= 10;
					prefix += symbols[i];
					used_count++;
					findPerms(used, symbols, A, prefix, used_count);
					prefix -= symbols[i];
					prefix /= 10;
					used_count--;
					used[i] = false;
				}
			}
		}
	}
	
//problem 25 again not really fair :( I think these problems are designed
// to be solved without having something like big integer as its just too easy then :/

	public static long bigFibo(int limit){
		BigInteger bi_a = new BigInteger("1");
		BigInteger bi_b = new BigInteger("1");
		long i = 2;
		while(bi_a.toString().length() < 1000){
			i++;
			bi_a = bi_a.add(bi_b);
			bi_b = bi_a.subtract(bi_b);
		}
		return i;
	}

//problem 26
	public static int longest_reciprocal(int limit){
		Set<Integer> divided;
		int longest = 7, length = 6;
		double one = 1.0, accu = 0.0;
		
		for(int i = 7; i <= limit; i++ ){
			divided = new HashSet<Integer>();
			accu = 1.0;
			int count = 0;
			while(!divided.contains((int)accu)){
				if(accu/i < 1){
					accu *= 10;
					continue;
				}else if(((int)accu) % i == 0){
					break;
				}
				divided.add(((int)accu));
				accu = accu % i;
				count++;
			}
			if(count > length){
				length = count;
				longest = i;
			}
		}
		return longest;
	}
	
// problem 27
	public static long problem27(){
		int n, largest = 0;
		long coefficient = 0;
		for(int a = 1000; a > -1001; a--){
			for(int b = 1000; b > -1001; b--){
				for(n = 0; isPrime((n*n)+(a*n)+b); n++){}
				if(n > largest){
					largest = n;
					coefficient = a*b;
				}
			}
		}
		return coefficient;
	}
		
	public static boolean isPrime(long n){
		if(n < 1)
			return false;
			
		long limit =  (long)Math.ceil(Math.sqrt(n));
		for(int m = 2; m < limit; m++){
			if(n % m == 0)
				return false;
		}	
		return true;
	}
