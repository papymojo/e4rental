package com.sii.rental.ui;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;

public class AgencyLabelProvider extends LabelProvider {

	
	@Override
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

@Override
public String getText(Object element) {
	if (element instanceof RentalAgency)
		return ((RentalAgency) element).getName();
	else if (element instanceof Customer)
		return ((Customer) element).getDisplayName();
	// TODO Auto-generated method stub
	return super.getText(element);
}

}
