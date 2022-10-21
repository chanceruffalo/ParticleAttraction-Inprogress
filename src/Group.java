import java.util.ArrayList;

public class Group {
    public ArrayList<Particle> points;
    public ArrayList<Relationship> rules;
    int population;
    float maxX,minX,minY,maxY,DTuner,ATuner;

    public Group(String name,int population, int group,float DTuner,float ATuner){
        this.population = population;
        this.DTuner = DTuner;
        this.ATuner = ATuner;
        maxX = (float) (Main.processing.displayWidth-70);
        minX = Main.particleXMin;
        maxY = (float)(Main.processing.displayHeight-70);
        minY = 70;

        rules = new ArrayList<Relationship>();
        points = new ArrayList<Particle>();

        for(int i = 0; i < population; i ++){
            float ranX = minX + (float)Math.random()*(maxX - minX);
            float ranY = minY + (float)Math.random()*(maxY - minY);
            Particle temp = new Particle(ranX,ranY,group);
            points.add(temp);
            Main.particles.add(temp);
        }
    }

    public void addRule(Group g2, float weight, String name){
        Relationship temp;
        temp = new Relationship(weight,this, g2,name);
        rules.add(temp);
    }

    public void display(){
        for(Relationship r: rules){
            r.rule(DTuner, ATuner);
        }
        for(Particle part: points){
            part.display();
        }
    }






}
