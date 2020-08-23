package com.adn.skripsi.alibi;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvSDMP, tvBR, tvP, tvPKA, tvPKIKB, tvImunisasi, tvPP, tvSPOG, tvSPKA, tvSPKB, tvSI, tvSRB, tvPB, tvOHA, tvOBS, tvBMHP, tvSPO, tvSum, tvPN;
    private Button btnCreatePDF, btnDetail, btnOpenPDF;
    private Context mContext;


    int sdmPendukung, bangunRuang, prasarana, pka, pkikb, imuniasi, PP, SPOG, SPKA, SPKB, SI, SRB, PB, OHA, OBS, BMHP,SPO, PN;
    int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0,m = 0,n = 0,o = 0,p = 0,q = 0,r = 0;
    int sum = 0;
    String namaPemohon, alamatPemohon, namaSarana, alamatSarana;
    Bitmap bmp, scaledbmp;

    String[] information = new String[]{"Nama Pemohon", "Alamat Pemohon"," Nama Sarana", "Alamat Sarana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hasil Alibi");

        initComponent();

        Intent intent = getIntent();
        namaPemohon = intent.getStringExtra("namaPemohon");
        alamatPemohon = intent.getStringExtra("alamatPemohon");
        namaSarana = intent.getStringExtra("namaSarana");
        alamatSarana = intent.getStringExtra("alamatSarana");

        sdmPendukung = intent.getIntExtra("sdmPendukung",0);
        bangunRuang = intent.getIntExtra("bangunRuang", 0);
        prasarana = intent.getIntExtra("prasarana",0);
        pka = intent.getIntExtra("pka",0);
        pkikb = intent.getIntExtra("pkikb",0);
        imuniasi = intent.getIntExtra("imunisasi",0);
        PP = intent.getIntExtra("pp", 0);
        SPOG = intent.getIntExtra("spog", 0);
        SPKA = intent.getIntExtra("spka", 0);
        SPKB = intent.getIntExtra("spkb", 0);
        SI = intent.getIntExtra("si", 0);
        SRB = intent.getIntExtra("srb",0);
        PB = intent.getIntExtra("pb", 0);
        OHA = intent.getIntExtra("oha", 0);
        OBS = intent.getIntExtra("obs", 0);
        BMHP = intent.getIntExtra("bmhp", 0);
        SPO = intent.getIntExtra("spo", 0);
        PN = intent.getIntExtra("pn", 0);


        if (PN == 100){
            r = 1;
            tvPN.setText(String.valueOf(100));
        }
        if (bangunRuang == 102){
            a = 1;
            tvBR.setText(String.valueOf(100));
        }else {
            tvBR.setText(String.valueOf(bangunRuang));
        }

        if (prasarana == 99){
            b = 1;
            tvP.setText(String.valueOf(100));
        }else{
            tvP.setText(String.valueOf(prasarana));
        }
        if (pka == 105){
            c = 1;
            tvPKA.setText(String.valueOf(100));
        }else{
            tvPKA.setText(String.valueOf(pka));
        }

        if (pkikb == 99){
            d = 1;
            tvPKIKB.setText(String.valueOf(100));
        }else{
            tvPKIKB.setText(String.valueOf(pkikb));
        }


        if (PP == 98){
            e = 1;
            tvPP.setText(String.valueOf(100));
        }else {
            tvPP.setText(String.valueOf(PP));
        }

        if (SPOG == 96){
            f = 1;
            tvSPOG.setText(String.valueOf(100));
        }else {
            tvSPOG.setText(String.valueOf(SPOG));
        }
        if (SPKB== 99){
            g = 1;
            tvSPKB.setText(String.valueOf(100));
        }else {
            tvSPKB.setText(String.valueOf(SPKB));
        }

        if (SI == 100) {
            h = 1;
        }
        tvSI.setText(String.valueOf(SI));

        if (SPKA == 100){
            i = 1;
        }
        tvSPKA.setText(String.valueOf(SPKA));

        if (SRB == 99){
            j = 1;
            tvSRB.setText(String.valueOf(100));
        }else {
            tvSRB.setText(String.valueOf(SRB));
        }

        if (PB == 90){
            k = 1;
            tvPB.setText(String.valueOf(100));
        }else{
            tvPB.setText(String.valueOf(PB));
        }

        if (OHA == 100){
            l = 1;
        }
        tvOHA.setText(String.valueOf(OHA));

        if (OBS == 100){
            m = 1;
        }
        tvOBS.setText(String.valueOf(OBS));

        if (BMHP == 120){
            n = 1;
            tvBMHP.setText(String.valueOf(100));
        }else{
            tvBMHP.setText(String.valueOf(BMHP));
        }

        if (SPO == 96){
            o = 1;
            tvSPO.setText(String.valueOf(100));
        }else{
            tvSPO.setText(String.valueOf(SPO));
        }
        if (imuniasi == 100) {
            p = 1;
        }
        tvImunisasi.setText(String.valueOf(imuniasi));

        if (sdmPendukung == 100){
            q = 1;
            tvSDMP.setText(String.valueOf(100));
        }else{
            tvSDMP.setText(String.valueOf(sdmPendukung));
        }

        sumAll();

    }
    private void initComponent(){
        tvSDMP = findViewById(R.id.tv_sdmp);
        tvBR = findViewById(R.id.tv_br);
        tvP = findViewById(R.id.tv_p);
        tvPKA = findViewById(R.id.tv_pka);
        tvPKIKB = findViewById(R.id.tv_pkikb);
        tvImunisasi = findViewById(R.id.tv_pi);
        tvPP = findViewById(R.id.tv_pp);
        tvSPOG = findViewById(R.id.tv_spog);
        tvSPKA = findViewById(R.id.tv_spka);
        tvSPKB = findViewById(R.id.tv_spkb);
        tvSI = findViewById(R.id.tv_si);
        tvSRB = findViewById(R.id.tv_srb);
        tvPB = findViewById(R.id.tv_pb);
        tvOHA = findViewById(R.id.tv_oa);
        tvOBS = findViewById(R.id.tv_od);
        tvBMHP = findViewById(R.id.tv_bmhp);
        tvSPO = findViewById(R.id.tv_sop);
        tvPN = findViewById(R.id.tv_pn);

        tvSum = findViewById(R.id.tv_sum_persentase);

        btnCreatePDF = findViewById(R.id.btn_createPDF);
        btnCreatePDF.setOnClickListener(this);

        btnDetail= findViewById(R.id.btn_detail);
        btnDetail.setOnClickListener(this);

        btnOpenPDF = findViewById(R.id.btn_open);
        btnOpenPDF.setOnClickListener(this);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 250, 230, false);

    }

    private void sumAll(){
        sum = ((a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r) * 100) /18;

        tvSum.setText(String.valueOf(sum));
    }


    private void generatePDF(){

                PdfDocument pdfDocument = new PdfDocument();
                Paint myPaint = new Paint();


                PdfDocument.PageInfo pageInfo =  new PdfDocument.PageInfo.Builder(300, 700,1).create();
                PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                Canvas canvas = page.getCanvas();

                canvas.drawBitmap(scaledbmp, 20 ,250 , myPaint);

                myPaint.setTextAlign(Paint.Align.CENTER);
                myPaint.setTextSize(12.0f);
                canvas.drawText("Hasil Penilaian Alibi", pageInfo.getPageWidth()/2, 150, myPaint);

                myPaint.setTextAlign(Paint.Align.LEFT);
                myPaint.setTextSize(8.0f);
                myPaint.setColor(Color.BLACK);

                int startXPosition = 10;
                int endXPosition = pageInfo.getPageWidth()-10;
                int startYPosition = 60;

                for (int i=0; i<4; i++){
                    canvas.drawText(information[i],startXPosition, startYPosition, myPaint);
                    canvas.drawLine(startXPosition, startYPosition+3, endXPosition, startYPosition+3, myPaint);
                    startYPosition+=20;
                }

                canvas.drawLine(85,50,85,130,myPaint);




                String[] getInfo = new String[]{namaPemohon, alamatPemohon, namaSarana, alamatSarana};

                myPaint.setColor(Color.rgb(122,119,19));
                myPaint.setTextSize(8.0f);
                int startYYPosition = 60;
                for (int i=0; i<4; i++){
                    canvas.drawText(getInfo[i],90, startYYPosition, myPaint);
                    startYYPosition+=20;
                }

                String[] obj = new String[]{
                        this.getResources().getString(R.string.sdm_p),
                        this.getResources().getString(R.string.br),
                        this.getResources().getString(R.string.prasarana),
                        this.getResources().getString(R.string.pkikb),
                        this.getResources().getString(R.string.pka2),
                        this.getResources().getString(R.string.pi),
                        this.getResources().getString(R.string.pp),
                        this.getResources().getString(R.string.pn),
                        this.getResources().getString(R.string.spog),
                        this.getResources().getString(R.string.spka),
                        this.getResources().getString(R.string.spkb),
                        this.getResources().getString(R.string.si),
                        this.getResources().getString(R.string.srb),
                        this.getResources().getString(R.string.pb),
                        this.getResources().getString(R.string.oa),
                        this.getResources().getString(R.string.od),
                        this.getResources().getString(R.string.bmhp),
                        this.getResources().getString(R.string.spo)

                };



                myPaint.setColor(Color.BLACK);
                myPaint.setTextSize(10.0f);
                int endXXXPosition = pageInfo.getPageWidth()-10;
                int startYYYPosition = 180;
                for (int i=0; i<obj.length; i++){
                    canvas.drawText(obj[i],10, startYYYPosition, myPaint);
                    canvas.drawLine(10, startYYYPosition+3, endXXXPosition, startYYYPosition+3, myPaint);
                    startYYYPosition+=20;
                }
                canvas.drawLine(260,175,260,540,myPaint);

            String[] result = new String[]{
                    String.valueOf(sdmPendukung),
                    String.valueOf(bangunRuang),
                    String.valueOf(prasarana),
                    String.valueOf(pka),
                    String.valueOf(pkikb),
                    String.valueOf(imuniasi),
                    String.valueOf(PP),
                    String.valueOf(SPOG),
                    String.valueOf(SPKA),
                    String.valueOf(SPKB),
                    String.valueOf(SI),
                    String.valueOf(SRB),
                    String.valueOf(PB),
                    String.valueOf(OHA),
                    String.valueOf(OBS),
                    String.valueOf(BMHP),
                    String.valueOf(SPO),
                    String.valueOf(PN)

            };

        int startYYYYPosition = 180;
                for (int i=0; i<result.length; i++){
                    canvas.drawText(result[i],270, startYYYYPosition, myPaint);
                    startYYYYPosition+=20;
                }

                myPaint.setTextAlign(Paint.Align.RIGHT);
                myPaint.setTextSize(12.0f);
                canvas.drawText("PETUGAS", 240, 600, myPaint);

                pdfDocument.finishPage(page);

                File file = new File("/sdcard/Alibi.pdf");

                try{
                    pdfDocument.writeTo(new FileOutputStream(file));
                    Toast.makeText(this,"Berhasil generate PDF", Toast.LENGTH_LONG).show();
                }catch (IOException e){
                    e.printStackTrace();
                    Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
                }
                pdfDocument.close();
    }
    private void openPDF(){
        File file = new File("/sdcard/Alibi.pdf");
        if (file.exists())
        {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            Uri uri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", file);
            intent.setDataAndType(uri, "application/pdf");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            try
            {
                startActivity(intent);
            }
            catch(ActivityNotFoundException e)
            {
                Toast.makeText(ResultActivity.this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_createPDF:
                    generatePDF();
                break;
            case R.id.btn_open:
                openPDF();
                break;

            case R.id.btn_detail:
                Intent intent = new Intent();
                intent.putExtra("r_sdm", sdmPendukung);
                intent.putExtra("r_br", bangunRuang);
                intent.putExtra("r_p", prasarana);
                intent.putExtra("r_pkikb", pkikb);
                intent.putExtra("r_pka", pka);
                intent.putExtra("r_pi", imuniasi);
                intent.putExtra("r_pp", PP);
                intent.putExtra("r_pn",PN);
                intent.putExtra("r_spog", SPOG);
                intent.putExtra("r_spka", SPKA);
                intent.putExtra("r_spkb", SPKB);
                intent.putExtra("r_si", SI);
                intent.putExtra("r_srb", SRB);
                intent.putExtra("r_pb",PB);
                intent.putExtra("r_oha", OHA);
                intent.putExtra("r_obs", OBS);
                intent.putExtra("r_bmhp", BMHP);
                intent.putExtra("r_spo", SPO);

                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
