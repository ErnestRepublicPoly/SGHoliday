package sg.edu.rp.c346.sgholiday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class holidays extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> secular, religion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);
        Intent intentReceived = getIntent();
        final String a = intentReceived.getStringExtra("selectedType");


        lv = this.findViewById(R.id.lvHoliday);

        secular = new ArrayList<>();
        secular.add(new Holiday("New Year Day", "1 Jan 2020", R.drawable.new_year));
        secular.add(new Holiday("Labor Day", "1 May 2020", R.drawable.labour_day));

        religion = new ArrayList<>();
        religion.add(new Holiday("Chinese New Year", "25 & 26 January 2020", R.drawable.cny));
        religion.add(new Holiday("Good Friday", "10 April 2020", R.drawable.goodfriday));
        religion.add(new Holiday("Vesak Day", "7 May 2020", R.drawable.cny));
        religion.add(new Holiday("Hari Raya Puasa", "24 May 2020", R.drawable.hari_raya_puasa));
        religion.add(new Holiday("Hari Raya Haji", "31 July 2020", R.drawable.hari_raya_haji));
        religion.add(new Holiday("National Day", "9 August 2020", R.drawable.national_day));
        religion.add(new Holiday("Deepavali", "14 November 2020", R.drawable.deepavali));
        religion.add(new Holiday("Christmas Day", "25 December 2020", R.drawable.christmas));

        if(a.equalsIgnoreCase("Secular")){
            aa = new HolidayAdapter(this, R.layout.row, secular);
        }else{
            aa = new HolidayAdapter(this, R.layout.row, religion);
        }
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday;
                if(a.equalsIgnoreCase("Secular")){
                    selectedHoliday = secular.get(position);
                }else{
                    selectedHoliday = religion.get(position);
                }

                Toast.makeText(holidays.this, "Holiday: " + selectedHoliday.getName()
                                + " Date: " + selectedHoliday.getDay(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
