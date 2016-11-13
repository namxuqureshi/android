package com.example.dev.officebox.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev.officebox.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.dev.officebox.helpers.StringConverter.bytesToHex;

public class NFCActivity extends Activity {


    private boolean FLAG = true;
    private CircleImageView img, img2;
    private ViewPropertyAnimator tmp = null, tmp2 = null;
    private NfcAdapter mNfcAdapter;

    @Override
    protected void onStart() {
        FLAG = true;
        super.onStart();

        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        img = (CircleImageView) findViewById(R.id.animate);
        img2 = (CircleImageView) findViewById(R.id.animate2);

        if (mNfcAdapter == null) {
            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
//        NfcManager
        else if (!mNfcAdapter.isEnabled()) {
            Toast.makeText(getApplicationContext(), "Please activate NFC and press Back to return to the application!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(android.provider.Settings.ACTION_NFC_SETTINGS));
        }
        animate();
        final TextView title = (TextView) findViewById(R.id.titleInBar);
        title.setText("NFC");

        handleIntent(getIntent());


    }

    private void animate() {

        tmp = img.animate();
        tmp2 = img2.animate();
        Thread t = new Thread(new Runnable() {
            float i = 10.0F;
            float i2 = -10.0F;

            @Override
            public void run() {

                while (FLAG) {
                    tmp.rotation(i);
                    tmp2.rotation(i2);
                    try {
                        i = i + 10.0F;
                        i2 = i2 - 10.0F;
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        tmp.start();
    }

    @Override
    protected void onNewIntent(final Intent intent) {

        handleIntent(intent);
    }


    private boolean handleIntent(final Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)) {
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            byte[] a = tag.getId();
            String ab = bytesToHex(a);
            FLAG = false;

            final Intent i = new Intent(this, AddNewTagActivity.class);
            i.putExtra("TAG_ID", ab);
            startActivity(i);
            finish();
        } else {
            return false;
        }
        return false;

    }


    public static void setupForegroundDispatch(final Activity activity, final NfcAdapter adapter) {
        final Intent intent = new Intent(activity.getApplicationContext(), activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        final PendingIntent pendingIntent = PendingIntent.getActivity(activity.getApplicationContext(), 0, intent, 0);

        IntentFilter[] filters = new IntentFilter[3];
        String[][] techList = new String[][]{};

//         Notice that this is the same filter as in our manifest.
        filters[0] = new IntentFilter();
        filters[0].addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filters[0].addCategory(Intent.CATEGORY_SELECTED_ALTERNATIVE);
//        filters[0].addDataType("");

        filters[1] = new IntentFilter();
        filters[1].addAction(NfcAdapter.ACTION_TAG_DISCOVERED);
        filters[1].addCategory(Intent.CATEGORY_SELECTED_ALTERNATIVE);
        filters[2] = new IntentFilter();
        filters[2].addAction(NfcAdapter.ACTION_TECH_DISCOVERED);
        filters[2].addCategory(Intent.CATEGORY_SELECTED_ALTERNATIVE);


        adapter.enableForegroundDispatch(activity, pendingIntent, filters, techList);
    }


    public static void stopForegroundDispatch(final Activity activity, final NfcAdapter adapter) {
        adapter.disableForegroundDispatch(activity);
    }

    @Override
    protected void onResume() {

        setupForegroundDispatch(this, mNfcAdapter);
        super.onResume();


    }

    @Override
    protected void onPause() {

        stopForegroundDispatch(this, mNfcAdapter);
        super.onPause();
    }


    @Override
    public void onBackPressed() {
        FLAG = false;
        super.onBackPressed();
    }

    public void goBack(final View view) {
        FLAG = false;
        super.onBackPressed();
    }
}
