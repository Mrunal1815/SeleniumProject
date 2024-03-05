package CommonUtils;

import java.util.Random;

public class JavaUtil {

	public int getRandomNumber() {
		Random random = new Random();
		int num = random.nextInt(200);
		return num;
	}
}
