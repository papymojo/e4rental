
package com.sii.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.opcoach.training.rental.RentalAgency;
import com.sii.rental.ui.AgencyLabelProvider;
import com.sii.rental.ui.AgencyTreeProvider;

public class AgencyPart {

	@PostConstruct
	public void postConstruct(Composite parent,RentalAgency a) {
		TreeViewer tv = new TreeViewer(parent);
		tv.setContentProvider(new AgencyTreeProvider());
		tv.setLabelProvider(new AgencyLabelProvider());
		Collection<RentalAgency> datas = new ArrayList<>();
		datas.add(a);
		tv.setInput(datas);
		tv.expandAll();
	}

}