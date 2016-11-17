/*****************************************************************
Data structure of a frame in the page table.

@author Bob Heine
@version 1.0
*****************************************************************/
public class ProcFrame {
	
	/** the frames number in the list */
	private int frameNum;

	/** process ID stored in frame */
	private int procID;

	/** the type of segment stored */
	private String segment;

	/** page number of segment */
	private int pageNum;

	/*****************************************************************
    	Constructor creates a frame with a given frame number.
    	@param frameNum the number of the frame in the list
    	*****************************************************************/
	public ProcFrame(int frameNum) {
		this.frameNum = frameNum;
		segment = "";
		procID = -1;
		pageNum = -1;
	}

	/*****************************************************************
    	Returns the frame number.
    	@return frame number
    	*****************************************************************/
	public int getFrameNum() {
		return frameNum;
	}

        /*****************************************************************
        Returns the process ID.
        @return process ID
        *****************************************************************/
	public int getProcID() {
		return procID;
	}

        /*****************************************************************
        Returns the type of segment.
        @return type of segment
        *****************************************************************/
	public String getSegment() {
		return segment;
	}

        /*****************************************************************
        Returns the page number.
        @return page number
        *****************************************************************/
	public int getPageNum() {
		return pageNum;
	}

        /*****************************************************************
        Assigns the frame a process ID.
        @param procID the process ID to be assigned
	@return none
        *****************************************************************/
	public void setProcID(int procID) {
		this.procID = procID;
	}

        /*****************************************************************
        Assigns the frame a segment type.
        @param segment the segment type to be assigned
        @return none
        *****************************************************************/
	public void setSegment(String segment) {
		this.segment = segment;
	}

        /*****************************************************************
        Assigns the frame a page number.
        @param pageNum the page number to be assigned
        @return none
        *****************************************************************/
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
