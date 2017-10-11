package com.sii.rental.ui;


import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.jface.viewers.ITreeContentProvider;

import com.opcoach.training.rental.RentalAgency;

public class AgencyTreeProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection<?>) {
			return ((Collection<?>) inputElement).toArray();
		}
		return (Object[]) inputElement;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		if (parentElement instanceof RentalAgency) {
			return ((RentalAgency) parentElement).getCustomers().toArray();
		}
			return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		
		return true;
	}



}
