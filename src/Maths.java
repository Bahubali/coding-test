/**
 * Created by bahubali.n on 19/02/17.
 */
public class Maths {

    public int max(int x, int y) {
        return  (x > y)? x : y;
    }

    /**
     * Need to be careful on return type in method overloading
     *
     * @param x
     * @param y
     */
    public void max(double x, int y) {
        System.out.println(((x > y)? x : y));
    }

    public static void main(String[] args) throws Exception{
        Maths maths = new Maths();
        maths.max(5.9, 5);
    }
}
