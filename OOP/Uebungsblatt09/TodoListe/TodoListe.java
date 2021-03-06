public class TodoListe {
    
    Aufgabe[] aufgaben = null;
    int indexEmpty = 0;


    // CREATES A NEW EMPTY TODOLISTE
    public static TodoListe erzeugeLeereListe (int maxAnzahl) {
        TodoListe liste = new TodoListe();
        liste.aufgaben = new Aufgabe[maxAnzahl];
        return liste;
    }
    
    
    // ADDS AN AUFGABE TO THE LIST
    public static boolean aufgabeHinzufuegen (TodoListe liste, String beschreibung) {
        
        // check if list is full, if so return false
        if (liste.indexEmpty == liste.aufgaben.length) {
            return false;
        }
        // if list is not full, add task and return true
        else {
            liste.aufgaben[liste.indexEmpty] = new Aufgabe(beschreibung);
            liste.indexEmpty++;
            return true;
        }
    }
    

    // RETURNS NUM OF ALL TASKS (nurErledigte false) OR ERL TASKS (true)
    public static int gibAnzahl (TodoListe liste, boolean nurErledigte) {
        

        // returns all aufgaben
        if (nurErledigte == false) {
            return liste.indexEmpty;
        }
        // counts erledigte aufgaben
        else {
            int numAufgaben = 0;
            for (int i = 0; i < liste.indexEmpty; i++) {
                if (liste.aufgaben[i].erledigt) {
                    numAufgaben++;
                }
            }
            return numAufgaben;
        }
    }
    

    // MARKS AUFGABE AS ERLEDIGT
    public static void markiereAlsErledigt (TodoListe liste, int index) {
        
        if (index < 0 || index >= liste.indexEmpty) {
            return;
        }
        else {
            liste.aufgaben[index].erledigt = true;
        }
    }
    

    // CREATES OUTPUT
    public static void ausgabe (TodoListe liste, int breiteInZeichen) {
        
        // output liste 
        for (int i = 0; i < liste.indexEmpty; i++) {
            if (liste.aufgaben[i].erledigt) {
                System.out.println("[x] " + liste.aufgaben[i].nameAufgabe);
            }
            else {
                System.out.println("[ ] " + liste.aufgaben[i].nameAufgabe);
            }
        }
        
        // create progressbar
        int numAufgabenAlle = gibAnzahl(liste, false);
        int numAufgabenErledigt = gibAnzahl(liste, true);
        ProgressBar bar = new ProgressBar(numAufgabenAlle, numAufgabenErledigt);

        // output progress
        System.out.println("Erledigt: " + ProgressBar.gibProzente(bar) + "%");
        System.out.println("Erledigt: " + ProgressBar.gibProgressBar(bar, breiteInZeichen));
    }
    

    // REMOVES AN AUFGABE
    public static void entferne (TodoListe liste, int index) {
        // check if index is in range
        if (index < 0 || index >= liste.indexEmpty) {
            return;
        }
        // overwrite index with index+1, same for following tasks
        else {
            for (int i = index; i < liste.indexEmpty-1; i++) {
                liste.aufgaben[i] = liste.aufgaben[i+1];
            }
            liste.indexEmpty--;
            liste.aufgaben[liste.indexEmpty] = null;
        }
    }
}

