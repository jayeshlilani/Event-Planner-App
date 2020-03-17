package smokinguns.navigation;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class sound extends AppCompatActivity {

    CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18;
    Button btn;
    String book = "",event="",subevent="";
    TextView tvhead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        try{
        tvhead= (TextView) findViewById(R.id.tvhead);
        Typeface custom2 = Typeface.createFromAsset(getAssets(),"fonts/exosemibold.otf");
        tvhead.setTypeface(custom2);

        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        c3 = (CheckBox) findViewById(R.id.c3);
        c4 = (CheckBox) findViewById(R.id.c4);
        c5 = (CheckBox) findViewById(R.id.c5);
        c6 = (CheckBox) findViewById(R.id.c6);
        c7 = (CheckBox) findViewById(R.id.c7);
        c8 = (CheckBox) findViewById(R.id.c8);
        c9 = (CheckBox) findViewById(R.id.c9);
        c10 = (CheckBox) findViewById(R.id.c10);
        c11 = (CheckBox) findViewById(R.id.c11);
        c12 = (CheckBox) findViewById(R.id.c12);
        c13 = (CheckBox) findViewById(R.id.c13);
        c14 = (CheckBox) findViewById(R.id.c14);
        c15 = (CheckBox) findViewById(R.id.c15);
        c16 = (CheckBox) findViewById(R.id.c16);
        c17 = (CheckBox) findViewById(R.id.c17);
        c18 = (CheckBox) findViewById(R.id.c18);
        btn = (Button) findViewById(R.id.btn);

            Intent i=getIntent();
            event=i.getStringExtra("event");
            subevent=i.getStringExtra("subevent");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (c1.isChecked())
                        book = book + c1.getText().toString() + "\n";
                    if (c2.isChecked())
                        book = book + c2.getText().toString() + "\n";
                    if (c3.isChecked())
                        book = book + c3.getText().toString() + "\n";
                    if (c4.isChecked())
                        book = book + c4.getText().toString() + "\n";
                    if (c5.isChecked())
                        book = book + c5.getText().toString() + "\n";
                    if (c6.isChecked())
                        book = book + c6.getText().toString() + "\n";
                    if (c7.isChecked())
                        book = book + c7.getText().toString() + "\n";
                    if (c8.isChecked())
                        book = book + c8.getText().toString() + "\n";
                    if (c9.isChecked())
                        book = book + c9.getText().toString() + "\n";
                    if (c10.isChecked())
                        book = book + c10.getText().toString() + "\n";
                    if (c11.isChecked())
                        book = book + c11.getText().toString() + "\n";
                    if (c12.isChecked())
                        book = book + c12.getText().toString() + "\n";
                    if (c13.isChecked())
                        book = book + c13.getText().toString() + "\n";
                    if (c14.isChecked())
                        book = book + c14.getText().toString() + "\n";
                    if (c15.isChecked())
                        book = book + c15.getText().toString() + "\n";
                    if (c16.isChecked())
                        book = book + c16.getText().toString() + "\n";
                    if (c17.isChecked())
                        book = book + c17.getText().toString() + "\n";
                    if (c18.isChecked())
                        book = book + c18.getText().toString() + "\n";
                    Intent i = new Intent(getApplicationContext(), services.class);
                    i.putExtra("book", book);
                    i.putExtra("event",event);
                    i.putExtra("subevent",subevent);
                    startActivity(i);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}