package com.sii.rental.ui.prefs;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;

import com.opcoach.e4.preferences.ScopedPreferenceStore;
import com.sii.rental.ui.RentalUIConstants;

public class Initializer extends AbstractPreferenceInitializer implements RentalUIConstants{

	public Initializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore pstore = new ScopedPreferenceStore(InstanceScope.INSTANCE, PLUGIN_ID);
		pstore.setDefault(PREF_PALETTE, "com.sii.rental.ui.default");
	}

}
