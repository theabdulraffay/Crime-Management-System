import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
class MyObjectOutputStream extends ObjectOutputStream {
	public MyObjectOutputStream() throws IOException {
		super();
	}

	public MyObjectOutputStream(OutputStream output) throws IOException {
		super(output);
	}

	public void writeStreamHeader(){}
}