
package com.sii.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.opcoach.training.rental.RentalAgency;
import com.sii.rental.ui.AgencyLabelProvider;
import com.sii.rental.ui.AgencyTreeProvider;
import com.sii.rental.ui.RentalUIConstants;

public class AgencyPart implements RentalUIConstants{

	private TreeViewer tv;

	@PostConstruct
	public void postConstruct(Composite parent,RentalAgency a,EMenuService ms,ESelectionService esel, IEclipseContext ctx) {
		tv = new TreeViewer(parent);
		tv.setContentProvider(new AgencyTreeProvider());
		AgencyLabelProvider p = ContextInjectionFactory.make(AgencyLabelProvider.class,ctx);
		tv.setLabelProvider(p);
		Collection<RentalAgency> datas = new ArrayList<>();
		datas.add(a);
		ms.registerContextMenu(tv.getControl(), "com.sii.rental.eap.popupmenu.0");
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
	
	@Inject @Optional
	public void refreshTree(@Preference(value=PREF_CUSTOMER_COLOR) String cCustomer,
			@Preference(value=PREF_RENTAL_COLOR) String cRental,
			@Preference(value=PREF_RENTAL_OBJECT_COLOR) String cObject) {
		if (tv != null && !tv.getControl().isDisposed())
			tv.refresh();
	}
	

}