
package com.sii.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.opcoach.training.rental.RentalAgency;
import com.sii.rental.ui.AgencyLabelProvider;
import com.sii.rental.ui.AgencyTreeProvider;

public class AgencyPart {

	@PostConstruct
	public void postConstruct(Composite parent,RentalAgency a,ESelectionService esel, IEclipseContext ctx) {
		TreeViewer tv = new TreeViewer(parent);
		tv.setContentProvider(new AgencyTreeProvider());
		AgencyLabelProvider p = ContextInjectionFactory.make(AgencyLabelProvider.class,ctx);
		tv.setLabelProvider(p);
		Collection<RentalAgency> datas = new ArrayList<>();
		datas.add(a);
		tv.setInput(datas);
		tv.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection s = event.getStructuredSelection();
				esel.setSelection((s.size() == 1)?s.getFirstElement():s.toArray());
			}
		});
		tv.expandAll();
	}

}