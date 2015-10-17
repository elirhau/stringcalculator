package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text)
	{
		
		if(text.contains("-"))
		{
			 String error = "Negatives not allowed: ";
			 
			 for(int i = 0; i < text.length(); i++)
			 {
				 if(text.substring(i, i+1).contains("-"))
				 {
					 if(i > 0)
					 {
						error = error + ",";
					 }
					 error = error + text.substring(i, i+2);
				 }
			 }

			throw new IllegalArgumentException(error);	 
		}

		

		if(text.equals(""))
		{	
			return 0;
		}

		String [] number = splitNumbers(text);
		number = tooBig(number);
		int summ = sum(number);


		return summ;
	}	

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
		if(numbers.startsWith("//"))
		{
			String sp = numbers.substring(2, 3);
			String num = numbers.substring(4);
			return num.split(sp);
		}
	    
	    return numbers.split("[, \n]");
	}
      
    private static int sum(String[] numbers)
    {
 	    int total = 0;
        for(String number : numbers)
        {
		    total += toInt(number);
		}
		return total;
    }


    private static String[] tooBig(String[] numbers)
    {
 	  	for(int i = 0; i < numbers.length; i++)
		{
			String c = numbers[i];
			int tala = toInt(c);
			if( tala > 1000)
			{
				numbers[i] = "0";
			}
		}
 	   	
		return numbers;
    }
}