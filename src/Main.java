import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet{
    public static PApplet processing;
    public static ArrayList<Particle> particles;
    public static ArrayList<Group> groups;
    public Group red,green,blue,white;
    public static float particleXMin,GUIXMin,GUIYMin,mag;


    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    public void settings() {
        fullScreen();
        //size(displayWidth,displayHeight);
    }

    public void setup() {
        processing = this;
        particleXMin = (float) ((float)displayWidth * .40);
        GUIXMin =  (float) ((float)displayWidth * .05);
        GUIYMin =  (float) ((float)displayHeight * .1);
        mag = (float).1;
        particles = new ArrayList<Particle>();
        groups = new ArrayList<Group>();
        green = new Group("Green",1000,2,140,(float).332);
        blue = new Group("Blue",1000,3,130,(float).332);
        red = new Group("Red",1000,1,100,(float).332);
        white = new Group("White",1000,4,60,(float).332);

        green.addRule(green,(float).4,"Green : Green");
        green.addRule(red,(float)-.5,"Green : Red");
        green.addRule(blue,(float)-.4,"Green : Blue");
        green.addRule(white,(float)-.6,"Green : White");

        red.addRule(red,(float).1,"Red : Red");
        red.addRule(green,(float).5,"Red : Green");
        red.addRule(white,(float)-.2,"Red : White");
        red.addRule(blue,(float)-.2,"Red : Blue");

        blue.addRule(blue,(float).1,"Blue : Blue");
        blue.addRule(white,(float)-.1,"Blue : White");
        blue.addRule(red,(float).2,"Blue : Red");
        blue.addRule(green,(float).4,"Blue : Green");

        white.addRule(white,(float).1,"White : White");
        white.addRule(green,(float).5,"White : Green");
        white.addRule(blue,(float)-.2,"White : Blue");
        white.addRule(red,(float)-.2,"White : Red");

        groups.add(green);
        groups.add(blue);
        groups.add(red);
        groups.add(white);
        intInfo();
    }

    public void intInfo(){
        float y = 50;
        textSize(25);
        fill(255,255,255);
        for(Group temp:groups){
            for(Relationship rule: temp.rules){
                rule.intinfo(100,y);
                y += 30;
            }
            y+=50;
        }
    }


    public void mousePressed(){
        boolean clicked = false;
        for(Group temp: groups){

            for(Relationship r: temp.rules){
                clicked = r.checkClick(mouseX,mouseY);
            }
            if(clicked){
                break;
            }
        }
    }

    public void draw() {
        background(0000);
        runParticles();
        displayInformation();
    }

    public void displayInformation(){
        for(Group temp:groups){
            for(Relationship rule: temp.rules){
                rule.display();
            }
        }
    }

    public void runParticles(){
        red.display();
        green.display();
        blue.display();
        white.display();
    }

    //g1 and g2 = particles1 and particles 2



}