package OopDesign;

public class Coin {
    private String flipOption = "";

    public Coin(){
        int randNum = (Math.random()%2<1)?0:1;
        if (randNum<1){
            flipOption ="Head";
        }else {
            flipOption = "Tail";
        }
    }

    public String getFlipOption(){
        return flipOption;
    }
    
}
