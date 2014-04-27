package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CopyUtils {

	@SuppressWarnings("unchecked")
	public static <T> T deepCopy(T source) {

		if (source == null) {
			return null;
		}
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		T dest;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(source);
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			dest = (T) ois.readObject();
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		} catch (ClassNotFoundException e2) {
			throw new RuntimeException(e2);
		} finally {
			try {
				bos.close();
				bis.close();
				ois.close();
				oos.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return dest;
	}
}
