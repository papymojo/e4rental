package com.sii.rental.ui.prefs;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;

import com.sii.rental.ui.RentalUIConstants;

public class ColorPrefPage extends FieldEditorPreferencePage implements RentalUIConstants {

	public ColorPrefPage() {
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
		addField(new ColorFieldEditor(PREF_CUSTOMER_COLOR,"Couleur Customer",getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_RENTAL_OBJECT_COLOR,"Couleur Rental Object",getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_RENTAL_COLOR,"Couleur Rental",getFieldEditorParent()));
	}

}
