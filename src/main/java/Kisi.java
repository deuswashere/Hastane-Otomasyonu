
public abstract class  Kisi {
    String isim;
    String TCKimlik;
    //constructor
    public Kisi(String isim, String TCKimlik) {
        this.isim = isim;
        this.TCKimlik = TCKimlik;
    }

    public String getIsim() {
        return isim;
    }

    public String getTCKimlik() {
        return TCKimlik;
    }
}
