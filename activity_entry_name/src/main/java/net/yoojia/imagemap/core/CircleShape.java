package net.yoojia.imagemap.core;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Log;
import net.yoojia.imagemap.support.ScaleUtility;
import net.yoojia.imagemap.util.MatrixConverHelper;

public class CircleShape extends Shape
{

    private final PointF center = new PointF();
    private float radius = 10f;

    public CircleShape(Object tag, int coverColor)
    {
        super(tag, coverColor);
    }

    public CircleShape(Object tag, int coverColor,float radius)
    {
        super(tag, coverColor);
        this.radius=radius;
    }

    /**
     * Set Center,radius
     * 
     * @param coords
     *            centerX,CenterY,radius
     */
    @Override
    public void setValues(float... coords)
    {
        final float centerX = coords[0];
        final float centerY = coords[1];

        this.center.set(centerX, centerY);

        if (coords.length > 2)
        {
            this.radius = coords[2];
        }

    }

    public void setRadius(float radius)
    {
        this.radius = radius;
    }

    @Override
    public PointF getCenterPoint()
    {
        return MatrixConverHelper.mapMatrixPoint(mOverMatrix, center.x, center.y);
    }

    @Override
    public void draw(Canvas canvas)
    {
    	PointF f = MatrixConverHelper.mapMatrixPoint(mOverMatrix, center.x, center.y);
        canvas.drawCircle(f.x, f.y, radius, drawPaint);
    }

    @Override
    public void scaleBy(float scale, float centerX, float centerY)
    {
//        PointF newCenter = ScaleUtility.scaleByPoint(center.x, center.y,
//                centerX, centerY, scale);
//        radius *= scale;
//        center.set(newCenter.x, newCenter.y);
    }

    @Override
    public void onScale(float scale)
    {
//        radius *= scale;
//        center.set(center.x *= scale, center.y *= scale);
    }

    @Override
    public void translate(float deltaX, float deltaY)
    {
//        center.x += deltaX;
//        center.y += deltaY;
    }

    @Override
    public boolean inArea(float x, float y)
    {
        boolean ret = false;
        float dx = center.x - Math.abs(x);
        float dy = center.y - Math.abs(y);
        float d = new Float(Math.sqrt((dx * dx) + (dy * dy))).floatValue();
        if (d < radius)
        {
            ret = false;  //change for vins test
        }
        return ret;
    }

    @Override
    public String getUrl()
    {
        return null;
    }

    @Override
    public String getPictureUrl()
    {
        return null;
    }

    @Override
    public String getContent()
    {
        return null;
    }

    @Override
    public String getTitle()
    {
        return null;
    }

    @Override
    public boolean bubbleTag()
    {
        return false;
    }

	@Override
	public float getCenterX() {
		return center.x;
	}

	@Override
	public float getCenterY() {
		return center.y;
	}

}
