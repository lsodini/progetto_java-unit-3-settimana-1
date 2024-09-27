package media;

public class Audio extends ElementoMultimediale implements Riproducibile {
    private Durata durata;
    private int volume;

    public Audio(String titolo, Durata durata, int volume) {
        super(titolo);
        setDurata(durata); // Controllo sulla durata
        setVolume(volume); // Controllo sul volume
    }

    public Durata getDurata() {
        return durata;
    }

    public void setDurata(Durata durata) {
        this.durata = durata; // Non ci sono ulteriori controlli necessari
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

    @Override
    public void play() {
        int minutiTotali = durata.getMinuti();
        System.out.println("Riproduzione di: " + titolo);
        System.out.println("Durata: " + durata);
        for (int i = 0; i < minutiTotali; i++) {
            System.out.println(titolo + " " + "!".repeat(volume));
        }
    }

    @Override
    public void esegui() {
        play();
    }
}
