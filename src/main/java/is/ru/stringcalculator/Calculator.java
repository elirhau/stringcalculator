package is.ru.stringcalculator;

public class Calculator {

public static int add(String text)
	{		

		negative(text);
		
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
			
			String del = "";
			String num = numbers.substring(2);
			String first = num.substring(0, num.indexOf("\n"));
			String last = num.substring(num.indexOf("\n") + 1, num.length());
			
			for(int i = 0; i < first.length(); i++)
			{
				if(first.substring(i, i + 1).equals("["))
				{
					del = "";
				}
				else if(first.substring(i, i + 1).equals("]"))
				{
					last = last.replace(del, ";");
				}
				else
				{
					del = del + first.substring(i, i + 1);
				}
			}
			return last.split(";");
		}
	    
	    return numbers.split("[, \n]");
	}
      
    private static int sum(String[] numbers)
    {
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }


    private static String[] tooBig(String[] numbers)
    {
 	   	for(int i = 0; i < numbers.length; i++)
		{
			if(Integer.parseInt(numbers[i]) > 100)
			{
				numbers[i] = "0";
			}
		}
 	   	
		return numbers;
    }

    private static void negative(String text)
    {
    	if(text.contains("-"))
		{
			String error = "Negatives not allowed: ";		 
			String num = "";
			String totalMessage = "";
			 
			for(int i = 0; i < text.length(); i++)
			{
				if(text.substring(i, i+1).contains("-"))
				{ 
					num = num + text.substring(i, i+2);
					 
					totalMessage = error + num;
					 
					num = num + ",";
				}
				 
				 
			}
 			throw new IllegalArgumentException(totalMessage);	 
		}
    }
}