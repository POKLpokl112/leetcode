package lintcode;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    public List<Integer> flatten(List<NestedInteger> nestedList) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nestedList.size(); i++) {
			NestedInteger ni = nestedList.get(i);

			if (ni.isInteger()) {
				list.add(ni.getInteger());
			} else {
				List<NestedInteger> nextList = ni.getList();
			}
		}
		return null;

    }
}

interface NestedInteger {
	boolean isInteger();

	Integer getInteger();

	List<NestedInteger> getList();
}