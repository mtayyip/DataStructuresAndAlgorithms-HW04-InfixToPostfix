import java.io.*;
/**
 * Main metodunun bulundugu sinif.
 * @author Muhammet
 */
public class TestMain 
{
    /**
     * 
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception 
    {       
        InfixToPostfix postfix=new InfixToPostfix();
        Assembly asm=new Assembly();
        
        /*input.txt den okuyup postfix.txt ye yazma.Her satiri alip InfixToPostfix sinifi icinde
        bulunan convertToPostfix metoduna gonderip sonucu postfix.txt ye yaziyor.*/
        File file1 = new File("input.txt");
        BufferedReader reader1 =new BufferedReader(new FileReader(file1));       
        FileWriter fw1=new FileWriter("postfix.txt");
        try (PrintWriter pw1 = new PrintWriter(fw1)) {
            String satir1 = reader1.readLine();
            while (satir1!=null) {
                String sonuc1=postfix.convertToPostfix(satir1);
                pw1.println(sonuc1);
                satir1 = reader1.readLine();}}    
        
        
        /*postfix.txt den okuyup output.asm ye yazma.Her satiri alip Assembly sinifi icinde
        bulunan convertToAssembly metoduna gonderip sonucu output.asm ye yaziyor.*/        
        File file2 = new File("postfix.txt");
        BufferedReader reader2 =new BufferedReader(new FileReader(file2));
        FileWriter fw2=new FileWriter("output.asm");
        try (PrintWriter pw2 = new PrintWriter(fw2)) {
            String satir2 = reader2.readLine();
            while (satir2!=null) {
                String sonuc2=asm.convertToAssembly(satir2);
                pw2.print(sonuc2);
                satir2 = reader2.readLine();}}   
    }
}
