import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.javafx.geom.CubicCurve2D;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;

public class EngineBody {

    public static Cone getCone(float height, float radius, Appearance app) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(radius, height, primflags, app);
    }
    public static Cylinder getCylinder(float radius, float height, Appearance app) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(radius, height, primflags, app);
    }
    public static Cylinder getCylinderMiddle(float radius, float height, Appearance app) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(radius, height, primflags, app);
    }

    public static Box getBox(float x, float y, float z, Appearance app) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(x, y, z, primflags, app);
    }


    public static Appearance getAppearence(Color color) {

        Appearance ap = new Appearance();

        Color3f c = new Color3f(color);
        Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
        Color3f white = new Color3f(.0f, .0f, .0f);

        ap.setMaterial(new Material(c, black, c, white, 1.0f));
        return ap;
    }
}