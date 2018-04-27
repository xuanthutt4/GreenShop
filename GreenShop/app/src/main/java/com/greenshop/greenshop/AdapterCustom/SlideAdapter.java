package com.greenshop.greenshop.AdapterCustom;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.greenshop.greenshop.R;


public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    int[] images = {
            R.drawable.ic_easily,
            R.drawable.ic_fast,
            R.drawable.ic_convenient
    };

    String[] heading = {
            "DỄ DÀNG",
            "NHANH CHÓNG",
            "TIỆN LỢI"
    };

    String[] descriptions = {
            "Ứng dụng hỗ trợ các bạn dễ dàng xem và chọn được sản phẩm mong muốn, không tốn nhiều" +
                    " công sức",
            "Chỉ việc chọn sản phẩm và tiến hành nhận hàng, thanh toán",
            "Không cần phải đi đâu hay làm thêm việc gì"
    };

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout, container, false);

        ImageView sildeImage = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDescription = view.findViewById(R.id.slide_description);

        sildeImage.setBackgroundResource(images[position]);
        slideHeading.setText(heading[position]);
        slideDescription.setText(descriptions[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        //container.removeView((View) object);
    }
}
