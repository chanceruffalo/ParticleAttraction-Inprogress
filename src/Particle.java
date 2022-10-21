public class Particle {
float x,y,vx,vy;
int group;

    public Particle(float x,float y, int group){
        this.x = x;
        this.y = y;
        this.group = group;
        vx = 0;
        vy = 0;
    }

    public void display(){
        if(group == 1){
            Main.processing.fill(250,0,0);
        }
        else if(group == 2){
            Main.processing.fill(0,250,0);
        }
        else if(group == 3){
            Main.processing.fill(0,0,250);
        }
        else if(group == 4){
            Main.processing.fill(250,250,250);
        }
        Main.processing.ellipse(x,y,3,3);
    }
}
