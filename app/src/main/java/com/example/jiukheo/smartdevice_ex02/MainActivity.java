package com.example.jiukheo.smartdevice_ex02;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected Button btHomepage;
    protected Button btDial;
    protected Button btCall;
    protected Button btSms;
    protected Button btMap;
    protected Button btSpeech;
    protected TextView tvSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btHomepage = (Button) findViewById(R.id.button);
        btDial = (Button) findViewById(R.id.btDial);
        btCall=(Button) findViewById(R.id.btCall);
        btSms =(Button) findViewById(R.id.btSms);
        btMap =(Button) findViewById(R.id.btMap);
        btSpeech =(Button) findViewById(R.id.btspeech);

        tvSpeech = (TextView) findViewById(R.id.tvSpeech);

        btHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                그냥 = 하는거는 이미 생성된 것을 참조(레퍼런드)하기 위해서 가져오는 것이다.
                버튼 아이디 연결에는 new가 없다 버튼이 이미 만들어져 있는 것이기 때문에.

                new 하는것은 지금 새로 사용하기 위해 만드는것이다.
                intent는 new를 해서 내가 관리하고 사용하는 것을 새로 만드는것이다.
                */

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ice.mokwon.ac.kr"));
                startActivity(intent);
            }
        });

        btDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01041144105"));
                startActivity(intent);
                //전화걸기 위한 키패드를 자동으로 띄워줌.

            }
        });
        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("Tel:01041144105"));
                startActivity(intent);
            }
        });

        btSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01041144105"));
                intent.putExtra("sms_body","Mokwon_University");
                //putExtra = 문자로 보내고 싶은 내용과 이름을 지정한다.
                startActivity(intent);

            }
        });

        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:36.321609,127.337957?z=20")); // ""를 parse 해서  Uri에 넣어준다.
                startActivity(intent);
            }
        });
    }
}
