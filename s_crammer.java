import java.util.*;

public class s_crammer
{
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);
    int n;
    System.out.print("Enter number of variables in equations : ");
    n = reader.nextInt();
    s_matrix coefficients = new s_matrix(n,n);
    s_matrix right_side = new s_matrix(n,1);
    System.out.println("Enter values for coefficient matrix.");
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        System.out.print("("+Integer.toString(i+1)+" , "+Integer.toString(j+1)+" ) = ");
        Float temp  = reader.nextFloat();
        coefficients.set(i,j,temp);
      }
    }
    coefficients.print();
    System.out.println("Enter values for rith side matrix.");
    for(int i=0;i<n;i++)
    {
      System.out.print("("+Integer.toString(i+1)+" , 1 ) = ");
      Float temp  = reader.nextFloat();
      right_side.set(i,0,temp);
    }
    right_side.print();
    Float[] determinants = new Float[n];
    for(int i=0;i<n;i++)
    {
      s_matrix temp = new s_matrix();
      temp.copy(coefficients);
      for(int j=0;j<n;j++)
      {
        temp.set(j,i,right_side.get(j,0));
      }
      System.out.printf("\nD%d is ",i+1);
      temp.print();
      determinants[i] = s_matrix.determinant(temp);
      System.out.printf("\n| D%d | = %.5f",i+1,determinants[i]);
    }

    Float det = s_matrix.determinant(coefficients);

    System.out.println("\n-----------------------------------------------\n");
    for(int i=0;i<n;i++)
    {
      System.out.printf("y%d = %.8f\n",i+1,determinants[i]/det);
    }
    System.out.println("\n-----------------------------------------------\n");
    System.out.println();
  }
}
