public class Prime {

	public void main(String[] args) {
		
		try {
			for(int i=1;i<=100;i++)
			{
				if(isPrime(i)) {
					throw new ArithmeticException("Prime Number Found: "+i);
				}
			}
		}
		catch (Exception e){
			System.out.println("Prime Number");
		}
		
	}
	
	public boolean isPrime(int num)
	{
		
	    for (int i = 2; i <= num / 2; ++i) {
	      if (num % i == 0) {
	    	  return false;
	      }
	    }
	    return true;
	  }
		
		
	

}