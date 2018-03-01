package forhdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

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
        fs.mkdirs(new Path("/data/data2"));
    }
    public void forCreat() throws IOException {
        FSDataOutputStream fsDataOutputStream=fs.create(new Path("/data/data2/1.txt"));
        fsDataOutputStream.write("hello world".getBytes());
        fsDataOutputStream.flush();
        fsDataOutputStream.close();
    }
    public void foropean() throws IOException {
        FSDataInputStream fsDataInputStream=fs.open(new Path("/data/data2/1.txt"));
        byte [] arr=new byte[1024];
        int len=0;
        while((len=fsDataInputStream.read(arr))!=-1){
            System.out.println(new String(arr,0,len));
        }
        fsDataInputStream.close();
    }
    public void forup() throws IOException {
        fs.copyFromLocalFile(new Path("D:/yff.txt"),new Path("/data/data2/2.txt"));
    }
    public void fordown () throws IOException {
        fs.copyToLocalFile(new Path("/data/data2/2.txt"),new Path("D:/yfff.txt"));
    }
    public void forrename() throws IOException {
        fs.rename(new Path("/data/data2/2.txt"),new Path("/data/data2/yff.txt"));
    }
    public void fordelete() throws IOException {
        fs.delete(new Path("/data/data2/"),true);
    }
    public void forfs() throws IOException {
        FsStatus fsStatus=fs.getStatus(new Path("/"));
        System.out.println(fsStatus.getCapacity());
        System.out.println(fsStatus.getRemaining());
        System.out.println(fsStatus.getUsed());
    }
    public void forff() throws IOException {
        FileStatus fileStatus=fs.getFileStatus(new Path("/data/data2/2.txt"));
        System.out.println(fileStatus.getAccessTime());
        System.out.println(fileStatus.getBlockSize());
        System.out.println(fileStatus.getLen());
        System.out.println(fileStatus.getOwner());
        System.out.println(fileStatus.getGroup());
    }

    public static void main(String[] args) throws IOException {
        TestHdfs testHdfs=new TestHdfs();
        //testHdfs.forMkdir();
       // testHdfs.forCreat();
        //testHdfs.foropean();
       // testHdfs.forup();
       // testHdfs.fordown();
       // testHdfs.forfs();
        //testHdfs.forff();
        //testHdfs.forrename();
        testHdfs.fordelete();

    }
}
