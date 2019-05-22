package com.scandit.barcodescannerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.scandit.barcodepicker.BarcodePicker;
import com.scandit.barcodepicker.OnScanListener;
import com.scandit.barcodepicker.ScanSession;
import com.scandit.barcodepicker.ScanSettings;
import com.scandit.barcodepicker.ScanditLicense;
import com.scandit.recognition.Barcode;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnScanListener {

    private BarcodePicker mPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // Set your license key
        ScanditLicense.setAppKey(getResources().getString(R.string.licence_key));
        ScanSettings settings = ScanSettings.create();
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_EAN13, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_EAN8, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_UPCA, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_UPCE, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_QR, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_MICRO_QR, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_CODE11, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_CODE25, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_CODE32, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_CODE39, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_CODE93, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_CODE128, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_DOTCODE, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_INTERLEAVED_2_OF_5, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_DATA_MATRIX, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_PDF417, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_MICRO_PDF417, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_MSI_PLESSEY, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_GS1_DATABAR, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_GS1_DATABAR_EXPANDED, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_GS1_DATABAR_LIMITED, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_CODABAR, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_AZTEC, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_MAXICODE, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_TWO_DIGIT_ADD_ON, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_FIVE_DIGIT_ADD_ON, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_KIX, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_RM4SCC, true);
        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_LAPA4SC, true);
//        settings.setSymbologyEnabled(Barcode.SYMBOLOGY_UNKNOWN, true);
// Instantiate the barcode picker by using the settings defined above.
        mPicker = new BarcodePicker(this, settings);

        setContentView(mPicker);
// Set the on scan listener to receive barcode scan events.
        mPicker.setOnScanListener(this);
    }

    @Override
    public void didScan(ScanSession scanSession) {

        List<Barcode> barcodeList = scanSession.getNewlyRecognizedCodes();

        if (barcodeList != null && barcodeList.size() > 0)
            Toast.makeText(this, barcodeList.get(0).getData(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        mPicker.startScanning();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mPicker.stopScanning();
        super.onPause();
    }
}
