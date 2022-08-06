/**
 * A class that extends Delivery.
 * @author Eylul Badem
 * @version 08.03.2021
*/ 
public class Mail extends Delivery
{
    // properties
    String content;
    
    // constructor 
    public Mail( String content, Customer sender, Customer receiver, int packageNo)
    {
        super( sender, receiver, packageNo );
        this.content = content;
    }
    
    // methods
    public double getWeight()
    {
        return 0.1;
    }
    
    public String toString()
    {
        return "MAIL INFO = package no(" + packageNo + ", content(" + content + "), sender(" + sender + "), receiver(" + receiver + ")" ;
    }
}