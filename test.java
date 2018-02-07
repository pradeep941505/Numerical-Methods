import java.util.Scanner;
public class test
{
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);  // Reading from System.in
    System.out.println("Enter size ");
    int rows = reader.nextInt();
    int cols = reader.nextInt();
    s_matrix x = new s_matrix(rows,cols);

    float count=0f;
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<cols;j++,count = count + 1f)
      {
        System.out.println("\nEnter number : ");
        float f = reader.nextFloat();
        x.set(i,j,f);
      }
    }
    x.print();
    System.out.println("Enter size ");
    rows = reader.nextInt();
    cols = reader.nextInt();
    s_matrix y = new s_matrix(rows,cols);

    count=0f;
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<cols;j++,count = count + 1f)
      {
        System.out.println("\nEnter number : ");
        float f = reader.nextFloat();
        y.set(i,j,f);
      }
    }
    y.print();
    x.print();
    s_matrix.multiply(x,y).print();
  }
}
