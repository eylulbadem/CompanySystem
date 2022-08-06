/**
 * An abstract class that creates deliveries.
 * @author Eylul Badem
 * @version 08.03.2021
*/ 
public abstract class Delivery
{
    // properties
    int packageNo;
    Customer sender;
    Customer receiver;
    
    // constructor 
    public Delivery( Customer sender, Customer receiver, int packageNo)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.packageNo = packageNo;
    }
    
    // methods
    public abstract double getWeight();
    
    public Customer getSender()
    {
        return sender;
    }
    
    public Customer getReceiver()
    {
        return receiver;
    }
    
    public double getPackageNo()
    {
        return packageNo;
    }
}