import java.util.Scanner;

import tw.ttu.eclass.clientManager.LoginManager;
import tw.ttu.eclass.clientManager.StudentManager;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		System.out.println("Input username and password:");
		username = scanner.next();
		password = scanner.next();
		
		// create client manager.
		LoginManager lm = new LoginManager();
		StudentManager sm = new StudentManager();
		// get session id.
		Long sessionId = lm.login(username, password);
		// if it is not -1, success.
		if (sessionId != -1) {
			System.out.println("login success!");
		} else {
			System.out.println("login fail!");
		}
		
		
		// get user photo
		byte[] pic = sm.getStudentPhotoByStudentId(49906111);
		if(pic!=null){
			System.out.println(pic.length);
			ImageDisplay imageDisplay = new ImageDisplay(pic);
			imageDisplay.repaint();
		}else{
			System.out.println("null");
		}
		
		scanner.close();
	}
}
