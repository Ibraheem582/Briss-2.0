/**
 *
 */
package at.laborg.briss.gui;

import java.awt.Point;
import java.awt.Rectangle;

public class DrawableCropRect extends Rectangle {

    private static final long serialVersionUID = -8836495805271750636L;

    static final int CORNER_DIMENSION = 20;

    private boolean selected = false;

    /**
     * Copy constructor.
     *
     * @param crop
     */
    public DrawableCropRect(final DrawableCropRect crop) {
        super();
        this.x = crop.x;
        this.y = crop.y;
        this.height = crop.height;
        this.width = crop.width;
    }

    public DrawableCropRect() {
        super();
    }

    public final boolean isSelected() {
        return selected;
    }

    public final void setSelected(final boolean selected) {
        this.selected = selected;
    }

    public final void setNewHotCornerUL(final Point p) {
        resizeToCoordinates(p.x, p.y, (int) getMaxX(), (int) getMaxY());
    }

    public final void setNewHotCornerLR(final Point p) {
        resizeToCoordinates(x, y, p.x, p.y);
    }

    public final void setNewHotCornerUR(final Point p) {
        resizeToCoordinates(x, p.y, p.x, (int) getMaxY());
    }

    public final void setNewHotCornerLL(final Point p) {
        resizeToCoordinates(p.x, y, (int) getMaxX(), p.y);
    }

    public final boolean containsInHotCornerUL(final Point p) {
        return ((p.x > getX() && p.x <= getX() + CORNER_DIMENSION) && (p.y > getY() && p.y <= getY() + CORNER_DIMENSION));
    }

    public final boolean containsInHotCornerLR(final Point p) {
        return ((p.x < getMaxX() && p.x > getMaxX() - CORNER_DIMENSION) && (p.y < getMaxY() && p.y > getMaxY()
            - CORNER_DIMENSION));
    }

    public final boolean containsInHotCornerUR(final Point p) {
        return ((p.x < getMaxX() && p.x > getMaxX() - CORNER_DIMENSION) && (p.y > getY() && p.y <= getY() + CORNER_DIMENSION));
    }

    public final boolean containsInHotCornerLL(final Point p) {
        return ((p.x > getX() && p.x <= getX() + CORNER_DIMENSION) && (p.y < getMaxY() && p.y > getMaxY()
                - CORNER_DIMENSION));
    }

    public final void resizeToCoordinates(int xUL, int yUL, int xLR, int yLR) {
        setSize(xLR - xUL, yLR - yUL);

        x = xUL;
        y = yUL;
    }
}
