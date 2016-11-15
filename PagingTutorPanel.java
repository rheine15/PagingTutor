import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class PagingTutorPanel extends JPanel {
	/* Info labels */
	JLabel physM;
	JLabel f0;
	JLabel f1;
	JLabel f2;
	JLabel f3;
	JLabel f4;
	JLabel f5;
	JLabel f6;
	JLabel f7;

	/* Memory labels that will be updated */
	JLabel frame0;
	JLabel frame1;
	JLabel frame2;
	JLabel frame3;
	JLabel frame4;
	JLabel frame5;
	JLabel frame6;
	JLabel frame7;

	File inputFile;
	PagingTutor pTutor;

	public PagingTutorPanel() {
		inputFile = (String)JOptionPane.showInputDialog("Enter file name: ");
		
		pTutor = new PagingTutor();
		physM = new JLabel("Physical Memory");
		add(physM);
		//createrigidarea
		JPanel grid = new JPanel(new GridLayout(0,2));
		add(grid);
		
		f0 = new JLabel("Frame 0");
		grid.add(f0);
		frame0 = new JLabel(pTutor.getFrame(0));
		grid.add(frame0);
		
		f1 = new JLabel("Frame 1");
		grid.add(f1);
		frame1 = new JLabel(pTutor.getFrame(1));
		grid.add(frame1);

		f2 = new JLabel("Frame 2");
		grid.add(f2);
		frame2 = new JLabel(pTutor.getFrame(2));
		grid.add(frame2);

		f3 = new JLabel("Frame 3");
		grid.add(f3);
		frame3 = new JLabel(pTutor.getFrame(3));
		grid.add(frame3);

		f4 = new JLabel("Frame 4");
		grid.add(f4);
		frame4 = new JLabel(pTutor.getFrame(4));
		grid.add(frame4);

		f5 = new JLabel("Frame 5");
		grid.add(f5);
		frame5 = new JLabel(pTutor.getFrame(5));
		grid.add(frame5);

		f6 = new JLabel("Frame 6");
		grid.add(f6);
		frame6 = new JLabel(pTutor.getFrame(6));
		grid.add(frame6);

		f7 = new JLabel("Frame 7");
		grid.add(f7);
		frame7 = new JLabel(pTutor.getFrame(7));
		grid.add(frame7);
		
		ButtonListener listen = new ButtonListener();
		JButton next = new JButton("Next..");
		add(next);
		next.addActionListener(listen);
	}
	
	public void next(String input) {
		pTutor.processLine(br.readLine());
		frame0.Text = pTutor.getFrame(0);
		frame1.Text = pTutor.getFrame(1);
		frame2.Text = pTutor.getFrame(2);
		frame3.Text = pTutor.getFrame(3);
		frame4.Text = pTutor.getFrame(4);
		frame5.Text = pTutor.getFrame(5);
		frame6.Text = pTutor.getFrame(6);
		frame7.Text = pTutor.getFrame(7);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//if source is next button
				next();
		}
	}
}
