package media;

public abstract class ElementoMultimediale {
    protected String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    // Getter per il titolo
    public String getTitolo() {
        return titolo;
    }

    // Setter per il titolo con un controllo (titolo non può essere vuoto o nullo)
    public void setTitolo(String titolo) {
        if (titolo != null && !titolo.trim().isEmpty()) {
            this.titolo = titolo;
        } else {
            throw new IllegalArgumentException("Il titolo non può essere vuoto o nullo.");
            //IllegalArgumentException fa parte del meccanismo di gestione degli errori di Java
        }
    }

    // Metodo astratto che sarà implementato dalle sottoclassi
    public abstract void esegui();
}
