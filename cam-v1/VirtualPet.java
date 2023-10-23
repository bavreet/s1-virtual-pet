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
            "It's 8am. What would you like to do.",
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
                takeABeat(4000);
                health -= 30;
                check();
            }
        }
        if(choice == 1){
            setMessage("Awesome!");
            takeABeat(4000);
            String userChoice = choices("Where do you want to walk?","local park","Spiderman's house","beach");
            if(userChoice.equals("local park")){
                four(20,5,5,1); // no need to check for any of them at this point because no possiblity
                check();
                setMessage("That was nice!");
                takeABeat(10000);

            }
            if(userChoice.equals("Spiderman's house")){
                    //set image dead and end code here
                    setMessage("You've died of exhaustion");
                    takeABeat(10000);
                    setMessage("Game Over");
                    takeABeat(10000);
                    System.exit(0);
            }
            if(userChoice.equals("beach")){
                four(10,10,10,1); //no need to run if hunger > 40 because no chance
                check();
                setMessage("That was nice!");
                takeABeat(10000);
            }

        }
        if(choice == 2){
            four(0,2,-5,0);
            check();
            setMessage("zzz...");
            takeABeat(10000);
        }

    }

    public void four(int hea, int hun, int tir, int hap){
        health += hea;
        hunger += hun;
        tiredness += tir;
        happiness += hap;
    }


    //checks
    public void healthCheck(){
        if(health <= 0){
            setMessage("You became too healthy!");
            takeABeat(10000);
            setMessage("Game Over");        
            takeABeat(10000);
            System.exit(0);
        }
    }

    public void tirednessCheck(){
        if(tiredness >= 40){
            setMessage("You've died of exhaustion!");
            takeABeat(10000);
            setMessage("Game Over");
            takeABeat(10000);
            System.exit(0);
        }
    }

    public void happinessCheck(){
        if(happiness <= 0){
            setMessage("You've become too unhappy!");
            takeABeat(10000);
            String userChoice = choices("Take a break","Watch TV","Go to the movies","Ignore");
            if(userChoice.equals("Ignore")){
                setMessage("After a long journey, you've lost hope.");
                takeABeat(10000);
                setMessage("Game Over");
                takeABeat(10000);
                System.exit(0);
            } 
            else{
                four(-5,5,-10,10);
                //image here
                setMessage("You feel better now");
                takeABeat(10000);
            }
        }
    }

    public void hungerCheck(){
        if(hunger >= 40){
            setMessage("You have starved!");
            takeABeat(10000);
            setMessage("Game Over");
            takeABeat(10000);
            System.exit(0);
        }
    }
    public void check(){
        hungerCheck();
        happinessCheck();
        healthCheck();
        tirednessCheck();
    }

    public void twelve(){
        Object[] options = {"eat", "play basketball", "Rob a bank"};
        Component frame = null; 
        int choice = JOptionPane.showOptionDialog(frame,
            "It's 12pm. What would you like to do.",
                "Question",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]); 
        if(choice == 0){
            String userChoice = choices("What would you like to eat?","Crushed cherry pits(delicious)","salad","salmon");
            if(userChoice.equals("Crushed cherry pits(delicious)")){
                setMessage("You've died from cyanide poisoning!");
                takeABeat(10000);
                setMessage("Game Over");
                takeABeat(10000);
                System.exit(0);
            }
            if(userChoice.equals("salad")){
                feed();
                takeABeat(10000);
                four(5,0,0,-7);
                check();
            }
            if(userChoice.equals("salmon")){
                feed();
                takeABeat(10000);
                four(10,0,0,0);
                check();
            }
        }
        if(choice == 1){
            setMessage("Awesome!");
            takeABeat(4000);
            String userChoice = choices("How intense?","Pick-up game","Shoot around","Play horse");
            if(userChoice.equals("Pick-up game")){
                setMessage("Wow, this is fun!");
                takeABeat(10000);
                four(10,10,10,5);
                check();

            }
            if(userChoice.equals("Shoot around")){
                    setMessage("This is fun!");
                    takeABeat(10000);
                    four(3,3,3,2);
                    check();
            }
            if(userChoice.equals("Play horse")){
                setMessage("This is fun!");
                takeABeat(10000);
                four(4,4,4,5); 
                check();
            }

        }
        if(choice == 2){
            String userChoice = choices("How do you want to proceed?","March straight in","Mask on and go in","Drop in by helicopter");
            if(userChoice.equals("March straight in")){
                setMessage("You've been caught!");
                takeABeat(10000);
                setMessage("Game Over");
                takeABeat(10000);
                System.exit(0);
            }
            if(userChoice.equals("Mask on and go in")){
                setMessage("You've been caught!");
                takeABeat(10000);
                setMessage("Game Over");
                takeABeat(10000);
                System.exit(0);
                //do the spongebob robbing image
            }
            if(userChoice.equals("Drop in by helicopter")){
                four(0,5,5,-5);
                setMessage("Mission successful!");
                takeABeat(10000);
                check();
                String userchoi = choices("Now that you're rich, would you like to continue?","Totally","Yes","No");
                if(userchoi.equals("No")){
                    setMessage("Cool! You'll be unhealthy, but at least you're rich!");
                    takeABeat(10000);
                    System.exit(0);
                }
                else{
                    setMessage("Great!");
                    takeABeat(10000);
                }
            }
        }

    }

    public void six(){
        Object[] options = {"run", "swim", "go to the gym"};
        Component frame = null; 
        int choice = JOptionPane.showOptionDialog(frame,
            "It's 6pm. What would you like to do.",
                "Question",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]); 
        if(choice == 0){
            String userChoice = choices("Where do you want to run?","Berkeley","San Francisco","Florida");
            if(userChoice.equals("Florida")){
                setMessage("You've died from exhaustion!");
                takeABeat(10000);
                setMessage("Game Over");
                takeABeat(10000);
                System.exit(0);
            }
            else{
                four(10,10,10,2);
                check();
                setMessage("Whew! That was tiring!");
                takeABeat(10000);
            }
        }
        if(choice == 1){
            setMessage("Awesome!");
            takeABeat(4000);
            String userChoice = choices("How much do you want to swim?","1000m","10000m","across the Pacific Ocean");
            if(userChoice.equals("1000m")){
                four(20,5,5,1); // no need to check for any of them at this point because no possiblity
                check();
                setMessage("That was nice!");
                takeABeat(10000);

            }
            if(userChoice.equals("10000m")){
                four(-50,30,30,-5);
                check();
                setMessage("Wow. That was really hard!");
                takeABeat(10000);
                setMessage("Game Over");
                takeABeat(10000);
                System.exit(0);
            }
            if(userChoice.equals("across the Pacific Ocean")){
                setMessage("You've died from exhaustion!");
                takeABeat(10000);
                setMessage("Game Over");
                takeABeat(10000);
                System.exit(0);
            }

        }
        if(choice == 2){
            String userChoice = choices("What would you like to do at the gym?","Cardio","Upper body","Lower body");
            if(userChoice.equals("Cardio")){
                four(10,10,10,-5); // no need to check for any of them at this point because no possiblity
                setMessage("Whew!");
                check();
                takeABeat(10000);

            }
            if(userChoice.equals("Upper body")){
                four(5,5,5,10);
                setMessage("I feel stronger already!");
                check();
                takeABeat(10000);
            }
            if(userChoice.equals("Lower body")){
                four(5,5,5,-5);
                check();
                setMessage("I feel stronger already!");
                takeABeat(10000);
            }
        }

    }

    public void ten(){
        Object[] options = {"Sleep", "Pull an all nighter for your chemistry test"};
        Component frame = null; 
        int choice = JOptionPane.showOptionDialog(frame,
            "It's 10pm. What would you like to do.",
                "Question",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]); 
        if(choice == 0){
                setMessage("Congratulations!");
                takeABeat(10000);
                setMessage("You've completed the game.");
                takeABeat(10000);
                System.exit(0);
        }
        else{
           four(-30,10,20,-10); 
           check();
           setMessage("You've managed to maintain a healthy lifestyle while getting good grades. Good job.");
           takeABeat(10000);
           System.exit(0);
        }
    }




//hunger for every related method
//tiredness for every related method
//happiness for every related method. maybe.
//health
//method for death and images
//should have methods that check for hunger, tiredness, health, and happiness. Run them whenever it's possibile they cross a certian threshold
//set images
} // end Virtual Pet
