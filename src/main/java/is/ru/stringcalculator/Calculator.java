package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text)
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
			
			if(numbers.substring(2,3).equals("["))
			{
				int i;
				for(i = 0; i < numbers.length(); i++)
				{
					if(numbers.substring(i, i+1).equals("]"))
					{
						break;
					}
				}
				
				String del = numbers.substring(3,i);
				String[] newNum = numbers.split("\n");
				String temp = newNum[1];
				temp = temp.replace(del, ";");
				
				return temp.split(";");
			}
			else
			{
				String sp = numbers.substring(2, 3);
				String num = numbers.substring(4);
				return num.split(sp);
			}
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

}