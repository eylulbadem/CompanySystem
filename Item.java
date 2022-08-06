/**
 * A class that creates an item that is converted to a Delivery first to be sent.
 * @author Eylul Badem
 * @version 08.03.2021
*/ 
public class Item
{
    // properties
    double weight;
    String content;
    
    // constructor 
    public Item( double weight, String content)
    {
        this.weight = weight;
        this.content = content;
    }
    
    // methods
    public double getW()
    {
        return weight;
    }
    
    public String getC()
    {
        return content;
    }
    
    @Override
    public String toString()
    {
        return "weight:" + weight + ", content:" + content;
        
    }
}