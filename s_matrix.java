public class s_matrix
{
  private int rows,columns;   // can be set only during construction
  private Float[][] elements;

  public s_matrix()
  {
    this.rows = this.columns = 0;
  }

  public s_matrix (int rows,int columns)
  {
    this.rows = rows;
    this.columns = columns;
    if(this.rows < 0)
      this.rows = 0;
    if(this.columns < 0)
      this.columns = 0;
    elements = new Float[rows][columns];
  }

  public void copy(s_matrix  arr)
  {
    this.elements = new Float[arr.get_rows()][arr.get_columns()];
    this.rows = arr.get_rows();
    this.columns = arr.get_columns();
    for(int i=0;i<arr.get_rows();i++)
    {
      for(int j=0;j<arr.get_columns();j++)
        this.elements[i][j] = arr.get(i,j);
    }
  }

  public void copy(float[][] arr,int rows,int columns)
  {
    if(this.rows != rows || this.columns != columns)
    {
      System.out.println("Number of rows and columns are not matching for copying.");
      return;
    }
    /*
      now copying
    */
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<columns;j++)
        this.elements[i][j] = arr[i][j];
    }
  }

  public void set(int pos_x,int pos_y,float val)
  {
    if( pos_x >= 0 && pos_x < rows && pos_y >=0 && pos_y < columns)
    {
      this.elements[pos_x][pos_y] = val;
    }
    else
    {
        System.out.print("Invalid position." + pos_x);
        System.out.println(" "+pos_y);
    }
  }

  public float get(int pos_x,int pos_y)
  {
    if( pos_x >= 0 && pos_x < rows && pos_y >=0 && pos_y < columns)
    {
      return this.elements[pos_x][pos_y];
    }
    else
      System.out.println("Invalid position.");
    return 0f;
  }

  public int get_rows()
  {
    return this.rows;
  }

  public int get_columns()
  {
    return this.columns;
  }

  public void print()
  {
    System.out.println("\n------------------------------------------------------");
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<columns;j++)
        System.out.print(elements[i][j]+" ");
      System.out.println();
    }
    System.out.println("-------------------------------------------------------");
  }

  public s_matrix  transpose()
  {
    s_matrix  temp = new s_matrix (this.columns,this.rows);
    for(int i=0;i<this.rows;i++)
    {
      for(int j=0;j<this.columns;j++)
        temp.set(j,i,this.elements[i][j]);
    }
    return temp;
  }

  public void multiply(float val)
  {
    for(int i=0;i<get_rows();i++)
    {
      for(int j=0;j<get_columns();j++)
      {
        set(i,j,this.get(i,j)*val);
      }
    }
  }

  public void remove_row(int row_index)
  {
    s_matrix  upper_part = this.get_sub_matrix(0,row_index-1,0,this.columns-1);
    s_matrix  lower_part = this.get_sub_matrix(row_index+1,this.rows-1,0,this.columns-1);
    this.concat_vertical(upper_part,lower_part);
  }

  public void remove_column(int column_index)
  {
    s_matrix  left_part = this.get_sub_matrix(0,this.get_rows()-1,0,column_index-1);
    s_matrix  right_part = this.get_sub_matrix(0,this.get_rows()-1,column_index+1,this.get_columns()-1);
    this.concat_horizontal(left_part,right_part);
  }

  public s_matrix  get_sub_matrix(int start_row,int end_row,int start_col,int end_col)
  {
    if(!(start_row >=0 && start_row < this.rows && end_row >=0 && end_row < this.rows && start_col >=0 && start_col < this.columns
        && end_col >=0 && end_col <this.columns && start_row <= end_row && start_col <= end_col))
    {
      //System.out.print("Invalid sub matrix boundaries.");
      return new s_matrix (0,0);
    }

  //  System.out.println("Getting matrix from rows "+Integer.toString(start_row)+" "+Integer.toString(end_row));
  //  System.out.println("Getting matrix from cols "+Integer.toString(start_col)+" "+Integer.toString(end_col));

    s_matrix  temp = new s_matrix (end_row-start_row+1,end_col-start_col+1);
    for(int i=start_row;i<=end_row;i++)
    {
      for(int j=start_col;j<=end_col;j++)
        temp.set(i-start_row,j-start_col,this.elements[i][j]);
    }
    return temp;
  }

  public void concat_horizontal(s_matrix  mat1,s_matrix  mat2)
  {
    if( mat1.get_rows() != mat2.get_rows())
    {
    //  System.out.println("Rows should be same for horizontal concatination.");
      if(mat1.get_rows() <=0 )
      {
        this.copy(mat2);
      }
      else
        this.copy(mat1);
      return;
    }
    s_matrix  temp = new s_matrix (mat1.get_rows(),mat1.get_columns()+mat2.get_columns());
    for(int i=0;i<mat1.get_rows();i++)
    {
      for(int j=0;j<mat1.get_columns();j++)
        temp.set(i,j,mat1.get(i,j));
      for(int j=0;j<mat2.get_columns();j++)
        temp.set(i,j+mat1.get_columns(),mat2.get(i,j));
    }
    this.copy(temp);
  }

  public void concat_vertical(s_matrix  mat1,s_matrix  mat2)
  {
    if( mat1.get_columns() != mat2.get_columns())
    {
      //  System.out.println("Columns should be same for vertical concatination.");
        if(mat1.get_columns() <= 0)
        {
          this.copy(mat2);
        }
        else
          this.copy(mat1);
        return;
    }
    s_matrix  temp = new s_matrix (mat1.get_rows()+mat2.get_rows(),mat2.get_columns());
    for(int i=0;i<mat1.get_columns();i++)
    {
      for(int j=0;j<mat1.get_rows();j++)
        temp.set(j,i,mat1.get(j,i));
      for(int j=0;j<mat2.get_rows();j++)
        temp.set(j+mat1.get_rows(),i,mat2.get(j,i));
    }
    this.copy(temp);
  }

  public static Float determinant(s_matrix m)
  {
    if(m.get_rows() == 2)
    {
      return m.get(0,0) * m.get(1,1) - m.get(1,0)*m.get(0,1);
    }
    s_matrix sub_mat = new s_matrix();
    sub_mat.copy(m);
    sub_mat.remove_row(0);
    Float det= 0f;
    for(int i=0;i<m.get_columns();i++)
    {
      s_matrix temp = new s_matrix();
      temp.copy(sub_mat);
      temp.remove_column(i);
      Float ans = m.get(0,i) * s_matrix.determinant(temp);
      if(i%2!=0)
        ans *= -1f;
      det += ans;
    }
    return det;
  }

}
