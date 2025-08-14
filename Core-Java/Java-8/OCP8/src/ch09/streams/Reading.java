package ch09.streams;

public class Reading {
	int year;
	int month;
	int day;
	double value;

	public Reading(int year, int month, int day, double value) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.value = value;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Reading [year=" + year + ", month=" + month + ", day=" + day + ", value=" + value + "]";
	}
}
