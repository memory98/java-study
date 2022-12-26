package prob04;

public class Person {

	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	public Person() {
		this.age = 12;
		this.name = "";
		this.numberOfPerson = 1;
	}
	/* 코드 작성 */
	public Person(String string) {
		this.age = 12;
		this.name = string;
	}

	public Person(int i, String string) {
		this.age = i;
		this.name = string;
	}
	
	public static int getPopulation() {
		return numberOfPerson+=1;
	}
	
	public void selfIntroduce() {
		System.out.println("내 이름은 "+name+
							"이며, 나이는 "+age+
							"살입니다."
				);
	}
}
