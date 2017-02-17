package com.handsome.didi.Adapter.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.handsome.didi.Bean.Comment;
import com.handsome.didi.Bean.Shop;
import com.handsome.didi.Bean.User;
import com.handsome.didi.R;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by handsome on 2016/4/8.
 */
public class CommentAdapter extends BaseAdapter {

    private List<Comment> commentList;
    private List<User> userList;
    private LayoutInflater mInflater;
    private Context context;

    public CommentAdapter(Context context, List<Comment> commentList, List<User> userList) {
        this.context = context;
        this.commentList = commentList;
        this.userList = userList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.adapter_comment, null);
        ViewHolder holder = getViewHolder(convertView);
        Comment comment = commentList.get(position);
        holder.tv_comment_content.setText(comment.getContent());
        holder.tv_comment_date.setText(comment.getDate());

        User user = userList.get(position);
        holder.tv_user_name.setText(user.getName());
        setRate(user.getRate(), holder.ly_user_rate);
        return convertView;
    }

    /**
     * 获得控件管理对象
     *
     * @param view
     * @return
     */
    private ViewHolder getViewHolder(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    /**
     * 控件管理类
     */
    private class ViewHolder {
        private TextView tv_user_name, tv_comment_content, tv_comment_date;
        private LinearLayout ly_user_rate;

        ViewHolder(View view) {
            tv_user_name = (TextView) view.findViewById(R.id.tv_user_name);
            tv_comment_content = (TextView) view.findViewById(R.id.tv_comment_content);
            tv_comment_date = (TextView) view.findViewById(R.id.tv_comment_date);
            ly_user_rate = (LinearLayout) view.findViewById(R.id.ly_user_rate);
        }
    }

    /**
     * 设置等级
     *
     * @param rate
     */
    private void setRate(int rate, LinearLayout resView) {
        int resId = 0;
        if (rate > 0 && rate <= 5) {
            resId = R.drawable.detail_mid_ic_rate_red;
        } else if (rate > 5 && rate <= 10) {
            rate -= 5;
            resId = R.drawable.detail_mid_ic_rate_blue;
        } else if (rate > 10 && rate <= 15) {
            rate -= 10;
            resId = R.drawable.detail_mid_ic_rate_cap;
        }
        for (int i = 0; i < rate; i++) {
            ImageView iv = new ImageView(context);
            iv.setImageResource(resId);
            resView.addView(iv);
        }
    }
}
