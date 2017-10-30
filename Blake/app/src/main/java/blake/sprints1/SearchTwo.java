package blake.sprints1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SearchTwo extends AppCompatActivity {
    private TextView nametv;
    private TextView addresstv;
    private TextView phonetv;
    private TextView netlinktv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_two);
        Intent i = getIntent();
        Information read = (Information) i.getSerializableExtra("information");
        nametv = (TextView) findViewById(R.id.name);
        nametv.setText(String.format(read.getName()));

        addresstv = (TextView) findViewById(R.id.address);
        addresstv.setText(String.format(read.getAddresss()));

        phonetv = (TextView) findViewById(R.id.phonenumber);
        phonetv.setText(String.format(read.getPhonenumber()));

        netlinktv = (TextView) findViewById(R.id.netlink);
        netlinktv.setText(String.format(read.getNetlink()));

        findViewById(R.id.review).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
