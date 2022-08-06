/**
 * An abstract class that implements Locatable. 
 * @author Eylul Badem
 * @version 08.03.2021
*/ 
public abstract class Person implements Locatable
{
    // properties
    String name;
    int posX;
    int posY;
    
    // constructor 
    public Person( String name, int x, int y)
    {
        this.name = name;
        this.posX = x;
        this.posY = y;
    }
    
    public Person( String name )
    {
        this.name = name;
        this.posX = 0;
        this.posY = 0;
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    
    public void setName( String newName )
    {
        this.name = newName;
    }

    public int getX()
    {
        return posX;
    }
    
    public int getY()
    {
        return posY;
    }
    
    public void setPos( int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }
}