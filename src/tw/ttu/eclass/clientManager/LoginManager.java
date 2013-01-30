package tw.ttu.eclass.clientManager;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import tw.ttu.eclass.rmi.interfaces.LoginService;
import tw.ttu.eclass.util.Encrypter;

public class LoginManager {
	private final String salt = "WmLUjXektQ^qgBH0k+f3FI%*<85i(&!";
	private LoginService loginService;
	private boolean isSetup = false;

	public LoginManager() {
		try {
//			if not use the policy file, don't set security manager
			System.setSecurityManager(new RMISecurityManager());
			
			Registry registry = LocateRegistry.getRegistry("140.129.19.238");
			loginService = (LoginService) registry.lookup("loginService");
			isSetup = true;
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
		}

	}

	public Long login(String username, String password) {
		if (isSetup) {
//			password = Encrypter.getMd5Hash(password + salt);
			Long sessid = -1L;
			try {
				sessid = loginService.login(username, password);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return sessid;
		}else{
			System.err.println("RMI not setup!");
			return -1L;
		}
	}
	public void logout(Long sessionId){
		try {
			loginService.logout(sessionId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

