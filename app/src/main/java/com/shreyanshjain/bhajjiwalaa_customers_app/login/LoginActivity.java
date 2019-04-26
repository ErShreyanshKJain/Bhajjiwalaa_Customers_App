package com.shreyanshjain.bhajjiwalaa_customers_app.login;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.shreyanshjain.bhajjiwalaa_customers_app.MainActivity;
import com.shreyanshjain.bhajjiwalaa_customers_app.R;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    AppCompatImageView app_logo;
    RelativeLayout login_layout;
    Button login_btn;
    FirebaseAuth auth;
    TextInputEditText phoneNum,verifyCode;
    CardView numCard,verifyCard;
    String mVerificationId;
    FirebaseAuth.AuthStateListener authStateListener;
    AlertDialog.Builder builder;
    AlertDialog dialog;
//    private static int LOGTIME_OUT=1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.dialog_progress);
        dialog = builder.create();


        app_logo = findViewById(R.id.login_logo);
        login_layout =  findViewById(R.id.login_layout);
        auth = FirebaseAuth.getInstance();
        phoneNum = findViewById(R.id.login_phone);
        numCard = findViewById(R.id.login_card);
        verifyCard=findViewById(R.id.verify_card);
        verifyCode=findViewById(R.id.verify_phone);

        checkFirebaseAuth();
        app_logo.animate()
                .setDuration(700)
                .translationY(-600f)
                .scaleXBy(-0.5f)
                .scaleYBy(-0.5f);

        login_layout.animate()
                .setDuration(1700)
                .alphaBy(1.0f);

        FirebaseApp.initializeApp(LoginActivity.this);

        login_btn = findViewById(R.id.login_button);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = phoneNum.getText().toString();
                Log.i("Info", num);
                if (num.isEmpty()) {
                    phoneNum.setError("Enter a valid mobile number");
                    phoneNum.requestFocus();
                    return;
                }

                dialog.show();
                sendVerificationCode(num);
//              openDialogBox();

                phoneNum.setHint("Verification Code");
                phoneNum.setEms(6);

                numCard.animate()
                        .setDuration(500)
                        .translationX(-1000f);

                verifyCard.setVisibility(View.VISIBLE);

                verifyCard.animate()
                        .setDuration(500)
                        .alphaBy(1.0f);

                login_btn.setText("Verify");

                login_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String code = verifyCode.getText().toString().trim();

                        if (code.isEmpty() || code.length() < 6) {
                            verifyCode.setError("Enter Valid Code");
                            verifyCode.requestFocus();
                            return;
                        }
                        dialog.show();
                        verifyVerificationCode(code);
                    }
                });
            }
        });
    }

    public void checkFirebaseAuth()
    {
        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null)
                {
                    Log.d("Firebase Auth","You are now signed in");
                    gotoMainActivity();
                }
            }
        };
        auth.addAuthStateListener(authStateListener);
    }

    public void sendVerificationCode(String mobile)
    {

        Log.d("Method","Send Verification Code");
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
        dialog.dismiss();
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();

            if (code!=null) {
                phoneNum.setText(code);

                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;
            Log.d("Method","On Code sent");
        }
    };

    public void verifyVerificationCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId,code);

        Log.d("Method","verify verification :" + code);
        dialog.show();
        signInWithPhoneAuthCredential(credential);
    }

    public void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        auth.signInWithCredential(credential)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            gotoMainActivity();
//                            dialog.show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    dialog.dismiss();
                                    // close this activity
                                    finish();
                        }
                        else{
                            dialog.dismiss();
                            String message = "Somthing is wrong, we will fix it soon...";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code entered...";

                            }

                            Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_LONG);
                            snackbar.setAction("Dismiss", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            });
                            snackbar.show();
                        }
                    }
                });
    }

    public void gotoMainActivity()
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        auth.removeAuthStateListener(authStateListener);
    }
}

//    void openDialogBox()
//    {
//        String m_Text = "";
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Title");
//
//        final EditText input = new EditText(this);
//
//        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//        builder.setView(input);
//
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
////                phone.sendVerificationCode(input.getText().toString());
//            }
//        });
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        builder.show();
//    }

