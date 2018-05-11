package hu.unideb.nursenotes.frontend;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinner;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;
import com.github.gcacace.signaturepad.views.SignaturePad;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.unideb.nursenotes.frontend.movements.ScrollEnable;

public class ClientActivity extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @BindView(R.id.multi_select_spinner)
    MultiSpinner multiSpinner;

    @BindView(R.id.signature_pad)
    SignaturePad signaturePad;

    @BindView(R.id.scroll_view)
    ScrollEnable scrollEnable;

    @BindView(R.id.save_button)
    Button mSaveButton;

    @BindView(R.id.clear_button)
    Button mClearButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verifyStoragePermissions(this);
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

        //SignaturePad

        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
               // Toast.makeText(ClientActivity.this, "OnStartSigning", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSigned() {
                mSaveButton.setEnabled(true);
                mClearButton.setEnabled(true);
            }

            @Override
            public void onClear() {
                mSaveButton.setEnabled(false);
                mClearButton.setEnabled(false);
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signaturePad.clear();
            }
        });

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap signatureBitmap = signaturePad.getSignatureBitmap();
                if (addJpgSignatureToGallery(signatureBitmap)) {
                    Toast.makeText(ClientActivity.this, "Signature saved into the Gallery", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ClientActivity.this, "Unable to store the signature", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        @Override
        public void onRequestPermissionsResult(int requestCode,
        @NonNull String permissions[], @NonNull int[] grantResults) {
            switch (requestCode) {
                case REQUEST_EXTERNAL_STORAGE: {
                    // If request is cancelled, the result arrays are empty.
                    if (grantResults.length <= 0
                            || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(ClientActivity.this, "Cannot write images to external storage", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        public File getAlbumStorageDir(String albumName) {
            // Get the directory for the user's public pictures directory.
            File file = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES), albumName);
            if (!file.mkdirs()) {
                Log.e("SignaturePad", "Directory not created");
            }
            return file;
        }

        public void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
            Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(newBitmap);
            canvas.drawColor(Color.WHITE);
            canvas.drawBitmap(bitmap, 0, 0, null);
            OutputStream stream = new FileOutputStream(photo);
            newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
            stream.close();
        }

        public boolean addJpgSignatureToGallery(Bitmap signature) {
            boolean result = false;
            try {
                File photo = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.jpg", System.currentTimeMillis()));
                saveBitmapToJPG(signature, photo);
                scanMediaFile(photo);
                result = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        private void scanMediaFile(File photo) {
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.fromFile(photo);
            mediaScanIntent.setData(contentUri);
            ClientActivity.this.sendBroadcast(mediaScanIntent);
        }

        /**
         * Checks if the app has permission to write to device storage.
         * <p/>
         * If the app does not have permission then the user will be prompted to grant permissions.
         *
         * @param activity the activity from which permissions are checked
         */
        public static void verifyStoragePermissions(Activity activity) {
            // Check if we have write permission
            int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        activity,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
        }

    @OnClick(R.id.savebutton)
    public void save(View view){
        Toast.makeText(getApplicationContext(),"Day saved!", Toast.LENGTH_LONG).show();
    }
}
