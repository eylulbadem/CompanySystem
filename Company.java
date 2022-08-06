import java.util.ArrayList;

/**
 * A class that implements Locatable. 
 * @author Eylul Badem
 * @version 08.03.2021
*/ 
public class Company implements Locatable
{
    // properties
    final int EMPLOYEE_CAPACITY = 15;
    Employee[] employees;
    ArrayList <Customer> customers;
    int numOfEmployees;
    int employeeNo;
    int packageNo;
    int posX;
    int posY;
    
    // constructor 
    public Company( int x, int y)
    {
        this.posX = x;
        this.posY = y;
        employeeNo = 0;
        packageNo = 0;
        numOfEmployees = 0;
        employees = new Employee[EMPLOYEE_CAPACITY];
        customers = new ArrayList<Customer>();
    }
    
    // methods
    public int getX()
    {
        return posX;
    }
    
    public int getY()
    {
        return posY;
    }
    
    public int getPackageNo()
    {
        return packageNo;
    }
    
    public void printEmployees()
    {
        for ( int i = 0; i < employees.length; i++ )
        {
            if ( employees[i] != null )
            System.out.println( employees[i]);
        }
    }
    
    public void printCustomers()
    {
        for ( int i = 0; i < customers.size(); i++ )
        {
            System.out.println( customers.get(i) );
        }
    }
    
    public void setPos( int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }
    
    /**
     * This method hires a candidate employee
     * @param candidate candidate employee 
     * @return true if hiring process was successful
     */
    public boolean addEmployee( Employee candidate)
    {
        boolean successful;
        successful = false;
        
        if ( employees[candidate.getEmployeeNo()] == null )
        {
            employees[candidate.getEmployeeNo()] = candidate;
            numOfEmployees = numOfEmployees + 1;
        }
        
        for ( int i = 0; i < EMPLOYEE_CAPACITY; i++ )
        {
            if ( employees[i] == candidate )
            {
                successful = true;
            } 
        }
        return successful;
    }
    
    public void addCustomer ( Customer customer)
    {
        customers.add( customer );
    }
    
    /**
     * This method terminates contract with the choosen employee
     * @param employeeIndex employee no of the chosen employee
     * @return true if the terminating process was successful
     */
    public boolean terminateContract( int employeeIndex)
    {
        String employeeName = employees[employeeIndex].name;
        employees[employeeIndex] = null;
        boolean successful;
        successful = false;
        if ( employees[employeeIndex] == null )
            {
                successful = true;
                System.out.println( employeeName + " is no longer working with you." );
            } 
            numOfEmployees = numOfEmployees - 1;
        return successful;
    }
    
    /**
     * This method creates a package to make it deliverable
     * @param sendItem item to package, @param sender sender customer, @param receiver receiver customer
     * @return true if the packaging process was successful
     */
    public boolean createDeliverable( Item sendItem, Customer sender, Customer receiver)
    {
        boolean available;
        available = false;
        
        for ( int i = 0; i < employees.length; i++ )
        {
            if ( employees[i] != null && employees[i].getAvailability() )
            {
                employees[i].addJob( sendItem, sender, receiver, packageNo );
                packageNo = packageNo + 1;
                available = true;
                break;
            }
        }
            
        return available;
    }
    
    /**
     * This method delivers all the packages company has at that moment.
     */
    public void deliverPackages()
    {
        for ( int i = 0; i < employees.length; i++ )
        {
            if ( employees[i] != null )
            {
            for ( int j = 0; j < employees[i].deliveries.length; j++ )
            {
                if ( employees[i].deliveries[j] != null )
                {
                    employees[i].deliverPackage();
                    System.out.println( "RESPONSIBLE EMPLOYEE FOR THE DELIVERY:" );
                    System.out.println( employees[i].toString() );
                    System.out.println();
                }
            }
            }
        }
    }
    
    public String toString()
    {
        return "COMPANY= number of employees:" + numOfEmployees + ", number of packages in the queue:" + packageNo ;
    }
}