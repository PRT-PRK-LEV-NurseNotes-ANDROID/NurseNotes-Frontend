package hu.unideb.nursenotes.activity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinner;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gcacace.signaturepad.views.SignaturePad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.unideb.nursenotes.R;
import hu.unideb.nursenotes.commons.pojo.request.ActivityRequest;
import hu.unideb.nursenotes.commons.pojo.response.ClientResponse;
import hu.unideb.nursenotes.listview.adapter.client.ClientListCustomAdapter;
import hu.unideb.nursenotes.task.activity.ActivityAddTask;

public class ActivityAddActivity extends AppCompatActivity {

    @BindView(R.id.client)
    TextView clientTextView;

    @BindView(R.id.clientspinner)
    Spinner clientSpinner;

    @BindView(R.id.activity)
    TextView activityTextView;

    @BindView(R.id.multi_select_spinner)
    MultiSpinner multiSpinner;

//    @BindView(R.id.traveltime)
//    TextView travelTimeTextView;
//
//    @BindView(R.id.traveltimetext)
//    Date travelTimeDate;
//
//    @BindView(R.id.datetext)
//    TextView dateTextView;
//
//    @BindView(R.id.dateEditText)
//    Date dateEditText;

    @BindView(R.id.signaturetext)
    TextView signatureTextView;

    @BindView(R.id.signature_pad)
    SignaturePad signaturePad;

    @BindView(R.id.clear_button)
    Button clearButton;

    @BindView(R.id.save_button)
    Button saveButton;

    @BindView(R.id.savebutton)
    Button saveDayButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
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
    }

    @OnClick(R.id.savebutton)
    public void addClient(View view){
        ObjectMapper mapper = new ObjectMapper();
        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
//        try {
//            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createActivity());
//            new ActivityAddTask(this).execute(jsonInString);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }

    private ActivityRequest createActivity() {
//        return ActivityRequest.builder()
//                .date(LocalDate.ofEpochDay(dateEditText.getTime()))
//                .travelTime((int) travelTimeDate.getTime())
//                .type()
        return null;
    }
}
