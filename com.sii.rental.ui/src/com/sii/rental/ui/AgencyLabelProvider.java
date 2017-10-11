package com.sii.rental.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;

public class AgencyLabelProvider extends LabelProvider implements IColorProvider,RentalUIConstants{

	@Inject @Named(RENTAL_UI_IMG_REGISTRY)
	private ImageRegistry registry;
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof RentalAgency)
			return registry.get(IMG_AGENCY);
		else if (element instanceof Customer)
			return registry.get(IMG_CUSTOMER);
		else if (element instanceof RentalObject)
			return registry.get(IMG_RENTAL_OBJECT);
		else if (element instanceof Rental)
			return registry.get(IMG_RENTAL);
		// TODO Auto-generated method stub		
		return null;
	}

@Override
public String getText(Object element) {
	if (element instanceof RentalAgency)
		return ((RentalAgency) element).getName();
	else if (element instanceof Customer)
		return ((Customer) element).getDisplayName();
	else if (element instanceof RentalObject)
		return ((RentalObject) element).getName();
	else if (element instanceof Rental)
		return ((Rental) element).toString();
	// TODO Auto-generated method stub
	return super.getText(element);
}

@Override
public Color getForeground(Object element) {
	if (element instanceof Customer) {
		return Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
	} else if (element instanceof Rental) {
		return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
	} else if (element instanceof RentalObject) {
		return Display.getCurrent().getSystemColor(SWT.COLOR_GREEN);
	} else if (element instanceof RentalAgency) {
		return Display.getCurrent().getSystemColor(SWT.COLOR_MAGENTA);
	}
	return null;
}

@Override
public Color getBackground(Object element) {
	// TODO Auto-generated method stub
	return null;
}

}
