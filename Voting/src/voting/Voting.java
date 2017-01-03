package voting;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

import voting.graphics.Paint;

@SuppressWarnings("serial")
public class Voting extends JFrame implements ActionListener
{

	public static BufferedImage background = null;
	public static BufferedImage[] logos = { null, null, null, null }; // brock, owen, vock, oven

	public static String[] candidates = { "Brock", "Owen", "Vock", "Oven" };
	public static int[] votes = { 0, 0, 0, 0 };
	public static int totVotes;

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenX = (int) screenSize.getWidth() - 10;
	public static int screenY = (int) screenSize.getHeight() - 50;

	public Voting()
	{
		super("Voting");
		Container c = getContentPane();
		c.add(new Paint());

		for(int i = 0; i < 5; i++)
		{
			Paint.btns[i].addActionListener(this);
		}

		try
		{
			background = ImageIO.read(new File("resources/background.png"));
			logos[1] = ImageIO.read(new File("resources/altBrock.png"));
			logos[0] = ImageIO.read(new File("resources/brock.png"));
			logos[3] = ImageIO.read(new File("resources/oven.png"));
			logos[2] = ImageIO.read(new File("resources/vock.png"));

			for(int i = 0; i < logos.length; i++)
			{
				logos[i] = Paint.scale(logos[i], screenX, (int) (screenY * .07));
			}
		} catch (IOException e)
		{
		}

	}

	public static void main(String[] args) {

		Voting frame = new Voting();

		frame.setSize(screenX, screenY);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if(button == Paint.btns[0])
		{
			// System.out.println(candidates[0] + ":" + votes[0]);
			votes[0]++;
			totVotes++;
		}
		else if(button == Paint.btns[1])
		{
			// System.out.println(candidates[1] + ":" + votes[1]);
			votes[1]++;
			totVotes++;
		}
		else if(button == Paint.btns[2])
		{
			// System.out.println(candidates[2] + ":" + votes[2]);
			votes[2]++;
			totVotes++;
		}
		else if(button == Paint.btns[3])
		{
			// System.out.println(candidates[3] + ":" + votes[3]);
			votes[3]++;
			totVotes++;
		}
		else if(button == Paint.btns[4])
		{
			votes[0] = 0;
			votes[1] = 0;
			votes[2] = 0;
			votes[3] = 0;
			totVotes = 0;
		}
		else
		{
			System.out.println("No Candidate found");
		}

		repaint();
	}

}
