package hu.unideb.nursenotes.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinner;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;
import com.simplify.ink.InkView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnTouch;
import hu.unideb.nursenotes.frontend.movements.ScrollEnable;
import lombok.Builder;

import static android.view.MotionEvent.ACTION_UP;

public class ClientActivity extends AppCompatActivity {

    @BindView(R.id.multi_select_spinner)
    MultiSpinner multiSpinner;

    @BindView(R.id.signature)
    InkView signiture;

    @BindView(R.id.scroll_view)
    ScrollEnable scrollEnable;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_client);
        ButterKnife.bind(this);

        final List<String> list = Arrays.asList(getResources().getStringArray(R.array.activities_array));

        final List<KeyPairBoolData> listArray0 = new ArrayList<>();

        final LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();

        for (int i = 0; i < list.size(); i++) {
//            KeyPairBoolData h = new KeyPairBoolData();
//            h.setId(i + 1);
//            h.setName(list.get(i));
//            h.setSelected(false);
//            listArray0.add(h);

            linkedHashMap.put(list.get(i), false);
        }

        multiSpinner.setItems(linkedHashMap, new MultiSpinnerListener() {
            @Override
            public void onItemsSelected(boolean[] booleans) {
            }
        });
        signiture.addListener(new InkView.InkListener() {
            @Override
            public void onInkClear() {
            }

            @Override
            public void onInkDraw() {
                switch(MotionEvent.ACTION_DOWN){
                    case (MotionEvent.ACTION_UP): scrollEnable.setScrolling(true); break;
                    case (MotionEvent.ACTION_OUTSIDE): scrollEnable.setScrolling(true); break;
                    case (MotionEvent.ACTION_DOWN): scrollEnable.setScrolling(false); break;
                    case (MotionEvent.ACTION_MOVE): scrollEnable.setScrolling(true); break;
                    case (MotionEvent.ACTION_HOVER_MOVE): scrollEnable.setScrolling(false); break;
                    case (MotionEvent.ACTION_POINTER_DOWN): scrollEnable.setScrolling(false); break;
                    case (MotionEvent.ACTION_SCROLL): scrollEnable.setScrolling(true); break;
                }
            }
        });
           }
    @OnClick(R.id.clients_button)
    public void clients_button(View view) {
        startActivity(new Intent(this, ClientList.class));
    }

    @OnClick(R.id.savebutton)
    public void save(View view){
        Toast.makeText(getApplicationContext(),"Day saved!", Toast.LENGTH_LONG).show();
    }
    @OnClick(R.id.historybutton)
    public void historybutton(View view) {
        startActivity(new Intent(this, History.class));
    }
}
