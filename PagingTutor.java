import java.util.*;

public class PagingTutor {
	ProcFrame[] frames;
	Queue waitlist = new LinkedList();
	
	public final int FRAME_SIZE = 512;

	public PagingTutor() {
		frames = new ProcFrame[8];
		for (int i = 0; i < 8; i++) {
			frames[i] = new ProcFrame(i);
		}
	}
	
	public String getFrame(int frameNum) {
		if (frames[frameNum].getProcID() == -1) {
			return "";
		} else {
		return "P" + frames[frameNum].getProcID() 
			+ " " + frames[frameNum].getSegment() 
			+ " Page " + frames[frameNum].getPageNum();
		}
	}
	
	public void processLine(String line) {
		String[] input = line.split(" ");
		int proc = Integer.parseInt(input[0]);
		int textsize;
		int datasize;

		if (input[1] == "Halt") {
			// clear process from frames
			for (int i = 0; i < 8; i++) {
				if (frames[i].getProcID() == proc) {
					frames[i] = new ProcFrame(i);
				}
			}
			tryWaitList();
		} else {
			textsize = Integer.parseInt(input[1]);
			datasize = Integer.parseInt(input[2]);
			int numPagesText;
			int numPagesData;
			
			// pages for data
			if (datasize%FRAME_SIZE == 0) {
				numPagesData = datasize/FRAME_SIZE;
			} else {
				numPagesData = (datasize/FRAME_SIZE)+1;
			}
			// pages for text
			if (textsize%FRAME_SIZE == 0) {
				numPagesText = textsize/FRAME_SIZE;
			} else {
				numPagesText = (textsize/FRAME_SIZE)+1;
			}
			tryCurrProc(proc, numPagesText, numPagesData);
		}
	}

	public void tryCurrProc(int proc, int textPages, int dataPages) {
		WaitingPage listHead = waitlist.peek();
		if (hasSpace((textPages+dataPages))) {
			placeInFrame(proc, textPages, dataPages);
		} else {
			waitlist.add(new WaitingPage(proc, textPages, dataPages));
		} 
	}

	public void tryWaitList() {
		WaitingPage head = waitlist.peek();
		if (hasSpace(head.getNumTextPages() + head.getNumDataPages())) {
			placeInFrame(head.getProcID(), head.getNumTextPages(), head.getNumDataPages());
			waitlist.remove();
		} 
	}

	public void placeInFrame(int proc, int textPages, int dataPages) {
		int text = 0;
		int data = 0;
		for (int i = 0; i < 8; i++) {
			if (textPages < 0 && frames[i].getProcID() == -1) {
				frames[i].setProcID(proc);
				frames[i].setSegment("Text");
				frames[i].setPageNum(text);
				text++;
				textPages--;
			} else if (dataPages < 0 && frames[i].getProcID() == -1) {
				frames[i].setProcID(proc);
				frames[i].setSegment("Data");
				frames[i].setPageNum(data);
				data++;
				dataPages--;
			}
		}
	}

	public boolean hasSpace(int pagesReq) {
		int pagesFree = 0;
		for (int i = 0; i < 8; i++) {
			if(frames[i].getProcID() == -1) {
				pagesFree++;
			}
		}
		return pagesFree >= pagesReq;
	}
}
