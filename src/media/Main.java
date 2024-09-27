package media;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Messaggio di benvenuto e spiegazione del funzionamento
        System.out.println("Benvenuto nel lettore multimediale!");
        System.out.println("Dovrai creare 5 elementi multimediali.");
        System.out.println("Successivamente, potrai scegliere uno di questi elementi per eseguire la riproduzione.");
        System.out.println("Durante la riproduzione, verranno mostrati i valori specificati con:");
        System.out.println("- Asterischi per la luminosità");
        System.out.println("- Punti esclamativi per il volume");
        System.out.println("- Il titolo si ripeterà in base ai minuti della durata.");

        // Creazione di 5 elementi multimediali
        for (int i = 0; i < 5; i++) {
            System.out.println("\nCreazione dell'elemento " + (i + 1));

            int scelta;
            do {
                System.out.print("Scegli il tipo di elemento (1. Immagine, 2. Audio, 3. Video): ");
                scelta = scanner.nextInt();
                scanner.nextLine();  // Consuma la nuova linea

                if (scelta < 1 || scelta > 3) {
                    System.out.println("Scelta non valida, riprova.");
                }
            } while (scelta < 1 || scelta > 3); // Ripete finché non è valida

            System.out.print("Inserisci il titolo: ");
            String titolo = scanner.nextLine();

            boolean elementoCreato = false; // Variabile per gestire il ciclo di creazione
            while (!elementoCreato) {
                try {
                    if (scelta == 1) {
                        System.out.print("Inserisci la luminosità (1-10): ");
                        int luminosita = scanner.nextInt();
                        elementi[i] = new Immagine(titolo, luminosita);
                        elementoCreato = true; // Elemento creato con successo
                    } else if (scelta == 2) {
                        System.out.print("Inserisci la durata (MM:SS): ");
                        String[] durataInput = scanner.nextLine().split(":");
                        int minuti = Integer.parseInt(durataInput[0]);
                        int secondi = Integer.parseInt(durataInput[1]);
                        System.out.print("Inserisci il volume (1-10): ");
                        int volume = scanner.nextInt();
                        elementi[i] = new Audio(titolo, new Durata(minuti, secondi), volume);
                        elementoCreato = true; // Elemento creato con successo
                    } else if (scelta == 3) {
                        System.out.print("Inserisci la durata (MM:SS): ");
                        String[] durataInput = scanner.nextLine().split(":");
                        int minuti = Integer.parseInt(durataInput[0]);
                        int secondi = Integer.parseInt(durataInput[1]);
                        System.out.print("Inserisci il volume (1-10): ");
                        int volume = scanner.nextInt();
                        System.out.print("Inserisci la luminosità (1-10): ");
                        int luminosita = scanner.nextInt();
                        elementi[i] = new Video(titolo, new Durata(minuti, secondi), volume, luminosita);
                        elementoCreato = true; // Elemento creato con successo
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Errore: input non valido. R1iprova.");
                    scanner.nextLine(); // Pulisce il buffer dell'input
                }
            }
        }

        // Esecuzione degli elementi
        int scelta;
        do {
            System.out.println("\nScegli quale oggetto eseguire (1-5) oppure 0 per uscire:");
            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= 5) {
                elementi[scelta - 1].esegui();
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        System.out.println("Programma terminato.");
        scanner.close();
    }
}
