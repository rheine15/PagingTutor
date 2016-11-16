import java.util.*;
import java.lang.*;

public class PagingTutor {
	ProcFrame[] frames;
	
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
			String out = "P" + frames[frameNum].getProcID() 
			+ " " + frames[frameNum].getSegment() 
			+ " Page " + frames[frameNum].getPageNum();
			return out;
		}
	}
	
	public void processLine(String line) {
		String[] input = line.split(" ");
		int proc = Integer.parseInt(input[0]);
		int textsize;
		int datasize;

		if (input[1].equals("Halt")) {
			// clear process from frames
			for (int i = 0; i < 8; i++) {
				if (frames[i].getProcID() == proc) {
					frames[i] = new ProcFrame(i);
				}
			}
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
			placeInFrame(proc, numPagesText, numPagesData);
		}
	}

	public void placeInFrame(int proc, int textPages, int dataPages) {
		int text = 0;
		int data = 0;
		for (int i = 0; i < 8; i++) {
			if (textPages > 0 && frames[i].getProcID() == -1) {
				frames[i].setProcID(proc);
				frames[i].setSegment("Text");
				frames[i].setPageNum(text);
				text++;
				textPages--;
			} else if (dataPages > 0 && frames[i].getProcID() == -1) {
				frames[i].setProcID(proc);
				frames[i].setSegment("Data");
				frames[i].setPageNum(data);
				data++;
				dataPages--;
			}
		}
	}
}
