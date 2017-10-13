package com.sii.rental.ui;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.opcoach.e4.preferences.ScopedPreferenceStore;
import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.core.helpers.RentalAgencyGenerator;

public class RentalAddon implements RentalUIConstants {
	private Map<String, Palette> palettemanager = new HashMap<>();

	@PostConstruct
	public void init(IEclipseContext ctx, IExtensionRegistry reg) {
		ctx.set(RentalAgency.class, RentalAgencyGenerator.createSampleAgency());
		ctx.set(RENTAL_UI_IMG_REGISTRY, getLocalImageRegistry());
		ctx.set(RENTAL_UI_PREF_STORE, new ScopedPreferenceStore(InstanceScope.INSTANCE, PLUGIN_ID));
		printxmladdon(reg);
		initPalette(reg, ctx);
	}

	private void initPalette(IExtensionRegistry reg, IEclipseContext ctx) {
		IExtensionPoint exp = reg.getExtensionPoint("com.sii.rental.ui.palette");
		IExtension[] exps = exp.getExtensions();
		for (IExtension ext : exps) {
			for (IConfigurationElement elt : ext.getConfigurationElements()) {
				try {
					System.out.println(
							elt.getAttribute("id") + elt.getAttribute("name") + elt.getAttribute("paletteClass"));
					Bundle b = Platform.getBundle(elt.getNamespaceIdentifier());
					Class<?> clazz = b.loadClass(elt.getAttribute("paletteClass"));
					IColorProvider p = (IColorProvider) ContextInjectionFactory.make(clazz, ctx);
					Palette pal = new Palette();
					pal.setId(elt.getAttribute("id"));
					pal.setName("name");
					pal.setProvider(p);
					palettemanager.put(elt.getAttribute("id"),pal);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void printxmladdon(IExtensionRegistry reg) {
		IExtensionPoint exp = reg.getExtensionPoint("org.eclipse.e4.workbench.model");
		IExtension[] exps = exp.getExtensions();
		for (IExtension ext : exps) {
			for (IConfigurationElement elt : ext.getConfigurationElements()) {
				if (elt.getName().equals("fragment")) {
					System.out.println("fragment found in plugin :" + elt.getAttribute("uri") + " "
							+ elt.getNamespaceIdentifier());
				} else if (elt.getName().equals("processor")) {
					System.out.println("processor found for class :" + elt.getAttribute("class") + " "
							+ elt.getNamespaceIdentifier());
				}
			}
		}
	}

	ImageRegistry getLocalImageRegistry() {
		// Get the bundle using the universal method to get it from the current class
		Bundle b = FrameworkUtil.getBundle(getClass());

		// Create a local image registry
		ImageRegistry reg = new ImageRegistry();

		// Then fill the values...
		reg.put(IMG_CUSTOMER, ImageDescriptor.createFromURL(b.getEntry(IMG_CUSTOMER)));
		reg.put(IMG_RENTAL, ImageDescriptor.createFromURL(b.getEntry(IMG_RENTAL)));
		reg.put(IMG_RENTAL_OBJECT, ImageDescriptor.createFromURL(b.getEntry(IMG_RENTAL_OBJECT)));
		reg.put(IMG_AGENCY, ImageDescriptor.createFromURL(b.getEntry(IMG_AGENCY)));
		reg.put(IMG_COLLAPSE_ALL, ImageDescriptor.createFromURL(b.getEntry(IMG_COLLAPSE_ALL)));
		reg.put(IMG_EXPAND_ALL, ImageDescriptor.createFromURL(b.getEntry(IMG_EXPAND_ALL)));

		return reg;
	}

	@Inject
	@Optional
	void reactOnCopy(@UIEventTopic("rental/copy") Customer c) {
		System.out.println(c.getDisplayName() + " copié");
	}
}
