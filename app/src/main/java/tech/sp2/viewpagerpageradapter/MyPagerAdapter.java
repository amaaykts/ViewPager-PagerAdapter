package tech.sp2.viewpagerpageradapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by ARTEM on 19.10.2016.
 */

public class MyPagerAdapter extends PagerAdapter {
    private Context context;
    private List<String> data;
    private LayoutInflater inflater;

    public MyPagerAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(View)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.pager_adapter, container, false);
        Button button = (Button)view.findViewById(R.id.button);
        button.setText(data.get(position) + " " + (position+1));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

}
