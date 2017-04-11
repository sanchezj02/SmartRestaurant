/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartrestaurant;

/**
 *
 * @author Justin Sanchez
 */
public class Dish {
    private String name, description, imagename, price;
    //constructor
    public Dish(String n, String d, String i, String p)
    {
       name = n;
       description = d;
       imagename = i;
       price = p;
    }
    
    //accessors
    public String getname()
    {
        return name;
    }
    public String getdesc()      
    {
        return description;
    }
    public String getimagename()
    {
        return imagename;
    }
    public String getprice()
    {
        return price;
    }
}
