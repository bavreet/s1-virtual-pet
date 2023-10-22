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
    private int hunger = 15;   // how hungry the pet is.
    private int tiredness = 5;
    private int health = 100;
    private int happiness = 10;
    
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

    public void setMessage(String x){
        face.setMessage(x);
    }

    public void walk(){
        //images here
    }



    // }

    public String choices(String a, String o1, String o2, String o3){
        Object[] options = {o1, o2, o3};
        Component frame = null; // You can set the parent frame to null if not needed.
        int choice = JOptionPane.showOptionDialog(frame,
                a,
                "Question",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]); 
        return options[choice].toString();
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

    public void eight(){
        Object[] options = {"eat", "go for a walk", "continue sleeping"};
        Component frame = null; 
        int choice = JOptionPane.showOptionDialog(frame,
            "It's 8:00am. What would you like to do.",
                "Question",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]); 
        if(choice == 0){
            if(choices("What would you like to eat?","ice cream","cake","eggs").equals("eggs")){
                feed();
            }
            else{
                feed();
                setMessage("Yum!");
                takeABeat(4000);
                health -= 30;
                //don't need to check if health is 0 bc no possibility here
            }
        }
        if(choice == 1){
            setMessage("Awesome!");
            takeABeat(4000);
            String userChoice = choices("Where do you want to walk?","local park","Spiderman's house","");
            if(userChoice.equals("local park")){
                //walk method
                four(20,5,5,1); // no need to check for any of them at this point because no possiblity

            }
            if(userChoice.equals("Spiderman's house")){
                    //set image dead and end code here
                    setMessage("You've died of exhaustion");
                    takeABeat(10000);
                    System.exit(0);
            }
            if(userChoice.equals("beach")){
                four(10,10,10,1); //no need to run if hunger > 40 because no chance
            }

        }
        if(choice == 2){
            four(0,2,-5,0);
            System.out.println(tiredness);
        }

    }

    public void four(int hea, int hun, int tir, int hap){
        health += hea;
        hunger += hun;
        tiredness += tir;
        happiness += hap;
    }


//hunger for every related method
//tiredness for every related method
//happiness for every related method. maybe.
//health
// if(health == 0){
//                     //set image dead and end code here
//                     takeABeat(10000);
//                     System.exit(0);
//                 } useful later
//should have methods that check for hunger, tiredness, health, and happiness. Run them whenever it's possibile they cross a certian threshold
//should make a method that adjusts all instead of writing hunger += 1, tiredness... all the time
} // end Virtual Pet
