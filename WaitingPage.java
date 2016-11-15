public class WaitingPage {
	int numDataPages;
	int numTextPages;
	int procID;

	public WaitingPage (int procID, int numDataPages, int numTextPages) {
		this.procID = procID;
		this.numTextPages = numTextPages;
		this.numDataPages = numDataPages;
	}
	
	public int getProcID() {
		return procID;
	}

	public int getNumDataPages() {
		return numDataPages;
	}

	public int getNumTextPages() {
		return numTextPages;
	}
}
