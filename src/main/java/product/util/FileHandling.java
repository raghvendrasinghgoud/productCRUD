package product.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileHandling {
	
	protected String path;
	
	public FileHandling(String pathWithFileName) {
		this.path=pathWithFileName;
	}
	
	public FileHandling(String path,String filename) {
		this.path=path+File.separator+filename;
//		System.out.println(path);
	}
	
	
	
	public void saveOrUpdateFile(InputStream data) throws IOException {
		FileOutputStream fos=new FileOutputStream(new File(this.path));
		fos.write(data.readAllBytes());
		fos.flush();
		fos.close();
	}

	public  void deleteFile() {
		new File(this.path).delete();
	}
	
}
