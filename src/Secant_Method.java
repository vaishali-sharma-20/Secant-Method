import java.lang.*;
import java.util.Scanner;

public class Secant_Method
{
   public static float f(float x)
    {
        return (x * x - x - 1);
    }

    public static void main(String[] args) {
        float x0, x1, x2 = 0, f0, f1, f2, e;
        int step = 1, N;
        Scanner read = new Scanner(System.in);
        System.out.println("Enter a, b, e, N");
        x0 = read.nextFloat();
        x1= read.nextFloat();
        e = read.nextFloat();
        N = read.nextInt();

        do
        {
            f0 = f(x0);
            f1 = f(x1);
            if(f0 == f1)
            {
                System.out.println("Mathematical Error.");
                break;
            }

            x2 = x1 - (x1 - x0) * f1/(f1-f0);
            f2 = f(x2);

            System.out.println("Step:\t" + step + "\nx0:\t\t" + x0 + "\nx1:\t\t" + x1 + "\nf0:\t\t" + f0 + "\nf1:\t\t" + f1 + "\n");

            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f2;

            step = step + 1;

            if(step > N)
            {
                System.out.println("Not Convergent.");
                break;
            }
        }while(Math.abs(f2)>e);

        System.out.println("\nRoot is:"+x2);
        }
}
