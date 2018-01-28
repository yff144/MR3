package forhdsp0115;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;

public class TestDown {
    @Test
    public void download() throws IOException {
        FileSystem fs=Log.getFileSystem();
        fs.copyToLocalFile(new Path("/for0115/3.txt"),new Path("D://jj2.txt"));
    }
}
