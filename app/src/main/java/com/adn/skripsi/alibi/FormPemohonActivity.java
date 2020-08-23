package com.adn.skripsi.alibi;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class FormPemohonActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout linearIdentitas, linearInstrumen;
    private Button btnLanjut, btnProses;
    private CheckBox checkTKL, checkTNK;
    private CheckBox checkRumah, checkNonRumah, checkRT, checkRP, checkRB, checkRN, checkKM;
    private CheckBox checkSAB, checkSK, checkSU;
    private CheckBox checkBDMTBS, checkBMTBS, checkRBA, checkFDDTKA, checkFKPSP, checkFRKALKB, checkRKB;
    private CheckBox checkBKIA, checkBKI, checkKI, checkBRI, checkPAK, checkFIC, checkFL, checkFR, checkSKH;
    private CheckBox checkImunisasi;
    private CheckBox checkIC, checkKP, checkFLP, checkFP, checkFNKB, checkFRP,checkFSK;
    private CheckBox checkBIDT, checkBLTASB, checkPR, checkPL, checkSD, checkSD2, checkSL, checkTD, checkTD2, checkTK, checkD, checkGB, checkGE, checkGTP, checkGV, checkKK, checkTK2, checkLPH, checkMO, checkMI, checkNHM, checkPO, checkPJ, checkPK, checkPB, checkSK2, checkS, checkSCB, checkSI, checkSD3, checkSJ, checkTOR;
    private CheckBox checkAPPB, checkLP, checkPLK, checkPTBA, checkTB;
    private CheckBox checkBLTASB2, checkIK, checkIUDK, checkAEA, checkGMC, checkKKL, checkKPBA, checkSUS, checkTS, checkS2, checkT;
    private CheckBox checkVC, checkVR;
    private CheckBox checkBSP, checkMR, checkPLD;
    private CheckBox checkB, checkCP, checkKG, checkSB, checkPR2, checkDB, checkK, checkLA, checkLO, checkM, checkP, checkP2, checkPPL, checkS4,checkSTKA, checkSMP, checkTST, checkT2, checkTK3, checkTK4, checkWK, checkB2, checkPTB, checkPP, checkHPN, checkKMK, checkLKP, checkSB2, checkSD4, checkS3;
    private CheckBox checkOI, checkMI2, checkMSI, checkKGI;
    private CheckBox checkVADT, checkTTD, checkVKI, checkSMG, checkDT, checkKDET, checkKLET, checkLT, checkKCAET, checkKGET, checkLT2, checkKDET2, checkKELT, checkMAV, checkKMAECV, checkLR, checkER, checkIUDCTA, checkIUDL, checkK2;
    private CheckBox checkBMA, checkBMCD, checkBMKS, checkBMK, checkBMKNS, checkBMKS2, checkBMLKS, checkBMM, checkBMPT, checkBMST, checkBMBCC, checkBMGB, checkBMISD, checkBMISW, checkBMJJ, checkBMKU, checkBMKFD, checkBMKN, checkBMP, checkBMPTP, checkBMP2, checkBMSC,checkBMST2, checkBMST3;
    private CheckBox checkSPOPA, checkSPOPP, checkSPOPN, checkSPOPBBL, checkSPOPKB, checkSPOPPPE, checkSPOPR, checkSPOHAP, checkSPOHPP, checkSPOPBA, checkSPOMS, checkSPOPPI;
    private CheckBox checkNifasBRPN;
    private EditText edtNmPemohon, edtAlmPemohon, edtNmSarana, edtAlmSarana;


    private LinearLayout linearSDMP, linearBR, linearRF, linearP, linearPKIKB, linearPKA, linearPI, linearPP, linearPN, linearSPOG, linearSPKA, linearSPKB, linearSI, linearSRB, linearPB, linearOBH, linearOBS, linearBMHP, linearSPO;

    int sdmPendukung;
    int bangunRuang;
    int prasarana;
    int PKA;
    int PKIKB;
    int imunisasi;
    int PP;
    int SPOG;
    int SPKA;
    int SPKB;
    int SI;
    int SRB;
    int PB;
    int OHA;
    int OBS;
    int BMHP;
    int SPO;
    int PN;


    private static final int PERMISSION_REQUEST_CODE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pemohon);

        initComponent();

        if (!checkPermission()) {
            Toast.makeText(this, "Otorisasi Perizinan Tidak Aktif", Toast.LENGTH_LONG).show();
        } else {
            if (checkPermission()) {
                requestPermissionAndContinue();
            } else {
                Toast.makeText(this, "Otorisasi Perizinan Tidak Aktif", Toast.LENGTH_LONG).show();
            }
        }

    }

    private void initComponent(){
        edtNmPemohon = findViewById(R.id.edt_nama_pemohon);
        edtAlmPemohon = findViewById(R.id.edt_alamat_pemohon);
        edtNmSarana = findViewById(R.id.edt_nama_sarana);
        edtAlmSarana = findViewById(R.id.edt_alamat_sarana);


        linearSDMP = findViewById(R.id.linear_sdmp);
        linearBR = findViewById(R.id.linear_br);
        linearRF = findViewById(R.id.linear_rf);
        linearP = findViewById(R.id.linear_p);
        linearPKIKB = findViewById(R.id.linear_pkikb);
        linearPKA = findViewById(R.id.linear_pka);
        linearPI = findViewById(R.id.linear_pi);
        linearPP = findViewById(R.id.linear_pp);
        linearPN = findViewById(R.id.linear_pn);
        linearSPOG = findViewById(R.id.linear_spog);
        linearSPKA = findViewById(R.id.linear_spka);
        linearSPKB = findViewById(R.id.linear_spkb);
        linearSPKB = findViewById(R.id.linear_spkb);
        linearSI = findViewById(R.id.linear_si);
        linearSRB = findViewById(R.id.linear_rsb);
        linearPB = findViewById(R.id.linear_pb);
        linearOBH = findViewById(R.id.linear_obh);
        linearOBS = findViewById(R.id.linear_obs);
        linearBMHP = findViewById(R.id.linear_bmhp);
        linearSPO = findViewById(R.id.linear_spo);


        checkTKL = findViewById(R.id.check_tkl);
        checkTNK = findViewById(R.id.check_tnk);

        checkRumah = findViewById(R.id.check_bangunan_rumah);
        checkNonRumah = findViewById(R.id.check_bangunan_non_rumah);

        checkRT = findViewById(R.id.check_fasilitas_tunggu);
        checkRP = findViewById(R.id.check_fasilitas_periksa);
        checkRB = findViewById(R.id.check_fasilitas_bersalin);
        checkRN = findViewById(R.id.check_fasilitas_nifas);
        checkKM = findViewById(R.id.check_fasilitas_wc);

        checkSAB = findViewById(R.id.check_prasarana_air);
        checkSK = findViewById(R.id.check_prasarana_listrik);
        checkSU = findViewById(R.id.check_prasarana_udara);

        checkBDMTBS = findViewById(R.id.check_bagan_dinding_mtbs);
        checkBMTBS = findViewById(R.id.check_bagan_mtbs);
        checkRBA = findViewById(R.id.check_buku_register_bayi);
        checkFDDTKA = findViewById(R.id.check_formulir_ddtka);
        checkFKPSP = findViewById(R.id.check_formulir_kpsp);
        checkFRKALKB = findViewById(R.id.check_formulir_rekapitulasi);
        checkRKB = findViewById(R.id.check_register_kohort_bayi);

        checkBKIA = findViewById(R.id.check_buku_kia);
        checkKI = findViewById(R.id.check_kartu_ibu);
        checkBKI = findViewById(R.id.check_buku_kohort_ibu);
        checkBRI = findViewById(R.id.check_buku_register_ibu);
        checkPAK = findViewById(R.id.check_pencatatan_asuhan);
        checkFIC = findViewById(R.id.check_formulir_informed);
        checkFL = findViewById(R.id.check_formulir_laporan);
        checkFR = findViewById(R.id.check_formulir_rujukan);
        checkSKH = findViewById(R.id.check_surat_keterangan_hamil);

        checkImunisasi = findViewById(R.id.check_formulir_laporan_imunisasi);

        checkIC = findViewById(R.id.check_informed_consent);
        checkKP = findViewById(R.id.check_kantong_persalinan);
        checkFLP = findViewById(R.id.check_formulir_laporan_persalinan);
        checkFP = findViewById(R.id.check_formulir_partograf);
        checkFNKB = findViewById(R.id.check_formulir_persalinan);
        checkFRP = findViewById(R.id.check_formulir_rujukan_persalinan);
        checkFSK = findViewById(R.id.check_formulir_surat_kelahiran);

        checkBIDT = findViewById(R.id.check_peralatan_bidt);
        checkBLTASB = findViewById(R.id.check_peralatan_bltasb);
        checkPR = findViewById(R.id.check_peralatan_pr);
        checkPL  = findViewById(R.id.check_peralatan_pl);
        checkSD = findViewById(R.id.check_peralatan_sd);
        checkSL = findViewById(R.id.check_peralatan_sl);
        checkTD = findViewById(R.id.check_peralatan_td);
        checkTD2 = findViewById(R.id.check_peralatan_td2);
        checkTK = findViewById(R.id.check_peralatan_tk);
        checkD = findViewById(R.id.check_peralatan_d);
        checkGB = findViewById(R.id.check_peralatan_gb);
        checkGE = findViewById(R.id.check_peralatan_geb);
        checkGTP = findViewById(R.id.check_peralatan_gtp);
        checkGV = findViewById(R.id.check_peralatan_gv);
        checkKK = findViewById(R.id.check_peralatan_kk);
        checkTK2 = findViewById(R.id.check_peralatan_tkk);
        checkLPH = findViewById(R.id.check_peralatan_lph);
        checkMO = findViewById(R.id.check_peralatan_moknd);
        checkMI = findViewById(R.id.check_peralatan_mi);
        checkNHM = findViewById(R.id.check_peralatan_nhm);
        checkPO = findViewById(R.id.check_peralatan_po);
        checkPJ = findViewById(R.id.check_peralatan_pj);
        checkPK = findViewById(R.id.check_peralatan_pk);
        checkPB = findViewById(R.id.check_peralatan_pb);
        checkSK2 = findViewById(R.id.check_peralatan_sk);
        checkS = findViewById(R.id.check_peralatan_s);
        checkSCB = findViewById(R.id.check_peralatan_scb);
        checkSI = findViewById(R.id.check_peralatan_si);
        checkSD2 = findViewById(R.id.check_peralatan_sd2);
        checkSJ = findViewById(R.id.check_peralatan_sj);
        checkTOR = findViewById(R.id.check_peralatan_tor);
        checkSD3 = findViewById(R.id.check_peralatan_sd3);

        checkAPPB = findViewById(R.id.check_pemeriksaan_appb);
        checkLP = findViewById(R.id.check_pemeriksaan_lp);
        checkPLK = findViewById(R.id.check_pemeriksaan_plk);
        checkPTBA = findViewById(R.id.check_pemeriksaan_ptba);
        checkTB = findViewById(R.id.check_pemeriksaan_tb);

        checkBLTASB2 = findViewById(R.id.check_pelayanan_blktasb);
        checkIK = findViewById(R.id.check_pelayanan_ik);
        checkIUDK = findViewById(R.id.check_pelayanan_iudk);
        checkAEA = findViewById(R.id.check_pelayanan_aeakdr);
        checkGMC = findViewById(R.id.check_pelayanan_gmcvd);
        checkKKL = findViewById(R.id.check_pelayanan_kkl);
        checkKPBA = findViewById(R.id.check_pelayanan_kpbakdr);
        checkSUS = findViewById(R.id.check_pelayanan_sus);
        checkTS = findViewById(R.id.check_pelayanan_ts);
        checkS2 = findViewById(R.id.check_pelayanan_s);
        checkT = findViewById(R.id.check_pelayanan_t);

        checkVC = findViewById(R.id.check_imunisasi_vc);
        checkVR = findViewById(R.id.check_imunisasi_vr);

        checkBSP = findViewById(R.id.check_resusitasi_bspp);
        checkMR = findViewById(R.id.check_resusitasi_mrp);
        checkPLD = findViewById(R.id.check_resusitasi_pld);

        checkB = findViewById(R.id.check_lain_b);
        checkCP = findViewById(R.id.check_lain_cp);
        checkKG = findViewById(R.id.check_lain_kg);
        checkSB = findViewById(R.id.check_lain_sb);
        checkPR2 = findViewById(R.id.check_lain_pr);
        checkDB = findViewById(R.id.check_lain_db);
        checkK = findViewById(R.id.check_lain_k);
        checkLA = findViewById(R.id.check_lain_la);
        checkLO = findViewById(R.id.check_lain_lo);
        checkM = findViewById(R.id.check_lain_m);
        checkP = findViewById(R.id.check_lain_p);
        checkP2 = findViewById(R.id.check_lain_p2);
        checkPPL = findViewById(R.id.check_lain_ppl);
        checkS3 = findViewById(R.id.check_lain_s);
        checkSTKA = findViewById(R.id.check_lain_stka);
        checkSMP = findViewById(R.id.check_lain_sump);
        checkTST = findViewById(R.id.check_lain_tstyddipp);
        checkT2 = findViewById(R.id.check_lain_t);
        checkTK3 = findViewById(R.id.check_lain_tk);
        checkTK4 = findViewById(R.id.check_lain_tk2);
        checkWK = findViewById(R.id.check_lain_wk);
        checkB2 = findViewById(R.id.check_lain_b2);
        checkPTB = findViewById(R.id.check_lain_ptb);
        checkPP = findViewById(R.id.check_lain_pp);
        checkHPN = findViewById(R.id.check_lain_hpn);
        checkKMK = findViewById(R.id.check_lain_kmksun);
        checkLKP = findViewById(R.id.check_lain_lkp);
        checkSB2 = findViewById(R.id.check_lain_sb2);
        checkSD4 = findViewById(R.id.check_lain_sd);
        checkS4 = findViewById(R.id.check_lain_s2);

        checkOI = findViewById(R.id.check_harus_oi);
        checkMI2 = findViewById(R.id.check_harus_mi);
        checkMSI = findViewById(R.id.check_harus_msi);
        checkKGI = findViewById(R.id.check_harus_kgi);

        checkVADT = findViewById(R.id.check_bisa_vadt);
        checkTTD = findViewById(R.id.check_bisa_ttd);
        checkVKI = findViewById(R.id.check_bisa_vki);
        checkSMG = findViewById(R.id.check_bisa_smg);
        checkDT = findViewById(R.id.check_bisa_dt);
        checkKDET = findViewById(R.id.check_bisa_kdet);
        checkKLET = findViewById(R.id.check_bisa_klet);
        checkLT = findViewById(R.id.check_bisa_lt);
        checkKCAET = findViewById(R.id.check_bisa_kcaet);
        checkKGET = findViewById(R.id.check_bisa_kget);
        checkLT2 = findViewById(R.id.check_bisa_lt2);
        checkKDET2 = findViewById(R.id.check_bisa_kdet2);
        checkKELT = findViewById(R.id.check_bisa_kelt);
        checkMAV = findViewById(R.id.check_bisa_mav);
        checkKMAECV = findViewById(R.id.check_bisa_kmaecv);
        checkLR = findViewById(R.id.check_bisa_lr);
        checkER = findViewById(R.id.check_bisa_er);
        checkIUDCTA = findViewById(R.id.check_bisa_iudcta);
        checkIUDL = findViewById(R.id.check_bisa_iudl);
        checkK2 = findViewById(R.id.check_bisa_k);

        checkBMA = findViewById(R.id.check_bmhp_a);
        checkBMCD = findViewById(R.id.check_bmhp_cd);
        checkBMKS = findViewById(R.id.check_bmhp_ks);
        checkBMK = findViewById(R.id.check_bmhp_k);
        checkBMKNS = findViewById(R.id.check_bmhp_kns);
        checkBMKS2 = findViewById(R.id.check_bmhp_ks2);
        checkBMLKS = findViewById(R.id.check_bmhp_lks);
        checkBMM = findViewById(R.id.check_bmhp_m);
        checkBMPT = findViewById(R.id.check_bmhp_pt);
        checkBMST = findViewById(R.id.check_bmhp_sta);
        checkBMBCC = findViewById(R.id.check_bmhp_bcc);
        checkBMGB = findViewById(R.id.check_bmhp_gb);
        checkBMISD = findViewById(R.id.check_bmhp_isd);
        checkBMISW = findViewById(R.id.check_bmhp_iswn);
        checkBMJJ = findViewById(R.id.check_bmhp_jj);
        checkBMKU = findViewById(R.id.check_bmhp_ku);
        checkBMKFD = findViewById(R.id.check_bmhp_kfd);
        checkBMKN = findViewById(R.id.check_bmhp_kn);
        checkBMP = findViewById(R.id.check_bmhp_p);
        checkBMPTP = findViewById(R.id.check_bmhp_ptp);
        checkBMP2 = findViewById(R.id.check_bmhp_p2);
        checkBMSC = findViewById(R.id.check_bmhp_scuct);
        checkBMST2 = findViewById(R.id.check_bmhp_st);
        checkBMST3 = findViewById(R.id.check_bmhp_st2);

        checkSPOPA = findViewById(R.id.check_spo_pa);
        checkSPOPP = findViewById(R.id.check_spo_pp);
        checkSPOPN = findViewById(R.id.check_spo_pn);
        checkSPOPBBL = findViewById(R.id.check_spo_pbbl);
        checkSPOPKB = findViewById(R.id.check_spo_plkb);
        checkSPOPPPE = findViewById(R.id.check_spo_pppe);
        checkSPOHAP = findViewById(R.id.check_spo_hap);
        checkSPOPR = findViewById(R.id.check_spo_pr);
        checkSPOHPP = findViewById(R.id.check_spo_hpp);
        checkSPOPBA = findViewById(R.id.check_spo_pba);
        checkSPOMS = findViewById(R.id.check_spo_ms);
        checkSPOPPI = findViewById(R.id.check_spo_ppi);

        checkNifasBRPN = findViewById(R.id.check_nifas_brpn);

        linearIdentitas = findViewById(R.id.linear_identitas);
        linearInstrumen = findViewById(R.id.linear_instrumen);

        btnLanjut = findViewById(R.id.btn_lanjut);
        btnProses = findViewById(R.id.btn_proses);

        btnLanjut.setOnClickListener(this);
        btnProses.setOnClickListener(this);
    }
    private void PN(){
        if (checkNifasBRPN.isChecked()){
            PN = 100;
        }
    }
    private void SPO(){
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0;

        if (checkSPOPA.isChecked()){
            a = 8;
        }
        if (checkSPOPP.isChecked()){
            b = 8;
        }
        if (checkSPOPN.isChecked()){
            c = 8;
        }
        if (checkSPOPBBL.isChecked()){
            d = 8;
        }
        if (checkSPOPKB.isChecked()){
            e = 8;
        }
        if (checkSPOPPPE.isChecked()){
            f = 8;
        }
        if (checkSPOPR.isChecked()){
            g = 8;
        }
        if (checkSPOHAP.isChecked()){
            h =8;
        }
        if (checkSPOHPP.isChecked()){
            i = 8;
        }
        if (checkSPOPBA.isChecked()){
            j = 8;
        }
        if (checkSPOMS.isChecked()){
            k = 8;
        }
        if (checkSPOPPI.isChecked()){
            l = 8;
        }

        SPO = a+b+c+d+e+f+g+h+i+j+k+l;
    }

    private void BMHP(){
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0,m = 0,n = 0,o = 0,p = 0,q = 0,r = 0,s = 0,t = 0, u = 0, v = 0, w = 0, x = 0, y= 0, z = 0;

        if (checkBMA.isChecked()){
            a = 5;
        }
        if (checkBMCD.isChecked()){
            b = 5;
        }
        if (checkBMKS.isChecked()){
            c = 5;
        }
        if (checkBMK.isChecked()){
            d = 5;
        }
        if (checkBMKNS.isChecked()){
            e = 5;
        }
        if (checkBMKS2.isChecked()){
            f = 5;
        }
        if (checkBMLKS.isChecked()){
            g = 5;
        }
        if (checkBMM.isChecked()){
            h = 5;
        }
        if (checkBMPT.isChecked()){
            i = 5;
        }
        if (checkBMST.isChecked()){
            j = 5;
        }
        if (checkBMBCC.isChecked()){
            k = 5;
        }
        if (checkBMGB.isChecked()){
            l = 5;
        }
        if (checkBMISD.isChecked()){
            m = 5;
        }
        if (checkBMISW.isChecked()){
            n = 5;
        }
        if (checkBMP2.isChecked()){
            o = 5;
        }
        if (checkBMJJ.isChecked()){
            p =5;
        }
        if (checkBMKU.isChecked()){
            q = 5;
        }
        if (checkBMKFD.isChecked()){
            r = 5;
        }
        if (checkBMKN.isChecked()){
            s = 5;
        }
        if (checkBMP.isChecked()){
            t = 5;
        }
        if (checkBMPTP.isChecked()){
            u = 5;
        }
        if (checkBMSC.isChecked()){
            v = 5;
        }
        if (checkBMST2.isChecked()){
            w = 5;
        }
        if (checkBMST3.isChecked()){
            x = 5;
        }
        BMHP = a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t+u+v+w+x;
    }

    private void OBS(){
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0,m = 0,n = 0,o = 0,p = 0,q = 0,r = 0,s = 0,t = 0;
        if (checkVADT.isChecked()){
            a = 5;
        }
        if (checkTTD.isChecked()){
            b = 5;
        }
        if (checkVKI.isChecked()){
            c = 5;
        }
        if (checkSMG.isChecked()){
            d = 5;
        }
        if (checkDT.isChecked()){
            e = 5;
        }
        if (checkKDET.isChecked()){
            f = 5;
        }
        if (checkKLET.isChecked()){
            g = 5;
        }
        if (checkLT.isChecked()){
            h = 5;
        }
        if (checkKCAET.isChecked()){
            i = 5;
        }
        if (checkKGET.isChecked()){
            j = 5;
        }
        if (checkLT2.isChecked()){
            k = 5;
        }
        if (checkKDET2.isChecked()){
            l = 5;
        }
        if (checkKELT.isChecked()){
            m = 5;
        }
        if (checkMAV.isChecked()){
            n = 5;
        }
        if (checkKMAECV.isChecked()){
            o = 5;
        }
        if (checkLR.isChecked()){
            p = 5;
        }
        if (checkER.isChecked()){
            q = 5;
        }
        if (checkIUDCTA.isChecked()){
            r = 5;
        }
        if (checkIUDL.isChecked()){
            s = 5;
        }
        if (checkK2.isChecked()){
            t = 5;
        }
        OBS = a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t;
    }

    private void OHA(){
        int a = 0, b = 0, c = 0, d = 0;

        if (checkOI.isChecked()){
            a = 25;
        }
        if (checkMI2.isChecked()){
            b = 25;
        }
        if (checkMSI.isChecked()){
            c = 25;
        }
        if (checkKGI.isChecked()){
            d = 25;
        }
        OHA = a+b+c+d;
    }

    private void PB(){
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g=0, h=0,i=0,j=0,k=0,l=0,m=0,n=0,o=0,p=0,q=0,r=0,s=0,t=0,u=0,v=0, w=0,x=0,y=0,z=0,aa=0,bb=0,cc=0,dd=0;

        if (checkB.isChecked()){
            a= 3;
        }
        if (checkCP.isChecked()){
            b = 3;
        }
        if (checkKG.isChecked()){
            c = 3;
        }
        if (checkSB.isChecked()){
            d = 3;
        }
        if (checkPR2.isChecked()){
            e = 3;
        }
        if (checkDB.isChecked()){
            f = 3;
        }
        if (checkK.isChecked()){
            g = 3;
        }
        if (checkLA.isChecked()){
            h = 3;
        }
        if (checkLO.isChecked()){
            i = 3;
        }
        if (checkM.isChecked()){
            j = 3;
        }
        if (checkP.isChecked()){
            k = 3;
        }
        if (checkP2.isChecked()){
            l = 3;
        }
        if (checkPPL.isChecked()){
            m = 3;
        }
        if (checkS3.isChecked()){
            n = 3;
        }
        if (checkSTKA.isChecked()){
            o = 3;
        }
        if (checkSMP.isChecked()){
            p = 3;
        }
        if (checkTST.isChecked()){
            q = 3;
        }
        if (checkT2.isChecked()){
            r = 3;
        }
        if (checkTK3.isChecked()){
            s = 3;
        }
        if (checkTK4.isChecked()){
            t = 3;
        }
        if (checkWK.isChecked()){
            u = 3;
        }
        if (checkB2.isChecked()){
            v = 3;
        }
        if (checkPTB.isChecked()){
            w = 3;
        }
        if (checkPP.isChecked()){
            x = 3;
        }
        if (checkHPN.isChecked()){
            y = 3;
        }
        if (checkKMK.isChecked()){
            z = 3;
        }
        if (checkLKP.isChecked()){
            aa = 3;
        }
        if (checkSB2.isChecked()){
            bb = 3;
        }
        if (checkSD4.isChecked()){
            cc = 3;
        }
        if (checkS4.isChecked()){
            dd = 3;
        }

        PB = a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t+u+v+w+x+y+z+aa+bb+cc+dd;
    }

    private void SRB(){
        int bsp = 0, mr = 0, pl = 0;

        if (checkBSP.isChecked()){
            bsp = 33;
        }
        if (checkMR.isChecked()){
            mr = 33;
        }
        if (checkPLD.isChecked()){
            pl = 33;
        }
        SRB = bsp+mr+pl;
    }

    private void SI(){
        int a = 0, b = 0;

        if (checkVC.isChecked()){
            a = 50;
        }
        if (checkVR.isChecked()){
            b = 50;
        }
        SI = a+b;
    }

    private void SPKB(){
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0;

        if (checkBLTASB2.isChecked()){
            a = 9;
        }
        if (checkIK.isChecked()){
            b = 9;
        }
        if (checkIUDK.isChecked()){
            c = 9;
        }
        if (checkAEA.isChecked()){
            d = 9;
        }
        if (checkGMC.isChecked()){
            e = 9;
        }
        if (checkKKL.isChecked()){
            f = 9;
        }
        if (checkKPBA.isChecked()){
            g = 9;
        }
        if (checkSUS.isChecked()){
            h = 9;
        }
        if (checkTS.isChecked()){
            i = 9;
        }
        if (checkS2.isChecked()){
            j = 9;
        }
        if (checkT.isChecked()){
            k = 9;
        }

        SPKB = a+b+c+d+e+f+g+h+i+j+k;
    }

    private  void SPKA(){
        int appb = 0, lp = 0, plk = 0, ptba = 0, tb = 0;

        if (checkAPPB.isChecked()){
            appb = 20;
        }
        if (checkLP.isChecked()){
            lp = 20;
        }
        if (checkPLK.isChecked()){
            plk = 20;
        }
        if (checkPTBA.isChecked()){
            ptba = 20;
        }
        if (checkTB.isChecked()){
            tb = 20;
        }
        SPKA = appb+lp+plk+ptba+tb;
    }
    private void SPOG(){
        int bidt = 0, bltast = 0, pr = 0, pl = 0, sd = 0, sd2 = 0, sl = 0, td = 0, td2 = 0, tk = 0, d = 0, gb = 0, ge = 0, gtp = 0, gv = 0, kk = 0, tk2 = 0, lph = 0, mo = 0, mi = 0, nhm = 0, po = 0, pj = 0 , pk = 0, pb = 0, sk = 0, s = 0, scb = 0, si = 0, sd3 = 0, sj = 0, tor = 0;
        if (checkBIDT.isChecked()){
            bidt = 3;
        }
        if (checkBLTASB.isChecked()){
            bltast = 3;
        }
        if (checkPR.isChecked()){
            pr = 3;
        }
        if (checkPL.isChecked()){
            pl = 3;
        }
        if (checkSD.isChecked()){
            sd = 3;
        }
        if (checkSD2.isChecked()){
            sd2  = 3;
        }
        if (checkSL.isChecked()){
            sl = 3;
        }
        if (checkTD.isChecked()){
            td = 3;
        }
        if (checkTD2.isChecked()){
            td2 = 3;
        }
        if (checkTK.isChecked()){
            tk = 3;
        }
        if (checkD.isChecked()){
            d = 3;
        }
        if (checkGB.isChecked()){
            gb = 3;
        }
        if (checkGE.isChecked()){
            ge = 3;
        }
        if (checkGTP.isChecked()){
            gtp = 3;
        }
        if (checkGV.isChecked()){
            gv = 3;
        }
        if (checkKK.isChecked()){
            kk = 3;
        }
        if (checkTK2.isChecked()){
            tk2 = 3;
        }
        if (checkLPH.isChecked()){
            lph = 3;
        }
        if (checkMO.isChecked()){
            mo = 3;
        }
        if (checkMI.isChecked()){
            mi = 3;
        }
        if (checkNHM.isChecked()){
            nhm = 3;
        }
        if (checkPO.isChecked()){
            po = 3;
        }
        if (checkPJ.isChecked()){
            pj = 3;
        }
        if (checkPK.isChecked()){
            pk = 3;
        }
        if (checkPB.isChecked()){
            pb = 3;
        }
        if (checkSK2.isChecked()){
            sk = 3;
        }
        if (checkS.isChecked()){
            s = 3;
        }
        if (checkSCB.isChecked()){
            scb = 3;
        }
        if (checkSI.isChecked()){
            si = 3;
        }
        if (checkSD3.isChecked()){
            sd3 = 3;
        }
        if (checkSJ.isChecked()){
            sj = 3;
        }
        if (checkTOR.isChecked()){
            tor = 3;
        }
        SPOG = bidt+bltast+pr+pl+sd+sd2+sl+td+td2+tk+d+gb+ge+gtp+gv+kk+tk+lph+mo+mi+nhm+po+pj+pk+pb+sk+s+scb+si+sd3+sj+tor;

    }

    private void PP(){
        int ic = 0, kp = 0, flp = 0, fp = 0, fnkb = 0, fr = 0, fsk = 0;

        if (checkIC.isChecked()){
            ic = 14;
        }
        if (checkKP.isChecked()){
            kp = 14;
        }
        if (checkFLP.isChecked()){
            flp = 14;
        }
        if (checkFP.isChecked()){
            fp = 14;
        }
        if (checkFNKB.isChecked()){
            fnkb = 14;
        }
        if (checkFRP.isChecked()){
            fr = 14;
        }
        if (checkFSK.isChecked()){
            fsk = 14;
        }
        PP = ic + kp + flp + fp + fnkb + fr + fsk;
    }
    private void imunisasi(){
        if (checkImunisasi.isChecked()){
            imunisasi = 100;
        }
    }

    private void PKIKB(){
        int bkia = 0, bki = 0, ki = 0, bri = 0, pak = 0, fic = 0, fl = 0, fr = 0, skh = 0;

        if (checkBKIA.isChecked()){
            bkia = 11;
        }
        if (checkBKI.isChecked()){
            bki = 11;
        }
        if (checkKI.isChecked()){
            ki = 11;
        }
        if (checkBRI.isChecked()){
            bri = 11;
        }
        if (checkPAK.isChecked()){
            pak = 11;
        }
        if (checkFIC.isChecked()){
            fic = 11;
        }
        if (checkFL.isChecked()){
            fl = 11;
        }
        if (checkFR.isChecked()){
            fr = 11;
        }
        if (checkSKH.isChecked()){
            skh = 11;
        }

        PKIKB = bkia + bki + ki + bri + pak + fic + fl + fr + skh;

    }

    private void PKA(){
        int bdmtbs = 0, bmtbs = 0, brba = 0, fddtka = 0 , fksp = 0, fralkb = 0, rkb = 0;

        if (checkBDMTBS.isChecked()) {
            bdmtbs = 15;
        }
        if (checkBMTBS.isChecked()){
            bmtbs = 15;
        }
        if (checkRBA.isChecked()){
            brba = 15;
        }
        if (checkFDDTKA.isChecked()){
            fddtka = 15;
        }
        if (checkFKPSP.isChecked()){
            fksp = 15;
        }
        if (checkFRKALKB.isChecked()){
            fralkb = 15;
        }
        if (checkRKB.isChecked()){
            rkb = 15;
        }
        PKA = bdmtbs + bmtbs + brba + fddtka + fksp + fralkb + rkb;
    }


    private void sdmPendukung(){

        int tkl, tnk;
        if (checkTKL.isChecked()){
            tkl = 50;
        }else{
            tkl = 0;
        }
        if (checkTNK.isChecked()){
            tnk = 50;
        }else {
            tnk = 0;
        }
        sdmPendukung = tkl + tnk;
        Log.d("hasil", String.valueOf(sdmPendukung));
    }

    private void bangunanRuang(){
        int bangunan = 0;
        int rt = 0;
        int rp = 0;
        int rb = 0;
        int rn = 0;
        int km = 0;

        if (checkRumah.isChecked()){
            bangunan = 17;
        }
        if (checkRT.isChecked()){
            rt = 17;
        }
        if (checkRP.isChecked()){
            rp = 17;
        }
        if (checkRB.isChecked()){
            rb = 17;
        }
        if (checkRN.isChecked()){
            rn = 17;
        }
        if (checkKM.isChecked()){
            km = 17;
        }

        bangunRuang = bangunan + rt + rp + rb + rn + km;
    }
    private void prasarana(){
        int sab = 0, sk = 0, su = 0;

        if (checkSAB.isChecked()){
            sab = 33;
        }
        if (checkSK.isChecked()){
            sk = 33;
        }
        if (checkSU.isChecked()){
            su = 33;
        }

        prasarana = sab + sk + su;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_lanjut:
                linearIdentitas.setVisibility(View.GONE);
                linearInstrumen.setVisibility(View.VISIBLE);
                btnLanjut.setVisibility(View.GONE);
                btnProses.setVisibility(View.VISIBLE);

                break;

            case R.id.btn_proses:
                sdmPendukung();
                bangunanRuang();
                prasarana();
                PKA();
                PKIKB();
                imunisasi();
                PP();
                SPOG();
                SPKA();
                SPKB();
                SI();
                SRB();
                PB();
                OHA();
                OBS();
                BMHP();
                SPO();
                PN();


                Intent intent= new Intent(this, ResultActivity.class);
                intent.putExtra("sdmPendukung", sdmPendukung);
                intent.putExtra("bangunRuang", bangunRuang);
                intent.putExtra("prasarana", prasarana);
                intent.putExtra("pka", PKA);
                intent.putExtra("pkikb", PKIKB);
                intent.putExtra("imunisasi", imunisasi);
                intent.putExtra("pp", PP);
                intent.putExtra("spog", SPOG);
                intent.putExtra("spka", SPKA);
                intent.putExtra("spkb", SPKB);
                intent.putExtra("si", SI);
                intent.putExtra("srb", SRB);
                intent.putExtra("pb", PB);
                intent.putExtra("oha", OHA);
                intent.putExtra("obs", OBS);
                intent.putExtra("bmhp", BMHP);
                intent.putExtra("spo", SPO);
                intent.putExtra("pn",PN);

                intent.putExtra("namaPemohon", edtNmPemohon.getText().toString());
                intent.putExtra("alamatPemohon", edtAlmPemohon.getText().toString());
                intent.putExtra("namaSarana", edtNmSarana.getText().toString());
                intent.putExtra("alamatSarana", edtAlmSarana.getText().toString());
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                int sdmp = data.getIntExtra("r_sdm",0);
                int br = data.getIntExtra("r_br",0);
                int r_prasarana = data.getIntExtra("r_p",0);
                int r_pka = data.getIntExtra("r_pka",0);
                int r_pkikb = data.getIntExtra("r_pkikb",0);
                int r_imuniasi = data.getIntExtra("r_pi",0);
                int r_PP = data.getIntExtra("r_pp", 0);
                int r_SPOG = data.getIntExtra("r_spog", 0);
                int r_SPKA = data.getIntExtra("r_spka", 0);
                int r_SPKB = data.getIntExtra("r_spkb", 0);
                int r_SI = data.getIntExtra("r_si", 0);
                int r_SRB = data.getIntExtra("r_srb",0);
                int r_PB = data.getIntExtra("r_pb", 0);
                int r_OHA = data.getIntExtra("r_oha", 0);
                int r_OBS = data.getIntExtra("r_obs", 0);
                int r_BMHP = data.getIntExtra("r_bmhp", 0);
                int r_SPO = data.getIntExtra("r_spo", 0);
                int r_PN = data.getIntExtra("r_pn", 0);

                if (sdmp == 100){
                    linearSDMP.setVisibility(View.GONE);
                }
                if (br == 102){
                    linearBR.setVisibility(View.GONE);
                    linearRF.setVisibility(View.GONE);
                }
                if (r_prasarana == 99){
                    linearP.setVisibility(View.GONE);
                }
                if (r_pkikb == 99){
                    linearPKIKB.setVisibility(View.GONE);
                }
                if (r_pka == 105){
                    linearPKA.setVisibility(View.GONE);
                }
                if (r_imuniasi == 100){
                    linearPI.setVisibility(View.GONE);
                }
                if (r_PP == 98){
                    linearPP.setVisibility(View.GONE);
                }
                if (r_PN == 100){
                    linearPN.setVisibility(View.GONE);
                }
                if (r_SPOG == 96){
                    linearSPOG.setVisibility(View.GONE);
                }
                if (r_SPKA == 100){
                    linearSPKA.setVisibility(View.GONE);
                }
                if (r_SPKB == 99){
                    linearSPKB.setVisibility(View.GONE);
                }
                if (r_SI == 100){
                    linearSI.setVisibility(View.GONE);
                }
                if (r_SRB == 99){
                    linearSRB.setVisibility(View.GONE);
                }
                if (r_PB == 90){
                    linearPB.setVisibility(View.GONE);
                }
                if (r_OHA == 100){
                    linearOBH.setVisibility(View.GONE);
                }
                if (r_OBS == 100){
                    linearOBS.setVisibility(View.GONE);
                }
                if (r_BMHP == 120){
                    linearBMHP.setVisibility(View.GONE);
                }
                if (r_SPO == 96){
                    linearSPO.setVisibility(View.GONE);
                }

            }
        }
    }
    private boolean checkPermission() {

        return ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                ;
    }

    private void requestPermissionAndContinue() {
        if (ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, WRITE_EXTERNAL_STORAGE)
                    && ActivityCompat.shouldShowRequestPermissionRationale(this, READ_EXTERNAL_STORAGE)) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setCancelable(true);
                alertBuilder.setTitle("Izin Akses");
                alertBuilder.setMessage("Izinkan aplikasi mengakses sd card anda");
                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(FormPemohonActivity.this, new String[]{WRITE_EXTERNAL_STORAGE
                                , READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
                    }
                });
                AlertDialog alert = alertBuilder.create();
                alert.show();
                Log.e("", "permission denied, show dialog");
            } else {
                ActivityCompat.requestPermissions(FormPemohonActivity.this, new String[]{WRITE_EXTERNAL_STORAGE,
                        READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
            }
        } else {
            Toast.makeText(this,"Permission accessed", Toast.LENGTH_LONG).show();
        }
    }
}
