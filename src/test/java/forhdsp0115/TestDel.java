package forhdsp0115;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;

public class TestDel {
    @Test
    public void delete() throws IOException {
        FileSystem fs=Log.getFileSystem();
        fs.delete(new Path("/for0115/3.txt"),false);
    }
}
