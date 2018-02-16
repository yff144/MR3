package forhdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestHdfs {
    private static String uri="hdfs://192.168.227.132:8020";
    private static FileSystem fs;
    static {
        try {
            fs=FileSystem.get(new URI(uri),new Configuration(),"groot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void forMkdir() throws IOException {
        fs.mkdirs(new Path("/data/data2/"));
    }
    public void forCreat() throws IOException {
        FSDataOutputStream fsDataOutputStream=fs.create(new Path("/data/data2/1.txt"));
        fsDataOutputStream.write("hello world".getBytes());

    }
}
