import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

class CS50
{
    public static void main(String [] args)
    {
        int n = GetInt();
        System.out.println(n);
    }

    /**
     *
     */
    public static float GetFloat()
    {
        while (true)
        {
            String s = CS50.GetString();
            if (s == null)
            {
                return Float.MAX_VALUE;
            }
            try
            {
                BigDecimal f = new BigDecimal(s.trim());
                if (f.compareTo(BigDecimal.valueOf(Float.MAX_VALUE)) <= 0 && 0 <= f.compareTo(BigDecimal.valueOf(Float.MIN_VALUE)))
                {
                    return f.floatValue();
                }
                else
                {
                    throw new NumberFormatException();
                }
            }
            catch (Exception e)
            {
                System.out.print("Retry: ");
            }
        }
    }


    /**
     *
     */
    public static int GetInt()
    {
        while (true)
        {
            String s = CS50.GetString();
            if (s == null)
            {
                return Integer.MAX_VALUE;
            }
            try
            {
                BigInteger i = new BigInteger(s.trim());
                if (i.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0 && 0 <= i.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)))
                {
                    return i.intValue();
                }
                else
                {
                    throw new NumberFormatException();
                }
            }
            catch (Exception e)
            {
                System.out.print("Retry: ");
            }
        }
    }

    /**
     *
     */
    public static String GetString()
    {
        Scanner s = new Scanner(System.in);
        try
        {
            return s.nextLine();
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
