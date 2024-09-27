package media;

public class Durata {
    private int minuti;
    private int secondi;

    public Durata(int minuti, int secondi) {
        setMinuti(minuti);
        setSecondi(secondi);
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        if (minuti >= 0) {
            this.minuti = minuti;
        } else {
            throw new IllegalArgumentException("I minuti non possono essere negativi.");
        }
    }

    public int getSecondi() {
        return secondi;
    }

    public void setSecondi(int secondi) {
        if (secondi >= 0 && secondi < 60) {
            this.secondi = secondi;
        } else {
            throw new IllegalArgumentException("I secondi devono essere compresi tra 0 e 59.");
        }
    }

    public int toSecondi() {
        return minuti * 60 + secondi;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", minuti, secondi);
    }
}
