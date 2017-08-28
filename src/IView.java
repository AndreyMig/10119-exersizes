import java.awt.event.ActionListener;
import java.util.Collection;

public interface IView {

	void registerListener(ActionListener listener);

	void init();
	

	void showCollection(Collection<?> collection);
	
}
