package code.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an array of strings, group anagrams together.
//
//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:
//
//[
//  ["ate", "eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
public class GroupAnagrams_time {

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);

			String s = new String(c);
			if (!map.containsKey(s)) {
				map.put(s, new ArrayList<>());
			}
			map.get(s).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> array = new ArrayList<>();

		List<String> list = new ArrayList<>();
		List<char[]> list1 = new ArrayList<>();

		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			list1.add(c);
			list.add(strs[i]);
		}

		while (!list.isEmpty()) {
			List<String> l = new ArrayList<>();
			l.add(list.remove(0));
			char[] c = list1.remove(0);
			for (int i = 0; i < list.size(); i++) {
				if (equal(c, list1.get(i))) {
					l.add(list.remove(i));
					list1.remove(i);
					i--;
				}
			}
			array.add(l);
		}

		return array;

	 }

	private boolean equal(char[] c, char[] ds) {
		if (c.length != ds.length) {
			return false;
		}
		for (int i = 0; i < ds.length; i++) {
			if (c[i] != ds[i]) {
				return false;
			}
		}

		return true;
	}
}
