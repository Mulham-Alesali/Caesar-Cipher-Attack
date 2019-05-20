/**
 * Class CiphersView that contains the view code for the project.
 * 
 * @autor Mahmoud Abdelrahman, Mulhamam Alisali, Nawid Shadab
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;



public class Analysis_View extends JPanel implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	Analysis_Model model;
	JButton btnclear = new JButton("clear");
	JButton btnopenCipherText = new JButton("openCipherText");
	
	JButton btndechiffrieren = new JButton("Analyse");
	
	JTextArea klartext = new JTextArea(20,20);	
	JTextArea cipherText = new JTextArea(20,20);
	
	JScrollPane scrollpane = new JScrollPane(klartext);
	JScrollPane scrollpane2 = new JScrollPane(cipherText);

	
	@SuppressWarnings("unused")
	private static File openFile(Frame f) {
		 
        String filename = File.separator + "txt";
        JFileChooser fileChooser = new JFileChooser(new File(filename));
 
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // only directories
         fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // only files 
        // pop up an "Open File" file chooser dialog
        fileChooser.showOpenDialog(f);

        return fileChooser.getSelectedFile();
 
    }
	
	
	
	public Analysis_View(Analysis_Model model)  {
		this.model = model;
		model.addPropertyChangeListener(this);
		setBackground(Color.lightGray);
		
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
		JLabel label1 = new JLabel("klartext");
		label1.setAlignmentY(TOP_ALIGNMENT);
		box.add(label1);
		box.add(Box.createVerticalStrut(5));
		klartext.setAlignmentX(LEFT_ALIGNMENT);
		klartext.setLineWrap(true);
	
		
		scrollpane.setPreferredSize(new Dimension(400,400));
		box.add(scrollpane, klartext);
		add(box);
		
		Box box2 = Box.createVerticalBox();
		box2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
		
		
		box2.add(Box.createVerticalStrut(20));
		
		
		
		
		box2.add(Box.createVerticalStrut(20));
		btnopenCipherText.addActionListener(this);
		btnopenCipherText.setAlignmentX(LEFT_ALIGNMENT);
		btnopenCipherText.setAlignmentY(TOP_ALIGNMENT);
		box2.add(btnopenCipherText);
		
		box2.add(Box.createVerticalStrut(20));
		btnclear.addActionListener(this);
		btnclear.setAlignmentX(LEFT_ALIGNMENT);
		btnclear.setAlignmentY(TOP_ALIGNMENT);
		box2.add(btnclear);
		
		
		
		box2.add(Box.createVerticalStrut(20));
		btndechiffrieren.addActionListener(this);
		btndechiffrieren.setAlignmentX(LEFT_ALIGNMENT);
		btndechiffrieren.setAlignmentY(TOP_ALIGNMENT);
		box2.add(btndechiffrieren);
		
		add(box2);
		
		
		Box box3 = Box.createVerticalBox();
		box3.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 50));
		box3.add(new JLabel("cipher Text"));
		box3.add(Box.createVerticalStrut(5));
		cipherText.setAlignmentX(LEFT_ALIGNMENT);
		cipherText.setLineWrap(true);
		scrollpane2.setPreferredSize(new Dimension(400,400));
		box3.add(scrollpane2, cipherText);
		box3.add(Box.createVerticalStrut(15));
		add(box3);	

	}

	/**
	 * In this method, we check which action is performed
	 * and regarding the action, we implement the code required.
	 */
	public void actionPerformed(ActionEvent e)  {		
		
		if(e.getSource() == btnclear) {
			this.cipherText.setText("");
			this.klartext.setText("");
			readInput();
		}
		else if(e.getSource() == btndechiffrieren) {
			
			try
			{
				if(this.cipherText.getText().equals(""))
				{
					throw new Exceptions("Chipher Text darf nicht leer sein!");

				}
				readInput();
				model.dechiffrieren();
			}
			catch(Exceptions e1)
			{
				JOptionPane.showMessageDialog(this,
						e1.getMessage(),"Eingabefehler",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if(e.getSource() == btnopenCipherText) {
			model.setFile(openFile(model.getFrame()));
			try {
				this.cipherText.setText(model.readFile(model.getFile()));
				readInput();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (Exceptions e1) {
				// TODO Auto-generated catch block
		        JOptionPane.showMessageDialog(null ,e1.getMessage(), "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void readInput() {
		model.setKlartext(this.klartext.getText());
		model.setCiphertext(this.cipherText.getText());
	}
	
	
	
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		
		
		String pn = e.getPropertyName();
	
		switch(pn) {

		case Analysis_Model.VIGENERE_DE:
			klartext.setText((String) e.getNewValue());
			break;
		default: 
			throw new IllegalArgumentException("Unknown property name: "+pn);
		}
	}
	
}


