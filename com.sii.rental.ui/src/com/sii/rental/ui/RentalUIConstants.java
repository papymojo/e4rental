package com.sii.rental.ui;


/**
 * Constant definitions for plug-in preferences, keys for colors, and to
 * identify objects nature.
 */
public interface RentalUIConstants
{

	public static final String PLUGIN_ID = "com.sii.rental.ui";
	public static final String RENTAL_UI_PREF_STORE = PLUGIN_ID + ".preferenceStore";
	public static final String RENTAL_UI_IMG_REGISTRY = PLUGIN_ID + ".imageRegistry";
	public static final String PALETTE_MANAGER = PLUGIN_ID +  ".paletteManager";

	// Constants to manage object images in registry. Constant values are path to icons
	public static final String IMG_AGENCY = "icons/Agency.png";
	public static final String IMG_CUSTOMER = "icons/Customers.png";
	public static final String IMG_RENTAL = "icons/Rentals.png";
	public static final String IMG_RENTAL_OBJECT = "icons/RentalObjects.png";
	public static final String IMG_COLLAPSE_ALL = "icons/collapseall.gif";
	public static final String IMG_EXPAND_ALL = "icons/expandall.gif";

	// Preferences constants

	public static final String PREF_PALETTE = "prefPalette";
	public static final String PREF_CUSTOMER_COLOR = "CustomerColor";
	public static final String PREF_RENTAL_COLOR = "RentalColor";
	public static final String PREF_RENTAL_OBJECT_COLOR = "RentalObjectColor";
	public static final String NONE_PALETTE = "com.opcoach.training.e4.rental.ui.NonePalette";

	public static final String PREF_DISPLAY_COUNT = "displayCounterPref";

}