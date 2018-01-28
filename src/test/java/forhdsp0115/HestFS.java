package forhdsp0115;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class HestFS {
    private FileSystem fs;
    private String url="hdfs://192.168.227.132:8020";
    @Before
    public void setUp() throws URISyntaxException, IOException, InterruptedException {
        fs=FileSystem.get(new URI(url),new Configuration(),"groot");
    }
    @Test
    public void testMkDir() throws IOException {
        fs.mkdirs(new Path("/for0115"));
    }
    @Test
    public void testCreateFile() throws IOException {
        FSDataOutputStream fsDataOutputStream=fs.create(new Path("/for0115/1.txt"));
        for(int i=0;i<3;i++){
            fsDataOutputStream.write(("haha"+i).getBytes());
        }
        fsDataOutputStream.flush();
        fsDataOutputStream.close();
    }
    @Test
    public void testCatFile() throws IOException {
        FSDataInputStream fsDataInputStream=fs.open(new Path("/for0115/1.txt"));
        byte [] arr=new byte[256];
        int len=0;
        while((len=fsDataInputStream.read(arr))!=-1) {
            System.out.println(new String(arr, 0, len));
        }

    }
    @Test
    public void upload() throws IOException {
        fs.copyFromLocalFile(new Path("D:\\yff.txt"),new Path("/for0115/2.txt"));
    }
    @Test
    public void downLoad() throws IOException {
        fs.copyToLocalFile(new Path("/for0115/2.txt"),new Path("D://yff2.txt"));
    }

}
