package com.jiangtea.rvdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    //图片数组
    private int[] mListIcons = new int[]{R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round
    };
    //标题数组
    private String[] mListTitle = new String[]{"标题1", "标题2", "标题3", "标题4", "标题5", "标题6", "标题7", "标题8",
            "标题9", "标题10", "标题11", "标题12", "标题13", "标题14", "标题15", "标题16", "标题17", "标题18", "标题19", "标题20"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        initData();
    }

    private void initData() {
        //样式，boolean代表展示的方向
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //创建一个竖横的listView
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //创建一个竖横的gridView
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3,GridLayoutManager.VERTICAL,false);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        //数据
        rv.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = View.inflate(parent.getContext(), R.layout.rv_item, null);
                RecyclerView.ViewHolder viewHolder = new RvViewholder(view);
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                //进行数据设置
                RvViewholder myViewholder = (RvViewholder) holder;
                //设置图片
                myViewholder.itemIv.setImageResource(mListIcons[position]);
                //设置标题数据
                myViewholder.itemTv.setText(mListTitle[position]);
            }

            @Override
            public int getItemCount() {
                return mListIcons.length;
            }

            class RvViewholder extends RecyclerView.ViewHolder {

                public ImageView itemIv;
                public TextView itemTv;

                /**
                 * 初始化控件
                 */
                public RvViewholder(View itemView) {
                    super(itemView);
                    itemIv = (ImageView) itemView.findViewById(R.id.item_iv);
                    itemTv = (TextView) itemView.findViewById(R.id.item_tv);
                }
            }
        });

    }
}
