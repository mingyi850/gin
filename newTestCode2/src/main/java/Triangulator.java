
import static java.lang.Thread.sleep;

public class Triangulator {
    private String name;
    private int x;
    private int y;
    private int z;

    public Triangulator (String name, int x, int y , int z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    


    public int findTriangleType() throws InterruptedException {
        int[] sidesArray = new int[3];
        sidesArray[0] = this.x;
        sidesArray[1] = this.y;
        sidesArray[2] = this.z;
        if (x == y & y == z) { //equilateral
            System.out.println("Triangle " + this.name + " is equilateral");
            return 1;
        }

        for (int start = 0; start < sidesArray.length; start++) {
            sleep(100);
            if ((sidesArray[start] == sidesArray[(start + 1) % 2]) & (sidesArray[(start + 1) % 2] != sidesArray[(start + 2)%2 ])) { //isoceles
                System.out.println("Triangle " + this.name + " is isoceles");
                return 3;
            }

        }
        System.out.println("Triangle " + this.name + " weird");
        return 2;
    }

    public static void main(String args[]) throws InterruptedException{
        Triangulator t1 = new Triangulator("t1", 1, 2, 3);
        Triangulator t2 = new Triangulator("t2", 6, 6, 6);
        Triangulator t3 = new Triangulator("t3", 1, 2, 2);
        Triangulator t4 = new Triangulator("t4", 1, 2, 123);
        t1.findTriangleType();
        t2.findTriangleType();
        t3.findTriangleType();
        t4.findTriangleType();
    }



}
