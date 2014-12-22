package com.syngenta.rhoffman.syngenta;

import java.util.Arrays;
/**
 * To determine if a product can be top loaded on another product without the trailer being washed.
 */

public class Toploadable{

    /**
     * A series of String arrays, one for each product that can have other products top loaded on
     * them.
     *
     * Each array will be named for the product that was previously contained in the trailer. It
     * will contain a list of each product that can be loaded on the previous product without the
     * trailer being washed.
     */

    //public String[] aatrexCompatible = {"Atrazine", "Bicep II Magnum", "Bicep II Magnum FC",
      //              "Bicep Lite II Magnum"};
    //public String[] atrazineCompatible = {"Aatrex"};
    //public String[] bicepCompatible = {"Bicep II Magnum", "Bicep II Magnum FC", "Bicep Lite II Magnum"};
    //public String[] lexarlumaxCompatible = {"Lexar EZ", "Lumax EZ"};
    //public String[] tdhtCompatible = {"Touchdown Total"};
    //public String[] products = {"Aatrex", "Atrazine", "Bicep II Magnum", "Bicep II Magnum FC",
      //      "Bicep Lite II Magnum", "Boundary", "Dual II Magnum", "Flexstar GT 3.5", "Halex GT",
      //      "Lexar EZ", "Lumax EZ", "Prefix", "Princep 4L", "Sequence", "Touchdown HiTech",
      //      "Touchdown Total"};
    public final String aatrex = "Aatrex";
    public final String atrazine = "Atrazine";
    public final String bicep = "Bicep II Magnum";
    public final String bicepFC = "Bicep II Magnum FC";
    public final String bicepLite = "Bicep Lite II Magnum";
    public final String lexar = "Lexar EZ";
    public final String lumax = "Lumax EZ";
    public final String tdht = "Touchdown HiTech";
    public final String touchdown = "Touchdown Total";

    public String previousProduct;
    public String nextProduct;

    /**
     * Constructor method to define the necessary parameters when initializing a new Toploadable object.
     * It takes two Strings as inputs, one representing the first product, and one representing the
     * next one.
     */

    public Toploadable(String first, String last){

        previousProduct = first;
        nextProduct = last;

    }


    /**
     * A very confusing series of if statements that determines whether the products are compatible
     * or not.
     */
    public boolean checkProductsByName(){
        if(previousProduct.equals(aatrex) && (nextProduct.equals(atrazine) || nextProduct.equals(bicep) ||
        nextProduct.equals(bicepFC) || nextProduct.equals(bicepLite))){
            return true;
        } else if(previousProduct.equals(atrazine) && nextProduct.equals(aatrex)){
            return true;
        } else if(previousProduct.equals(bicep) && (nextProduct.equals(bicepFC) ||
        nextProduct.equals(bicepLite))){
            return true;
        } else if(previousProduct.equals(bicepFC) && (nextProduct.equals(bicep) ||
        nextProduct.equals(bicepLite))){
            return true;
        } else if(previousProduct.equals(bicepLite) && (nextProduct.equals(bicep) ||
        nextProduct.equals(bicepFC))){
            return true;
        } else if(previousProduct.equals(lexar) && nextProduct.equals(lumax)){
            return true;
        } else if(previousProduct.equals(lumax) && nextProduct.equals(lexar)){
            return true;
        } else if(previousProduct.equals(tdht) && nextProduct.equals(touchdown)){
            return true;
        }
        return false;
    }

}
