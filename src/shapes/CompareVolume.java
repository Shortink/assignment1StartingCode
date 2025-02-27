package shapes;

import java.util.Comparator;

/**
 * Created on February 19, 2025
 * @author bbteruel
 * @version 1.0
 */

public class CompareVolume implements Comparator<AbstractShapes>{
	
	@Override
	public int compare(AbstractShapes Shape1, AbstractShapes Shape2) {
		if ( Shape1.calcVolume() > Shape2.calcVolume() )
			return 1;
		else if ( Shape1.calcVolume() < Shape2.calcVolume() )
			return -1;
		else
			return 0;
	}
}
