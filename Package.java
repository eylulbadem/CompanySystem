/**
 * A class that extends Delivery. 
 * @author Eylul Badem
 * @version 08.03.2021
*/ 
public class Package extends Delivery
{
    // properties
    Item packedItem;
    
    // constructor 
    public Package( Item content, Customer sender, Customer receiver, int packageNo)
    {
        super( sender, receiver, packageNo );
        this.packedItem = content;
    }
    
    // methods
    public double getWeight()
    {
        return 0.1;
    }
    
    public String toString()
    {
        return "PACKAGE= no:" + packageNo + ", " + packedItem.toString() +  ", \n sender:" + sender + ", \n receiver:" + receiver;
    }
}