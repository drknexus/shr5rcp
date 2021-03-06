/**
 * 2014 Urs Zeidler
 */
package de.urszeidler.eclipse.shr5.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
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

import de.urszeidler.eclipse.shr5.BaseMagischePersona;
import de.urszeidler.eclipse.shr5.FokusBinding;
import de.urszeidler.eclipse.shr5.Shr5Package;

/**
 * This is the item provider adapter for a {@link de.urszeidler.eclipse.shr5.FokusBinding} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FokusBindingItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider,
        ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FokusBindingItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addFokusPropertyDescriptor(object);
            addActivePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Fokus feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated not
     */
    protected void addFokusPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor// createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                        getString("_UI_FokusBinding_fokus_feature"), getString("_UI_PropertyDescriptor_description",
                                "_UI_FokusBinding_fokus_feature", "_UI_FokusBinding_type"), Shr5Package.Literals.FOKUS_BINDING__FOKUS, true, false,
                        true, null, null, null) {
                    @Override
                    public Collection<?> getChoiceOfValues(Object object) {
                        Collection<?> choiceOfValues = super.getChoiceOfValues(object);

                        FokusBinding binding = (FokusBinding)object;
                        EObject eContainer = binding.eContainer();
                        if (eContainer instanceof BaseMagischePersona) {
                            BaseMagischePersona p = (BaseMagischePersona)eContainer;
                            EObject container = p.eContainer();
                            List<Object> arrayList = new ArrayList<Object>(choiceOfValues.size());
                            for (Object o : choiceOfValues) {
                                if (o instanceof EObject) {
                                    EObject eo = (EObject)o;
                                    if (eo.eContainer().equals(container))
                                        arrayList.add(o);
                                }
                            }
                            return arrayList;
                        }
                        return Collections.EMPTY_SET;
                    }

                });
    }

    /**
     * This adds a property descriptor for the Active feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addActivePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_FokusBinding_active_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_FokusBinding_active_feature", "_UI_FokusBinding_type"),
                 Shr5Package.Literals.FOKUS_BINDING__ACTIVE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This returns FokusBinding.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/FokusBinding"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        FokusBinding fokusBinding = (FokusBinding)object;
        return getString("_UI_FokusBinding_type") + " " + fokusBinding.isActive();
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(FokusBinding.class)) {
            case Shr5Package.FOKUS_BINDING__ACTIVE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return Shr5EditPlugin.INSTANCE;
    }

}
