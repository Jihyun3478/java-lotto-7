package lotto.model.domain;

public class PurchaseMoney {
	private static final int MINIMUM_MONEY_SIZE = 1000;
	private final int money;

	public PurchaseMoney(int money) {
		validate(money);
		this.money = money;
	}

	private void validate(int money) {
		moreThanThousand(money);
		divideThousand(money);
	}

	private void moreThanThousand(int input) {
		if (input <= MINIMUM_MONEY_SIZE) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
		}
	}

	private void divideThousand(int input) {
		if (input % MINIMUM_MONEY_SIZE != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
		}
	}

	public int getLottoCount() {
		return money / MINIMUM_MONEY_SIZE;
	}

	public int getMoney() {
		return money;
	}
}
