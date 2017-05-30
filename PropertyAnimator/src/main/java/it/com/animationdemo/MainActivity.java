package it.com.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View textView = findViewById(R.id.text);
        method05(textView);
    }

    private void method05(View textView) {
        textView.setScaleY(0.5f);//初始值
        textView.setScaleX(0.5f);//

        textView.setPivotX(1);//设置缩放中心点x
        textView.setPivotY(1);//设置缩放中心点y

        textView.setAlpha(0.3f);//初始值

        textView.animate()
                .setInterpolator(new BounceInterpolator())
                .setDuration(5000)
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f);
    }

    /**
     * xml的形式来加载和播放动画:在animator文件夹下面定义动画的xml文件
     * 在XML文件中我们一共可以使用如下三种标签：
     * <animator>           对应代码中的ValueAnimator
     * <objectAnimator>     对应代码中的ObjectAnimator
     * <set>                对应代码中的AnimatorSet
     */
    private void method03(View textView) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.set_demo);
        animator.setTarget(textView);
        animator.start();
    }

    //set组合动画
    private void method04(View textView) {
        //1.定义一系列动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(textView, "alpha", 1.0f, 0f, 1.0f, 0f, 1.0f, 0f, 1.0f);
        alpha.setDuration(20000);
        alpha.start();

        ObjectAnimator rotation = ObjectAnimator.ofFloat(textView, "rotation", 0, 360, 720);
        rotation.setDuration(2000);
        rotation.start();

        float curTranslationY = textView.getTranslationY();
        ObjectAnimator translationY = ObjectAnimator.ofFloat(textView, "translationY",
                -400f, curTranslationY, 500f, curTranslationY);
        translationY.setDuration(5000);
        translationY.start();

        ObjectAnimator scaleY = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 3f, 1f, 3f, 1f);
        scaleY.setDuration(5000);
        scaleY.start();

        //2. 组合播放动画集合
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alpha)
                .with(rotation)
                .with(translationY)
                .with(scaleY);//返回的是builder对象

        //3.动画的监听器.如果不需要键听那么多的方法的话,可以使用AnimatorListenerAdapter,这个类对方法进行了空实现,方便对部分时间的监听.
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {//动画开始的时候调用
                Log.i("AnimatorListener", "-------------------onAnimationStart-");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("AnimatorListener", "-------------------onAnimationEnd-");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i("AnimatorListener", "-------------------onAnimationCancel-");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i("AnimatorListener", "-------------------onAnimationRepeat-");
            }
        });

        animatorSet.start();
    }

    /**
     * ValueAnimator来操作一个对象
     * ofObject()用来对任意对象做动画操作;至于什么样的操作,需要配合TypeEvaluator来做.
     */
    private void method02() {
        PointF startPoint = new PointF(0f, 0f);
        PointF endPoint = new PointF(300f, 300f);
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        valueAnimator.setDuration(4000);
        valueAnimator.start();
    }

    /**
     * 1.ValueAnimator的基本用法：完成值得平滑过渡
     * ofFloat()方法用来操作一个float值
     * ofInt()用来操作一个int值
     */
    private void method01() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i("animation", "-----" + animation.getAnimatedValue());
            }
        });
        valueAnimator.start();
    }
}
