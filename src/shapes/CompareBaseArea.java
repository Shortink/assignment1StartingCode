package shapes;

import java.util.Comparator;

/**
 * Created on February 19, 2025
 * @author bbteruel
 * @version 1.0
 */

public class CompareBaseArea implements Comparator<IShapes>{
	
	@Override
	public int compare(IShapes iShape1, IShapes iShape2) {
		if ( iShape1.calcBaseArea() > iShape2.calcBaseArea() )
			return 1;
		else if ( iShape1.calcBaseArea() < iShape2.calcBaseArea() )
			return -1;
		else
			return 0;
	}
}
