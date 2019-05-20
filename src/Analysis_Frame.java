/**
 * Class CiphersFrame that contains the required code to display the window
 * and its contents.
 * 
 * @autor Mahmoud Abdelrahman, Mulhamam Alisali, Nawid Shadab
 * 
 */
import java.awt.event.*;
import javax.swing.*;




public class Analysis_Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Analysis_Frame(){
		super("Cäsar Analysis");
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		Analysis_Model model = new Analysis_Model(this);
		Analysis_View view = new Analysis_View(model);
		getContentPane().add(view);
		pack();
	}
	
	public static void main(String[] args)  {
		Analysis_Frame f = new Analysis_Frame();
		f.setVisible(true);
		
	}

}