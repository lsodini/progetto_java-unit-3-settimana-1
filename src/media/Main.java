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

            // Scelta del tipo di elemento
            int scelta;
            do {
                System.out.print("Scegli il tipo di elemento (1. Immagine, 2. Audio, 3. Video): ");
                scelta = scanner.nextInt();
                scanner.nextLine();  // Consuma la nuova linea

                if (scelta < 1 || scelta > 3) {
                    System.out.println("Scelta non valida, riprova.");
                }
            } while (scelta < 1 || scelta > 3); // Ripete finché non è valida

            // Titolo dell'elemento
            String titolo;
            do {
                System.out.print("Inserisci il titolo: ");
                titolo = scanner.nextLine();
                if (titolo.trim().isEmpty()) {
                    System.out.println("Il titolo non può essere vuoto. Riprova.");
                }
            } while (titolo.trim().isEmpty()); // Ripete finché il titolo non è valido

            // Creazione dell'elemento multimediale
            boolean elementoCreato = false; // Variabile per gestire il ciclo di creazione
            while (!elementoCreato) {
                try {
                    if (scelta == 1) {
                        // Creazione dell'immagine
                        System.out.print("Inserisci la luminosità (1-10): ");
                        int luminosita = scanner.nextInt();
                        if (luminosita < 1 || luminosita > 10) {
                            throw new IllegalArgumentException("La luminosità deve essere compresa tra 1 e 10.");
                        }
                        elementi[i] = new Immagine(titolo, luminosita);
                        elementoCreato = true; // Elemento creato con successo
                    } else if (scelta == 2 || scelta == 3) {
                        // Creazione di audio o video
                        String durataInput;
                        do {
                            System.out.print("Inserisci la durata (MM:SS): ");
                            durataInput = scanner.nextLine();
                            if (durataInput.trim().isEmpty()) {
                                System.out.println("La durata non può essere vuota. Riprova.");
                            }
                        } while (durataInput.trim().isEmpty()); // Ripete finché la durata non è valida

                        String[] durataParts = durataInput.split(":");
                        if (durataParts.length != 2) {
                            throw new IllegalArgumentException("Formato durata non valido. Usa MM:SS.");
                        }

                        int minuti = Integer.parseInt(durataParts[0]);
                        int secondi = Integer.parseInt(durataParts[1]);
                        if (minuti < 0 || secondi < 0 || secondi >= 60) {
                            throw new IllegalArgumentException("Durata non valida. Minuti non negativi e secondi compresi tra 0 e 59.");
                        }

                        // Volume
                        int volume;
                        do {
                            System.out.print("Inserisci il volume (1-10): ");
                            volume = scanner.nextInt();
                            if (volume < 1 || volume > 10) {
                                System.out.println("Il volume deve essere compreso tra 1 e 10.");
                            }
                        } while (volume < 1 || volume > 10); // Ripete finché il volume non è valido

                        // Luminosità per il video
                        if (scelta == 3) {
                            int luminosita;
                            do {
                                System.out.print("Inserisci la luminosità (1-10): ");
                                luminosita = scanner.nextInt();
                                if (luminosita < 1 || luminosita > 10) {
                                    System.out.println("La luminosità deve essere compresa tra 1 e 10.");
                                }
                            } while (luminosita < 1 || luminosita > 10); // Ripete finché la luminosità non è valida
                            elementi[i] = new Video(titolo, new Durata(minuti, secondi), volume, luminosita);
                        } else {
                            elementi[i] = new Audio(titolo, new Durata(minuti, secondi), volume);
                        }
                        elementoCreato = true; // Elemento creato con successo
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Errore: input non valido. Premi invio e riprova.");
                    scanner.nextLine(); // Pulisce il buffer dell'input
                }
            }
        }
        // Visualizzazione degli elementi creati
        System.out.println("\nElementi creati:");
        for (int i = 0; i < elementi.length; i++) {
            System.out.printf("%d. %s (Tipo: %s)%n", i + 1, elementi[i].getTitolo(), elementi[i].getClass().getSimpleName());
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
