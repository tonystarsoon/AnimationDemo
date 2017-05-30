package it.com.animationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tony on 2017/4/28.
 */
public class MoveCircle extends View {
    private float CIRCLE_RADIUS = 100f;
    private Paint mPaint;
    private PointF mCurrentPoint;
    private String color;

    public MoveCircle(Context context) {
        super(context);
    }

    public MoveCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    public MoveCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mCurrentPoint == null) {
            mCurrentPoint = new PointF(CIRCLE_RADIUS, CIRCLE_RADIUS);
            drawCircle(canvas);
            startAnim();
        } else {
            drawCircle(canvas);
        }
    }

    //封装了画一个圆形的方法.
    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(mCurrentPoint.x, mCurrentPoint.y, CIRCLE_RADIUS, mPaint);
    }

    //通过使用一个数值的动画,来操作实际的坐标值,这样就可以控制view的位置,执行想要的动画效果.
    private void startAnim() {
        PointF endPoint = new PointF(CIRCLE_RADIUS, getHeight() - CIRCLE_RADIUS);
        ValueAnimator locationAnimator = ValueAnimator.ofObject(new PointEvaluator(), mCurrentPoint, endPoint);
        locationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint = (PointF) animation.getAnimatedValue();//获取到当前点的最新位置,
                invalidate();//执行onDraw方法
            }
        });
        locationAnimator.setDuration(3000);
        locationAnimator.setInterpolator(new MyInterploator());//自定义的差速器

        ObjectAnimator colorAnimator = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), "#0000FF", "#00FF00");
        colorAnimator.setDuration(3000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(colorAnimator).with(locationAnimator);
        animatorSet.start();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }
}
