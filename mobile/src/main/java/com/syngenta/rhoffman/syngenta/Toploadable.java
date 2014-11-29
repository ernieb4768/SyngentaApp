package com.syngenta.rhoffman.syngenta;


public class Toploadable{

    public String[] aatrexCompatible = {"Atrazine", "Bicep II Magnum", "Bicep II Magnum FC",
                    "Bicep Lite II Magnum"};
    public String[] atrazineCompatible = {"Aatrex"};
    public String[] bicepCompatible = {"Bicep II Magnum", "Bicep II Magnum FC", "Bicep Lite II Magnum"};
    public String[] lexarlumaxCompatible = {"Lexar EZ", "Lumax EZ"};
    public String[] tdhtCompatible = {"Touchdown Total"};
    public String[] products = {"Aatrex", "Atrazine", "Bicep II Magnum", "Bicep II Magnum FC", "Bicep" +
            " Lite II Magnum", "Boundary", "Dual II Magnum", "Flexstar GT 3.5", "Halex GT", "Lexar EZ",
            "Lumax EZ", "Prefix", "Princep 4L", "Sequence", "Touchdown HiTech", "Touchdown Total"};

    public void getProductName(int previousProductInt, int nextProductInt){

        String previousProductString;
        String nextProductString;

        switch(nextProductInt){
            case 0:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            case 1:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            case 2:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            case 3:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            case 4:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            case 6:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            case 9:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            case 10:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            case 14:
                previousProductString = products[previousProductInt];
                nextProductString = products[nextProductInt];
                checkProductsByName(previousProductInt, previousProductString, nextProductString);
                break;
            default:
                break;
        }

    }

    public void checkProductsByName(int a, String previous, String next){

        switch(a){
            case 0:
                for(String anAatrexCompatible : aatrexCompatible){
                    if(anAatrexCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            case 1:
                for(String anAtrazineCompatible : atrazineCompatible){
                    if(anAtrazineCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            case 2:
                for(String aBicepCompatible : bicepCompatible){
                    if(aBicepCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            case 3:
                for(String aBicepCompatible : bicepCompatible){
                    if(aBicepCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            case 4:
                for(String aBicepCompatible : bicepCompatible){
                    if(aBicepCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            case 6:
                for(String aBicepCompatible : bicepCompatible){
                    if(aBicepCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            case 9:
                for(String aLexarCompatible : lexarlumaxCompatible){
                    if(aLexarCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            case 10:
                for(String aLumaxCompatible : lexarlumaxCompatible){
                    if(aLumaxCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            case 14:
                for(String aTouchdownCompatible : tdhtCompatible){
                    if(aTouchdownCompatible.equals(previous)){
                        TopLoadMatrix matrix = new TopLoadMatrix();
                        matrix.startTrue(previous, next);
                    }
                }
                break;
            }
        TopLoadMatrix falseMatrix = new TopLoadMatrix();
        falseMatrix.startFalse(previous, next);
    }

}
