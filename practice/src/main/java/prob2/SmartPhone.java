package prob2;

public class SmartPhone extends MusicPhone{
	public void execute(String function) {
		if(function.equals("음악")) {
			playMusic();
		} else if(function.equals("통화")) {
			super.execute(function);
		} else if(function.equals("앱")){
			app();
		} else {
			System.out.println("에러요");
		}
	}
	public void playMusic() {
		System.out.println( "다운로드해서 음악재생" );

	}
	
	public void call() {
		System.out.println( "통화기능시작" );

	}
	
	public void app() {
		System.out.println( "앱실행" );

	}
}
