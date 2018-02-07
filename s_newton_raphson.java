import java.util.Scanner;

public class s_newton_raphson
{
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);
    s_function f,f_,x;
    String temp;
    x = new s_function("x");
    System.out.println("Enter expression for f ");
    temp = reader.nextLine();
    f = new s_function(temp);
    System.out.println("Enter expression for f' : ");
    temp = reader.nextLine();
    f_ = new s_function(temp);
    System.out.println("Enter initial value for x : ");
    Float y = reader.nextFloat();
    s_variable_table table = f.get_variables_table();
    table.add_variable("x",Float.toString(y));

    int iteration = 1;
    float dif = 1.f;
    while(dif!=0f)
    {
      System.out.println("\n-----------------------------------\nIteration : "+iteration+"\n");
      Float f_x,f__x,x_x;
      f_x = f.get_value(table);
      f__x = f_.get_value(table);
      x_x = x.get_value(table);
      System.out.println("x"+iteration+" = "+x_x);
      System.out.println("f"+iteration+" = "+f_x);
      System.out.println("f'"+iteration+" = "+f__x);
      Float ans = x_x - (f_x /f__x );
      System.out.println("x"+Integer.toString(iteration+1)+" = "+ans);
      table.add_variable("x",Float.toString(ans));
      dif = ans - y;
      y = ans;
      iteration++;
    }
    System.out.printf("\nf( %.10f ) = %.10f\n",y,f.get_value(table));

  }
}
