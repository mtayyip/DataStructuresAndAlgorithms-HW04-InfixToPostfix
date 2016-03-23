/**
 * Register sinifi icerisinde registerin degeri ve gosterdigi karakteri tutmak icin
 *deger ve karakter isimli iki degiskeni bulunmakta.
 * @author Muhammet
 */
public class Register 
{
    /**Registerin degerini tutmak icin.Baslangicta bos oldugunu gostermek icin -1 atiyorum.**/
    public int deger=-1;
    /**Registerin gosterdigi karakteri tutmak icin.Baslangicta bos oldugunu gostermek icin "bosluk" atiyorum.**/
    public String karakter=" "; 
    
    /**
     * Getter
     * @return Registerin degeri
     */
    public int getDeger() 
    { return deger;}

    /**
     * Getter
     * @return Registerin gosterdigi karakter
     */
    public String getKarakter() 
    { return karakter;}
    
    /**
     * Setter
     * @param deger Registerin yeni degeri
     */
    public void setDeger(int deger) 
    { this.deger = deger;}

    
    /**
     * Setter
     * @param karakter Registerin gosterdigi yeni karakter
     */
    public void setKarakter(String karakter) 
    { this.karakter = karakter;}

    
    /**
     * Register bosmu diye kontrol etmek icin yapilan metot. 
     * @return Register bossa true degilse false.
     */
    boolean valueZero() 
    {
        if(this.getDeger()==-1)
            return true;
        else
            return false;
    }      
}
