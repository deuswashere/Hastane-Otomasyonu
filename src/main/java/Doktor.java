//Inheritance
public class Doktor extends Kisi{
    int diplomaNo;
    //consutractor
    public Doktor(String isim, String TCKimlik,int diplomaNo) {
        super(isim, TCKimlik);
        this.diplomaNo = diplomaNo;
    }

    public int getDiplomaNo() {
        return diplomaNo;
    }

    public String getIsim() {
        return isim;
    }
    
}
