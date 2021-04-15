import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class CSVReader {

    BufferedReader reader;
    String delimiter;
    boolean hasHeader;
    String[] current;


    List<String> columnLabels = new ArrayList<>();
    Map<String, Integer> columnLabelsToInt = new HashMap<>();

    public  CSVReader(String filename, String delimiter) throws IOException {
        this(filename, delimiter, false);
    }
    public CSVReader(String filename) throws IOException {
        this(filename, ",", false);
    }

    public CSVReader(String filename, String delimiter, boolean hasHeader) throws IOException {
        this(new InputStreamReader(new FileInputStream(filename), Charset.forName("Windows-1250")), delimiter, hasHeader);
    }

    //Reader
    public CSVReader(Reader reader, String delimiter, boolean hasHeader) throws IOException {
        this.reader = new BufferedReader(reader);
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if (hasHeader)
            parseHeader();
    }

   void parseHeader() throws IOException {
       String line = reader.readLine();
       if(line==null){
           return;
       }
       String[]header = line.split(delimiter);
       for(int i =0;i<header.length;i++){
           columnLabels.add(header[i]);
           columnLabelsToInt.put(header[i], i);
       }
   }
    boolean next() throws IOException {
        String line = reader.readLine();
        if(line ==null)
            return false;
        current = line.split(delimiter);
        return true;
    }

    String get(int columnIndex){
       if(isMissing(columnIndex))
           return "";
       return current[columnIndex];
    }

    /*
    String get(String columnLabel) {
        return get(columnLabelsToInt.get(columnLabel));
    }
    */
    String get(String columnLabel){
       if(isMissing(columnLabel))
           return "";
       return current[columnLabelsToInt.get(columnLabel)];
    }
    int getInt(int columnIndex) throws IOException{
       if(isMissing(columnIndex))
           throw new IOException();
       String result = current[columnIndex];
       return Integer.parseInt(result);
    }

    int getInt(String columnLabel){
       if(isMissing(columnLabel))
           return -1;
       String result = current[columnLabelsToInt.get(columnLabel)];
       return Integer.parseInt(result);
    }

    long getLong(int columnIndex){
       if(isMissing(columnIndex))
           return -1;
       String result = current[columnIndex];
       return Long.parseLong(result);
    }

    long getLong(String columnLabel){
       if(isMissing(columnLabel))
           return -1;
       String result = current[columnLabelsToInt.get(columnLabel)];
       return Long.parseLong(result);

    }

    double getDouble(int columnIndex){
       if(isMissing(columnIndex))
           return -1;
       String result = current[columnIndex];
       return Double.parseDouble(result);
    }

    double getDouble(String columnLabel){
       if(isMissing(columnLabel))
           return -1;
       String result = current[columnLabelsToInt.get(columnLabel)];
       return Double.parseDouble(result);
    }

    boolean isMissing(String columnLabel){
       Integer columnIndex = columnLabelsToInt.get(columnLabel);
       if(columnIndex == null)
           return true;
       return this.isMissing(columnIndex);
    }

    boolean isMissing(int columnIndex){
       if(columnIndex<0 || columnIndex >= this.current.length)
           return true;
       //isBlank(" ") returns true
       else if(current[columnIndex].isBlank()){
           return true;
       }
       return false;
    }


}