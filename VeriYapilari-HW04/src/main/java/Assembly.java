import java.util.*;
/**
 * Postfix seklinde verilen ifadeyi register'lar la assembly koda ceviren sinif.
 * @author Muhammet
 */
public class Assembly 
{
    /**
     * Gelen ifadeyi stack te tutup yeri geldiginde pop la cekiyorum.
     */
    private Stack<Object> ExStack;
    private StringBuilder StrAssembly;
    private StringBuilder StrConvert;
    
    /**
     * 0 dan 8 e kadar olusturdugum Register'lar
     */     
    Register $t0=new Register();
    Register $t1=new Register();
    Register $t2=new Register();
    Register $t3=new Register();
    Register $t4=new Register();
    Register $t5=new Register();
    Register $t6=new Register();
    Register $t7=new Register();
        
    public String convertToAssembly(String postfix)
    {
        ExStack=new Stack<>();
        StrAssembly=new StringBuilder();    
        StrConvert=new StringBuilder(); 
        StringTokenizer asmTokens = new StringTokenizer(postfix);
        
        try 
        {
            while (asmTokens.hasMoreTokens()) 
            {
                String nextToken = asmTokens.nextToken();
                char first=nextToken.charAt(0);
                
                if(Character.isJavaIdentifierStart(first)||Character.isDigit(first)){
                    ExStack.push(nextToken);
                    StrAssembly.append(nextToken);
                    StrAssembly.append(' ');
                    if(Character.isDigit(first))
                        Operatorli(nextToken);}                            
              
                else if(first=='+')
                    Operatoradd();
                
                else if(first=='-')
                    Operatorsub();
                
                else if(first=='/')
                    Operatordiv(); 
                
                else if(first=='*')
                    Operatormult();
                
                else if(first=='=')
                    Operatorassign();
                    
                else 
                    throw new Exception("Kullanilmayan Karakter"+first);
            }           
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return StrConvert.toString(); 
    } 
    
    
    /**
     * Gelen ifadeyi stackte tutuyordum.+ operatoru gelince stack bastaki iki elemanini
     * cekip duruma gore registerlarin degerlerine atiyor. 
     * Aslinda private olmasi gereken bu metot Javadoc ta gorunmesi icin public yapildi. 
     * @throws java.lang.Exception karakterBakma metodunun throw firlatma ihtimali oldugu icin
     * cagiran metodu bilgilendirmek icin.
     */
    public void Operatoradd() throws Exception 
    {
        String right=(String)ExStack.pop();
        String left=(String)ExStack.pop();
        int res1,res2;
        
        /*StringBuilder newline icin calisan metot*/
        StrConvert.append(System.getProperty("line.separator"));
        StrConvert.append("add   ");

        boskenRegisterYapma("999");
        StrConvert.append(" , ");

        if(!Character.isDigit(left.charAt(0)))
            res1=karakterBakma(left);        
        
        StrConvert.append(", ");

        if(!Character.isDigit(right.charAt(0)))
            res2=karakterBakma(right);        
    }
    
    
    
    /**
     * Gelen ifadeyi ExStack te tutuyordum.- operatoru gelince stack bastaki iki elemanini
     * pop()la cekip duruma gore registerlarin degerlerine atiyor. 
     * Aslinda private olmasi gereken bu metot Javadoc ta gorunmesi icin public yapildi. 
     * @throws java.lang.Exception karakterBakma metodunun throw firlatma ihtimali oldugu icin
     * cagiran metodu bilgilendirmek icin.
     */
    public void Operatorsub() throws Exception
    {
        String right=(String)ExStack.pop();
        String left=(String)ExStack.pop();
        int res1,res2;
        
        /*StringBuilder newline icin calisan metot*/
        StrConvert.append(System.getProperty("line.separator"));
        StrConvert.append("sub   ");
           
        boskenRegisterYapma("999");
        StrConvert.append(" , ");

        if(!Character.isDigit(left.charAt(0)))
            res1=karakterBakma(left);         
        
        StrConvert.append(", ");      

        if(!Character.isDigit(right.charAt(0)))
            res2=karakterBakma(right);   
    }
    
    
    
    /**
     * Gelen ifadeyi ExStack te tutuyordum.* operatoru gelince stack bastaki iki elemanini
     * pop()la cekip duruma gore registerlarin degerlerine atiyor. 
     * Aslinda private olmasi gereken bu metot Javadoc ta gorunmesi icin public yapildi. 
     * @throws java.lang.Exception karakterBakma metodunun throw firlatma ihtimali oldugu icin
     * cagiran metodu bilgilendirmek icin.
     */
    public void Operatormult() throws Exception
    {
        String right=(String)ExStack.pop();
        String left=(String)ExStack.pop();
        int res1=0,res2=0;
        /*StringBuilder newline icin calisan metot*/
        StrConvert.append(System.getProperty("line.separator"));
        StrConvert.append("mult   ");
           
        if(!Character.isDigit(left.charAt(0)))
            res1=karakterBakma(left);        
        
        StrConvert.append(", ");
        

        if(!Character.isDigit(right.charAt(0)))
            res2=karakterBakma(right); 
        
        StrConvert.append(System.getProperty("line.separator"));
        StrConvert.append("mflo   ");
        
        boskenRegisterYapma("999");
        int sonuc=res1*res2;
        
        assign("999",String.valueOf(sonuc));
    }
    
    
    
    /**
     * Gelen ifadeyi ExStack te tutuyordum./ operatoru gelince stack bastaki iki elemanini
     * pop()la cekip duruma gore registerlarin degerlerine atiyor. 
     * Aslinda private olmasi gereken bu metot Javadoc ta gorunmesi icin public yapildi. 
     * @throws java.lang.Exception karakterBakma metodunun throw firlatma ihtimali oldugu icin
     * cagiran metodu bilgilendirmek icin.
     */
    public void Operatordiv() throws Exception
    {
        String right=(String)ExStack.pop();
        String left=(String)ExStack.pop();
        int res1=0,res2=0;
        /*StringBuilder newline icin calisan metot*/
        StrConvert.append(System.getProperty("line.separator"));
        StrConvert.append("div   ");
           
        if(!Character.isDigit(left.charAt(0)))
            res1=karakterBakma(left);        
        
        StrConvert.append(", ");
        

        if(!Character.isDigit(right.charAt(0)))
            res2=karakterBakma(right); 
        
        StrConvert.append(System.getProperty("line.separator"));
        StrConvert.append("mfhi   ");
        
        try{
            boskenRegisterYapma("999");
            int sonuc=res1/res2;        
            assign("999",String.valueOf(sonuc));        
        } 
        catch(Exception e)
        {
            System.out.println("0 la bölme hatasi");
        }
    }
    
    
    /**
     * Bu metot stackte bulunan eleman eger bir sayi ise(constant ise) direkt olarak
     * o sayiyi bir register'a atiyor.
     * Aslinda private olmasi gereken bu metot Javadoc ta gorunmesi icin public yapildi. 
     * @param c registerin degeri ile degistirilmek istenen string.Degistirme yaparken Integer.parseInt
     * ile int e donusturelecek.
     * @throws java.lang.Exception boskenRegisterYapma metodunun throw firlatma ihtimali oldugu icin
     * cagiran metodu bilgilendirmek icin.
     */
    public void Operatorli(String c) throws Exception
    {
        /*StringBuilder newline icin calisan metot*/
        StrConvert.append(System.getProperty("line.separator"));
        StrConvert.append("li   ");        
        boskenRegisterYapma(c);
        StrConvert.append(" , ");
        StrConvert.append(c);
    }

    
    /**
     * Gelen ifadeyi ExStack te tutuyordum./ operatoru gelince stack bastaki iki elemanini
     * pop()la cekip duruma gore registerlarin degerlerine atiyor.  
     * Aslinda private olmasi gereken bu metot Javadoc ta gorunmesi icin public yapildi. 
     */   
    public void Operatorassign()
    {
        String right=(String)ExStack.pop();
        String left=(String)ExStack.pop();
              
        if(!Character.isDigit(left.charAt(0)))
            assign(left,right); 
        
        if(!Character.isDigit(right.charAt(0)))
            assign(right,left);
    }
    
    /**
     * Bu metot iki string aliyor.Ve ikinci parametrenin hangi register da oldugunu bulup
     * o register in karakterini birinci stringle degistiriyor.
     * Aslinda private olmasi gereken bu metot Javadoc ta gorunmesi icin public yapildi. 
     * @param c1 registerin yeni karakter degeri.
     * @param c2 degisecek olan registeri bulmak icin verilen string.
     */
    public void assign(String c1,String c2)  
    {  
        if($t0.getDeger()==Integer.parseInt(c2)){
            $t0.setKarakter(c1);}
        
        else if($t1.getDeger()==Integer.parseInt(c2)){
            $t1.setKarakter(c1);}
        
        else if($t2.getDeger()==Integer.parseInt(c2)){
            $t2.setKarakter(c1);}
               
        else if($t3.getDeger()==Integer.parseInt(c2)){
            $t3.setKarakter(c1);}
        
        else if($t4.getDeger()==Integer.parseInt(c2)){
            $t4.setKarakter(c1);}        
        
        else if($t5.getDeger()==Integer.parseInt(c2)){
            $t5.setKarakter(c1);}        
        
        else if($t6.getDeger()==Integer.parseInt(c2)){
            $t6.setKarakter(c1);}       
        
        else if($t7.getDeger()==Integer.parseInt(c2)){
            $t7.setKarakter(c1);}          
    }
    
    

    /**
     * Gonderilen parametredeki string ile ayni olan registerin karakter degerini bulmaya
     * calisan,bulunca append le registerin ismini yazan ve registerin degerini return eden metot.
     * Aslinda private olmasi gereken bu metot Javadoc ta gorunmesi icin public yapildi.
     * @param c registerin karakter degeri ile ayni mi diye bakilacak olan string
     * @return registerin degeri
     * @throws java.lang.Exception Eger 8 tane olan register'imiz dan biri degilse hata veriyor.
     */
    public int karakterBakma(String c) throws Exception
    {        
        if($t0.karakter.compareTo(c)==0){
            StrConvert.append("$t0");
            return $t0.deger;}
        
        else if($t1.karakter.compareTo(c)==0){
            StrConvert.append("$t1");
            return $t1.deger;}
        
        else if($t2.karakter.compareTo(c)==0){
            StrConvert.append("$t2");
            return $t2.deger;}
               
        else if($t3.karakter.compareTo(c)==0){
            StrConvert.append("$t3");
            return $t3.deger;}
        
        else if($t4.karakter.compareTo(c)==0){
            StrConvert.append("$t4");
            return $t4.deger;}        
        
        else if($t5.karakter.compareTo(c)==0){
            StrConvert.append("$t5");
            return $t5.deger;}        
        
        else if($t6.karakter.compareTo(c)==0){
            StrConvert.append("$t6");
            return $t6.deger;}       
        
        else if($t7.karakter.compareTo(c)==0){
            StrConvert.append("$t7");
            return $t7.deger;}       

        else
            throw new Exception("Register sayisi gecildi");       
    } 
    
    
    
    /**
     * Register sinifinin valueZero metodu ile registerlarin bos veya dolu oldugunu kontrol edip
     * eger bossa append le registerin ismini yazan,gelen stringle degerini degistiren ve ayrica icinin 
     * dolu oldugunu gostermek icin karakterine de . koyan metot.
     * Aslinda private olmasi gereken metot Javadoc ta gorunmesi icin public yapildi.
     * @param c Integer.parseInt metodu ile gelen c Stringini int e cevirip registerin degerini set ediyorum.
     * @throws java.lang.Exception Eger 8 tane olan register'imiz dan biri degilse hata veriyor.
     */
    public void boskenRegisterYapma(String c) throws Exception
    {
        if($t0.valueZero()){
            StrConvert.append("$t0");
            $t0.setDeger(Integer.parseInt(c));
            $t0.setKarakter(".");}
        
        else if($t1.valueZero()){
            StrConvert.append("$t1");
            $t1.setDeger(Integer.parseInt(c));
            $t1.setKarakter(".");}
        
        else if($t2.valueZero()){
            StrConvert.append("$t2");  
            $t2.setDeger(Integer.parseInt(c));
            $t2.setKarakter("."); }
               
        else if($t3.valueZero()){
            StrConvert.append("$t3"); 
            $t3.setDeger(Integer.parseInt(c));
            $t3.setKarakter(".");}
        
        else if($t4.valueZero()){
            StrConvert.append("$t4");
            $t4.setDeger(Integer.parseInt(c));
            $t4.setKarakter(".");}        
        
        else if($t5.valueZero()){
            StrConvert.append("$t5");
            $t5.setDeger(Integer.parseInt(c));
            $t5.setKarakter(".");}        
        
        else if($t6.valueZero()){
            StrConvert.append("$t6");
            $t6.setDeger(Integer.parseInt(c));
            $t6.setKarakter(".");}        
        
        else if($t7.valueZero()){
            StrConvert.append("$t7");
            $t7.setDeger(Integer.parseInt(c));
            $t7.setKarakter(".");}
        
        else
            throw new Exception("Register sayisi gecildi"); 
    }
}

