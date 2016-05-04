/**
 * CS50 Library for Java
 * https://github.com/cs50/java
 *
 * Port of CS50 Library for C.
 *
 * Copyright (c) 2016,
 * David J. Malan <malan@harvard.edu>
 * All rights reserved.
 *
 * BSD 3-Clause License
 * http://www.opensource.org/licenses/BSD-3-Clause
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * * Neither the name of CS50 nor the names of its contributors may be used
 *   to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

class CS50
{
    public static void main(String [] args)
    {
        int n = GetInt();
        System.out.println(n);
        n = GetInt();
        System.out.println(n);
    }

    /**
     * Reads a line of text from standard input and returns the equivalent
     * char; if text does not represent a char, user is prompted to retry.
     * Leading and trailing whitespace is ignored. If line can't be read,
     * returns Character.MAX_VALUE.
     */
    public static char GetChar()
    {
        // try to get a char from user
        while (true)
        {
            // get a line of text, returning Character.MAX_VALUE on error
            String s = CS50.GetString();
            if (s == null)
            {
                return Character.MAX_VALUE;
            }

            // return a char if only a char (possibly with leading and/or trailing whitespace) was provided
            if (s.length() == 1)
            {
                return s.charAt(0);
            }
            else
            {
                System.out.print("Retry: ");
            }
        }
    }

    /**
     * Reads a line of text from standard input and returns the equivalent
     * double as precisely as possible; if text does not represent a
     * double, user is prompted to retry. Leading and trailing whitespace
     * is ignored. If line can't be read, returns Double.MAX_VALUE.
     */
    public static double GetDouble()
    {
        // try to get a double from user
        while (true)
        {
            // get a line of text, returning Double.MAX_VALUE on error
            String s = CS50.GetString();
            if (s == null)
            {
                return Double.MAX_VALUE;
            }

            // return a double if only a double (possibly with leading and/or trailing whitespace) was provided, checking for overflow
            try
            {
                BigDecimal d = new BigDecimal(s.trim());
                if (d.compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) < 0 && d.compareTo(BigDecimal.valueOf(Double.MIN_VALUE)) >= 0)
                {
                    return d.doubleValue();
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
     * Reads a line of text from standard input and returns the equivalent
     * float as precisely as possible; if text does not represent a float,
     * user is prompted to retry. Leading and trailing whitespace is ignored.
     * If line can't be read, returns Float.MAX_VALUE.
     */
    public static float GetFloat()
    {
        // try to get a float from user
        while (true)
        {
            // get a line of text, returning Float.MAX_VALUE on error
            String s = CS50.GetString();
            if (s == null)
            {
                return Float.MAX_VALUE;
            }

            // return a float if only a float (possibly with leading and/or trailing whitespace) was provided, checking for overflow
            try
            {
                BigDecimal f = new BigDecimal(s.trim());
                if (f.compareTo(BigDecimal.valueOf(Float.MAX_VALUE)) < 0 && f.compareTo(BigDecimal.valueOf(Float.MIN_VALUE)) >= 0)
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
     * Reads a line of text from standard input and returns it as an
     * int in [-2^31, 2^31 - 1) if possible; if text does not represent
     * such an int, user is prompted to retry. Leading and trailing whitespace
     * is ignored. If line can't be read, returns Integer.MAX_VALUE.
     */
    public static int GetInt()
    {
        // try to get an int from user
        while (true)
        {
            // get a line of text, returning Integer.MAX_VALUE on error
            String s = CS50.GetString();
            if (s == null)
            {
                return Integer.MAX_VALUE;
            }

            // return an int if only an int (possibly with leading and/or trailing whitespace) was provided, checking for overflow
            try
            {
                BigInteger i = new BigInteger(s.trim());
                if (i.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) < 0 && i.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0)
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
     * Reads a line of text from standard input and returns an equivalent
     * long in [-2^63, 2^63 - 1) if possible; if text does not represent
     * such a long, user is prompted to retry. Leading and trailing whitespace
     * is ignored. If line can't be read, returns Long.MAX_VALUE.
     */
    public static long GetLong()
    {
        // try to get a long from user
        while (true)
        {
            // get a line of text, returning Long.MAX_VALUE on error
            String s = CS50.GetString();
            if (s == null)
            {
                return Long.MAX_VALUE;
            }

            // return a long if only a long (possibly with leading and/or trailing whitespace) was provided, checking for overflow
            try
            {
                BigInteger l = new BigInteger(s.trim());
                if (l.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 0 && l.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0)
                {
                    return l.longValue();
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
     * Reads a line of text from standard input and returns it as a
     * String, sans trailing newline character. (Ergo, if user inputs
     * only "\n", returns "" not null.) Returns null upon error or no
     * input whatsoever (i.e., just EOF). Leading and trailing whitespace
     * is not ignored.
     */
    public static String GetString()
    {
        // try to get a String from user, returning null on error
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
