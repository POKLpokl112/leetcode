package code.one;

//true false true false place rule
//false false false in places
//is there n true to places
//fuck off length<2 and n<1 situation
public class CanPlaceFlower {
	public boolean canPlaceFlower(boolean[] places ,int n){
		int count = 0;
		if (!places[0] && !places[1]) {
			count++;
		}

		if (!places[places.length - 1] && !places[places.length - 2]) {
			count++;
		}
		
		for (int i = 2; i < places.length - 2; i++) {
			if (!places[i - 1] && !places[i] && !places[i + 1]) {
				count++;
				i++;
			}
		}
		return count < n ? false : true;
	}
}
