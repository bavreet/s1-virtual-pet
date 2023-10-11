import javax.swing.*;
import java.util.*;

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
                    "Get reponse",
                    JOptionPane.PLAIN_MESSAGE
);

        return s;
    }

    public int getIntResponse(){
        String s = (String)JOptionPane.showInputDialog(
            new JFrame(),
         "How many laps should I run?",
         "Question?",
         JOptionPane.PLAIN_MESSAGE
       );
    int x = Integer.parseInt(s);
    return x;
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
