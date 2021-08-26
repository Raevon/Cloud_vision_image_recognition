package Parser;

import Models.Labels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Labels> parseLabelss(String[] lines){
        List<Labels> labels = new ArrayList<>();
        for (String line : lines) {
            try {
                labels.add(parseLabels(line));
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }
        }
        return labels;
    }
   public static String[] getArray(String filename, String data){
       String [] values2 = new String[20];
       String replacement = data.replace("\n"," ");
       String finalrelace = replacement.replace("\"","\\"+"\"");
       //  System.out.println(replacement);
       values2=finalrelace.split(",");

       //response.getLabelAnnotationsList().toString().split(",");
       try {
           FileWriter myWriter = new FileWriter(filename);
           for (int i =0;i<values2.length;i++){
               myWriter.write("\""+values2[i]+"\","+"\n");
               // System.out.println(forparse[i]);
           }
           myWriter.close();
           System.out.println("Successfully wrote to the file.");
       } catch (IOException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }
       values2=new String[20];
       BufferedReader reader;
       try {
           reader = new BufferedReader(new FileReader(filename));
           String line = reader.readLine();
           int i = 0 ;
           while (line != null) {
               String[] lineParts = line.split(",");
               line = reader.readLine();
               values2[i]=line;
               i++;
           }
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
return values2;
   }
    public static Labels parseLabels(String line) throws Exception {
        String mid = parseValue(line, "mid: ");
        System.out.println("mid: " + mid);
        String description = parseValue(line, "description: ");
        System.out.println("description: " + description);
        String score = parseValue(line, "score: ");
        System.out.println("score: " + score);
        String topicality = parseValue(line, "topicality: ");
        System.out.println("topicality: " + topicality);
        Labels labels = new Labels(mid.replaceAll("\\\\"+"\"", ""), description.replaceAll("\\\\"+"\"", ""), Double.parseDouble(score), Double.parseDouble(topicality));
        return labels;
    }

    public static String parseValue(String line, String criteria) throws Exception {
        int beginIndex = line.lastIndexOf(criteria);
        beginIndex += criteria.length();
        if(beginIndex == -1){
            System.out.println("Line: " + line + "\nCriteria: " + criteria);
           // throw new Exception("Criteria not found in the line");
        }

        int endIndex = line.indexOf(' ', beginIndex);
        if(endIndex == -1){
            System.out.println("StartIndex: " + beginIndex + "\nCriteria: 'space'");
         //   throw new Exception("Criteria not found in the line/ or last line element is not space");
        }

        System.out.println("Line: " + line + "\nbeginIndex: " + beginIndex + "endIndex: " + endIndex);
        return line.substring(beginIndex, endIndex);
    }
}
