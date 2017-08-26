import java.awt.event.ActionListener;

public interface IView {

	void init();

	void registerListener(ActionListener listener);

	void selectionMade(String option);

	void showData();
	
	String[] getArgs();
	
	void onError(Exception e);

}
