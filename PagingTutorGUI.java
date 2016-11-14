import javax.swing.JFrame;

class PagingTutorGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Paging Tutor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PagingTutorPanel panel = new PagingTutorPanel();
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}
}
