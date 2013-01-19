
import java.io.File;
import java.text.SimpleDateFormat;

public class RenameFile {

	public static void main(String[] args) throws InvalidFileException {
		// TODO Auto-generated method stub
		String filename="";
		try {
		  filename = args[0];
		} catch (Exception e) {
			System.out.println("Need argument of a valid filename.");
		}
		File file = new File(filename);
		if (!file.exists()) {
			System.out.println("File ["+filename+"] doesn't exist.");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
//		System.out.println("After Format : " + sdf.format(file.lastModified()));

		String[] tmp = filename.split("\\.");
		String extension = tmp[tmp.length-1];
		
		File file2;
	    int idx=1;

	    String newName = sdf.format(file.lastModified()) + "-"+idx+"." + extension;
	    file2 = new File(newName);
	    while ((file2.exists()) && (idx < 10)) {
	    	idx++;
	    	newName = sdf.format(file.lastModified()) + "-"+idx+"." + extension;
		    file2 = new File(newName);
	    }
	    
	    boolean success=false;
	    if(!file2.exists()) {
  	      success = file.renameTo(file2);
	    }
	    if (success) {
			  System.out.println("Renaming success - " + filename + " to " + newName);
	    } else {
			  System.out.println("Renaming error");
	    }
	}

	public class InvalidFileException extends Exception {

		  public InvalidFileException(String message){
		     super(message);
		  }

		}	
}
