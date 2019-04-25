package com.shreyanshjain.bhajjiwalaa_customers_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.shreyanshjain.bhajjiwalaa_customers_app.login.LoginActivity;

import java.util.concurrent.TimeUnit;

public class PhoneVerification {

//    Context context;
//    Activity activity;
//    FirebaseAuth auth;
//    TextInputEditText phoneNum;
//    public PhoneVerification() {
//        auth=FirebaseAuth.getInstance();
//    }
//
//    public PhoneVerification(Context context, FirebaseAuth auth,TextInputEditText phone) {
//        this.context = context;
//        this.auth = auth;
//        phoneNum = phone;
////        this.view = view;
//    }
//
//    public void sendVerificationCode(String mobile)
//    {
//        Log.d("Method","Send Verification Code");
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                "+91" + mobile,
//                60,
//                TimeUnit.SECONDS,
//                TaskExecutors.MAIN_THREAD,
//                mCallbacks);
//    }
//
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        @Override
//        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//
//            String code = phoneAuthCredential.getSmsCode();
//
//            if (code!=null) {
//                phoneNum.setText(code);
//
//                verifyVerificationCode(code);
//            }
//        }
//
//        @Override
//        public void onVerificationFailed(FirebaseException e) {
//            Toast.makeText(context,e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//            super.onCodeSent(s, forceResendingToken);
//            mVerificationId = s;
//            Log.d("Method","On Code sent");
//        }
//    };
//
//    public void verifyVerificationCode(String code) {
//        LoginActivity login = new LoginActivity();
//        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId,code);
//
//        Log.d("Method","verify verification :" + code);
//        login.signInWithPhoneAuthCredential(credential);
//    }
//

}
