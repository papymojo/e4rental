
package com.sii.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.opcoach.training.rental.RentalAgency;
import com.sii.rental.ui.AgencyLabelProvider;
import com.sii.rental.ui.AgencyTreeProvider;

public class AgencyPart {

	@PostConstruct
	public void postConstruct(Composite parent,RentalAgency a, IEclipseContext ctx) {
		TreeViewer tv = new TreeViewer(parent);
		tv.setContentProvider(new AgencyTreeProvider());
		AgencyLabelProvider p = ContextInjectionFactory.make(AgencyLabelProvider.class,ctx);
		tv.setLabelProvider(p);
		Collection<RentalAgency> datas = new ArrayList<>();
		datas.add(a);
		tv.setInput(datas);
		tv.expandAll();
	}

}