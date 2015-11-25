package com.example.vanhung.demo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wefika.flowlayout.FlowLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FlowLayout my_layout;
    final int begin_button_id = 200;
    final String delimiter_defaul = ".......";
    List<Integer>list_control_id=new ArrayList<>();
    TextView txt_answer=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        my_layout = (FlowLayout) findViewById(R.id.my_control);
        FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);
        FlowLayout.LayoutParams layoutParams = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.MATCH_PARENT, FlowLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 5);

        String[] data = getResources().getStringArray(R.array.items);
        String[] answer = getResources().getStringArray(R.array.answers);
        String delimiter = ".......";
        for (int i = 0; i < data.length; i++) {
            if (i == data.length - 1) {
                delimiter = "";
            }
            TextView t = new TextView(MainActivity.this);
            t.setLayoutParams(params);
            t.setPadding(5, 5, 5, 5);
            t.setText(data[i]);
            t.setTextColor(Color.BLUE);
            my_layout.addView(t);
            if (!"".equals(delimiter)) {
                TextView textview_delimiter = new TextView(MainActivity.this);
                list_control_id.add(i);
                textview_delimiter.setLayoutParams(params);
                textview_delimiter.setId(i);
                textview_delimiter.setOnClickListener(OnTexViewAnswerclick);
                textview_delimiter.setPadding(5, 5, 5, 5);
                textview_delimiter.setText(delimiter);
                textview_delimiter.setTextColor(Color.BLUE);
                my_layout.addView(textview_delimiter);
            }
        }

        for (int i = 0; i < answer.length; i++) {

            Button t = new Button(MainActivity.this);
            t.setTag(i);
            t.setId(begin_button_id + i);
            t.setOnClickListener(OnAnswerClick);
            t.setLayoutParams(layoutParams);
            t.setPadding(5, 5, 5, 5);
            t.setText(answer[i]);
            t.setTextColor(Color.BLUE);
            my_layout.addView(t);
        }

    }

    public View.OnClickListener OnAnswerClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Button buttoncontrol = (Button) v;
            String message = buttoncontrol.getText().toString();
            for (int i=0;i<list_control_id.size();i++)
            {
                int id=list_control_id.get(i);
                TextView control=(TextView)my_layout.findViewById(id);
                if (control!=null)
                {
                    if (delimiter_defaul.equals(control.getText().toString()))
                    {
                        if (txt_answer!=null)
                        {
                            if (txt_answer.getId()>control.getId()) {
                                txt_answer = control;
                            }
                        }else
                        {
                            txt_answer=control;
                        }
                    }
                }

            }

            txt_answer.setText(message);
            txt_answer.setTextColor(getResources().getColor(R.color.colorAccent));
            txt_answer.setTag(buttoncontrol.getId());
            buttoncontrol.setText("");
            buttoncontrol.setEnabled(false);
            txt_answer=null;
        }
    };
    public View.OnClickListener OnTexViewAnswerclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView txt_control = (TextView) v;
            if (delimiter_defaul.equals(txt_control.getText().toString()))
            {
                return;
            }
            int tag=Integer.parseInt(txt_control.getTag().toString());
            Button control_button = (Button) my_layout.findViewById(tag);
            if (control_button != null) {
                control_button.setText(txt_control.getText().toString());
                control_button.setEnabled(true);
                txt_control.setText(delimiter_defaul);
                txt_control.setTextColor(Color.BLUE);
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showHtml(View v) {
        Intent intent = new Intent(this, AnimationActivity.class);
        startActivity(intent);
    }
}
