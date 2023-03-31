import java.util.ArrayList;
import java.util.Scanner;


public class BilgiSistemi {
    //Nesneleri depolamak için ArrayListler
    public ArrayList<Hasta> hastalar = new ArrayList<Hasta>();
    public ArrayList<Doktor> doktorlar = new ArrayList<Doktor>();
    public ArrayList<Tedavi> tedaviler = new ArrayList<Tedavi>();
    public Scanner scn = new Scanner(System.in);
    //consturactor
    public BilgiSistemi() {
        //Kullanıcı buradan işlemleri yapabiliyor. While döngüsü içinde olduğu için sınırsız işlem yapabiliyor.
        //Eğer işlemden çıkmak isterse 7 ye basıyor ve bu şekilde else if in break kodu çalışıp döngüden çıkıp program sona eriyor.
        System.out.println("Bilgi Sistemine Hoş Geldiniz");
        String secenekler=("+++++++++++++++++++++++\n"
                         + "1-Hasta Ekle\n"
                         + "2-Doktor Ekle\n"
                         + "3-Tedavi Ekle\n"
                         + "4-Hasta Bul\n"
                         + "5-Doktor Bul\n"
                         + "6-Seçenekleri Gör\n"
                         + "7-Sistemden Çık\n"
                         + "+++++++++++++++++++++++\n");
        System.out.println(secenekler);
        
        while (true) {       
            int islem = scn.nextInt();
            scn.nextLine();
            if (islem ==1) {
                System.out.println("İsim: ");
                String isim= scn.nextLine();
                System.out.println("TC Kimlik No: ");
                String Tckimlik = scn.nextLine();
                //Burada eklemek istedikleri kişinin kayıtlı olup olmadığına bakıyor
                if (hastaBul(Tckimlik)!=null||doktorBul(Tckimlik)!=null) {
                    System.out.println("Bu TC Kimlik No ya sahip kişi zaten kayıtlı.");
                    continue;
                }
                System.out.println("Doğum Yılı: ");
                int dogumyılı = scn.nextInt();
                Hasta hasta = new Hasta(isim,Tckimlik,dogumyılı);
                if(hastaEkle(hasta)){
                    System.out.println("Hasta başarılı bir şekilde eklendi.");
                }
                else{
                    System.out.println("Bu hasta zaten kayıtlı.");
                }
            }
            else if (islem ==2) {
                System.out.println("İsim: ");
                String isim= scn.nextLine();
                System.out.println("TC Kimlik No: ");
                String Tckimlik = scn.nextLine();
                //Burada eklemek istedikleri kişinin kayıtlı olup olmadığına bakıyor
                if (hastaBul(Tckimlik)!=null||doktorBul(Tckimlik)!=null) {
                    System.out.println("Bu TC Kimlik No ya sahip kişi zaten kayıtlı.");
                    continue;
                }
                System.out.println("Diploma No: : ");
                int diplomaNo = scn.nextInt();
                Doktor doktor = new Doktor(isim,Tckimlik,diplomaNo);
                if(doktorEkle(doktor)){
                    System.out.println("Doktor başarılı bir şekilde eklendi.");
                }
                else{
                    System.out.println("Bu doktor zaten kayıtlı.");
                }
            }
            else if (islem ==3) {
                System.out.println("Hasta İsmi: ");
                String Hisim= scn.nextLine();
                System.out.println("Hasta TC Kimlik No: ");
                String HTckimlik = scn.nextLine();
                System.out.println("Hasta Doğum Yılı: ");
                int Hdogumyılı = scn.nextInt();
                scn.nextLine();
                Hasta hasta = new Hasta(Hisim,HTckimlik,Hdogumyılı);
                
                System.out.println("Doktor İsim: ");
                String isim= scn.nextLine();
                System.out.println("Doktor TC Kimlik No: ");
                String Tckimlik = scn.nextLine();
                System.out.println("Doktor Diploma No: : ");
                int diplomaNo = scn.nextInt();
                scn.nextLine();
                Doktor doktor = new Doktor(isim,Tckimlik,diplomaNo);
                
                tedaviEkle(hasta, doktor);
                
            }
            else if (islem ==4) {
                Hasta hasta;
                System.out.println("Hasta TC Kimlik No: ");
                String tcK = scn.nextLine();
                hasta =hastaBul(tcK);
                if (hasta==null) {
                    System.out.println("Kişi bulunamadı");
                    continue;
                }else{
                    System.out.println("Kişi bulundu");
                    System.out.println("İsim: "+hasta.getIsim()+"\n"
                                     + "TC Kimlik No: "+hasta.TCKimlik+"\n"
                                     + "Doğum Yılı: "+hasta.getDogumYili());
                }
            }
            else if (islem ==5) {
                Doktor doktor;
                System.out.println("Doktor TC Kimlik No: ");
                String tcK = scn.nextLine();
                doktor =doktorBul(tcK);
                if (doktor==null) {
                    System.out.println("Kişi bulunamadı");
                    continue;
                }else{
                    System.out.println("Kişi bulundu");
                    System.out.println("İsim: "+doktor.getIsim()+"\n"
                                     + "TC Kimlik No: "+doktor.TCKimlik+"\n"
                                     + "Diploma No: "+doktor.diplomaNo);
                }
                
            }
            else if (islem ==6) {
                //Burada seçenekleri tekrar görmek için 6 ya basıyor ve seçenekleri tekrar görüyor.
                System.out.println(secenekler);
            }
            else if (islem ==7) {
                break;
            }
            else {
                System.out.println("Yanlış işlem girdiniz...");
            }
        }
            System.out.println("Sistemden Çıkılıyor...");
    }
    
    //Parametre ArrayListe kayıtlı mı ona bakıyor kayıtlı ise false döndürüyor değil ise ArrayListe ekleyip true döndürüyor
    public boolean hastaEkle(Hasta hasta){
        for(Hasta h : hastalar){
            if (hasta.equals(h)) {
                return false;
            }
            
        }
        hastalar.add(hasta);
        return true;
    }
    
    //Parametre ArrayListe kayıtlı mı ona bakıyor kayıtlı ise false döndürüyor değil ise ArrayListe ekleyip true döndürüyor
    public boolean doktorEkle(Doktor doktor){
        for(Doktor d : doktorlar){
            if (doktor.equals(d)) {
                return false;
            }
            
        }
        doktorlar.add(doktor);
        return true;
    }
    
    
    public void tedaviEkle(Hasta hasta,Doktor doktor){
        //Parametrelerin ArrayListlerde kayıtlı olup olmadığına bakıyor eğer kayıtlı değilse uyarı veriyor.
        //Kayıtlı ise tedavi nesnesi oluşturup tedaviler ArrayListine ekliyor.
        boolean dOnay = false;
        boolean hOnay = false;
        for(Doktor d : doktorlar){
            if (doktor.getIsim().equals(d.getIsim())&&doktor.getTCKimlik().equals(d.getTCKimlik())&&doktor.getDiplomaNo()==d.getDiplomaNo()) {
                dOnay =true;
            }
        }
        
        
        for(Hasta h : hastalar){
            if (hasta.getIsim().equals(h.getIsim())&&hasta.getTCKimlik().equals(h.getTCKimlik())&&hasta.getDogumYili()==h.getDogumYili()) {
                hOnay =true;
            } 
        }
        
        if (!dOnay&&!hOnay) {
            System.out.println("Doktor ve Hasta Bulunamadı");
        }
        else if (!dOnay) {
            System.out.println("Doktor Bulunamadı");
        }
        else if (!hOnay) {
            System.out.println("Hasta Bulunamadı");
        }
        else{
            System.out.println("Ayrıntıları giriniz: ");
            String ayrintilar = scn.nextLine();
            Tedavi tedavi = new Tedavi(hasta,doktor);
            tedavi.setAyrintilar(ayrintilar);
            System.out.println("Ayrıntılar: "+tedavi.getAyrintilar());
            tedaviler.add(tedavi);
            
        }  
        
        
        
    }
    
    //Parametre ile aynı değere sahip nesnenin TcKimliği varsa o nesneyi geri döndürüyor yoksa null değer döndürüyor
    public Hasta hastaBul(String TCKimlik){
        for(Hasta h : hastalar){
            if (TCKimlik.equals(h.getTCKimlik())) {
                return h;
            }
            
        }
     return null;
    }
    
    //Parametre ile aynı değere sahip nesnenin TcKimliği varsa o nesneyi geri döndürüyor yoksa null değer döndürüyor
    public Doktor doktorBul(String TCKimlik){
        for(Doktor d : doktorlar){
            if (TCKimlik.equals(d.getTCKimlik())) {
                return d;
            }
            
        }
        
        return null;
    }

}
