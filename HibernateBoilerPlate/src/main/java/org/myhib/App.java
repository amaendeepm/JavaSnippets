package org.myhib;

import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibUtils.getSessionFactory().openSession();
        session.close();
    }
}
