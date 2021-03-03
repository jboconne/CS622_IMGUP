package multipleImageUploadsDBGui;

import java.util.EventListener;

import multipleImageUploads.FormEvent;
/* This is FormListenerMultiple() interface that gets called by the MainFrame() class of the ImageUploader() class 
   It listens for any events that occur on the formPanel() class and uses the FormEvent() class as a input parameter 'e'
*/
public interface FormListener extends EventListener {
	public void formEventOccurred(FormEvent e);

	public void formEventOccurred(multipleImageUploadsDBGui.FormEvent ev);
}
