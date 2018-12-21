package model;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 8/12/2018<br/>
 * Time: 9:24<br/>
 * To change this template use File | Settings | File Templates.
 */
public class TestDatumAdapter {

    private static int keuze = 0;
    private static String datum;
    private static char opnieuw;

    public static void main(String[] args) {

        String start;
        start = "****************************************************************************" + "\n" +
                "*********************Dit is een ISO datum converter*************************" + "\n" +
                "***Keuzes zijn 1:naar Euro, 2:naar Usa, 3:naar dd/mm/yy, 4: naar mm/dd/yy***" + "\n" +
                "****************************************************************************" + "\n" +
                "****************************************************************************" + "\n\n"
        ;
        System.out.print(start);

        Scanner scanner = new Scanner(System.in);

        do {

            try {

                do {

                    System.out.print("Geef de conversie keuze in 1,2,3 of 4 : ");
                    keuze = Integer.parseInt(scanner.next());

                } while (keuze > 4 || keuze < 1);

                System.out.print("Geef de Isodatum in volgend formaat yyyy-mm-dd : ");
                datum = scanner.next();
                DatumInfo datumInfo = new DatumAdapter();
                datumInfo.setDatumIso(datum);
                testdatumInfo(datumInfo,keuze);

            } catch (Exception ex) {

                System.out.println("\n"+"Foute datum formaat ingegeven, moet ISO formaat zijn" + "\n");
            }

            System.out.print("Wilt u nog een datum converteren ? (J/N) ");
            opnieuw = scanner.next().charAt(0);

        } while (Character.toUpperCase(opnieuw) == 'J');


    }


    public static void testdatumInfo(DatumInfo datumInfo, int keus) {

        switch (keus) {

            case 1:
                System.out.println("Datum in Euro notatie : " + datumInfo.getDatumEuro());
                break;
            case 2:
                System.out.println("Datum in Usa notatie : " + datumInfo.getDatumUsa());
                break;
            case 3:
                System.out.println("Datum in Dmy notatie : " + datumInfo.getDatumDmy());
                break;
            case 4:
                System.out.println("Datum in Mdy notatie : " + datumInfo.getDatumMdy());
                break;


        }


    }
}
