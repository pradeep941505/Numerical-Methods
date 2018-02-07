import java.util.*;

public class s_convergence
{
  public static void main(String[] args)
  {
    s_function f;
    String exp;
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter expression of the function : ");
    exp = reader.nextLine();
    f = new s_function(exp);
    Float value;
    System.out.print("Enter value of f for wich x has to be calculated : ");
    value = reader.nextFloat();
    Float x = 1f;
    s_variable_table table = f.get_variables_table();
    table.add_variable("x",Float.toString(1f));
    Float diff = f.get_value(table) - value;
    System.out.println("\nInitial difference is "+diff);
    int iteration = 1;
    float ans=value;
    while(diff != 0f)
    {
      try
      {
        x = x-((diff/100f)*x);
        ans = f.get_value(table);
        table.add_variable("x",Float.toString(x));
        diff = f.get_value(table)-value;
      }
      catch(Exception e)
      {
        break;
      }
      //System.out.printf("\nIteration%d , f = %.6f, x = %.6f\n",iteration,f.get_value(table),x);
    //  System.out.printf("diff = %.9f",diff);
      //reader.nextLine();
      iteration++;
      if(iteration == 200)
        break;
    }
    System.out.printf("\nf(%.9f) = %.9f\n",x,ans);
  }
}
