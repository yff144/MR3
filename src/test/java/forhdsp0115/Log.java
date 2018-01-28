package forhdsp0115;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public  class Log {
    private static FileSystem fs;
    private static String url="hdfs://192.168.227.132:8020";
    public static FileSystem getFileSystem(){
        try {
            fs=FileSystem.get(new URI(url),new Configuration(),"groot");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return fs;
    }

}
