class Prime{
  public static int primecount = 0;
  public static int nonprimecount = 0;
  public static void main(String[] args) {
        int i=0;
        
        while( i<5){
          long startTime = System.nanoTime();
          long[] array = randomarray();
          countPrimeNumbers(array);
          long endTime = System.nanoTime();
          long Timediff = endTime - startTime;
          System.out.println(Timediff);
          i++;
          primecount = 0;
          nonprimecount = 0;
          }
         int j=0;
        while( j<5){
          long startTime = System.nanoTime();
          long[] array = randomarray();
          countNotPrimeNumbers(array);    
          long endTime = System.nanoTime();
          long Timediff = endTime - startTime;
          System.out.println(Timediff);
          j++;
          primecount = 0;
          nonprimecount = 0;
          }
      }   
     public static long[] randomarray(){
      long[] arr = new long [1000000];
      for (int i=0 ; i<1000000; i++){
      arr[i] = seven_digit_number();
      }
      return arr;
     }
      
  public static long generateRandomNumbers(){
    long number = System.nanoTime() % 10;
    return number;
  }

public static long seven_digit_number(){
  long num=0;
  for (int j=0; j<7; j++){
    long number = generateRandomNumbers();
    num = num*10 + number;
    }
    return num;
    
  }
    
    public static boolean isPrime(long n){
    if (n == 1){
      return false;
      }
    if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
         for (int i=2; i <= n/2; i++){
          if(n % i == 0){
            return false;
        }
        }
    return true;
    }  
  // Function to count prime numbers and nonprime in an array
    public static void countPrimeNumbers(long[] array) {
        int primecount = 0;
        int nonprimecount = 0;
        for (long n : array) {
            if (isPrime(n) == true) {
                primecount++;
            }
        else {
        nonprimecount ++;
         }
        }
      System.out.println(primecount);
      System.out.println(nonprimecount);
    }
    
    public static boolean isNotPrime(long n){
    if (n == 1){
      return false;
      }
    if (n % 2 != 0 || n % 3 != 0) {
            return false;
        }
         for (int i=2; i <= n/2; i++){
          if(n % i != 0){
            return false;
        }
        }
    return true;
    }  
  // Function to count prime numbers and nonprime in an array
    public static void countNotPrimeNumbers(long[] array) {
        int primecount = 0;
        int nonprimecount = 0;
        for (long n : array) {
            if (isNotPrime(n) == true) {
                primecount++;
            }
        else {
        nonprimecount ++;
         }
        }
      System.out.println(primecount);
      System.out.println(nonprimecount);
    }
    }

