package media;

public class Video extends ElementoMultimediale implements Riproducibile {
    private Durata durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, Durata durata, int volume, int luminosita) {
        super(titolo);
        setDurata(durata); // Controllo sulla durata
        setVolume(volume); // Controllo sul volume
        setLuminosita(luminosita); // Controllo sulla luminosità
    }

    public Durata getDurata() {
        return durata;
    }

    public void setDurata(Durata durata) {
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume >= 1 && volume <= 10) {
            this.volume = volume;
        } else {
            throw new IllegalArgumentException("Il volume deve essere compreso tra 1 e 10.");
        }
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        if (luminosita >= 1 && luminosita <= 10) {
            this.luminosita = luminosita;
        } else {
            throw new IllegalArgumentException("La luminosità deve essere compresa tra 1 e 10.");
        }
    }

    @Override
    public void play() {
        int minutiTotali = durata.getMinuti(); // Otteniamo i minuti dalla durata
        System.out.println("Riproduzione di: " + titolo);
        System.out.println("Durata: " + durata);
        for (int i = 0; i < minutiTotali; i++) {
            System.out.println(titolo + " " + "!".repeat(volume) + "*".repeat(luminosita));
        }
    }

    @Override
    public void esegui() {
        play();
    }
}
