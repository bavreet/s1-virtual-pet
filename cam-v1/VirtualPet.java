/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */
import java.awt.Component;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class VirtualPet {
    
    VirtualPetFace face;
    private int hunger = 0;   // how hungry the pet is.
    private int tiredness = 0;
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
    }
    

    public void feed() {
        if (hunger > 10) {
            hunger = hunger - 10;
        } else {
            hunger = 0;
        }
        face.setMessage("Yum, thanks");
        face.setImage("normal");
    }
    
    public void exercise() {
        hunger = hunger + 3;
        face.setMessage("1, 2, 3, jump.  Whew.");
        face.setImage("tired");

        if(tiredness < 4){
            face.setMessage("That was great");
            face.setImage("ecstatic");
        }
    }
    
    public void sleep() {
        hunger = hunger + 1;
        face.setImage("asleep");
    }

    // public void eat(String x){
    //     String ans = getResponse("What do you want to eat?");


    // }
    public void eat() {
        Object[] options = {"Banana", "Burger", "Ice Cream"};
        Component frame = null; // You can set the parent frame to null if not needed.
        int choice = JOptionPane.showOptionDialog(frame,
                "What do you want to eat?",
                "Question",
                JOptionPane.DEFAULT_OPTION, // Just a single option.
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]); // Default selection is the first option (Banana).
    
        if (choice != JOptionPane.CLOSED_OPTION) {
            String selectedOption = (String) options[choice];
            System.out.println("You chose: " + selectedOption);
            // You can do something with the selected option here.
        }
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


    public void start(){
        face.setMessage("Hello, this is a fitness based game");
        takeABeat(1000);
        String a = getResponse("Would you like to continue?");
        while(!a.equals("Yes")&&!a.equals("yes")){
            a = getResponse("Would you like to continue?");
        }
    }

    public void takeABeat(int milliseconds){
        try {//this catches errors. Thread interrupts the process do it doesn't keep running. Like hitting pause in snap.
            Thread.sleep(1000); //milliseconds
        } catch(Exception e){
        }
    }



} // end Virtual Pet
