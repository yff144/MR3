package forhdsp0115;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;

public class TestUp {
    @Test
    public void upload() throws IOException {
        FileSystem fs=Log.getFileSystem();
        fs.copyFromLocalFile(new Path("D:\\jj.txt"),new Path("/for0115/3.txt"));
    }
}
