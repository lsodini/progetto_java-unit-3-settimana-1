package media;

public class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        setLuminosita(luminosita); // Controllo sul range della luminosità
    }

    // Getter per la luminosità
    public int getLuminosita() {
        return luminosita;
    }

    // Setter con controllo sul range (1-10)
    public void setLuminosita(int luminosita) {
        if (luminosita >= 1 && luminosita <= 10) {
            this.luminosita = luminosita;
        } else {
            throw new IllegalArgumentException("La luminosità deve essere compresa tra 1 e 10.");
        }
    }

    // Aumenta la luminosità di 1
    public void aumentaLuminosita() {
        if (luminosita < 10) {
            luminosita++;
        }
    }

    // Diminuisce la luminosità di 1
    public void diminuisciLuminosita() {
        if (luminosita > 1) {
            luminosita--;
        }
    }

    // Metodo per mostrare l'immagine
    public void show() {
        System.out.println(titolo + " " + "*".repeat(luminosita));
    }

    // Implementazione del metodo esegui
    @Override
    public void esegui() {
        show();
    }
}
