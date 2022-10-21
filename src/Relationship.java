public class Relationship {
    public float weight,x,y;
    public Group g2,g1;
    public  Button positive, negative;
    public  String name;

    public Relationship(float weight,Group g1, Group g2, String name){
        this.weight = weight;
        this.g2 = g2;
        this.g1 = g1;
        this.name = name;
        positive = new Button("+");
        negative = new Button("-");
    }

    public void rule( float DTuner, float ATuner){
        //loop forces for each particle
        for(int i = 0; i < g1.population; i ++) {

            float fx = 0;
            float fy = 0;
            Particle a =  g1.points.get(i);

            for (int j = 0; j < g2.population; j++) {
                Particle b = g2.points.get(j);
                //calculate distance
                float dx = a.x - b.x;
                float dy = a.y - b.y;
                //Pythagorean theorem
                float d = (float) Math.sqrt(dx * dx + dy * dy);
                //if there is distance find forces
                //fine tune max d value
                if (d > 0 & d < DTuner) {
                    float F = weight * 1 / d;
                    fx += (F * dx);
                    fy += (F * dy);
                }
            }
            //After finding all forces applied to this particle update...
            //calulate acceleration and find new x and y
            // fine tune how fast accleration
            a.vx = (float) ((a.vx + fx)*ATuner);
            a.vy = (float) ((a.vy + fy)*ATuner);

            if(a.x <= Main.particleXMin) {
                a.vx = Math.abs(a.vx);
            }

            if(a.x >= Main.processing.displayWidth){
                a.vx = Math.abs(a.vx)*(-1);
            }
            if(a.y <=0){
                a.vy = Math.abs(a.vy);
            }
            if(a.y >= Main.processing.displayHeight){
                a.vy = Math.abs(a.vy)*(-1);
            }
            a.x += a.vx;
            a.y += a.vy;

        }

    }

    public void intinfo(float x,float y){
        positive.x = x;
        positive.y = y-5;
        negative.x = x+40;
        negative.y = y-5;
        this.x = x + 100;
        this.y = y;
    }

    public void display(){
        positive.display();
        negative.display();
        Main.processing.fill(255,255,255);
        Main.processing.textSize(20);
        Main.processing.text(name + " : " + weight,x,y);
    }

    public boolean checkClick(float mouseX, float mouseY){
        if(negative.clicked(mouseX,mouseY)){
            this.weight -= Main.mag;
            return true;
        }
        else if(positive.clicked(mouseX,mouseY)){
            this.weight += Main.mag;
            return true;
        }
        return false;
    }

}
