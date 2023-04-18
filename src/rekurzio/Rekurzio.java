package rekurzio;

import java.util.Scanner;

public class Rekurzio {

    public static void main(String[] args) {
        //bemenet lehet pozitív egész szám
        long kezdet = System.nanoTime();
        //1. Első n szám összege (n ∊ N). Mérjünk futási időt, és teszteljük milliós nagyságrenddel is mindkettőt!
        //int eredmeny = osszegRek(15000);
        //2. Valahány db szöveg beolvasása, majd összefűzése szóközzel.
        //String eredmeny = mondat(3);
        //3. Faktoriális kiszámítása.
        //long eredmeny = fakt(35);
        //4. Hatvány kiszámítása (a kitevő csak természetes szám lehet).
        //long eredmeny = hatvanyRek(2,0);
        //5. Hatvány kiszámítása csak rekurzívan úgy, hogy a kitevő csak egész szám lehet; ha páros, akkor a kitevő felére emelve az alapot önmagával szorzom meg.
        //long eredmeny = hatvanyRekTovabb(4, 12);
        //6. N. Fibonacci szám kiszámítása először rekurzívan (paraméter: hány darabot kérünk, 1 az első szám)
        //7. N. Fibonacci szám kiszámítása nem rekurzívan
        long eredmeny = fibonacci(4);
        long vege = System.nanoTime();
        System.out.printf("Eltelt idő(nSec): %d, eredmeny: %d ", vege - kezdet, eredmeny);
    }

    private static int osszeg(int n) {
        int osszeg = 0;
        for (int i = 1; i <= n; i++) {
            osszeg += i;
        }
        return osszeg;
    }

    private static int osszegRek(int n) {
        if (n == 1) {
            return 1;
        } else {
            return osszegRek(n - 1) + n;
        }
    }

    private static String mondat(int szovegDb) {
        String osszefuzott = "";
        for (int i = 0; i < szovegDb; i++) {
            Scanner szoveg = new Scanner(System.in);
            System.out.println("Adj meg egy szöveget: ");
            osszefuzott += szoveg.nextLine() + " ";
        }

        return osszefuzott;

    }

    private static String mondatRek(int szovegDb) {
        if (szovegDb <= 0) {
            return "";
        } else {
            Scanner beker = new Scanner(System.in);
            System.out.println("Adj meg egy szöveget: ");
            String szoveg = beker.nextLine() + " ";
            return mondatRek(szovegDb - 1) + szoveg;
        }
    }

    private static long fakt(int szam) {
        long szorzat = 1;
        for (int i = 1; i <= szam; i++) {
            szorzat *= i;
        }

        return szorzat;

    }

    private static long faktRek(int szam) {
        if (szam <= 1) {
            return 1;
        } else {
            return faktRek(szam - 1) * szam;
        }

    }

    private static long hatvany(int alap, int kitevo) {
        long vegosszeg = 1;
        for (int i = 0; i < kitevo; i++) {
            vegosszeg *= alap;
        }
        return vegosszeg;
    }

    private static long hatvanyRek(int alap, int kitevo) {
        if (kitevo == 0) {
            return 1;
        } else {
            return hatvanyRek(alap, kitevo - 1) * alap;
        }

    }

    private static long hatvanyRekTovabb(int alap, int kitevo) {
        int eredmeny;
        if (kitevo == 0) {
            return 1;
        } else if (kitevo % 2 == 0) {
            eredmeny = (int) hatvanyRekTovabb(alap, kitevo / 2);
            return eredmeny * eredmeny;
        } else if (kitevo % 2 == 1) {
            return hatvanyRek(alap, kitevo - 1) * alap;
        }
        return 0;
    }

    private static long fibonacci(int szam) {
        int osszeg = 0;
        int elozo = 1, kovetkezo = 1;
        
        if (szam == 1 || szam == 2) {
            return 1;
        } else {
            for (int i = 0; i < szam; i++) {
                osszeg += elozo + kovetkezo;
                elozo = kovetkezo;
                kovetkezo = osszeg;
        }
    }
        return osszeg;
    }
    private static long fibonacciRek(int szam) {
        if (szam == 1 || szam == 2) {
            return 1;
        } else {
            return fibonacciRek(szam - 1) + fibonacciRek(szam - 2);
        }
    }
}
