package lotto.controller;

import lotto.domain.Money;

public class Repeater {
	private static boolean repeater;

	private Repeater() {
	}

	public static void init() {
		repeater = true;
	}

	public static boolean isContinue() {
		return repeater;
	}

	public static void set(Money setValue) {
		repeater = setValue.equals(0);
	}

	public static void set(String setValue) {
		repeater = setValue.equals("");
	}
}
