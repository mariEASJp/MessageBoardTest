package kontraktor.messageboardtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MessageBoard extends AppCompatActivity {

    EditText etxtTest;
    TextView txtTest;
    Button cmdEnter;
    TableLayout tblMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etxtTest = (EditText) findViewById(R.id.etxtTest);
        txtTest = new TextView(this);
        tblMessages = (TableLayout) findViewById(R.id.tblMessages);

        cmdEnter = (Button) findViewById(R.id.cmdEnter);
        cmdEnter.setOnClickListener(cmdClickListener);


    }


    private final Button.OnClickListener cmdClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Create paramater layout
            TableRow.LayoutParams param =
                    new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.FILL_PARENT);

            TableRow.LayoutParams paramText = param;
            paramText.setMargins(0,8,0,8);

            //Create new table row
            TableRow tr = new TableRow(getApplicationContext());
            tr.setLayoutParams(param);

            //Create new TextView widget
            txtTest = new TextView(getApplicationContext());
            txtTest.setText(etxtTest.getText());
            txtTest.setLayoutParams(param);
            txtTest.setBackgroundColor(Color.WHITE);
            txtTest.setTextColor(Color.BLACK);
            txtTest.setTextSize(20);
            txtTest.setGravity(Gravity.FILL);
            txtTest.setSingleLine(false);
            //Add TextView to row
            tr.addView(txtTest);
            //Add Row to tblMessages
            tblMessages.addView(tr,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            //Clear the textedit
            etxtTest.setText("");
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message_board, menu);
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
}
