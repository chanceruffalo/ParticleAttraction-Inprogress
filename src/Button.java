public class Button {

    public float x,y,w,h;
    public String text;

    public Button(String text,float x, float y,float w, float h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.text = text;
    }
    public Button(String text){
        x = -10;
        y = -10;
        w = 10;
        h = 10;
        this.text = text;
    }

    public void display(){
        Main.processing.fill(255,255,255);
        Main.processing.rect(x,y,h,w);
        Main.processing.fill(0,0,0);
        Main.processing.textSize(20);
        Main.processing.text(text,(w/2)+(x-5),(h/2)+y+5);
    }

    public boolean clicked(float mx, float my){
        if(mx > x && mx < x + w && my > y && my < my + h){
            return true;
        }
        return false;

    }
}
