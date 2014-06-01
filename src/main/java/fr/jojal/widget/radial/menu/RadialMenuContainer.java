package fr.jojal.widget.radial.menu;

import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.scene.input.MouseEvent;

/**
 * @author Jordan Mens
 */

public class RadialMenuContainer extends RadialMenuItem {

	private ObservableList<RadialMenuItem> items = FXCollections.observableArrayList();
	private BooleanProperty isChildrenVisible;
    private BooleanProperty isChildrenCenterOnParent;
    private BooleanProperty isSeparatorEnable;
	

	public RadialMenuContainer() {

		setChildrenVisible(false);
		
		getPath().addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
			setChildrenVisible(!isChildrenVisible());
			event.consume();
        });

		items.addListener((InvalidationListener) obs -> update());
	}
	

	protected void updateChildren() {
		if(items.size() == 0) return;
		//TODO Radial separator
		double radialItemLenght = 360 / items.size();
		
		for(int i = 0; i < items.size(); i++) {

			RadialMenuItem radialMenuItem = items.get(i);
			
			double parentInnerRadius = radialMenuItem.getParentItem().getInnerRadius();
            double parentOuterRadius = radialMenuItem.getParentItem().getOuterRadius();
            double parentArcLenght = radialMenuItem.getParentItem().getLength();

            double newInnerRadius = parentOuterRadius;
            double newOuterRadius = parentOuterRadius + (parentOuterRadius - parentInnerRadius);

            double ratio = parentOuterRadius / newOuterRadius;
            double newArcLenght = parentArcLenght * ratio;
            //double newArcLenght = radialItemLenght;

            double startAngle = radialMenuItem.getParentItem().getStartAngle(); //+ ((newArcLenght - parentArcLenght) / 2);
            if(isChildrenCenterOnParent()) {
                //TODO Check the calculation to center items on their parent
                startAngle -= (items.size() * newArcLenght) / 2 - (newArcLenght/2);
            }


            radialMenuItem.setInnerRadius(newInnerRadius);
			radialMenuItem.setOuterRadius(newOuterRadius);
			radialMenuItem.setStartAngle(i * newArcLenght + startAngle);
			radialMenuItem.setLength(newArcLenght);
			radialMenuItem.setGap(radialMenuItem.getParentItem().getGap());
			radialMenuItem.setVisible(isChildrenVisible());
			
			if (radialMenuItem instanceof RadialMenuContainer) {
                ((RadialMenuContainer) radialMenuItem).updateChildren();
			}
		}
	}

	public void addItem(RadialMenuItem item) {
		item.setParentItem(this);
		items.add(item);
		
		getChildren().add(item);
	}


    public ObservableList<RadialMenuItem> getItems() {
		return items;
	}
    
    /************************************************************/
    public final BooleanProperty isChildrenVisibleProperty() {
        if (isChildrenVisible == null) {
        	isChildrenVisible = new SimpleBooleanProperty(this, "isChildrenVisible") {
        		@Override
        		protected void invalidated() {
        			for(RadialMenuItem item : items) {
        				item.setVisible(get());
                        PseudoClass selectedClass = PseudoClass.getPseudoClass("selected");
                        getPath().pseudoClassStateChanged(selectedClass, isChildrenVisible());
        			}
        		}
        	};
        }
        return isChildrenVisible;
    }
    
    public final boolean isChildrenVisible() {
    	return isChildrenVisibleProperty().get();
    }
    
    public final void setChildrenVisible(boolean isChildrenVisible) {
    	this.isChildrenVisibleProperty().set(isChildrenVisible);
    }
    /************************************************************/
    public final BooleanProperty isChildrenCenterOnParentProperty() {
        if (isChildrenCenterOnParent == null) {
            isChildrenCenterOnParent = new SimpleBooleanProperty(this, "isChildrenCenterOnParent") {
                @Override
                protected void invalidated() {
                    updateChildren();
                }
            };
        }
        return isChildrenCenterOnParent;
    }

    public final boolean isChildrenCenterOnParent() {
        return isChildrenCenterOnParentProperty().get();
    }

    public final void setChildrenCenterOnParent(boolean childrenCenterOnParent) {
        this.isChildrenCenterOnParentProperty().set(childrenCenterOnParent);
    }
    /************************************************************/
    public final BooleanProperty isSeparatorEnableProperty() {
        if (isSeparatorEnable == null) {
            isSeparatorEnable = new SimpleBooleanProperty(this, "isSeparatorEnable") {
                @Override
                protected void invalidated() {
                    updateChildren();
                }
            };
        }
        return isSeparatorEnable;
    }

    public final boolean isSeparatorEnable() {
        return isSeparatorEnableProperty().get();
    }

    public final void setSeparatorEnable(boolean separatorEnable) {
        this.isSeparatorEnableProperty().set(separatorEnable);
    }

//	private int computeLevel(int level) {
//		
//		if(this instanceof RadialMenuItem) {
//			return level;
//		}
//		
//		if(getParentItem() == null) {
//			return level;
//		}
//		
//		return ((RadialMenuContainer)getParentItem()).computeLevel(level + 1);
//	}
}
