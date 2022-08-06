/**
 * A class that extends Person.
 * @author Eylul Badem
 * @version 08.03.2021
*/ 
public class Customer extends Person
{
    // properties
    String content = "none";
    Item currentItem = new Item( 0, content );
    
    // constructor 
    public Customer( String name)
    {
        super(name);
    }
    
    // methods
    public Item getCurrentItem()
    {
        return currentItem;
    }
    
    public void setCurrentItem( Item currentItem )
    {
        this.currentItem.weight = currentItem.getW();
        this.currentItem.content = currentItem.getC();
    }
    
    /**
     * This method sends the wanted item to the wanted customer.
     * @param company the company the program is working with, @param item the item to send, @param receiver receiver customer
     */
    public void sendItem( Company company, Item item, Customer receiver)
    {
        boolean available;
        available = false;
        Customer sender = new Customer( this.name );
        
        for ( int i = 0; i < company.employees.length; i++ )
        {
            if ( company.employees[i] != null )
            {
                if ( company.employees[i].getAvailability() )
                available = true;
            }
        }
        
        if ( available )
        {
            company.createDeliverable( item, sender, receiver);
            receiver.setCurrentItem( item );
            System.out.println( "Item added to queue." );
        }
        else 
            System.out.println( "Your employees are not available." );
        
    }
    
    public String toString()
    {
        Item emptyItem = new Item( 0, content );
        if ( currentItem == emptyItem )
        return "Customer= name:" + this.name + " and current item: none ";
        else
        return "Customer= name:" + this.name + " and current item:" + currentItem.toString();
    }
}