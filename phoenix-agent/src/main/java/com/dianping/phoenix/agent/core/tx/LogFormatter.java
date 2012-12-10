package com.dianping.phoenix.agent.core.tx;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class LogFormatter {

	private final static String NEW_LINE = "\r\n";
	public static final String CHUNK_TERMINATOR = "\r\n--9ed2b78c112fbd17a8511812c554da62941629a8--\r\n";
	public static final String LOG_TERMINATOR = "\r\n--255220d51dc7fb4aacddadedfe252a346da267d4--\r\n";

	public void writeHeader(OutputStream logOut, Map<String, String> headers) throws IOException {
		StringBuilder sb = new StringBuilder();

		if (headers != null) {
			for (Map.Entry<String, String> headEntry : headers.entrySet()) {
				sb.append(headEntry.getKey());
				sb.append(": ");
				sb.append(headEntry.getValue());
				sb.append(NEW_LINE);
			}
		}

		if (sb.length() > 0) {
			sb.append(NEW_LINE);
		} else {
			sb.append(NEW_LINE);
			sb.append(NEW_LINE);
		}

		logOut.write(sb.toString().getBytes());
		
		Log4jAppender.startTeeLog(logOut);
	}

	public void writeChunkTerminator(OutputStream logOut) throws IOException {
		logOut.write(CHUNK_TERMINATOR.getBytes("ascii"));
		logOut.flush();
		
		Log4jAppender.endTeeLog();
	}

	public void writeTerminator(OutputStream logOut) throws IOException {
		logOut.write(LOG_TERMINATOR.getBytes("ascii"));
		
		Log4jAppender.endTeeLog();
	}

}
