public class test
{
  public static void main(String[] args)
  {
    s_matrix x = new s_matrix(4,4);
    float count=0f;
    for(int i=0;i<4;i++)
    {
      for(int j=0;j<4;j++,count = count + 1f)
        x.set(i,j,count);
    }
    x.print();
    x = x.transpose();
    x.print();
  }
}
