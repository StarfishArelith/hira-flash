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
			initList.add(new Character("???","A"));
			initList.add(new Character("???","I"));
			initList.add(new Character("???","U"));
			initList.add(new Character("???","E"));
			initList.add(new Character("???","O"));
			
			initList.add(new Character("???","KA"));
			initList.add(new Character("???","KI"));
			initList.add(new Character("???","KU"));
			initList.add(new Character("???","KE"));
			initList.add(new Character("???","KO"));
			
			initList.add(new Character("???","SA"));
			initList.add(new Character("???","SHI"));
			initList.add(new Character("???","SU"));
			initList.add(new Character("???","SE"));
			initList.add(new Character("???","SO"));
			
			initList.add(new Character("???","TA"));
			initList.add(new Character("???","CHI"));
			initList.add(new Character("???","TSU"));
			initList.add(new Character("???","TE"));
			initList.add(new Character("???","TO"));
			
			initList.add(new Character("???","NA"));
			initList.add(new Character("???","NI"));
			initList.add(new Character("???","NU"));
			initList.add(new Character("???","NE"));
			initList.add(new Character("???","NO"));
			
			initList.add(new Character("???","HA"));
			initList.add(new Character("???","HI"));
			initList.add(new Character("???","FU"));
			initList.add(new Character("???","HE"));
			initList.add(new Character("???","HO"));
			
			initList.add(new Character("???","MA"));
			initList.add(new Character("???","MI"));
			initList.add(new Character("???","MU"));
			initList.add(new Character("???","ME"));
			initList.add(new Character("???","MO"));
			
			initList.add(new Character("???","YA"));
			initList.add(new Character("???","YU"));
			initList.add(new Character("???","YO"));
			
			initList.add(new Character("???","RA"));
			initList.add(new Character("???","RI"));
			initList.add(new Character("???","RU"));
			initList.add(new Character("???","RE"));
			initList.add(new Character("???","RO"));
			
			initList.add(new Character("???","WA"));
			initList.add(new Character("???","WI"));
			initList.add(new Character("???","WE"));
			initList.add(new Character("???","WO"));
			
			initList.add(new Character("???","N"));
		}
	}
}