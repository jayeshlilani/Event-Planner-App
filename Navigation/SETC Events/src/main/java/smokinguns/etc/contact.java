package smokinguns.etc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import smokinguns.etc.R;

public class contact extends AppCompatActivity {

    Button btn_message;
    EditText et_name,et_phone,et_subject,et_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        et_name= (EditText) findViewById(R.id.et_name);
        et_phone= (EditText) findViewById(R.id.et_phone);
        et_subject= (EditText) findViewById(R.id.et_subject);
        et_msg= (EditText) findViewById(R.id.et_msg);
        btn_message= (Button) findViewById(R.id.btn_message);


        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_name.getText().toString().equals(""))
                {
                    et_name.setError("Name cannot be empty");
                    et_name.requestFocus();
                    return;
                }
                if((!Patterns.PHONE.matcher(et_phone.getText().toString()).matches()) || (et_phone.getText().toString().length()<10))
                {
                    et_phone.setError("Invalid Phone");
                    et_phone.requestFocus();
                    return;
                }
                if(et_subject.getText().toString().equals(""))
                {
                    et_subject.setError("Subject cannot be empty");
                    et_subject.requestFocus();
                    return;
                }
                if(et_msg.getText().toString().equals(""))
                {
                    et_msg.setError("Message cannot be empty");
                    et_msg.requestFocus();
                    return;
                }
                Intent email=new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse("mailto:smokingunsetc@gmail.com"));
                email.putExtra(Intent.EXTRA_SUBJECT,et_subject.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT,et_msg.getText().toString()+"\n Name : "+et_name.getText().toString()+"\n Contact : "+et_phone.getText().toString());
                startActivity(email);
            }
        });
    }
}
