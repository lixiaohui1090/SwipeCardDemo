package xuansu.com.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RecycleAdapter  mAdapter;
    List<PicEntity>  list;

    SwipeCardLayoutManager  lm;
    public static int TRANS_Y_GAP;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         TRANS_Y_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());
        setContentView(R.layout.activity_swipe_card);
        rv= (RecyclerView) findViewById(R.id.rv);
         lm=new SwipeCardLayoutManager(this);
         rv.setLayoutManager(lm);
         list=initDatas();
        mAdapter=new RecycleAdapter(this,list);
         rv.setAdapter(mAdapter);
         SwipeCallback  callback=new SwipeCallback(mAdapter,list);
         ItemTouchHelper  item=new ItemTouchHelper(callback);
         item.attachToRecyclerView(rv);

    }

    public static List<PicEntity> initDatas() {
        List<PicEntity> datas = new ArrayList<>();
        int i = 1;
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155117_8i4Rk.thumb.700_0.jpeg", "美女1"));
        datas.add(new PicEntity(i++, "http://cdnq.duitang.com/uploads/item/201505/04/20150504155014_irFvu.thumb.700_0.jpeg", "美女2"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201309/17/20130917032356_hdGjF.thumb.700_0.jpeg", "美女3"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155137_JWcRK.thumb.700_0.jpeg", "美女4"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155036_zNrPT.thumb.700_0.jpeg", "美女5"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201504/26/201504262026_weMcT.thumb.700_0.jpeg", "美女6"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201504/26/201504261920_HsSm3.thumb.700_0.jpeg", "美女7"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201309/17/20130917032356_hdGjF.thumb.700_0.jpeg","美女8"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201309/17/20130917032356_hdGjF.thumb.700_0.jpeg","美女9"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201309/17/20130917032356_hdGjF.thumb.700_0.jpeg","美女10"));
        datas.add(new PicEntity(i++, "http://img5q.duitang.com/uploads/item/201309/17/20130917032356_hdGjF.thumb.700_0.jpeg","美女11"));
        return datas;
    }
}
