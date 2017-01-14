package util;

public class FileOperation {
    public static void main(String[] args) {
        FileUtil futil = new FileUtil();
        // open existing file to read
        String s1 = futil.openReadFile("rpg.txt");
        System.out.println(s1);
        
        while(futil.getReadScanner().hasNext()) {
            // read line per line, split line by comma delimiter
            String[] readLine = futil.getReadScanner().next().split(",");
            
            // printout per line
            String name1 = readLine[0];
            double experience1 = Double.parseDouble(readLine[1]);
            int energy1 = Integer.parseInt(readLine[2]);
            int money1 = Integer.parseInt(readLine[3]);          
            System.out.printf("%s\t%d\t%f%n",name1,experience1,energy1,money1);
        }        
        // close opening read file
        String s3 = futil.closeReadFile();
        System.out.println(s3);
    }
}


