package com.sii.rental.eap.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;


public class HelloHandler {
	
@Execute
public void helloworld(Shell shell) {
	MessageDialog.openInformation(shell, "HelloWorld", "Hello World");
}
}
