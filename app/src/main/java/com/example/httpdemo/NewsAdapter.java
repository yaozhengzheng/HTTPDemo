package com.example.httpdemo;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/12/18.
 * author ${yao}.
 */

public class NewsAdapter extends BaseQuickAdapter<GankModel> {
    public NewsAdapter(List<GankModel> data) {
        super(R.layout.item_news, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final GankModel model) {
        baseViewHolder.setText(R.id.title, model.desc)
                .setText(R.id.desc, model.desc)//
                .setText(R.id.pubDate, model.publishedAt.toString())//
                .setText(R.id.source, model.source);

        View view = baseViewHolder.getConvertView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebActivity.runActivity(mContext, model.desc, model.url);
            }
        });
        NineGridView nineGrid = baseViewHolder.getView(R.id.nineGrid);
        ArrayList<ImageInfo> imageInfo = new ArrayList<>();
        if (model.images != null) {
            for (String image : model.images) {
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(image);
                info.setBigImageUrl(image);
                imageInfo.add(info);
            }
        }
        nineGrid.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));
    }
}
