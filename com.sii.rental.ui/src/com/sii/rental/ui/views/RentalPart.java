package com.sii.rental.ui.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;

public class RentalPart {

	private Label rentedObjectLabel;
	private Label dateFin;
	private Label dateDebut;
	private Label client;

	@Inject
	public RentalPart(Composite parent,RentalAgency a) {
		parent.setLayout(new GridLayout(1, false));

		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		infoGroup.setText("Information");
		infoGroup.setLayout(new GridLayout(3, false));
		new Label(infoGroup, SWT.NONE);

		rentedObjectLabel = new Label(infoGroup, SWT.BORDER);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel.setLayoutData(gd);

		Label nom = new Label(infoGroup, SWT.NONE);
		nom.setText("nom :");

		client = new Label(infoGroup, SWT.NONE);
		client.setText("New Label");
		new Label(infoGroup, SWT.NONE);

		Group datesGroup = new Group(parent, SWT.NONE);
		datesGroup.setLayout(new GridLayout(2, false));
		datesGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		datesGroup.setText("Dates de locations");

		Label du = new Label(datesGroup, SWT.NONE);
		du.setText("du :");

		dateDebut = new Label(datesGroup, SWT.NONE);
		dateDebut.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		dateDebut.setText("New Label");

		Label au = new Label(datesGroup, SWT.NONE);
		au.setText("au :");

		dateFin = new Label(datesGroup, SWT.NONE);
		dateFin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		dateFin.setText("New Label");
	}

	@Focus
	public void onFocus() {

	}

	public void setRental(Rental r) {
		if (r != null) {
			rentedObjectLabel.setText(r.getRentedObject().getName());
			client.setText(r.getCustomer().getFirstName()+ " " +r.getCustomer().getLastName());
			dateDebut.setText(r.getStartDate().toString());
			dateFin.setText(r.getEndDate().toString());
		} else {
			rentedObjectLabel.setText("");
			client.setText("");
			dateDebut.setText("");
			dateFin.setText("");	
		}

	}
	
	@Inject 
	@Optional 
	public void listenToSel(@Named(IServiceConstants.ACTIVE_SELECTION) Rental r) {
		setRental(r);
	}
	}