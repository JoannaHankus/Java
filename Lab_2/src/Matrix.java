public class Matrix {

 //private double[][] m;
 private int rows, cols;
 double[] data;
 int row_len,max;
Matrix (int rows, int cols){
    this.rows = rows;
    this.cols = cols;
    data = new double[rows*cols];
}
 public Matrix(double[][] d)
 {
     for (int i =0; i<d.length; i++){
             row_len = d[i].length;
             if (row_len > max)
                 max = row_len;
         }

     this.rows = d.length;
     this.cols = max;

     data = new double [rows*cols];

     for (int i = 0; i <rows; i++){
         for (int j = 0; j<cols; j++){
             if (j>d[i].length-1)
             {
                 data[i*cols + j] = 0;
             }
             else
                 data[i*cols + j] = d[i][j];

         }
     }
 }
 double [][] asArray()
 {
    double[][]arr = new double[rows][cols];
    for (int i=0; i<rows; i++)
    {
        for (int j=0; j<cols;j++)
        {
            arr[i][j] = data[i*cols +j];
        }
    }
    return arr;
 }
    double get(int r, int c){return data[r*cols + c];}
    int getRows(){return rows;}
    int getCols(){return cols;}
    void set(int r, int c, double value){data[r*cols + c] = value;}

    public String toString(){
    StringBuilder buf = new StringBuilder();
    buf.append("[");
    for (int i = 0; i<rows; i++){
        buf.append("[");
        for (int j = 0; j<cols; j++){
            buf.append(data[i*cols +j]);
            if(j!=cols-1)buf.append(",");

        }
        buf.append("]");
    } buf.append("]");
    return buf.toString();
    }

    int [] shape()
    {
        int [] arr = new int[2];
        arr[0] = rows;
        arr[1] = cols;
        return arr;
    }
     void reshape (int newRows, int newCols)
     {
        if(rows*cols != newRows *newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d", rows, cols, newRows, newCols));
        else
            rows = newRows;
            cols = newCols;
     }

     Matrix add(Matrix m)
     {
         if (rows != m.getRows() || cols != m.getCols())
             throw new RuntimeException("zly wymiar");
         Matrix l = new Matrix(rows, cols);
         for (int i = 0; i<l.rows; i++)
         {
             for (int j = 0; j<l.cols; j++)
             {
                 l.data[i*cols + j] = this.data[i*cols +j] + m.data[i*cols+j];
             }
         }
         return l;
         /*for (int i = 0; i <d.length; i++){
         * l.data[i] = data[i] + m.data[i];}*/
     }

    Matrix add(double w)
    {
        Matrix l = new Matrix(rows, cols);
        for (int i = 0; i<l.rows; i++)
        {
            for (int j = 0; j<l.cols; j++)
            {
                l.data[i*cols + j] = data[i*cols +j] + w;
            }
        }
        return l;

    }

    Matrix sub(Matrix m)
    {
        if (rows != m.getRows() || cols != m.getCols())
            throw new RuntimeException("zly wymiar");
        Matrix l = new Matrix(rows, cols);
        for (int i = 0; i<data.length; i++)
        {
            l.data[i] = data[i] - m.data[i];
        }
        return l;

    }
    Matrix sub(double w)
    {
        Matrix l = new Matrix(rows, cols);
        for (int i = 0; i<l.rows; i++)
        {
            for (int j = 0; j<l.cols; j++)
            {
                l.data[i*cols + j] = data[i*cols +j] - w;
            }
        }
        return l;

    }

    Matrix mul(Matrix m)
    {
        if (rows != m.getRows() || cols != m.getCols())
            throw new RuntimeException("zly wymiar");
        Matrix l = new Matrix(rows, cols);
        for (int i = 0; i<data.length; i++)
        {
            l.data[i] = data[i] * m.data[i];
        }
        return l;
    }
    Matrix mul(double w)
    {
        Matrix l = new Matrix(rows, cols);
        for (int i = 0; i<l.rows; i++)
        {
            for (int j = 0; j<l.cols; j++)
            {
                l.data[i*cols + j] = data[i*cols +j] * w;
            }
        }
        return l;

    }

    Matrix div(Matrix m)
    {
        if (rows != m.getRows() || cols != m.getCols())
            throw new RuntimeException("zly wymiar");
        Matrix l = new Matrix(rows, cols);
        for (int i = 0; i<data.length; i++)
        {
            if(m.data[i] == 0)
                throw new RuntimeException("NDZIEL##");
            else
            l.data[i] = data[i] / m.data[i];
        }
        return l;
    }

    Matrix div(double w)
    {
        Matrix l = new Matrix(rows, cols);
        for (int i = 0; i<data.length; i++)
        {
            if(w == 0)
                throw new RuntimeException("NDZIEL##");
            else
                l.data[i] = data[i] / w;
        }
        return l;

    }

    Matrix dot(Matrix m)
    {
        if (cols != m.getRows())
            throw new RuntimeException("zly wymiar");
        Matrix l = new Matrix(rows, m.getCols());
        for (int i = 0; i<rows; i++)
        {
            for (int j = 0; j<m.getCols(); j++)
            {
                double sum = 0;
                for (int k = 0; k<cols; k++)
                {
                   sum += data[i*cols +k] * m.data[k*m.getCols() +j];
                }
                l.data[i*m.getCols() + j] = sum;
            }
        }
        return l;


    }

    double frobenius(){
        double norm = 0;

        for (int i=0; i<data.length;i++){
            norm += data[i] * data[i];
        }
        return norm;
    }

    Matrix getSubmatrix(int fromRow, int toRow, int fromCol, int toCol){
        if (fromRow <0 || fromCol<0 || toCol >cols || toRow>rows)
            throw new RuntimeException("zly zakres");

    Matrix result = new Matrix(toRow-fromRow, toCol-fromCol);

    for (int i=fromRow; i<toRow-1; i++) {
        for (int j = fromCol; j < toCol-1; j++){

                result.data[] = this.data[i * cols + j];
            }
        }

    return result;
    }



}
