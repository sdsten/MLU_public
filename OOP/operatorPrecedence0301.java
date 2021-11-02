/**********************************************************************
 *  Re: OOP Uebungsblatt 3, Aufgabe 1 (Operator Precedence)           * 
 *  Meine Loesungen im Praxistest                                     *
 **********************************************************************/

public class operatorPrecedence0301 {
    public static void main(String args[]) {

        // values
        int i = 8;
        int j = 3;
        int k = 2;
        double kd = 1.5;          
        double ld = 4.25;         
        boolean a = true;
        boolean b = false;

        // expressions
        System.out.println(i % j - i * k + i);
        System.out.println((((i % j) - (i * k)) + i));

        System.out.println(ld % k + kd);
        System.out.println(((ld % k) + kd));

        System.out.println(!b && a || b && !a);
        System.out.println((((!b) && a) || (b && (!a))));

        System.out.println(j++ - i * k / i);
        j = 3;   // incr. operators have side-effects so this is to 'reset' them
        System.out.println((((j++) - ((i * k) / i))));
        j = 3;

        System.out.println(j - ++i * k / i);
        i = 8;
        System.out.println((j - (((++i) * k) / i)));

        System.out.println(0 < -k || a == false ^ b == true);
        System.out.println(((0 < (-k)) || ((a == false) ^ (b == true))));

        System.out.println(i <= k * j & a);
        System.out.println(((i <= (k * j)) & a));
    }
};

/**********************************
 *  Output:                       *
 *  -------                       *
 *  -6                            *         
 *  -6                            *
 *  1.75                          *
 *  1.75                          *
 *  true                          *
 *  true                          *
 *  1                             *
 *  1                             *
 *  1                             *
 *  1                             *
 *  false                         *
 *  false                         *
 *  false                         *
 *  false                         *
 **********************************/



/*******************************************************************
 *  Originale Aufgabenstellung:                                    *
 *  Paranthecize and determine value of expressions                *
 *  -----------------------------------------------                *
 *  Values:                                                        *
 *  i = 8; kd = 1.5; a = true                                      *
 *  j = 3; ld = 4.25; b = false                                    *
 *  k = 2;                                                         *
 *  Expressions:                                                   *
 *  1. i % j - i * k + i                                           *
 *  2. ld % k + kd                                                 *
 *  3. !b && a || b && !a                                          *
 *  4. j++ - i * k / i                                             *
 *  5. j - ++i * k / i                                             *
 *  6. 0 < -k || a == false ^ b == true                            *
 *  7. i <= k * j & a                                              *
 *******************************************************************/