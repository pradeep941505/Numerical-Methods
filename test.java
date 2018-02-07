import java.util.Scanner;
public class test
{
  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);  // Reading from System.in
    System.out.println("Enter size ");
    String exp = reader.nextLine();
    // System.out.println("Enter variable name : ");
    // String var = reader.next();
    // System.out.println("Enter value to be replaced : ");
    // float val = reader.nextFloat();
    s_expression e = new s_expression(exp);
    s_variable_table variables = e.get_variables_table();
    variables.print();
    System.out.println("Before replacing "+e.get_expression());
    // e.replace(var,val);
    while(true)
    {
      for(int i=0;i<variables.count;i++)
      {
        System.out.println("Give value for  : "+variables.var_names.get(i));
        float f = reader.nextFloat();
        variables.add_variable(variables.var_names.get(i),Float.toString(f));
      }
      variables.print();
      System.out.println("Answer "+e.evaluate(variables)); 
    }
  }
}
