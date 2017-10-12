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
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((label == null) ? 0 : label.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			return true;
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

		private AgencyTreeProvider getOuterType() {
			return AgencyTreeProvider.this;
		}
	}
}
