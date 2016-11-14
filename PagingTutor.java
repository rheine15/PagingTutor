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
		} else {
			textsize = Integer.parseInt(input[1]);
			datasize = Integer.parseInt(input[2]);
			int numPages;
			if(((datasize+textsize)%FRAME_SIZE) == 0) {
				numPages = (datasize+textsize)/FRAME_SIZE;
			} else {
				numPages = ((datasize+textsize)/FRAME_SIZE)+1;
			}
			hasSpace(numPages);
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
