import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ConsoleView implements IView {
	private ArrayList<ActionListener> listeners = new ArrayList<ActionListener>();

	@Override
	public void registerListener(ActionListener listener) {
		this.listeners.add(listener);

	}

	@Override
	public void init() {
		Scanner s = new Scanner(System.in);
		String op = "";
		while (op.compareToIgnoreCase("-1") != 0) {
			System.out.println("choose");

			op = s.nextLine();
			proccessEvent(op);

		}
		
		s.close();

	}

	private void proccessEvent(String command) {

		for (ActionListener actionListener : listeners) {
			actionListener.actionPerformed(new ActionEvent(this, -1, command));
		}

	}

	@Override
	public void showCollection(Collection<?> collection) {
		for (Object object : collection) {
			System.out.println(object);
		}
		
	}

}
