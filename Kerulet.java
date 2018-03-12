import java.text.DecimalFormat;

public class Kerulet {
    public static void main(String[] args) {
        String help = new String("-help");
        int numberOfObjects = 0;
        int leptet = 0;
        int inputChecker = 0;
        double kerulet = 0;
        if (args[0].equals(help)) {
            System.out.println("Parancsosori paraméterekben add meg síkidomok típusát és kért adatait a kerületeik kiszámításához.");
            System.out.println("A kör típusát a 0 szám jelöli, utána egy számot írj, ami a kör sugara.");
            System.out.println("A négyzet típusát az 1 szám jelöli, utána egy számot írj, ami az oldalhossza.");
            System.out.println("A téglalap típusát a 2 szám jelöli, utána két számot írj, melyek az oldalhosszak.");
            System.out.println("A háromszög típusát a 3 szám jelöli, utána három számot írj, melyek az oldalhosszak.");
            System.out.println("4-től kezdődően minden szám általános poligont jelöl, mely után a típust jelölő értékkel megegyező számú oldalhosszt szükséges megadni.");
            System.out.println("\tPélda:");
            System.out.println("\t\tjava Kerulet 0 2 3 3 4 2 1 5 6 4 5 4 4 5 4 4 2 4 5 6 2 4 5");
            System.out.println("\t\t\t\t0 2 | 3 3 4 2 | 1 5 | 6 4 5 4 4 5 4 | 4 2 4 5 6 | 2 4 5");
            System.out.println("\t\t\t\tkör | háromszög | négyzet | hatszög | négyszög | téglalap");
        } else {
            for (int i = 0; i < args.length; i += leptet) {
                if (Integer.parseInt(args[i]) == 0) {
                    inputChecker += 2;
                    if (inputChecker > args.length) {
                        System.out.println("HIBA >> A(z) " + (i+1) + ". számmal jelzett körnek nem adtál meg minden adatát. Kérlek, ellenőrizd.");
                        System.exit(2);
                    }
                    else if (Integer.parseInt(args[i+1]) == 0) {
                        System.out.println("HIBA >> A(z) " + (i + 1) + ". számmal jelzett körnél 0 hosszúságú sugarat adtál meg. Kérlek, ellenőrizd.");
                        System.exit(3);
                    } else {
                        kerulet += Math.PI * Integer.parseInt(args[i + 1]) * Integer.parseInt(args[i + 1]);
                        leptet = 2;
                        numberOfObjects++;
                    }
                }
                if (Integer.parseInt(args[i]) == 1) {
                    inputChecker += 2;
                    if (inputChecker > args.length) {
                        System.out.println("HIBA >> A(z) " + (i+1) + ". számmal jelzett négyzetnek nem adtál meg minden adatát. Kérlek, ellenőrizd.");
                        System.exit(2);
                    } else if (Integer.parseInt(args[i+1]) == 0) {
                        System.out.println("HIBA >> A(z) " + (i + 1) + ". számmal jelzett négyzetnél 0 oldalhosszúságot adtál meg. Kérlek, ellenőrizd.");
                        System.exit(3);
                    } else {                }
                    kerulet += 4 * Integer.parseInt(args[i + 1]);
                    leptet = 2;
                    numberOfObjects++;
                }
                if (Integer.parseInt(args[i]) == 2) {
                    inputChecker += Integer.parseInt(args[i]) + 1;
                    if (inputChecker > args.length) {
                        System.out.println("HIBA >> A(z) " + (i+1) + ". számmal jelzett téglalapnak nem adtál meg minden adatát. Kérlek, ellenőrizd.");
                        System.exit(2);
                    } else if (Integer.parseInt(args[i+1]) == 0 || Integer.parseInt(args[i+2]) == 0) {
                        System.out.println("HIBA >> A(z) " + (i + 1) + ". számmal jelzett téglalapnál 0 oldalhosszúságot adtál meg. Kérlek, ellenőrizd.");
                        System.exit(3);
                    } else {
                        kerulet += 2 * (Integer.parseInt(args[i + 1]) + Integer.parseInt(args[i + 2]));
                        leptet = Integer.parseInt(args[i]) + 1;
                        numberOfObjects++;
                    }
                }
                if (Integer.parseInt(args[i]) > 2) {
                    inputChecker += Integer.parseInt(args[i]) + 1;
                    if (inputChecker > args.length) {
                        System.out.println("HIBA >> A(z) " + (i+1) + ". számmal jelzett síkidomnak nem adtál meg minden adatát. Kérlek, ellenőrizd.");
                        System.exit(2);
                    } else {
                        int[] poligonCheck = new int[Integer.parseInt(args[i])];
                        for (int j = 0; j < Integer.parseInt(args[i]); j++) {
                            poligonCheck[j] = Integer.parseInt(args[i + j + 1]);
                        }
                        int poligonSum = 0;
                        int max = poligonCheck[0];
                        for (int k = 0; k < poligonCheck.length; k++) {
                            poligonSum += poligonCheck[k];
                            if (max < poligonCheck[k]) {
                                max = poligonCheck[k];
                            }
                            if (poligonCheck[k] == 0) {
                                System.out.println("HIBA >> A(z) " + (i + 1) + ". számmal jelzett síkidomnál 0 oldalhosszúságot adtál meg. Kérlek, ellenőrizd.");
                                System.exit(3);
                            }
                        }
                        if (max >= poligonSum - max) {
                            System.out.println("HIBA >> A(z) " + (i + 1) + ". számmal jelzett síkidom az azt követő adatokkal nem hozható létre. Adj meg valós oldalhosszakat a számítás elvégzéséhez.");
                            System.exit(1);
                        } else {
                            kerulet += poligonSum;
                            leptet = Integer.parseInt(args[i]) + 1;
                            numberOfObjects++;
                        }
                    }
                }

            }
            DecimalFormat f = new DecimalFormat("##.00");
            System.out.println("A megadott " + numberOfObjects + " db síkidom kerületeinek összege = " + f.format(kerulet));
        }
    }
}
