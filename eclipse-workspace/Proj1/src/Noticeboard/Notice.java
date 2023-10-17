package Noticeboard;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Notice {

    public static void main(String[] args) {

        List<String> data = new ArrayList<>();
        Path path = Paths.get("data.txt");
        try {
            data = Files.readAllLines(path);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


        if (data.size()>6){
            data.remove(data.size()-1);
            System.out.println(data);
        }
        else
            System.out.println(data);

        try {
            Files.write(path, data);
            System.out.println(data);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
}
