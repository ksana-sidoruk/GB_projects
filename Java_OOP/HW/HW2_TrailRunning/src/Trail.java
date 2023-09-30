import java.util.ArrayList;
import java.util.Random;
public class Trail extends Obstacle{
    protected int length;
//    protected static Random r;
    protected String[] names = {
            "тропинке",
            "звериной тропе",
            "бездорожью",
            "наезженной колее"};

    public Trail(){
        super.name = names[Trail.r.nextInt(0, 3)];
        this.length = Trail.r.nextInt(10, 850);
    }

    public int getLength() {
        return length;
    }
    protected void setLength(int length) {
        this.length = length;
    }
}
