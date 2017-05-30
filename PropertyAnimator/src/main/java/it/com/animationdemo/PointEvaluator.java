package it.com.animationdemo;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by tony on 2017/4/28.
 */

/**
 * 是一个求值器,根据传入的两个对象封装的数据,以及我们想要的函数来计算一个新的值,并返回回去.
 */
public class PointEvaluator implements TypeEvaluator<PointF> {
    /**
     *
     * @param fraction      这里的fraction相当于是初始值距离目标值的一个比例.比例.比例.
     * @param startValue
     * @param endValue
     * @return
     */
    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
        float startX = startValue.x;
        float startY = startValue.y;
        float endX = endValue.x;
        float endY = endValue.y;
        float currentX = startX + fraction * (endX - startX);
        float currentY = startY + fraction * (endY - startY);
        return new PointF(currentX, currentY);//得到了一个新的点.
    }
}
