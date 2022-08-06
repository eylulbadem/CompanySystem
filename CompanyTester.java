import java.util.Scanner;

/**
 * Tester class to test the classes and the methods.
 * @author Eylul Badem
 * @version 09.03.2021
*/ 
public class CompanyTester
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        // Constants 
        final int MENU_DEL_EMP = 1;
        final int MENU_ENGIN_20 = 2;
        final int MENU_HULYA = 3;
        final int MENU_DELIVER = 4;
        final int MENU_EMPLOYEES = 5;
        final int MENU_CUSTOMERS = 6;
        final int MENU_EXIT = 7;
        
        // Variables
        Company myCompany;
        int selection;
        String name1 = "Eylul";
        String name2 = "Ekin";
        String name3 = "Emir";
        String name4 = "Hulya";
        String name5 = "Engin";
        String content = "some content";
        myCompany = new Company( 1, 2 );
        Employee newEmp1 = new Employee( 0, name1 );
        Employee newEmp2 = new Employee( 1, name2 );
        Employee newEmp3 = new Employee( 2, name3 );
        Customer newCust1 = new Customer( name4 );
        Customer newCust2 = new Customer( name5 );
        Item item1 = new Item( 1, content );
        Item item2 = new Item( 0.1, content );
        Item item3 = new Item( 3.5, content );
        
        // Program Code
        myCompany.addEmployee( newEmp1 );
        myCompany.addEmployee( newEmp2 );
        myCompany.addEmployee( newEmp3 );
        myCompany.addCustomer( newCust1 );
        myCompany.addCustomer( newCust2 );
        
        do
        {
            // display menu
            System.out.println();
            System.out.println( "Welcome!");
            System.out.println( "This is a screen where you can make operations related to your company." );
            System.out.println( "-----------------------------------------" );
            System.out.println();
            System.out.println( MENU_DEL_EMP + "- to terminate contract with Eylul" );
            System.out.println( MENU_ENGIN_20 + " - to make Engin send 20 packages to Hülya which is more than the company can" );
            System.out.println( MENU_HULYA + " - to make Hulya send a mail to Engin" );
            System.out.println( MENU_DELIVER + " - to deliver every order the company has at the moment" );
            System.out.println( MENU_EMPLOYEES + " - to check employees" );
            System.out.println( MENU_CUSTOMERS + " - to check customers" );
            System.out.println( MENU_EXIT + " - to exit" );
            System.out.println();
            selection = scan.nextInt();
            
            // process selection
            if ( selection == MENU_DEL_EMP ) 
            {
                myCompany.terminateContract( 0 );
            }
            else if ( selection == MENU_ENGIN_20 )
            {
                for ( int i = 0; i < 20; i++ )
                newCust2.sendItem( myCompany, item3, newCust1 );
            }
            
            else if ( selection == MENU_HULYA )
            {
                newCust1.sendItem( myCompany, item2, newCust2 );
            }
            
            else if ( selection == MENU_EMPLOYEES ) 
            {
                myCompany.printEmployees();
            }
            
            else if ( selection == MENU_CUSTOMERS ) 
            {
                myCompany.printCustomers();
            }
            
            else if ( selection == MENU_DELIVER )
            {
                myCompany.deliverPackages();
            }
            
        } while ( selection != MENU_EXIT );

        System.out.println( "Thanks for stopping by! See you" );
        scan.close();
    }
    
}