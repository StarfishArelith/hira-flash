import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class hiraFlash extends JFrame
{
	private final JLabel output;
	private final JButton input;
	
	private boolean hiraBool = true;
	
	private ArrayList<Character> initList = new ArrayList<Character>();
	private ArrayList<Character> finlList = new ArrayList<Character>();
	
	int currentIndex = 0;
	
	public static void main(String[] args)
	{
		hiraFlash hf = new hiraFlash();
		hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hf.setSize(280,100);
		hf.setLocationRelativeTo(null);
		hf.setVisible(true);
	}
	
	public hiraFlash()
	{
		super("Hiragana Flash Card");
		
		fillListInit fli = new fillListInit();
		fli.initInitList();
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel mPanel = new JPanel();
		mPanel.setLayout(new GridLayout(1,0));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		add(mPanel,c);
		
		output = new JLabel("");
		output.setFont(new Font("Lucida Console Regular", Font.PLAIN, 30));
		mPanel.add(output,BorderLayout.CENTER);
		
		input = new JButton("Start"); 
		input.setFont(new Font("Arial", Font.PLAIN, 20));
		mPanel.add(input,BorderLayout.CENTER);
		
		inputHandler inputHandle = new inputHandler();
		input.addActionListener(inputHandle);
	}

	private class inputHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			if(initList.size() > 1)
			{
				if(hiraBool)
				{
					currentIndex = (int)(Math.random() * initList.size());
					output.setText(initList.get(currentIndex).getHiragana());
					input.setText("Reveal");
					hiraBool ^= true;
				}
				else
				{
					output.setText(initList.get(currentIndex).getHiragana() + "  " + initList.get(currentIndex).getRomaji());
					input.setText("Next");
					finlList.add(initList.get(currentIndex));
					initList.remove(currentIndex);
					hiraBool ^= true;
				}
			}
			else
			{
				if(hiraBool)
				{
					currentIndex = 0;
					output.setText(initList.get(currentIndex).getHiragana());
					input.setText("Reveal");
					hiraBool ^= true;
				}
				else
				{
					output.setText(initList.get(currentIndex).getHiragana() + "  " + initList.get(currentIndex).getRomaji());
					input.setText("Restart");
					finlList.add(initList.get(currentIndex));
					initList.remove(currentIndex);
					hiraBool ^= true;
					
					//reset
					for(Character c:finlList)
					{
						initList.add(c);
					}
					finlList.clear();
				}
			}
		}
	}

	private class Character
	{
		private String hiragana;
		private String romaji;

		Character(String h, String r)
		{
			hiragana = h;
			romaji = r;
		}

		public void setHiragana(String h)
		{
			hiragana = h;
		}

		public void setRomaji(String r)
		{
			romaji = r;
		}

		public String getHiragana()
		{
			return hiragana;
		}

		public String getRomaji()
		{
			return romaji;
		}
	}
	
	private class fillListInit
	{
		void initInitList()
		{
			initList.add(new Character("あ","A"));
			initList.add(new Character("い","I"));
			initList.add(new Character("う","U"));
			initList.add(new Character("え","E"));
			initList.add(new Character("お","O"));
			
			initList.add(new Character("か","KA"));
			initList.add(new Character("き","KI"));
			initList.add(new Character("く","KU"));
			initList.add(new Character("け","KE"));
			initList.add(new Character("こ","KO"));
			
			initList.add(new Character("さ","SA"));
			initList.add(new Character("し","SHI"));
			initList.add(new Character("す","SU"));
			initList.add(new Character("せ","SE"));
			initList.add(new Character("そ","SO"));
			
			initList.add(new Character("た","TA"));
			initList.add(new Character("ち","CHI"));
			initList.add(new Character("つ","TSU"));
			initList.add(new Character("て","TE"));
			initList.add(new Character("と","TO"));
			
			initList.add(new Character("な","NA"));
			initList.add(new Character("に","NI"));
			initList.add(new Character("ぬ","NU"));
			initList.add(new Character("ね","NE"));
			initList.add(new Character("の","NO"));
			
			initList.add(new Character("は","HA"));
			initList.add(new Character("ひ","HI"));
			initList.add(new Character("ふ","FU"));
			initList.add(new Character("へ","HE"));
			initList.add(new Character("ほ","HO"));
			
			initList.add(new Character("ま","MA"));
			initList.add(new Character("み","MI"));
			initList.add(new Character("む","MU"));
			initList.add(new Character("め","ME"));
			initList.add(new Character("も","MO"));
			
			initList.add(new Character("や","YA"));
			initList.add(new Character("ゆ","YU"));
			initList.add(new Character("よ","YO"));
			
			initList.add(new Character("ら","RA"));
			initList.add(new Character("り","RI"));
			initList.add(new Character("る","RU"));
			initList.add(new Character("れ","RE"));
			initList.add(new Character("ろ","RO"));
			
			initList.add(new Character("わ","WA"));
			initList.add(new Character("ゐ","WI"));
			initList.add(new Character("ゑ","WE"));
			initList.add(new Character("を","WO"));
			
			initList.add(new Character("ん","N"));
		}
	}
}