import java.util.*;
/**
 * Data Structures Abstraction and Design Using Java kitabi sayfa 181 de bulunan
 * kodlarin bazi yerleri degistirelerek infix seklinde verilen String i Postfix biciminde 
 * geri veren siniftir.Icerisinde sadece convertToPostfix metodu bulunmaktadir. 
 * @author Muhammet
 */
public class InfixToPostfix 
{
    private Stack<Character> ExStack;
    private StringBuilder StrPostfix;
    
    public String convertToPostfix(String infix)
    {
        ExStack=new Stack<>();
        StrPostfix=new StringBuilder();    
        StringTokenizer infixTokens = new StringTokenizer(infix);
        try 
        {
            while (infixTokens.hasMoreTokens()) 
            {
                String nextToken = infixTokens.nextToken();
                char first=nextToken.charAt(0);
                if(Character.isJavaIdentifierStart(first)||Character.isDigit(first))
                {
                    StrPostfix.append(nextToken);
                    StrPostfix.append(' ');
                    
                }
                else if(first=='+' || first=='-' || first=='*' || first=='/' || first=='=')
                    Operator(first);
                else 
                    throw new Exception("Kullanilmayan Karakter"+first);
            }
            while (!ExStack.empty()) 
            {
                char op = ExStack.pop();
                StrPostfix.append(op);
                StrPostfix.append(' ');
            }
         
            return StrPostfix.toString(); 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return StrPostfix.toString(); 
    } 
    
    private void Operator(char c)
    {
        if(ExStack.isEmpty())
            ExStack.push(c);
        else{
            char ust =ExStack.peek();
            if (siralama(c) >siralama(ust))
                ExStack.push(c);
            else {
                while (!ExStack.empty()&& siralama(c) <= siralama(ust)) {
                    ExStack.pop();
                    StrPostfix.append(ust);
                    StrPostfix.append(' ');
                    if (!ExStack.empty()) 
                        ust = ExStack.peek();}
                ExStack.push(c);
                }
            }
    }
    
    /**
     * @param c karakter
     * @return Gelen karakterin onceligine gore 0,1 veya 2 donderiyor.
     */
    private int siralama(char c){
        if(c=='*' || c=='/')
            return 2;
        else if(c=='+' || c=='-')
            return 1;
        else if(c=='=')
            return 0;
        else
            return -1;} 
    
}
