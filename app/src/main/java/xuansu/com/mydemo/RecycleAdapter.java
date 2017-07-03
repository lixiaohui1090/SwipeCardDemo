package xuansu.com.mydemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by xuansu on 2017/7/3.
 */

public class RecycleAdapter extends RecyclerView.Adapter {
  private  Context  mContext;
    private  List<PicEntity>  list;
    public RecycleAdapter(Context  mCxt, List<PicEntity>  list) {
        this.mContext=mCxt;
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.item_swipe_card,null,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  MyHolder){
            MyHolder myHolder = (MyHolder) holder;
            myHolder.setData(position,list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MyHolder extends  RecyclerView.ViewHolder{

        private TextView mTvPosition;
        private ImageView  mImg;
        public MyHolder(View itemView) {
            super(itemView);
            mTvPosition= (TextView) itemView.findViewById(R.id.tvPrecent);
             mImg= (ImageView) itemView.findViewById(R.id.iv);
        }


        public  void  setData(int  posotion,PicEntity  entity){
            mTvPosition.setText(entity.getTitle()+"/"+list.size());
            Picasso.with(mContext).load(entity.getPath()).into(mImg);
        }
    }
}
