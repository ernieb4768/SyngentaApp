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

    public String[] aatrexCompatible = {"Atrazine", "Bicep II Magnum", "Bicep II Magnum FC",
                    "Bicep Lite II Magnum"};
    public String[] atrazineCompatible = {"Aatrex"};
    public String[] bicepCompatible = {"Bicep II Magnum", "Bicep II Magnum FC", "Bicep Lite II Magnum"};
    public String[] lexarlumaxCompatible = {"Lexar EZ", "Lumax EZ"};
    public String[] tdhtCompatible = {"Touchdown Total"};
    public String[] products = {"Aatrex", "Atrazine", "Bicep II Magnum", "Bicep II Magnum FC", "Bicep" +
            " Lite II Magnum", "Boundary", "Dual II Magnum", "Flexstar GT 3.5", "Halex GT", "Lexar EZ",
            "Lumax EZ", "Prefix", "Princep 4L", "Sequence", "Touchdown HiTech", "Touchdown Total"};

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
     * This method is designed to see if the next product can be loaded on the previous product
     * without the trailer being washed.
     */
    public void checkProductsByName(){

        switch(Arrays.asList(products).indexOf(previousProduct)){

            case 0:
                for(String anAatrexCompatible : aatrexCompatible){
                    if(anAatrexCompatible.equals(nextProduct)){
                        TopLoadMatrix aatrex = new TopLoadMatrix();
                        aatrex.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            case 1:
                for(String anAtrazineCompatible : atrazineCompatible){
                    if(anAtrazineCompatible.equals(nextProduct)){
                        TopLoadMatrix atrazine = new TopLoadMatrix();
                        atrazine.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            case 2:
                for(String aBicepCompatible : bicepCompatible){
                    if(aBicepCompatible.equals(nextProduct)){
                        TopLoadMatrix bicep = new TopLoadMatrix();
                        bicep.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            case 3:
                for(String anotherBicepCompatible : bicepCompatible){
                    if(anotherBicepCompatible.equals(nextProduct)){
                        TopLoadMatrix aBicep = new TopLoadMatrix();
                        aBicep.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            case 4:
                for(String yetAnotherBicepCompatible : bicepCompatible){
                    if(yetAnotherBicepCompatible.equals(nextProduct)){
                        TopLoadMatrix bBicep = new TopLoadMatrix();
                        bBicep.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            case 6:
                for(String aDualCompatible : bicepCompatible){
                    if(aDualCompatible.equals(nextProduct)){
                        TopLoadMatrix dual = new TopLoadMatrix();
                        dual.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            case 9:
                for(String aLexarCompatible : lexarlumaxCompatible){
                    if(aLexarCompatible.equals(nextProduct)){
                        TopLoadMatrix lexar = new TopLoadMatrix();
                        lexar.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            case 10:
                for(String aLumaxCompatible : lexarlumaxCompatible){
                    if(aLumaxCompatible.equals(nextProduct)){
                        TopLoadMatrix lumax = new TopLoadMatrix();
                        lumax.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            case 14:
                for(String aTouchdownCompatible : tdhtCompatible){
                    if(aTouchdownCompatible.equals(nextProduct)){
                        TopLoadMatrix touchdown = new TopLoadMatrix();
                        touchdown.startTrue(previousProduct, nextProduct);
                    }
                }
                break;
            default:
                TopLoadMatrix matrix = new TopLoadMatrix();
                matrix.startFalse(previousProduct, nextProduct);
                break;

        }

    }

}
