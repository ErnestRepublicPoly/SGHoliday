package sg.edu.rp.c346.sgholiday;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holidayArrayList;
    private Context context;
    private TextView tvHoliday, tvDate;
    private ImageView ivPicture;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holidayArrayList = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvHoliday = rowView.findViewById(R.id.textViewHoliday);
        tvDate = rowView.findViewById(R.id.textViewDate);
        ivPicture = rowView.findViewById(R.id.imageViewHoliday);

        Holiday currentHoliday= holidayArrayList.get(position);

        tvHoliday.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDay());
        ivPicture.setImageResource(currentHoliday.getImage());

        return rowView;
    }
}