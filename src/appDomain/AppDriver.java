package appDomain;

public class AppDriver
{

	public static void main( String[] args )
	{
		// Handle Program Arguments
		// 2025FEB20 BBTERUEL
		String argsFileName = null;
		String argsType = null;
		String argsSort = null;
		
		for (int i = 0; i < args.length; i++) {
			// file name argument
			if ("-f".equals(args[i].substring(0, 2)) || 
					"-F".equals(args[i].substring(0, 2))) {
				
				argsFileName = args[i].substring(2);
			}
			
			// type argument 
			if ("-t".equals(args[i].substring(0, 2)) || 
					"-T".equals(args[i].substring(0, 2))) {
				
				//TODO Error Handling. 
				//Valid Arguments: v (volume), h (height) or a (base area)
				
				argsType = args[i].substring(2);
			}
			
			// sort argument 
			if ("-s".equals(args[i].substring(0, 2)) || 
					"-S".equals(args[i].substring(0, 2))) {
				
				//TODO Error Handling. 
				//Valid Arguments:  b (bubble), s (selection), i (insertion), m (merge), q (quick) or z(your choice of sorting algorithm) 
				argsSort = args[i].substring(2);
			}
		}
		

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
