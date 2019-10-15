package lab2b;

public enum Statment {

	LIVE, DEAD;

	public Statment getStatment(int around) {
		switch (this) {
		case LIVE:
			return (around < 2 || around > 3) ? DEAD : LIVE;
		case DEAD:
			return (around == 3) ? LIVE : DEAD;

		default:
			return this;
		}
	}

	public boolean isLive() {
		return (this == LIVE) ? true : false;
	}
}
