package tv.danmaku.ijk.media.example.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;

import tv.danmaku.ijk.media.example.widget.media.IjkVideoView;

public class DrawableIjkVideoView extends IjkVideoView {
    Paint paint = new Paint();
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            postInvalidate();
            handler.postDelayed(this, 1000);
        }
    };

    public DrawableIjkVideoView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public DrawableIjkVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public DrawableIjkVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
    }

    public DrawableIjkVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
    }

    @Override
    protected void onFinishInflate() {
        handler.postDelayed(runnable, 1000);
        super.onFinishInflate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawRect(30, 330, 80, 780, paint);
        paint.setStrokeWidth(0);
        paint.setColor(Color.CYAN);
        canvas.drawRect(33, 360, 77, 777, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(33, 333, 77, 760, paint);

        super.onDraw(canvas);
    }
}
