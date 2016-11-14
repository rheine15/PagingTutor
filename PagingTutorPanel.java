import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

	/* Memory labels with grid that the live in */
	//grid here
	JLabel frame0;
	JLabel frame1;
	JLabel frame2;
	JLabel frame3;
	JLabel frame4;
	JLabel frame5;
	JLabel frame6;
	JLabel frame7;

	public PagingTutorPanel() {
		physM = new JLabel("Physical Memory");
		add(physM);
		//createrigidarea
		
		f0 = new JLabel("Frame 0");
		add(f0);
		f1 = new JLabel("Frame 1");
		add(f1);
		f2 = new JLabel("Frame 2");
		add(f2);
		f3 = new JLabel("Frame 3");
		add(f3);
		f4 = new JLabel("Frame 4");
		add(f4);
		f5 = new JLabel("Frame 5");
		add(f5);
		f6 = new JLabel("Frame 6");
		add(f6);
		f7 = new JLabel("Frame 7");
		add(f7);
		
		ButtonListener listen = new ButtonListener();
		JButton next = new JButton("Next..");
		add(next);
		next.addActionListener(listen);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}
}
