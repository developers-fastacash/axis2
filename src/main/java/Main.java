import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.fastacash.vfx.MoBeLinkClassStub;
import com.mobewallet.webservices.LogIn2Document;
import com.mobewallet.webservices.LogIn2ResponseDocument;

public class Main {
	public static void main(String[] args) {
		try {
			MoBeLinkClassStub proxy = new MoBeLinkClassStub(
					"http://www.vfxplc.com/mobe/mobelink.asmx");
			LogIn2Document request = LogIn2Document.Factory.newInstance();
			LogIn2Document.LogIn2 data = request.addNewLogIn2();
			data.setClientID("mob900021");
			data.setPassword("welcome");
			data.setSourceSystem("fastacash");

			try {
				LogIn2ResponseDocument response = proxy.logIn2(request);
				System.out.println(response.toString());
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
