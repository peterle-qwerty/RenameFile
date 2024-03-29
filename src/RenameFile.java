
import java.io.File;
import java.text.SimpleDateFormat;

public class RenameFile {

	public static void main(String[] args) throws InvalidFileException {
		// TODO Auto-generated method stub
		String filename="";
		File file = null;
		SimpleDateFormat sdf = null;
		try {
			
//		  if (true) {
//				throw new Exception("ERROR");
//		  }
		  filename = args[0];
 		  file = new File(filename);
		  if (!file.exists()) {
			throw new InvalidFileException("Invalid File");
		  }
          sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
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
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Need argument of a valid filename.");
		} catch (InvalidFileException e) {
			System.out.println("File ["+filename+"] doesn't exist.");
		} catch (Exception e ) {
			System.out.println(e.getMessage());
		}
		

	}


}
