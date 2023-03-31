
import java.util.Scanner;

public class Tedavi {
    //composition
    Doktor doktor;
    Hasta hasta;
    String ayrintilar;

    //consturactor
    Tedavi(Hasta hasta, Doktor doktor) {
        System.out.println(doktor.getIsim()+" adlı doktor "+hasta.getIsim()+" adlı hastayı tedavi etti.");
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public String getAyrintilar() {
        return ayrintilar;
    }

    public void setAyrintilar(String ayrintilar) {
        this.ayrintilar = ayrintilar;
    }
}
