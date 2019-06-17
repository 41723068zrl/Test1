package cn.edu.swufe.test1;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Present extends AppCompatActivity {
//    FragmentManager presentManager;
    EditText editPresent;
    float newPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.present);

        editPresent=(EditText)findViewById(R.id.edit_present);


    }

    public void savePresent(View btn){
        newPresent=Float.parseFloat(editPresent.getText().toString());

        Intent intent=getIntent();
        Bundle bdlPresent=new Bundle();
        bdlPresent.putFloat("newPresent_key",newPresent);
        intent.putExtras(bdlPresent);
        setResult(4,intent);
        finish();

//
//        TargetFragment pFragment=new TargetFragment();
//        Bundle bdlPresent1=new Bundle();
//        bdlPresent1.putFloat("newPresent_key",newPresent);
//        pFragment.setArguments(bdlPresent1);
//
//        FragmentManager presentManager=getSupportFragmentManager();
//        FragmentTransaction transaction=presentManager.beginTransaction();
//        transaction.add(R.id.fragment_Target,pFragment);
//        transaction.commit();

    }

}
