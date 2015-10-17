package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text)
	{
		if(text.equals(""))
		{	
			return 0;
		}

		String [] number = splitNumbers(text);
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
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
}