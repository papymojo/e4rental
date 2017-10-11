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
			RentalAgency a = (RentalAgency) parentElement;
			return new Node[] {new Node(Node.CUSTOMERS,a),new Node(Node.RENTAL,a),new Node(Node.OBJECTS,a)};
		} else if (parentElement instanceof Node) {
			return ((Node) parentElement).getChildren();
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

	class Node {
		private static final String CUSTOMERS = "Customers";
		private static final String RENTAL = "Locations";
		private static final String OBJECTS = "Objets à louer";
		private String label;
		private RentalAgency a;
		public Node(String label, RentalAgency a) {
			super();
			this.label = label;
			this.a = a;
		}
		public Object[] getChildren() {
			if(label == CUSTOMERS) {
				return a.getCustomers().toArray();
			}
			if(label == RENTAL) {
				return a.getRentals().toArray();
			}
			if(label == OBJECTS) {
				return a.getObjectsToRent().toArray();
			}
			return null;
		}
		public String toString() {
			return label;
		}
	}
}
