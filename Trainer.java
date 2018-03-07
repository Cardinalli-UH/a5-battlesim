import java.util.Scanner;

class Trainer {

	int passCount = 0;

	protected static int number = 0;

	String name = "";

	Pokemon mon = null;

	public Trainer() {

		this.number++;

		this.name = "Trainer " + number;
	}

	void setMon(Pokemon mon) {

		this.mon = mon;

	}

}
