package com.example.skripsi.alibi;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.interfaces.PBEKey;

import static com.example.skripsi.alibi.LogUtils.LOGE;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvSDMP, tvBR, tvP, tvPKA, tvPKIKB, tvImunisasi, tvPP, tvSPOG, tvSPKA, tvSPKB, tvSI, tvSRB, tvPB, tvOHA, tvOBS, tvBMHP, tvSPO, tvSum, tvPN;
    private Button btnCreatePDF, btnDetail;
    private Context mContext;


    int sdmPendukung, bangunRuang, prasarana, pka, pkikb, imuniasi, PP, SPOG, SPKA, SPKB, SI, SRB, PB, OHA, OBS, BMHP,SPO, PN;
    int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0,m = 0,n = 0,o = 0,p = 0,q = 0,r = 0;
    int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hasil Alibi");

        initComponent();

        Intent intent = getIntent();
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

    }

    private void sumAll(){
        sum = ((a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r) * 100) /18;

        tvSum.setText(String.valueOf(sum));
    }

    private void generatePDF(String dest){
        try{

            /**
             * Creating Document
             */
            Document document = new Document();
            // Location to save
            PdfWriter.getInstance(document, new FileOutputStream(dest));

            // Open to write
            document.open();

            // Document Settings
            document.setPageSize(PageSize.A4);
            document.addCreationDate();
            document.addAuthor("Adjie Dwi Nugroho");
            document.addCreator("Aplikasi Alibi");

            BaseColor mColorAccent = new BaseColor(0, 153, 204, 255);
            float mHeadingFontSize = 20.0f;
            float mValueFontSize = 26.0f;
            /**
             * How to USE FONT....
             */
            BaseFont urName = BaseFont.createFont("assets/fonts/brandon_medium.otf", "UTF-8", BaseFont.EMBEDDED);

            // LINE SEPARATOR
            LineSeparator lineSeparator = new LineSeparator();
            lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));

            // Title Order Details...
            // Adding Title....
            Font mOrderDetailsTitleFont = new Font(urName, 36.0f, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderDetailsTitleChunk = new Chunk("Hasil Persentase Instrumen", mOrderDetailsTitleFont);
            Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk);
            mOrderDetailsTitleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(mOrderDetailsTitleParagraph);


            // Fields of Order Details...
            // Adding Chunks for Title and value
            Font mOrderIdFont = new Font(urName, mHeadingFontSize, Font.NORMAL, mColorAccent);
            Chunk mOrderIdChunk = new Chunk("SDM Pendukung", mOrderIdFont);
            Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
            document.add(mOrderIdParagraph);

            Font mOrderIdValueFont = new Font(urName, mValueFontSize, Font.NORMAL, BaseColor.BLACK);
            Chunk mOrderIdValueChunk = new Chunk(String.valueOf(sdmPendukung), mOrderIdValueFont);
            Paragraph mOrderIdValueParagraph = new Paragraph(mOrderIdValueChunk);
            document.add(mOrderIdValueParagraph);

            document.add(new Paragraph(""));
            document.add(new Chunk(lineSeparator));
            document.add(new Paragraph(""));

            document.close();

            Toast.makeText(mContext, "Created... :)", Toast.LENGTH_SHORT).show();
        }catch (IOException | DocumentException ie) {
            LOGE("createPdf: Error " + ie.getLocalizedMessage());
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(mContext, "No application found to open this file.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_createPDF:
                generatePDF(FileUtils.getAppPath(mContext)+ "Alibi(Hasil Instrumen Penilaian).pdf");
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
