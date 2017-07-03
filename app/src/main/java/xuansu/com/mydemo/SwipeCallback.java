package xuansu.com.mydemo;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback;
import android.view.View;

import java.util.List;

/**
 * Created by xuansu on 2017/7/3.
 */

public class SwipeCallback extends SimpleCallback {

    private RecycleAdapter mAdapter;
    private List<PicEntity> data;

    public SwipeCallback(RecycleAdapter mAdapter, List<PicEntity> entity) {
        super(0, ItemTouchHelper.DOWN | ItemTouchHelper.UP |
                ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT);
        this.mAdapter = mAdapter;
        this.data = entity;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        PicEntity o = data.remove(viewHolder.getAdapterPosition());
        data.add(0, o);
        mAdapter.notifyItemMoved(viewHolder.getLayoutPosition(), 0);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        double maxdistance = recyclerView.getWidth() * 0.5f;
        double distance = Math.sqrt(dX * dX + dY * dY);
        double fraction = distance / maxdistance;
        if (fraction > 1)
            fraction = 1;
        int itemCount = recyclerView.getChildCount();

        for (int i = 0; i < itemCount; i++) {
            View view = recyclerView.getChildAt(i);
            int level = itemCount - i - 1;
            if(level==4-1){//  控制的是最下层的Item
                view.setTranslationY((float) (MainActivity.TRANS_Y_GAP *(level -1)));
                view.setScaleX((float) (1 - 0.05f* (level- 1)));
                view.setScaleY((float) (1 - 0.05f * (level -1)));
            }else if(level<4-1){
                view.setTranslationY((float) (MainActivity.TRANS_Y_GAP * level - fraction * MainActivity.TRANS_Y_GAP));
                view.setScaleX((float) (1-0.05f*level+fraction*0.05f));
                view.setScaleY((float) (1-0.05f*level+fraction*0.05f));
            }

        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return 100;
    }
}
