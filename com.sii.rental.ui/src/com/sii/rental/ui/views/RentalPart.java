package com.sii.rental.ui.views;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.opcoach.training.rental.Rental;
import com.sii.rental.core.RentalCoreActivator;

public class RentalPart {

	private Label rentedObjectLabel;
	private Label dateFin;
	private Label dateDebut;
	private Label client;

	@PostConstruct
	public void createContent(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		infoGroup.setText("Information");
		infoGroup.setLayout(new GridLayout(3, false));
		new Label(infoGroup, SWT.NONE);

		rentedObjectLabel = new Label(infoGroup, SWT.BORDER);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel.setLayoutData(gd);
		new Label(infoGroup, SWT.NONE);

		Label nom = new Label(infoGroup, SWT.NONE);
		nom.setText("nom :");

		client = new Label(infoGroup, SWT.NONE);
		client.setText("New Label");

		Group datesGroup = new Group(parent, SWT.NONE);
		datesGroup.setLayout(new GridLayout(2, false));
		datesGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		datesGroup.setText("Dates de locations");

		Label du = new Label(datesGroup, SWT.NONE);
		du.setText("du :");

		dateDebut = new Label(datesGroup, SWT.NONE);
		dateDebut.setText("New Label");

		Label au = new Label(datesGroup, SWT.NONE);
		au.setText("au :");

		dateFin = new Label(datesGroup, SWT.NONE);
		dateFin.setText("New Label");
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
	}

	@Focus
	public void onFocus() {

	}

	public void setRental(Rental r) {
		rentedObjectLabel.setText(r.getRentedObject().getName());
	}
}