import javax.swing.*;

public class Runner {
    public Runner(){
        VirtualPet p = new VirtualPet();
        p.exercise();
        takeABeat(1000);
        p.feed();
        takeABeat(4000);
        p.exercise();
        String ans = getResponse("How was your day?");
        System.out.println(ans);
    }

    public String getResponse(String q){
        String s = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    q,
                    "Get a Response",
                    JOptionPane.PLAIN_MESSAGE
        );
        return s;
    }

    public void takeABeat(int milliseconds){
        try {//this catches errors. Thread interrupts the process do it doesn't keep running. Like hitting pause in snap.
            Thread.sleep(1000); //milliseconds
        } catch(Exception e){
    }

    }
    public static void main(String[] args) { //you can make the mainmethod anywhere you want. See this.
        new Runner();
    }
}
