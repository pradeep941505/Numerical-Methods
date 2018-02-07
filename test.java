import java.util.Scanner; 
public class test
{
  public static void main(String[] args)
  {
    s_matrix x = new s_matrix(4,4);
    Scanner reader = new Scanner(System.in);  // Reading from System.in
    float count=0f;
    for(int i=0;i<4;i++)
    {
      for(int j=0;j<4;j++,count = count + 1f)
      {
        System.out.println("\nEnter number : ");
        float f = reader.nextFloat();
        x.set(i,j,f);
      }
    }
    x.print();
    float f = s_matrix.determinant(x);
    System.out.println("\nDeterminant is : "+f);
  }
}
