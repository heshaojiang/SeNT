package com.grgbanking.sent.utils.fsnUtils.gen;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class MyZipInputStream extends ZipInputStream {
	
	private byte[] tmpbuf = new byte[51200];
	
	private boolean closed = false;
	    // this flag is set to true after EOF has reached for
	    // one entry
	private boolean entryEOF = false;

	public MyZipInputStream(InputStream in) {
		super(in);
	}

    public long skip(long n) throws IOException {
        if (n < 0) {
            throw new IllegalArgumentException("negative skip length");
        }
        if (closed) {
            throw new IOException("Stream closed");
        }
        int max = (int)Math.min(n, Integer.MAX_VALUE);
        int total = 0;
        while (total < max) {
            int len = max - total;
            if (len > tmpbuf.length) {
                len = tmpbuf.length;
            }
            len = read(tmpbuf, 0, len);
            if (len == -1) {
                entryEOF = true;
                break;
            }
            total += len;
        }
        return total;
    }
}
