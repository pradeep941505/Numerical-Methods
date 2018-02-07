public class s_function
{
  private s_expression function_exp;
  private s_variable_table variables;

  public s_function(String expression)
  {
    function_exp = new s_expression(expression);
    this.variables = this.function_exp.get_variables_table();
  }

  public s_variable_table get_variables_table()
  {
    return variables;
  }

  public Float get_value(s_variable_table table)
  {
    return function_exp.evaluate(table);
  }

  public String get_expression()
  {
    return this.function_exp.get_expression();
  }

  public static s_function add(s_function f1,s_function f2)
  {
    String functional_expression = "("+f1.function_exp.get_expression() + ")+(" + f2.function_exp.get_expression()+")";
    s_function s = new s_function(functional_expression);
    return s;
  }

  public static s_function subtract(s_function f1,s_function f2)
  {
    String functional_expression = "("+f1.function_exp.get_expression() + ")-(" + f2.function_exp.get_expression()+")";
    s_function s = new s_function(functional_expression);
    return s;
  }

  public static s_function multiply(s_function f1,s_function f2)
  {
    String functional_expression = "("+f1.function_exp.get_expression() + ")*(" + f2.function_exp.get_expression()+")";
    s_function s = new s_function(functional_expression);
    return s;
  }

  public static s_function divide(s_function f1,s_function f2)
  {
    String functional_expression = "("+f1.function_exp.get_expression() + ")/(" + f2.function_exp.get_expression()+")";
    s_function s = new s_function(functional_expression);
    return s;
  }
}
