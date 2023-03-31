//Inheritance
public class Hasta extends Kisi{
    int dogumYili;
    //constructor
    public Hasta( String isim, String TCKimlik,int dogumYili) {
        super(isim, TCKimlik);
        this.dogumYili = dogumYili;
    }

    public int getDogumYili() {
        return dogumYili;
    }

    public String getIsim() {
        return isim;
    }

}
