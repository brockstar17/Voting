package voting.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import voting.Voting;

@SuppressWarnings("serial")
public class Paint extends JPanel
{

	private int w = Voting.screenX;
	private int h = Voting.screenY;

	public static JButton[] btns = { new JButton("Vote for " + Voting.candidates[0]), new JButton("Vote for " + Voting.candidates[1]), new JButton("Vote for " + Voting.candidates[2]), new JButton("Vote for " + Voting.candidates[3]), new JButton("Reset Votes") };

	private Color[] clrs = { Color.RED, Color.BLACK, Color.BLUE, Color.GREEN };

	public Paint()
	{
		for(int i = 0; i < 5; i++)
		{

			this.add(btns[i]);
		}
	}

	// scale(Voting.logos[i], w, (int) (h * .07))

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(scale(Voting.background, w, h), 0, 0, null);

		g.setColor(Color.BLACK);

		double nw = 0.03;
		double nh = 0.15;

		for(int i = 0; i < 4; i++)
		{
			g.setColor(clrs[i]);

			if(Voting.votes[i] > 0)
			{
				// g.fillRect((int) (w - (w - (w * .1276))), (int) (h - ((h - ((h * .108) * ((i * 1.4) + 1))))), barScale(Voting.votes, Voting.totVotes, (int) (w - (w * .14)))[i], (int) (h * .07));
				// g.drawImage(Voting.logos[i], barScale(Voting.votes, Voting.totVotes, (int) (w - (w * .14)))[i], (int) (h - ((h - ((h * .108) * ((i * 1.4) + 1))))), null);
				g.drawImage(Voting.logos[i].getSubimage(0, 0, barScale(Voting.votes, Voting.totVotes, (int) (w - (w * .14)))[i], (int) (h * .07)), (int) (w - (w - (w * .1276))), (int) (h - ((h - ((h * .108) * ((i * 1.4) + 1))))), barScale(Voting.votes, Voting.totVotes, (int) (w - (w * .14)))[i], (int) (h * .07), null);
			}
		}

		g.setColor(Color.BLACK);

		Font fontNames = new Font("Serif", Font.PLAIN | Font.BOLD, 20);

		g.setFont(fontNames);

		for(int i = 0; i < Voting.candidates.length; i++)
		{

			g.drawString(Voting.candidates[i], (int) (w - (w - (w * nw))), (int) (h - ((h - (h * nh) * (i + 1)))));
			g.drawString(String.valueOf(Voting.votes[i]), (int) (w - (w - (w * nw))), (int) (h - ((h - (h * nh) * (i + 1.15)))));
		}

	}

	public static BufferedImage scale(BufferedImage img, int dWidth, int dHeight) {
		BufferedImage scaledImage = null;
		if(img != null)
		{
			scaledImage = new BufferedImage(dWidth, dHeight, img.getType());
			Graphics2D graphics2D = scaledImage.createGraphics();
			graphics2D.drawImage(img, 0, 0, dWidth, dHeight, null);
			graphics2D.dispose();
		}
		return scaledImage;
	}

	private int[] barScale(int[] vts, int total, int w) {
		double[] rts = new double[4];
		for(int i = 0; i < 4; i++)
		{
			rts[i] = (double) vts[i] / (double) total;
		}

		int[] bar = new int[4];
		for(int i = 0; i < 4; i++)
		{
			bar[i] = (int) (w * rts[i]);
		}
		// System.out.println("Ratios: " + rts[0] + " bar: " + bar[0]);
		return bar;
	}

}
