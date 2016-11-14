public class ProcFrame {
	private int frameNum;
	private int procID;
	private String segment;
	private int pageNum;

	public ProcFrame(int frameNum) {
		this.frameNum = frameNum;
		segment = "";
		procID = -1;
		pageNum = -1;
	}

	public int getFrameNum() {
		return frameNum;
	}

	public int getProcID() {
		return procID;
	}

	public String getSegment() {
		return segment;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setProcID(int procID) {
		this.procID = procID;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
