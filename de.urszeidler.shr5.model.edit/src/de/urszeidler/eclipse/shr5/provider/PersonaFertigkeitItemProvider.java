/**
 */
package de.urszeidler.eclipse.shr5.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.urszeidler.eclipse.shr5.PersonaFertigkeit;
import de.urszeidler.eclipse.shr5.Shr5Package;

/**
 * This is the item provider adapter for a
 * {@link de.urszeidler.eclipse.shr5.PersonaFertigkeit} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class PersonaFertigkeitItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PersonaFertigkeitItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addStufePropertyDescriptor(object);
            addFertigkeitPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

	/**
	 * This adds a property descriptor for the Fertigkeit feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFertigkeitPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PersonaFertigkeit_fertigkeit_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_PersonaFertigkeit_fertigkeit_feature", "_UI_PersonaFertigkeit_type"),
                 Shr5Package.Literals.PERSONA_FERTIGKEIT__FERTIGKEIT,
                 true,
                 false,
                 true,
                 null,
                 null,
                 null));
    }

	/**
	 * This adds a property descriptor for the Stufe feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStufePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Steigerbar_stufe_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Steigerbar_stufe_feature", "_UI_Steigerbar_type"),
                 Shr5Package.Literals.STEIGERBAR__STUFE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

	/**
	 * This returns PersonaFertigkeit.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated not
	 */
	@Override
	public Object getImage(Object object) {
		PersonaFertigkeit personaFertigkeit = (PersonaFertigkeit) object;

		ComposeableAdapterFactory factory = ((Shr5ItemProviderAdapterFactory) this.adapterFactory).getRootAdapterFactory();
		if (factory != null && personaFertigkeit.getFertigkeit() != null) {
			IItemLabelProvider labelprovider = (IItemLabelProvider) factory.adapt(personaFertigkeit.getFertigkeit(),
					IItemLabelProvider.class);
			if (labelprovider != null)
				return labelprovider.getImage(personaFertigkeit.getFertigkeit());
		}

		return overlayImage(object, getResourceLocator().getImage("full/obj16/PersonaFertigkeit"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 * 
	 */
	@Override
	public String getText(Object object) {
		PersonaFertigkeit personaFertigkeit = (PersonaFertigkeit) object;

		ComposeableAdapterFactory factory = ((Shr5ItemProviderAdapterFactory) this.adapterFactory).getRootAdapterFactory();
		String fertigkeitName = "";
		if (factory != null && personaFertigkeit.getFertigkeit() != null) {
			IItemLabelProvider labelprovider = (IItemLabelProvider) factory.adapt(personaFertigkeit.getFertigkeit(),
					IItemLabelProvider.class);
			if (labelprovider != null)
				fertigkeitName = labelprovider.getText(personaFertigkeit.getFertigkeit()) + " : ";
		}
		return fertigkeitName + personaFertigkeit.getStufe();
	}

	/**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
     * @generated
     */
	@Override
	public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(PersonaFertigkeit.class)) {
            case Shr5Package.PERSONA_FERTIGKEIT__STUFE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
        return Shr5EditPlugin.INSTANCE;
    }

}
