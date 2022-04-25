package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Pruebas2 {

	public static void main(String[] args) {
		//
		List<Integer> nums = new ArrayList<>();
		nums.add(2);
		nums.add(3);
		double media = 0;
		for (Integer num : nums) {
			media = media + num;
		}
		System.out.println(media);
		media = media / nums.size();
		System.out.println(media);
	}

}
