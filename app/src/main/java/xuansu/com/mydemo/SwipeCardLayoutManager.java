package xuansu.com.mydemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by xuansu on 2017/7/3.
 */

public class SwipeCardLayoutManager extends LayoutManager {
    Context  mCxt;
    public SwipeCardLayoutManager(Context  mCxt) {
        this.mCxt=mCxt;
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams( (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                270,
                mCxt.getResources().getDisplayMetrics()),
                (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 330,
                mCxt.getResources().getDisplayMetrics()));
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        detachAndScrapAttachedViews(recycler);
        int  itemCount=getItemCount();
        int  startPosition;
        if(itemCount<4){
            startPosition=0;
        }else{
            startPosition=getItemCount()-4;
        }

        for(int i=startPosition;i<itemCount;i++){
            //   从当前位置获取视图
           View  mView= recycler.getViewForPosition(i);
            //   把视图添加上
            addView(mView);
            //  计算视图的大小
            measureChild(mView,0,0);

            //  获取当前的图片占用后剩余的宽度
            int specWith=getWidth()-getDecoratedMeasuredWidth(mView);
            int  specHight=getHeight()-getDecoratedMeasuredHeight(mView);
            layoutDecorated(mView,specWith/2,specHight/2,
                    specWith/2+getDecoratedMeasuredWidth(mView),
                    specHight/2+getDecoratedMeasuredHeight(mView));
            int  level=itemCount-i-1;
//            mView.setTranslationY(MainActivity.TRANS_Y_GAP*level);
            mView.setScaleX(1-0.05f*level);
            mView.setScaleY(1-0.05f*level);
            if (level < 4 -1) {
                mView.setTranslationY(MainActivity.TRANS_Y_GAP* level);
            } else {
                mView.setTranslationY(MainActivity.TRANS_Y_GAP* (level - 1));
            }
        }

    }
}
