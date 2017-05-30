package it.com.tweenanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

/**
 * 补间动画:
 * 1. 在文件夹/anim/下面定义补间动画的xml文件R.anim.alpha_demo,
 * 2. 在代码中调用AnimationUtils.loadAnimation(*,*);获得动画对象;
 * 3. 对需要进行动画播放的控件x.startAnimation(animation);即可对该控件调用动画.
 */
public class MainActivity extends AppCompatActivity {
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.text);
    }

    /**
     * 渐变动画: alpha
     * android:duration="2000"     时间间隔
     * android:fromAlpha="1.0"     渐变初始值
     * android:toAlpha="0.1"       结束值
     * android:interpolator="@android:anim/bounce_interpolator" 插速器
     *
     * @param view
     */
    public void alpha(View view) {
        //xml文件定义的
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_demo);
//        mText.startAnimation(animation);

        //代码中定义
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setInterpolator(new BounceInterpolator());
        mText.startAnimation(alphaAnimation);
    }

    /**
     * 缩放动画：scale
     * android:duration="2000"    时间间隔
     * android:fromXScale="1.0"   缩放起始值X
     * android:fromYScale="1.0"   缩放起始值Y
     * android:pivotX="50%"       缩放中心点的位置x
     * android:pivotY="50%"       缩放中心点的位置y
     * android:toXScale="0.5"     缩放结束值x
     * android:toYScale="0.5"     缩放结束值y
     *
     * @param view
     */
    public void scale(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_demo);
        mText.startAnimation(animation);
    }

    /**
     * 旋转动画 rotate
     * android:duration="2000"
     * android:fromDegrees="0"
     * android:pivotX="50%"       旋转中心点x
     * android:pivotY="50%"       旋转中心点y
     * android:toDegrees="270"    旋转到多少度
     *
     * @param view
     */
    public void rotate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_demo);
        mText.startAnimation(animation);
    }

    /**
     * x方向平移动画
     * android:duration="2000"
     * android:fromXDelta="10"    起始位置x
     * android:fromYDelta="10"    起始位置y
     * android:toXDelta="400"     结束位置x
     * android:toYDelta="400"     结束位置y
     *
     * @param view
     */
    public void translation(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translationx_demo);
        mText.startAnimation(animation);
    }

    /**
     * 系列动画集合
     *
     * @param view
     */
    public void set(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_demo);
        mText.startAnimation(animation);
    }
}
