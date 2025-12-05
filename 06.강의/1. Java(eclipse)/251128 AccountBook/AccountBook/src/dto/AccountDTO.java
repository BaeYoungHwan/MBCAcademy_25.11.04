package dto;

public class AccountDTO {
	// 제목, 수입/지출, 금액, 날짜, 내용
	private String title;
	private int income;
	private int amount;
	private String date;
	private String memo;
	
	//생성자
	public AccountDTO() {
	
	}
	
	//data 값 입력하기
	public AccountDTO(String title, int income, int amount, String date, String memo) {
		super();
		this.title = title;
		this.income = income;
		this.amount = amount;
		this.date = date;
		this.memo = memo;
	}

	
	// Getter Setter
	public String getTitle() {
		return title;
	}

	public int getIncome() {
		return income;
	}

	public int getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public String getMemo() {
		return memo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	//toString 전체 값 표출하기
	@Override
	public String toString() {
		return "AccountDTO [title=" + title + ", income=" + income + ", amount=" + amount + ", date=" + date + ", memo="
				+ memo + "]";
	}
	// 보기 좋게 표현하기
	public String getData() {
		return title + "-" + income + "-" + amount + "-" + date + "-" + memo; 
	}	
	
	
	
	
}


