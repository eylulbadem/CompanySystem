/**
 * A class that extends Person. Responsible for packaging and delivery. 
 * @author Eylul Badem
 * @version 08.03.2021
*/ 
public class Employee extends Person
{
    // properties
    final int MAX_JOBS = 5;
    int currentJobs; 
    Delivery[] deliveries = new Delivery[MAX_JOBS];
    double salary;
    int employeeNo;
    boolean available;
    String status = "";

    
    // constructor 
    public Employee( int employeeNo, String name)
    {
        super(name);
        this.employeeNo = employeeNo;
        available = true;
        salary = 500;
        currentJobs = 0;
        status = "available";
    }
    
    // methods
    public void adjustSalary( double value)
    {
        salary = value;
    }
    
    /**
     * This method checks the choosen employee's availability
     * @return true if employee has an empty spot on their deliveries list
     */
    public boolean getAvailability()
    {
        boolean available;
        available = false;
        status = "busy";
        for ( int i = 0; i < deliveries.length; i++ )
        {
            if ( deliveries[i] == null )
            {
                available = true;
                status = "available";
            }
        }
        return available;
    }
    
    /**
     * This method adds a delivery job to an employee's delivery list
     * @param sendItem the choosen item to send, @param sender customer, @param receiver customer, @param packageNo no of the choosen item as a package
     */
    public void addJob( Item sendItem, Customer sender, Customer receiver, int packageNo)
    {
        double weight;
        weight = sendItem.getW();
        
        if ( weight <= 0.1 )
        {
            Mail mailItem = new Mail( sendItem.getC(), sender, receiver, packageNo );
            for ( int i = 0; i < deliveries.length; i ++)
            {
                if( deliveries[i] == null )
                {
                    deliveries[i] = mailItem;
                    break;
                }
                   
            }
        }
        else
        {
            Package packageItem = new Package( sendItem, sender, receiver, packageNo );
            for ( int i = 0; i < deliveries.length; i ++)
            {
                if( deliveries[i] == null )
                {
                    deliveries[i] = packageItem;
                    break;
                }
            }
        }
        currentJobs = currentJobs + 1;
    }
    
    /**
     * This method makes an employee deliver all the packages in their package list at that moment
     */
    public void deliverPackage()
    {
        for ( int i = 0; i < MAX_JOBS; i++ )
        {
            if( deliveries[i] != null )
            {
                System.out.println( deliveries[i].toString() );
                System.out.println( "Successfully delivered!" );
                System.out.println();
                deliveries[i] = null;
                
                currentJobs = currentJobs - 1;
            }
        }
    }
    
    public int getEmployeeNo()
    {
        return this.employeeNo;
    }
    
    public String toString()
    {
        getAvailability();
        return "Employee= no:" + employeeNo + ", name:" + this.name + ", salary:" + this.salary + ", \n number of current jobs:" + currentJobs + ", status:" + status;
    }
}