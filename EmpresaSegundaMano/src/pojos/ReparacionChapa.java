package pojos;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author a16jorgemf
 */
public class ReparacionChapa extends Reparacion {

    private Color colorChapa;

    public ReparacionChapa(Color colorChapa, Date fecha, String descripcion, Taller taller) {
        super(fecha, descripcion, taller);
        this.colorChapa = colorChapa;
    }

    public ReparacionChapa() {
    }

    public Color getColorChapa() {
        return colorChapa;
    }

    public void setColorChapa(Color colorChapa) {
        this.colorChapa = colorChapa;
    }

}
